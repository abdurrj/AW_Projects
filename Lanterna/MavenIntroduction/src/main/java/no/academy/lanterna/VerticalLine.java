package no.academy.lanterna;

public class VerticalLine {
    final int length;
    final int xStartPos;
    final int yStartPos;
    final char block = '\u2588';
    int[][] vLinePos;

    public VerticalLine(int length, int xStartPos, int yStartPos) {
        this.length = length;
        this.xStartPos = xStartPos;
        this.yStartPos = yStartPos;
        makeArray(xStartPos, yStartPos, length);
    }

    private void makeArray(int xStartPos, int yStartPos, int length){
        vLinePos = new int[length][2];
        for (int i = 0; i<length; i++){
            vLinePos[i] = new int[]{xStartPos, yStartPos + i};
        }
    }


}
