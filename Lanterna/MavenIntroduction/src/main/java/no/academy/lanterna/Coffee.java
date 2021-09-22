package no.academy.lanterna;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import static no.academy.lanterna.main.isWall;
import static no.academy.lanterna.main.isGhost;

public class Coffee {
    int xPos;
    int yPos;
    char coffeCup = '\u2615';

    public Coffee(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void RelocateCoffee(Terminal terminal, List<Line> lineList, List<CoWorker> coWorkerList) throws IOException {
        int newX = ThreadLocalRandom.current().nextInt(80);
        int newY = ThreadLocalRandom.current().nextInt(24);
        terminal.setCursorPosition(newX, newY);
        while(isWall(lineList, terminal)||isGhost(coWorkerList, newX, newY)){
            newX = ThreadLocalRandom.current().nextInt(80);
            newY = ThreadLocalRandom.current().nextInt(24);
            terminal.setCursorPosition(newX, newY);
        }
        xPos = newX;
        yPos = newY;
        terminal.setForegroundColor(TextColor.ANSI.WHITE);
        terminal.setCursorPosition(newX, newY);
        terminal.putCharacter(coffeCup);
    }
}
