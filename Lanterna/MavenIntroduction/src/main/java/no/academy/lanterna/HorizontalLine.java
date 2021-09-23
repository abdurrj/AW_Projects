package no.academy.lanterna;

import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class HorizontalLine extends Line {


    public HorizontalLine(int length, int xStartPos, int yStartPos) {
        super(length, xStartPos, yStartPos);
        makeArray(xStartPos, yStartPos, length);
    }


    protected void makeArray(int xStartPos, int yStartPos, int length){
        super.linePos = new int[length][2];
        for (int i = 0; i<length; i++){
            super.linePos[i] = new int[]{xStartPos+i, yStartPos};
        }
    }

    public void makeLine(Line line, Terminal terminal) throws IOException {
        for (int i = 0; i<line.length;i++){
            terminal.setCursorPosition((line.xStartPos + i), line.yStartPos);
            terminal.putCharacter(line.block);
        }
    }
}


