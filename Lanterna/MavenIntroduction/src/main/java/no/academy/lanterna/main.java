//Figuren bør ha 3 liv - som countes.
//Vi må ha en count for highScore som countes er spiste enhet + x antall poeng for flagg.
package no.academy.lanterna;


import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class main {

    public static void main(String[] args) throws IOException, InterruptedException {

        //Lag terminal og skjul cursor
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
        defaultTerminalFactory.setTerminalEmulatorFontConfiguration(SwingTerminalFontConfiguration.getDefaultOfSize(18));
        TerminalSize terminalSize = new TerminalSize(80, 24);
        defaultTerminalFactory.setInitialTerminalSize(terminalSize);
        Terminal terminal = defaultTerminalFactory.createTerminal();
//        Font myFont = new Font("Serif", Font.BOLD, 12);
//        AWTTerminalFontConfiguration.newInstance(myFont);
//        defaultTerminalFactory.setTerminalEmulatorFontConfiguration(AWTTerminalFontConfiguration.newInstance(myFont));

        Screen screen = new TerminalScreen(terminal);
        TextGraphics textGraphics = screen.newTextGraphics();
        screen.startScreen();

//        textGraphics.putString(2,1, "Hei", SGR.BLINK);
        //Thread.sleep(2000);

        KeyStroke startKeyStroke = null;
        boolean startReadingInput = true;

        while(startReadingInput) {
            do {
                String info = "Bli kvitt gruff ved å drikke kaffekoppene.";
                String info2 = "Men pass deg for slitsomme kollegaer...";
                textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
                textGraphics.putString(32, 6, "Morgengretten ☹   ", SGR.BOLD);
                textGraphics.putString(20, 8, info, SGR.ITALIC);
                textGraphics.putString(20, 9, info2, SGR.ITALIC);

                textGraphics.putString(28, 12, "Trykk spacebar for å starte!", SGR.BLINK);
                textGraphics.putString(28, 13, "Trykk q for å avslutte!", SGR.BLINK);

                screen.refresh();
                startKeyStroke = terminal.pollInput();
            } while (startKeyStroke == null);
            Character cStart = startKeyStroke.getCharacter();

            if (cStart == Character.valueOf(' ')) {
                startReadingInput = false;
                System.out.println("Starting game");
                terminal.clearScreen();
            }
            if (cStart == Character.valueOf('q')) {
                startReadingInput = false;
                System.out.println("Ending game..");
                terminal.close();
                System.exit(0);
            }
        }

        terminal.resetColorAndSGR();

        terminal.flush();
        terminal.setCursorVisible(false);


        //Sett opp en player2 character og plasser den random et sted

        int x = 6;
        int y = 7;
//        final char player2 = '\u2639';

        UserPlayer player = new UserPlayer(6, 7);



        terminal.setForegroundColor(TextColor.ANSI.YELLOW_BRIGHT);
        terminal.setCursorPosition(player.xPos, player.yPos);
        terminal.putCharacter(player.playerChar);


        boolean continueReadingInput = true;
        List<Line> lineList = GameBoard.MapMaker(terminal);


        List<CoWorker> coWorkerList = makeGhosts(1, terminal, lineList);

        // tegn inn bomber og linjer (egne funksjoner)
        drawLine(lineList, terminal);
        terminal.flush();

        int cupScore = 0;
        int numOfCups = 0;

        TextColor.ANSI veggFarge = TextColor.ANSI.BLACK_BRIGHT;


        Coffee coffeeCup = new Coffee(73, 21);
        terminal.setForegroundColor(TextColor.ANSI.WHITE_BRIGHT);
        terminal.setCursorPosition(coffeeCup.xPos, coffeeCup.yPos);
        terminal.putCharacter(coffeeCup.coffeCup);
        terminal.flush();
        while(continueReadingInput){
            terminal.setCursorVisible(false);
            String score = "Cups of coffee: " + cupScore;

            textGraphics.setBackgroundColor(veggFarge);
            textGraphics.setForegroundColor(TextColor.ANSI.WHITE_BRIGHT);
            textGraphics.putString(33, 0, "High Score: " + cupScore, SGR.BOLD);
            screen.refresh();
            terminal.resetColorAndSGR();
            terminal.setCursorVisible(false);

            for (CoWorker coWorker : coWorkerList){
                terminal.setForegroundColor(TextColor.ANSI.RED_BRIGHT);
                terminal.setCursorPosition(coWorker.xPos, coWorker.yPos);
                terminal.putCharacter(coWorker.ghostChar);
            }
            terminal.flush();


            int xPrevious = player.xPos;
            int yPrevious = player.yPos;
            KeyStroke keyStroke = null;

            do {
                Thread.sleep(5);
                keyStroke = terminal.pollInput();
            }while(keyStroke==null);

            KeyType type = keyStroke.getKeyType();
            Character c = keyStroke.getCharacter();
            switch(type){
                case ArrowDown -> {player.yPos++;}
                case ArrowUp ->   {player.yPos--;}
                case ArrowLeft -> {player.xPos--;}
                case ArrowRight-> {player.xPos++;}
            }
            if (x!=xPrevious || y!= yPrevious){
                for (CoWorker g : coWorkerList){
                    terminal.setForegroundColor(TextColor.ANSI.RED_BRIGHT);
                    g.moveGhost(g, terminal, 1, player, lineList, coffeeCup);
                    terminal.flush();
                }
            }

            terminal.setCursorPosition(player.xPos, player.yPos);
            if (isWall(lineList, terminal)){ // If wall
                terminal.setCursorPosition(xPrevious,yPrevious); // Ikke gå
                player.xPos = xPrevious; player.yPos = yPrevious;
            }
            else{
                terminal.setForegroundColor(TextColor.ANSI.YELLOW_BRIGHT);
                terminal.putCharacter(player.playerChar);
                terminal.setCursorPosition(xPrevious, yPrevious);
                terminal.putCharacter(' ');
            }

            if (isGhost(coWorkerList, player)){
                continueReadingInput = false;
            }
            if (isGoal(player, coffeeCup)){
                cupScore++;
                System.out.println(cupScore);
                terminal.setForegroundColor(TextColor.ANSI.WHITE_BRIGHT);
                coffeeCup.RelocateCoffee(terminal, lineList, coWorkerList);
                numOfCups++;
                if (numOfCups==4){
                    coWorkerList.add(new CoWorker(2,1));
                    numOfCups=0;
                }

            }
            if (c == Character.valueOf('q')){
                continueReadingInput = false;
                System.out.println("quit");
            }
            terminal.flush();
        }

        Thread.sleep(1000);
        terminal.resetColorAndSGR();
        terminal.clearScreen();

        textGraphics.enableModifiers(SGR.BOLD);
        textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
        textGraphics.setForegroundColor(TextColor.ANSI.WHITE_BRIGHT);
        TextGraphics endScreen = textGraphics.drawRectangle(new TerminalPosition(30, 9),new TerminalSize(20, 5), '*');

        textGraphics.putString(32, 10, "G A M E  O V E R", SGR.BLINK, SGR.BOLD);
        textGraphics.putString(34, 12, "Score: "+cupScore, SGR.BOLD);
        screen.refresh();
    }


    // For alle linjer i linjelista, kjøre makeline funksjonen (ligger objektfilene)
    public static void drawLine(List<Line> lineList, Terminal terminal) throws IOException {
        for (Line line : lineList) {
            line.makeLine(line, terminal);
            }
        terminal.flush();
    }

    // for alle linjer i linjelista, sjekk om posisjonen til spiller er en veggposisjon
    public static boolean isWall(List<Line> lineList, Terminal terminal) throws IOException{
        for (Line line : lineList) {
            for (int i = 0; i < line.length; i++) {
                int tRow = terminal.getCursorPosition().getRow();
                int tCol = terminal.getCursorPosition().getColumn();
                int[] linePos = line.linePos[i];
                if (tRow == linePos[1] && tCol == linePos[0]) {
                    return true; // Hvis det er vegg, returner true (if wall sjekke oppe)
                }
            }
        }
        return false;
    }

    // For alle bomber i bombelista, sjekk om spillerposisjonen er på bombe
    public static boolean isBomb(List<Bomb> bombList, Terminal terminal) throws IOException{
        for (Bomb b : bombList){
            int tRow = terminal.getCursorPosition().getRow();
            int tCol = terminal.getCursorPosition().getColumn();
            if (tRow ==  b.getY() && tCol == b.getX()){
                return true;
            }
        }
        return false;
    }

    // Lage bomber og gi en liste med bomber
    public static List<Bomb> makeBomb(int amount, Terminal terminal, List<Line> lineList) throws IOException {
        List<Bomb> bombList = new ArrayList<>();
        for (int i = 0; i<amount; i++){
            Random r = new Random();
            int x = r.nextInt(80);
            int y = r.nextInt(24);
            terminal.setCursorPosition(x, y);
            while(isWall(lineList, terminal)) {
                x = r.nextInt(80);
                y = r.nextInt(24);
                terminal.setCursorPosition(x,y);
            }
            Bomb bomb = new Bomb(x, y);
            bombList.add(bomb);
        }
        return bombList;
    }

    public static List<CoWorker> makeGhosts(int amount, Terminal terminal, List<Line> lineList) throws IOException {
        List<CoWorker> coWorkerList = new ArrayList<>();
        for (int i = 0; i<amount;i++){
            Random r = new Random();
            int x = r.nextInt(80);
            int y = r.nextInt(24);
            terminal.setCursorPosition(x, y);
            while(isWall(lineList, terminal)) {
                x = r.nextInt(80);
                y = r.nextInt(24);
                terminal.setCursorPosition(x, y);
            }
            CoWorker coWorker = new CoWorker(x, y);
            coWorkerList.add(coWorker);
        }
        return coWorkerList;
    }


    public static boolean isGhost(List<CoWorker> coWorkerList, UserPlayer player){
        for (CoWorker g : coWorkerList){
            if (g.xPos == player.xPos && g.yPos == player.yPos){
                System.out.println("OMNOMNOMNOM");
                return true;
            }
        }
        return false;
    }

    public static boolean isGhost(List<CoWorker> coWorkerList, int x, int y){
        for (CoWorker g : coWorkerList){
            if (g.xPos == x && g.yPos == y){
                System.out.println("OMNOMNOMNOM");
                return true;
            }
        }
        return false;
    }

    public static boolean isGoal(UserPlayer player,Coffee coffeeCup){
        if (player.xPos == coffeeCup.xPos && player.yPos == coffeeCup.yPos){
            return true;
        }
        return false;
    }
    public static boolean isGoal(int x, int y,Coffee coffeeCup){
        if (x == coffeeCup.xPos && y == coffeeCup.yPos){
            return true;
        }
        return false;
    }

}
