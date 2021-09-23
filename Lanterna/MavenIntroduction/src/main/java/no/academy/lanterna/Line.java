package no.academy.lanterna;

import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public abstract class Line {
    int[][] linePos;
    int length;
    int xStartPos;
    int yStartPos;
    final char block = '\u2588';

    public Line(int length, int xStartPos, int yStartPos) {
        this.length = length;
        this.xStartPos = xStartPos;
        this.yStartPos = yStartPos;
    }

    /**
     * Make every point of the wall to an array. The array is for wall check
     * @param xStartPos starting row
     * @param yStartPos starting columt
     * @param length length of the line
     */
    abstract void makeArray(int xStartPos, int yStartPos, int length);


    /**
     * Method to draw the line inn on the game board
     * @param line is the Line object to draw in
     * @param terminal that is running the game
     * */
    public abstract void makeLine(Line line, Terminal terminal) throws IOException;
}
