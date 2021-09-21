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

    abstract void makeArray(int xStartPos, int yStartPos, int length);

    public abstract void makeLine(Line line, Terminal terminal) throws IOException;
}
