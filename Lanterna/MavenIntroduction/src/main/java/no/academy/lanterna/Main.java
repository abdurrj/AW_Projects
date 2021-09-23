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
import java.util.List;

public class Main {

    static TextColor.ANSI wallColor = TextColor.ANSI.BLACK_BRIGHT;
    static TextColor.ANSI coWorkerColor = TextColor.ANSI.RED_BRIGHT;
    static TextColor.ANSI playerColor = TextColor.ANSI.YELLOW_BRIGHT;
    static TextColor.ANSI textAndCoffeeColor = TextColor.ANSI.WHITE_BRIGHT;
    static int coWorkerEntryX = 2;
    static int coWorkerEntryY = 1;
    static int coffeeStartX = 73;
    static int coffeeStartY = 21;

    public static void main(String[] args) throws IOException, InterruptedException {

        // Create terminal and set Font size to make viewing easier
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
        defaultTerminalFactory.setTerminalEmulatorFontConfiguration(SwingTerminalFontConfiguration.getDefaultOfSize(25));
        Terminal terminal = defaultTerminalFactory.createTerminal();

        Screen screen = new TerminalScreen(terminal);
        TextGraphics textGraphics = screen.newTextGraphics();
        screen.startScreen();
        terminal.setCursorVisible(false);



        // Startscreen start
        KeyStroke startKeyStroke;
        boolean startReadingInput = true;

        GameBoard.startScreen(textGraphics);

        screen.refresh();
        terminal.setCursorVisible(false);
        while(startReadingInput) {
            do {
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
        // Startscreen end


        terminal.flush();

        // Set player character color, position and place character
        Player player = new Player(2, 1);
        terminal.setForegroundColor(playerColor);
        terminal.setCursorPosition(player.xPos, player.yPos);
        terminal.putCharacter(player.playerChar);


        // Initiate map, return list of Line (Wall) objects to draw
        // And check validity of the moves
        List<Line> lineList = GameBoard.mapMaker(terminal);


        // Draw lines and update terminal
        GameBoard.drawLine(lineList, terminal);
        terminal.flush();


        // Place initial coffeCup and set score to 0
        Coffee coffeeCup = new Coffee(coffeeStartX, coffeeStartY);
        coffeeCup.placeInitialCoffee(terminal, lineList);
        int cupScore = 0;

        // Create a list of coWorker objects. Game initially starts with one
        List<CoWorker> coWorkerList = CoWorker.makeCoWorker(1, terminal, lineList, coffeeCup, player);


        // Game loop
        boolean continueReadingInput = true;
        while(continueReadingInput){


            GameBoard.updateScore(terminal, screen, textGraphics, cupScore, wallColor);


            for (CoWorker coWorker : coWorkerList){
                terminal.setForegroundColor(coWorkerColor);
                terminal.setCursorPosition(coWorker.xPos, coWorker.yPos);
                terminal.putCharacter(coWorker.coWorkerChar);
            }
            terminal.flush();


            int xPrevious = player.xPos;
            int yPrevious = player.yPos;


            KeyStroke keyStroke;
            do {
                Thread.sleep(5);
                keyStroke = terminal.pollInput();
            }while(keyStroke==null);

            KeyType type = keyStroke.getKeyType();
            Character c = keyStroke.getCharacter();


            // Move player
            switch(type){
                case ArrowDown -> player.yPos++;
                case ArrowUp ->   player.yPos--;
                case ArrowLeft -> player.xPos--;
                case ArrowRight-> player.xPos++;

            }

            // For every coWorker in list, move co-worker
            for (CoWorker coWorker : coWorkerList){
                terminal.setForegroundColor(coWorkerColor);
                coWorker.moveCoWorker(terminal, 1, player, lineList, coffeeCup);
                terminal.flush();
            }

            // Get player position and do MoveCheck for wall, co-worker and coffee
            // If it's a wall: do not allow moving.
            terminal.setCursorPosition(player.xPos, player.yPos);
            if (MoveCheck.isWall(lineList, terminal)){ // If wall
                terminal.setCursorPosition(xPrevious,yPrevious); // Ikke gå
                player.xPos = xPrevious; player.yPos = yPrevious;
            }
            else{
                terminal.setForegroundColor(playerColor);
                terminal.putCharacter(player.playerChar);
                terminal.setCursorPosition(xPrevious, yPrevious);
                terminal.putCharacter(' ');
            }

            // If it's a co-worker, stop the game
            if (MoveCheck.isCoWorker(coWorkerList, player)){
                continueReadingInput = false;
                terminal.setBackgroundColor(textAndCoffeeColor);
                terminal.setForegroundColor(coWorkerColor);
                textGraphics.putString(23, 23, "Du har blitt fanget av en kollega!", SGR.BOLD, SGR.BLINK);
                screen.refresh();
                terminal.setCursorVisible(false);
            }

            // If it's a coffee cup, increase score, move coffee cup
            if (MoveCheck.isCoffee(player, coffeeCup)){
                cupScore++;
                terminal.setForegroundColor(textAndCoffeeColor);
                coffeeCup.relocateCoffee(terminal, lineList, coWorkerList);
                // For every 4th cup of coffee, a new co-worker arrives
                if (cupScore % 4 == 0){
                    coWorkerList.add(new CoWorker(coWorkerEntryX,coWorkerEntryY));
                }

            }

            // Quit the game if player inputs q
            if (c == Character.valueOf('q')){
                continueReadingInput = false;
                System.out.println("quit");
            }
            terminal.flush();
        }

        // Pause the game screen for 2 seconds, before game over screen is shown
        Thread.sleep(2000);
        terminal.resetColorAndSGR();
        terminal.clearScreen();
        textGraphics.enableModifiers(SGR.BOLD);
        textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
        textGraphics.setForegroundColor(textAndCoffeeColor);
        textGraphics.drawRectangle(new TerminalPosition(30, 9),new TerminalSize(20, 5), '*');

        textGraphics.putString(32, 10, "G A M E  O V E R", SGR.BLINK, SGR.BOLD);
        textGraphics.putString(34, 12, "Score: "+cupScore, SGR.BOLD);
        screen.refresh();
        terminal.setCursorVisible(false);
    }


}
