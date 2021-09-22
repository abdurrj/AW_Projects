package no.academy.lanterna;

import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


import static no.academy.lanterna.main.isWall;
import static no.academy.lanterna.main.isGoal;

public class CoWorker {
    int xPos;
    int yPos;
    char ghostChar = 'K';


    public CoWorker(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void moveGhost(CoWorker coWorker, Terminal terminal, int difficulty, UserPlayer player, List<Line> lineList, Coffee coffeeCup) throws IOException {
        for (int i = 0; i < difficulty; i++) {
            int xPrevGhost = coWorker.xPos;
            int yPrevGhost = coWorker.yPos;
            int moveDirection = ThreadLocalRandom.current().nextInt(0, 2);

            if (moveDirection == 0 || coWorker.yPos == player.yPos) {
                if (player.xPos > coWorker.xPos) {
                    terminal.setCursorPosition(coWorker.xPos + 1, coWorker.yPos);
                    if (!isWall(lineList, terminal) && !isGoal(coWorker.xPos+1, coWorker.yPos, coffeeCup)) {
                        coWorker.xPos++;
                    }
                }
                if (player.xPos < coWorker.xPos) {
                    terminal.setCursorPosition(coWorker.xPos - 1, coWorker.yPos);
                    if (!isWall(lineList, terminal) && !isGoal(coWorker.xPos-1, coWorker.yPos, coffeeCup)) {
                        coWorker.xPos--;
                    }
                }
            } else {
                if (player.yPos > coWorker.yPos) {
                    terminal.setCursorPosition(coWorker.xPos, coWorker.yPos + 1);
                    if (!isWall(lineList, terminal) && !isGoal(coWorker.xPos, coWorker.yPos+1, coffeeCup)) {
                        coWorker.yPos++;
                    }
                }
                if (player.yPos < coWorker.yPos) {
                    terminal.setCursorPosition(coWorker.xPos, coWorker.yPos - 1);
                    if (!isWall(lineList, terminal) && !isGoal(coWorker.xPos, coWorker.yPos-1, coffeeCup)) {
                        coWorker.yPos--;
                    }
                }
            }
            terminal.setCursorPosition(coWorker.xPos, coWorker.yPos);
            terminal.putCharacter(coWorker.ghostChar);
            if (xPrevGhost != coWorker.xPos || yPrevGhost != coWorker.yPos) {
                terminal.setCursorPosition(xPrevGhost, yPrevGhost);
                terminal.putCharacter(' ');
            }
        }
    }

}
