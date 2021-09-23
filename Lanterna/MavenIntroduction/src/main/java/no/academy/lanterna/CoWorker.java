package no.academy.lanterna;

import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static no.academy.lanterna.MoveCheck.isNotCoffee;
import static no.academy.lanterna.MoveCheck.isWall;

public class CoWorker {
    int xPos;
    int yPos;
    char coWorkerChar = '\u25CF';


    public CoWorker(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    /**
     * To move the individual co-worker on the map, one step at the time.
     * It will randomly decide whether to move in an X or Y direction, unless player y == co-worker y.
     * In that case it will try moving in the x direction
     * @param terminal is the terminal running the game.
     * @param difficulty is amount of steps the co-workers can take for your single step.
     * @param player to check for player location when moving.
     * @param lineList is list of walls.
     * @param coffeeCup is the coffee cup object.
     * */
    public void moveCoWorker(Terminal terminal, int difficulty, Player player, List<Line> lineList, Coffee coffeeCup) throws IOException {
        for (int i = 0; i < difficulty; i++) {
            int xPrevGhost = xPos;
            int yPrevGhost = yPos;
            int moveDirection = ThreadLocalRandom.current().nextInt(0, 2);

            if (moveDirection == 0 || yPos == player.yPos) {
                if (player.xPos > xPos) {
                    terminal.setCursorPosition(xPos + 1, yPos);
                    if (!isWall(lineList, terminal) && MoveCheck.isNotCoffee(xPos + 1, yPos, coffeeCup)) {
                        xPos++;
                    }
                }
                if (player.xPos < xPos) {
                    terminal.setCursorPosition(xPos - 1, yPos);
                    if (!isWall(lineList, terminal) && MoveCheck.isNotCoffee(xPos - 1, yPos, coffeeCup)) {
                        xPos--;
                    }
                }
            } else {
                if (player.yPos > yPos) {
                    terminal.setCursorPosition(xPos, yPos + 1);
                    if (!isWall(lineList, terminal) && MoveCheck.isNotCoffee(xPos, yPos + 1, coffeeCup)) {
                        yPos++;
                    }
                }
                if (player.yPos < yPos) {
                    terminal.setCursorPosition(xPos, yPos - 1);
                    if (!isWall(lineList, terminal) && MoveCheck.isNotCoffee(xPos, yPos - 1, coffeeCup)) {
                        yPos--;
                    }
                }
            }
            terminal.setCursorPosition(xPos, yPos);
            terminal.putCharacter(coWorkerChar);
            if (xPrevGhost != xPos || yPrevGhost != yPos) {
                terminal.setCursorPosition(xPrevGhost, yPrevGhost);
                terminal.putCharacter(' ');
            }
        }
    }


    /**
     * Method to make the co-workers at the start of the game.
     * @param amount to set the number of co-workers the game starts with.
     * @param terminal is the terminal running the game
     * @param lineList is the list of walls. To not place co-worker in wall
     * @param coffee is the coffee cup. To not place co-worker on coffee cup
     * @param player To avoid placing co-worker on top of player.
     * @return List of CoWorker objects
     * */
    public static List<CoWorker> makeCoWorker(int amount, Terminal terminal, List<Line> lineList, Coffee coffee, Player player) throws IOException {
        List<CoWorker> coWorkerList = new ArrayList<>();
        for (int i = 0; i<amount;i++){
            Random r = new Random();
            int x = r.nextInt(terminal.getTerminalSize().getColumns());
            int y = r.nextInt(terminal.getTerminalSize().getRows());
            terminal.setCursorPosition(x, y);
            while(isWall(lineList, terminal) || !isNotCoffee(x, y, coffee) || (x==player.xPos && y==player.yPos)) {
                x = r.nextInt(terminal.getTerminalSize().getColumns());
                y = r.nextInt(terminal.getTerminalSize().getRows());
                terminal.setCursorPosition(x, y);
            }
            CoWorker coWorker = new CoWorker(x, y);
            coWorkerList.add(coWorker);
        }
        return coWorkerList;
    }

}
