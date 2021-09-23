package no.academy.lanterna;

import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static no.academy.lanterna.Main.*;
import static no.academy.lanterna.MoveCheck.isWall;

public class Coffee {
    int xPos;
    int yPos;
    char coffeeCup = '\u2615';


    public Coffee(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    /**
     * Places the coffee cup on the map at the start of the game
     * If initial placement is a wall, it will randomly relocate it.
     * @param terminal is the terminal running the game.
     * @param lineList is a list containing walls.
     * */
    public void placeInitialCoffee(Terminal terminal, List<Line> lineList) throws IOException {
        terminal.setForegroundColor(textAndCoffeeColor);
        while(isWall(lineList, xPos, yPos)){
            xPos = ThreadLocalRandom.current().nextInt(terminal.getTerminalSize().getColumns());
            yPos = ThreadLocalRandom.current().nextInt(terminal.getTerminalSize().getRows());
        }
        terminal.setCursorPosition(xPos, yPos);
        terminal.putCharacter(coffeeCup);
        terminal.flush();
    }

    /**
     * Randomly relocates the coffee cup on the game board.
     * Makes sure new location is not occupied by a wall or a co-worker.
     * It will also never place the cup on the start location for new co-workers, cup is moved as a new co-worker arrives
     * @param terminal is the terminal running the game.
     * @param lineList is the list containing walls.
     * @param coWorkerList is the list containing co-workers
     * */
    public void relocateCoffee(Terminal terminal, List<Line> lineList, List<CoWorker> coWorkerList) throws IOException {
        int newX = ThreadLocalRandom.current().nextInt(terminal.getTerminalSize().getColumns());
        int newY = ThreadLocalRandom.current().nextInt(terminal.getTerminalSize().getRows());
        terminal.setCursorPosition(newX, newY);
        while(isWall(lineList, terminal) || MoveCheck.isCoWorker(coWorkerList, newX, newY) || (newX == coWorkerEntryX && newY == coWorkerEntryY)){
            newX = ThreadLocalRandom.current().nextInt(terminal.getTerminalSize().getColumns());
            newY = ThreadLocalRandom.current().nextInt(terminal.getTerminalSize().getRows());
            terminal.setCursorPosition(newX, newY);
        }
        xPos = newX;
        yPos = newY;
        terminal.setForegroundColor(textAndCoffeeColor);
        terminal.setCursorPosition(newX, newY);
        terminal.putCharacter(coffeeCup);
    }
}
