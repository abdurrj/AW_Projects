package no.academy.lanterna;

import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GameBoard extends JFrame {


    public static List<Line> BoxMaker(int length,int width, int xStartPos, int yStartPos){
        List<Line> box = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            box.add(new VerticalLine(length, xStartPos+i, yStartPos));
        }
        return box;
    }

    public static List<Line> MapMaker(Terminal terminal) throws IOException {
        List<Line> lineList = new ArrayList<>();
//        int terminalSizeX = terminal.getTerminalSize().getRows();
        int terminalSizeX = 24;
//        int terminalSizeY = terminal.getTerminalSize().getColumns();
        int terminalSizeY = 80;

        // Walls
        Line lWall = new VerticalLine(terminalSizeY, 1, 0);
        Line lWallB = new VerticalLine(terminalSizeY, 0, 0);
        Line rWall = new VerticalLine(terminalSizeY, terminalSizeY - 1, 0);
        Line rWallB = new VerticalLine(terminalSizeY, terminalSizeY - 2, 0);
        Line upperWall = new HorizontalLine(terminalSizeY, 0, 0);
        Line lowerWall = new HorizontalLine(terminalSizeY, 0, terminalSizeX - 1);

        // Boxes
        for (int i = 9; i<terminalSizeY-13;i+=13){
            lineList.addAll(BoxMaker(2, 10, i, 3));
            lineList.addAll(BoxMaker(2, 10, i, 7));
            lineList.addAll(BoxMaker(2, 10, i, 19));
            lineList.addAll(BoxMaker(2, 10, i, 15));
            lineList.addAll(BoxMaker(4, 4, i+3, 10));
        }

        // Add walls to wall list
        lineList.add(lWall);
        lineList.add(lWallB);
        lineList.add(rWall);
        lineList.add(rWallB);
        lineList.add(upperWall);
        lineList.add(lowerWall);

        return lineList;
    }

}
