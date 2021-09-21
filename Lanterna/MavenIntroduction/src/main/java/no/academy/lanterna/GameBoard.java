package no.academy.lanterna;

import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.*;
import java.awt.*;
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
        int terminalSizeX = terminal.getTerminalSize().getRows();
        int terminalSizeY = terminal.getTerminalSize().getColumns();

        // Walls
        Line lWall = new VerticalLine(terminalSizeY, 1, 0);
        Line lWallB = new VerticalLine(terminalSizeY, 0, 0);
        Line rWall = new VerticalLine(terminalSizeY, terminalSizeY - 1, 0);
        Line rWallB = new VerticalLine(terminalSizeY, terminalSizeY - 2, 0);
        Line upperWall = new HorizontalLine(terminalSizeY, 0, 0);
        Line lowerWall = new HorizontalLine(terminalSizeY, 0, terminalSizeX - 1);

        // Maze
        // Boxes
        for (int i = 9; i<terminalSizeY-13;i+=13){
            lineList.addAll(BoxMaker(2, 10, i, 3));
            lineList.addAll(BoxMaker(2, 10, i, 7));
            lineList.addAll(BoxMaker(2, 10, i, 19));
            lineList.addAll(BoxMaker(2, 10, i, 15));
        }
/*        List<Line> boxUpperLeftCornerFat = BoxMaker(2, 10,6, 3);
        List<Line> boxUpperLeftCornerThin = BoxMaker(1, 10,6, 6);
        List<Line> boxLowerLeft2 = BoxMaker(1, 10,6, 17);
        List<Line> boxLowerLeft1 = BoxMaker(2, 10,6, 19);
        List<Line> boxUpperLeft3 = BoxMaker(2, 10,19, 3);
        List<Line> boxUpperLeft4 = BoxMaker(1, 10,19, 6);
        List<Line> boxLowerLeft3 = BoxMaker(1, 10,19, 17);
        List<Line> boxLowerLeft4 = BoxMaker(2, 10,19, 19);
        List<Line> wallExtendLeft = BoxMaker(6, 16, 0, 9);
        List<Line> boxLowerLeft = BoxMaker(4, 3,4, 4);
        List<Line> boxUpperRight = BoxMaker(6,3, 40, 4);
        List<Line> boxLowerRight = BoxMaker(4,3, 40, 17);


        // Add to list
        lineList.addAll(boxUpperLeftCornerFat);
        lineList.addAll(boxUpperLeftCornerThin);
        lineList.addAll(boxLowerLeft2);
        lineList.addAll(boxLowerLeft1);
        lineList.addAll(wallExtendLeft);
        lineList.addAll(boxUpperLeft3);
        lineList.addAll(boxUpperLeft4);
        lineList.addAll(boxLowerLeft3);
        lineList.addAll(boxLowerLeft4);*/

//        lineList.addAll(boxLowerLeft);
//        lineList.addAll(boxLowerRight);
//        lineList.addAll(boxUpperRight);


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
