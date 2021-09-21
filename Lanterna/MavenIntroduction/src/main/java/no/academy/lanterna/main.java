//Figuren bør ha 3 liv - som countes.
//Vi må ha en count for highScore som countes er spiste enhet + x antall poeng for flagg.


package no.academy.lanterna;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class main {

    public static void main(String[] args) throws IOException, InterruptedException {

        //Lag terminal og skjul cursor
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
        Terminal terminal = defaultTerminalFactory.createTerminal();
        terminal.setCursorVisible(false);
//        terminal.setBackgroundColor(TextColor.ANSI.MAGENTA);

        //Sett opp en player character og plasser den random et sted

//        TerminalSize terminalSize = terminal.getTerminalSize();
//        for (int col = 0; col < terminalSize.getColumns(); col++) {
//            for (int row = 0; row < terminalSize.getRows(); row++ ) {
//                terminal.putCharacter(col, row, new TextCharacter(
//                        ' ', TextColor.ANSI.DEFAULT, TextColor.ANSI.values()[
//                                Random.nextInt(TextColor.ANSI.values().length)]
//                ));
//            }
//        }



        int terminalSizeX = terminal.getTerminalSize().getRows();
        int terminalSizeY = terminal.getTerminalSize().getColumns();
        int x = 6;
        int y = 7;
        final char player = 'X';





//                TextColor.ANSI.DEFAULT,
//                // This will pick a random background color
//        screen.setCharacter(column, row, new TextCharacter(
//                ' ',
//                TextColor.ANSI.DEFAULT,
//                // This will pick a random background color
//                TextColor.ANSI.values()[random.nextInt(TextColor.ANSI.values().length)]));


        terminal.setCursorPosition(x, y);
        terminal.putCharacter(player);
        boolean continueReadingInput = true;


        List<Line> lineList = GameBoard.MapMaker(terminal);


        // Lag en liste med bomber, velg antall bomber som er ønsket
        List<Bomb> bombList = makeBomb(5);

        // tegn inn bomber og linjer (egne funksjoner)
        drawBomb(bombList, terminal);

        drawLine(lineList, terminal);

        terminal.flush();


        while(continueReadingInput){
            int xPrevious = x;
            int yPrevious = y;
            KeyStroke keyStroke = null;
            do {
                Thread.sleep(5);
                keyStroke = terminal.pollInput();
            }while(keyStroke==null);
            KeyType type = keyStroke.getKeyType();
            Character c = keyStroke.getCharacter();
            switch(type){
                case ArrowDown -> y++;
                case ArrowUp ->   y--;
                case ArrowLeft -> x--;
                case ArrowRight-> x++;
            }

            terminal.setCursorPosition(x, y);
            if (isWall(lineList, terminal)){ // If wall
                terminal.setCursorPosition(xPrevious,yPrevious); // Ikke gå
                x = xPrevious; y = yPrevious;
            }
            else{
                terminal.putCharacter(player);
                terminal.setCursorPosition(xPrevious, yPrevious);
                terminal.putCharacter(' ');
            }
            if (isBomb(bombList, terminal)){ // if Bomb
                continueReadingInput = false; // slutt å lese input
                System.out.println("Oh no! You hit a bomb!");
            }
            if (c == Character.valueOf('q')){
                continueReadingInput = false;
                System.out.println("quit");
            }
            terminal.flush();

        }

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
                    System.out.println("WALL!");
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
                System.out.println("Ka-boom");
                return true;
            }
        }
        return false;
    }

    // Lage bomber og gi en liste med bomber
    public static List<Bomb> makeBomb(int amount){
        List<Bomb> bombList = new ArrayList<>();
        for (int i = 0; i<amount; i++){
            Random r = new Random();
            Bomb bomb = new Bomb(r.nextInt(80), r.nextInt(24));
            bombList.add(bomb);
        }
        return bombList;
    }

    public static void drawBomb(List<Bomb> bombList, Terminal terminal) throws IOException {
        for (Bomb b : bombList){
            int[] pos = new int[]{b.getX(), b.getX()};
            terminal.setCursorPosition(pos[0], pos[1]);
            terminal.putCharacter('O');
        }
    }


}
