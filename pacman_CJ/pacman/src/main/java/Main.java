import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        // Fixed parameters
        final String points = "Score: ";
        final String toExit = "Press 'q' anytime to exit the game";
        final char blockSymbol = '\u2588';
        final char ghostSymbol = 'A';
        final char player = '<';
        final char player2 = 'O';
        final char randomPoints = 'S';
        final char empty = ' ';
        final char dotSymbol = '·';

        // Start terminal
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
        Terminal terminal = defaultTerminalFactory.createTerminal();
        terminal.setCursorVisible(false);

        // Add score and information about how to quit
        terminal.setCursorPosition(30, 25);
        terminal.putString(points);
        terminal.setCursorPosition(40, 10);
        terminal.putString(toExit);

        // Get block positions and place blocks. This list contains all UNVALID moves on the board.
        List<Position> blockPositions = getPositions(0);
        for (Position blockPos : blockPositions){
            terminal.setCursorPosition(blockPos.getX(), blockPos.getY());
            terminal.putCharacter(blockSymbol);
        }

        // Get dot positions and place dots. This list contains all VALID moves on the board.
        List<Position> dotPositions = getPositions(1);
        for (Position dotPos : dotPositions){
            terminal.setCursorPosition(dotPos.getX(), dotPos.getY());
            terminal.putCharacter(dotSymbol);
        }

        // Create Ghosts object
        List<Ghost> ghosts = createGhosts();

        // Is updated by 1 each time in the for-loop. Used to alternate between symbols "player" and "player2" (open and closed pac-man)
        int loopCounter = 1;

        // Counts the number of points
        int pointCounter = 0;

        // Initial player position. x and y represents the current step, while oldX and oldY keeps track of the former position.
        int x = 5;
        int y = 1;
        int oldX = x;
        int oldY = y;

        // Creates two random positions where extra points is gained
        Random r = new Random();
        Position randEle = dotPositions.get(r.nextInt(dotPositions.size()));
        terminal.setCursorPosition(randEle.getX(), randEle.getY());
        terminal.putCharacter(randomPoints);
        Position randEle2 = dotPositions.get(r.nextInt(dotPositions.size()));
        terminal.setCursorPosition(randEle2.getX(), randEle2.getY());
        terminal.putCharacter(randomPoints);

        // Creating and setting portals
        Position portal = dotPositions.get(0);
        terminal.setCursorPosition(portal.getX(), portal.getY());
        terminal.putCharacter('@');
        Position portal2 = dotPositions.get(23);
        terminal.setCursorPosition(portal2.getX(), portal.getY());
        terminal.putCharacter('@');

        // Write the initial player position to terminal
        terminal.setCursorPosition(x, y);
        terminal.putCharacter(player);

        // Place ghosts on the board
        for (Ghost g : ghosts){
            terminal.setCursorPosition(g.getX(), g.getY());
            terminal.putCharacter(ghostSymbol);
        }

        // Update the terminal
        terminal.flush();

        boolean hasLost = false;
        boolean continueReadingInput = true;

        while(continueReadingInput){

            // Handle input from characters and keys (primarily arrows)
            KeyStroke keyStroke = null;
            do {
                Thread.sleep(5);
                keyStroke = terminal.pollInput();
            } while (keyStroke == null);

            Character c = keyStroke.getCharacter();
            KeyType type = keyStroke.getKeyType();

            // If the player has typed q, then quit the game
            if (c == Character.valueOf('q')){
                continueReadingInput = false;
                System.out.println("quit");
                terminal.close();
            }

            // If player has typed one of the arrows, update current position
            switch(type){
                case ArrowLeft:
                    x = x - 1;
                    break;
                case ArrowRight:
                    x = x + 1;
                    break;
                case ArrowUp:
                    y = y - 1;
                    break;
                case ArrowDown:
                    y = y + 1;
                    break;
            }

            // If the current position can't be made, set the current position to the old position
            if (!isValidMove(blockPositions, x, y)){
                x = oldX;
                y = oldY;
            }
            else{
                // If the current position has not been visited before, then add points (either regular points or extra points - depending on the position)
                if (!hasItBeenVisited(dotPositions, x, y)) {
                    if (!isPortal(dotPositions, x, y)) {
                        pointCounter += 10;
                        if (x == randEle.getX() && y == randEle.getY())
                            pointCounter += 40;
                        else if (x == randEle2.getX() && y == randEle2.getY())
                            pointCounter += 40;
                    }
                }

                // Get a new list of Ghost-object, where every ghost has moved a random position
                List<Ghost> newGhosts = getNewGhosts(ghosts, blockPositions);

                // Loop through every old ghost position and new ghost position
                for (int i = 0; i < newGhosts.size(); i++){;
                    // Fill the old ghost position with symbols "randomPoints", "dotSymbol" or "empty" depending on the history
                    Ghost oldGhost = ghosts.get(i);
                    int oldGhostX = oldGhost.getX();
                    int oldGhostY = oldGhost.getY();
                    terminal.setCursorPosition(oldGhostX, oldGhostY);
                    for (Position pos : dotPositions){
                        if (pos.getX() == oldGhostX && pos.getY() == oldGhostY){
                            if (!pos.getHasBeenVisited()){
                                if ((pos.getX() == randEle.getX() && pos.getY() == randEle.getY()) || (pos.getX() == randEle2.getX() && pos.getY() == randEle2.getY())){
                                    terminal.putCharacter(randomPoints);
                                }
                                else if (isPortal(dotPositions, pos.getX(), pos.getY())) {
                                    terminal.putCharacter('@');
                                }
                                else {
                                    terminal.putCharacter(dotSymbol);
                                }
                            }
                            else{
                                terminal.putCharacter(empty);
                            }
                        }
                    }

                    // Place "ghostSymbol" at new ghost position
                    Ghost newGhost = newGhosts.get(i);
                    terminal.setCursorPosition(newGhost.getX(), newGhost.getY());
                    terminal.putCharacter(ghostSymbol);
                }

                // At the former player position, place "empty"
                terminal.setCursorPosition(oldX, oldY);
                if (isPortal(dotPositions, oldX, oldY)){
                    terminal.putCharacter('@');
                }
                else{
                    terminal.putCharacter(empty);
                }

                // Setting x, y position to "visit" and updates terminal window
                terminal.setCursorPosition(x, y);
                if (!isPortal(dotPositions, x, y)) {
                    visit(dotPositions, x, y);
                }
                terminal.flush();

                // Checks whether a ghost and the player's position is the same or has been crossed. If so, then the player has lost the game.
                for (int i = 0; i < ghosts.size(); i++){
                    Ghost oldGhost = ghosts.get(i);
                    Ghost newGhost = newGhosts.get(i);
                    if ((newGhost.getX() == x && newGhost.getY() == y) || (newGhost.getX() == oldX && newGhost.getY() == oldY && oldGhost.getX() == x && oldGhost.getY() == y)){
                        hasLost = true; // evaluated at the bottom of the main-function
                    }
                }

                // Update ghosts and oldX and oldY
                ghosts = newGhosts;
                oldX = x;
                oldY = y;

                // If player is on portal coordinates, set players coordinates to the other portal
                if (x == portal.getX() && y == portal.getY()){
                    oldX = portal2.getX();
                    oldY = portal2.getY();
                    x = portal2.getX();
                    y = portal2.getY();
                    terminal.setCursorPosition(portal2.getX(), portal2.getY());
                }
                else if (x == portal2.getX() && y == portal2.getY()){
                    oldX = portal.getX();
                    oldY = portal.getY();
                    x = portal.getX();
                    y = portal.getY();
                    terminal.setCursorPosition(portal.getX(), portal.getY());
                }

                // Places player, with different symbol alternating rounds
                if (loopCounter % 2 == 0){
                    terminal.putCharacter(player);
                }
                else{
                    terminal.putCharacter(player2);
                }

                // Displays the points counter
                terminal.setCursorPosition(37,25);
                terminal.putString(Integer.toString(pointCounter));

                // Increases loop counter with one, making alternating rounds odd/even
                loopCounter++;

                terminal.flush();
            }

            // Max score is 2560, if player gets to this score they win
            if (pointCounter == 2560){
                terminal.close();
                win();
                break;
            }

            // If the user has lost, close the terminal and run lose()
            if (hasLost){
                terminal.close();
                lose();
                break;
            }

        }

    }

    public static List<Position> getPositions(int field){
        // Returns a list of positions on the board (level) based on input "field".
        // The method loops through the level matrix, and saves the position where the matrix
        // element equals "field" in a Position object. The Position objects are saved in an
        // ArrayList, and then returned
        int[][] level = {
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
                {0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,},
                {0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,},
                {0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,},
                {0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,},
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,},
                {0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,},
                {0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,},
                {0,1,1,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,1,1,0,},
                {0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,},
                {2,2,2,2,2,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,2,2,2,2,2,},
                {2,2,2,2,2,0,1,0,0,1,1,1,1,1,1,1,1,1,1,0,0,1,0,2,2,2,2,2,},
                {0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,},
                {0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,},
                {0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,},
                {0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,},
                {0,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,0,},
                {0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0,},
                {0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0,},
                {0,1,1,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,1,1,0,},
                {0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,},
                {0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,},
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,}
        };

        List<Position> positions = new ArrayList<Position>();
        for (int i = 0; i < level.length; i++){
            for (int j = 0; j < level[i].length; j++){
                if (level[i][j] == field){
                    positions.add(new Position(j, i));
                }
            }

        }
        return positions;
    }

    public static boolean isValidMove(List<Position> positions, int x, int y){
        // Returns false if x and y equals a position in list positions.
        // If x and y does not equal any position in positions, return true.
        for (Position p : positions){
            if (p.getX() == x && p.getY() == y){
                return false;
            }
        }
        return true;
    }

    public static List<Ghost> getNewGhosts(List<Ghost> ghosts, List<Position> blockPositions){
        // Returns an ArrayList of objects Ghosts with a randomized move relative to the inputted list "ghosts".
        // The method loops through every Ghost object in inputted list "ghosts", extracting the x and y coordinates.
        // Then, using Random() a number between 0 and 3 is drawn, and based on which number is drawn a new x- or y-coordinate
        // is set for the ghost. If the move is not valid, the algorithm will continue to draw random numbers until a
        // valid move can be made. The new Ghost objects is then stored in a list called newGhostPositions.
        List<Ghost> newGhostPositions = new ArrayList<>();
        for (Ghost g : ghosts) {
            int ghostX = g.getX();
            int ghostY = g.getY();
            boolean cont = true;

            while (cont) {
                Random r = new Random();
                int randomNumber = r.nextInt(4);
                switch (randomNumber) {
                    case 0:
                        if (isValidMove(blockPositions, ghostX + 1, ghostY)) {
                            newGhostPositions.add(new Ghost(new Position(ghostX + 1, ghostY)));
                            cont = false;
                        }
                        break;
                    case 1:
                        if (isValidMove(blockPositions, ghostX - 1, ghostY)) {
                            newGhostPositions.add(new Ghost(new Position(ghostX - 1, ghostY)));
                            cont = false;
                        }
                        break;
                    case 2:
                        if (isValidMove(blockPositions, ghostX, ghostY + 1)) {
                            newGhostPositions.add(new Ghost(new Position(ghostX, ghostY + 1)));
                            cont = false;
                        }
                        break;
                    case 3:
                        if (isValidMove(blockPositions, ghostX, ghostY - 1)) {
                            newGhostPositions.add(new Ghost(new Position(ghostX, ghostY - 1)));
                            cont = false;
                        }
                        break;
                }
            }
        }
        return newGhostPositions;
    }

    public static boolean hasItBeenVisited(List<Position> positions, int x, int y){
        // Checks if the input x, y has been visited by the player previously
        boolean hasItBeenVisited = false;

        for (Position p : positions){
            if (p.getX() == x && p.getY() == y){
                hasItBeenVisited = p.getHasBeenVisited();
            }
        }

        return hasItBeenVisited;
    }

    public static void visit(List<Position> positions, int x, int y){
        // To declare the input coordinates as "visited"
        for (Position p: positions){
            if (p.getX() == x && p.getY() == y){
                p.setHasBeenVisited(true);
                break;
            }
        }

    }

    public static void win() throws IOException, InterruptedException {
        // Shows a "winner" screen
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
        Terminal terminal = defaultTerminalFactory.createTerminal();


        terminal.clearScreen();
        terminal.setCursorPosition(31, 12);
        terminal.putString("YOU WIN!");
        terminal.flush();

        int xL = 30;
        int yU = 12;
        int xR = 38;
        int yD = 12;


        for (int i = 0; i < 10; i++) {
            xL -= 3;
            yU -= 2;
            xR += 3;
            yD += 2;


            terminal.setCursorPosition(xL, yU);
            terminal.putCharacter('\u0416');
            terminal.flush();
            terminal.setCursorPosition(xR, yU);
            terminal.putCharacter('\u0416');
            terminal.flush();
            terminal.setCursorPosition(xL, yD);
            terminal.putCharacter('\u0416');
            terminal.flush();
            terminal.setCursorPosition(xR, yD);
            terminal.putCharacter('\u0416');
            terminal.flush();
            terminal.setCursorPosition(xL, 12);
            terminal.putCharacter('\u0416');
            terminal.flush();
            terminal.setCursorPosition(xR, 12);
            terminal.putCharacter('\u0416');
            terminal.flush();
            terminal.setCursorPosition(34, yU);
            terminal.putCharacter('\u0416');
            terminal.flush();
            terminal.setCursorPosition(34, yD);
            terminal.putCharacter('\u0416');
            terminal.flush();


            Thread.sleep(200);
        }
    }

    public static void lose() throws IOException, InterruptedException {
        // shows a "loser" screen
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
        Terminal terminal = defaultTerminalFactory.createTerminal();


        terminal.clearScreen();
        terminal.setCursorPosition(31, 12);
        terminal.putString("YOU LOSE");
        terminal.flush();

        int xL = 30;
        int yU = 12;
        int xR = 38;
        int yD = 12;


        for (int i = 0; i < 10; i++) {
            xL -= 3;
            yU -= 2;
            xR += 3;
            yD += 2;


            terminal.setCursorPosition(xL, yU);
            terminal.putCharacter('\u0416');
            terminal.flush();
            terminal.setCursorPosition(xR, yU);
            terminal.putCharacter('\u0416');
            terminal.flush();
            terminal.setCursorPosition(xL, yD);
            terminal.putCharacter('\u0416');
            terminal.flush();
            terminal.setCursorPosition(xR, yD);
            terminal.putCharacter('\u0416');
            terminal.flush();
            terminal.setCursorPosition(xL, 12);
            terminal.putCharacter('\u0416');
            terminal.flush();
            terminal.setCursorPosition(xR, 12);
            terminal.putCharacter('\u0416');
            terminal.flush();
            terminal.setCursorPosition(34, yU);
            terminal.putCharacter('\u0416');
            terminal.flush();
            terminal.setCursorPosition(34, yD);
            terminal.putCharacter('\u0416');
            terminal.flush();

            Thread.sleep(200);

        }
    }

    public static List<Ghost> createGhosts(){
        // Returns a list of Ghosts-objects to be put initially on the board.
        List<Ghost> ghosts = new ArrayList<>();
        ghosts.add(new Ghost(new Position(1,1)));
        ghosts.add(new Ghost(new Position(1, 8)));
        ghosts.add(new Ghost(new Position(15, 20)));
        ghosts.add(new Ghost(new Position(12, 20)));
        ghosts.add(new Ghost(new Position(16, 5)));
        ghosts.add(new Ghost(new Position(16, 11)));
        ghosts.add(new Ghost(new Position(22, 1)));
        ghosts.add(new Ghost(new Position(6,18)));
        ghosts.add(new Ghost(new Position(26, 8)));
        return ghosts;
    }

    public static boolean isPortal(List<Position> positions, int x, int y){
        // checks if there is a portal at the coordinates
        boolean isPortal = false;

        Position portal = positions.get(0);
        Position portal2 = positions.get(23);

        if ((x == portal.getX() && y == portal.getY()) || (x == portal2.getX() && y == portal2.getY())) {
            isPortal = true;
        }

        return isPortal;
    }

}
