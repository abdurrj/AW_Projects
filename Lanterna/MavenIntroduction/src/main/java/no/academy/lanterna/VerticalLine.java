package no.academy.lanterna;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;


public class VerticalLine extends Line {

    public VerticalLine(int length, int xStartPos, int yStartPos) {
        super(length, xStartPos, yStartPos);
        makeArray(xStartPos, yStartPos, length);
    }

    protected void makeArray(int xStartPos, int yStartPos, int length){
        super.linePos = new int[length][2];
        for (int i = 0; i<length; i++){
            super.linePos[i] = new int[]{xStartPos, yStartPos + i};
        }
    }

    public void makeLine(Line line, Terminal terminal) throws IOException {
        for (int i = 0; i<line.length;i++){
            terminal.setForegroundColor(TextColor.ANSI.BLACK_BRIGHT);
            terminal.setCursorPosition(line.xStartPos, line.yStartPos + i);
            terminal.putCharacter(line.block);
        }
    }

}
