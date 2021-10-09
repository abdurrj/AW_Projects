package no.academy.lanterna;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GameBoard extends JFrame {

    /**
     * Method to create and stack lines, creating solid blocks with specified height and width.
     * @param height is the vertical height
     * @param width is the horizontal width
     * @param xStartPos starting row
     * @param yStartPos starting column
     * @return List of no.academy.lanterna.Line objects
     * */
    public static List<Line> boxMaker(int height, int width, int xStartPos, int yStartPos){
        List<Line> box = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            box.add(new VerticalLine(height, xStartPos+i, yStartPos));
        }
        return box;
    }

    /**
     * Static method to make the game board with outer walls and obstacles in the middle.
     * To make walls
     * @param terminal is the terminal running the game
     * @return List of no.academy.lanterna.Line objects
     * */
    public static List<Line> mapMaker(Terminal terminal) throws IOException {
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

        // Boxes
        for (int i = 9; i<terminalSizeY-13;i+=13){
            lineList.addAll(boxMaker(2, 10, i, 3));
            lineList.addAll(boxMaker(2, 10, i, 7));
            lineList.addAll(boxMaker(2, 10, i, 19));
            lineList.addAll(boxMaker(2, 10, i, 15));
            lineList.addAll(boxMaker(4, 4, i+3, 10));
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

    /**
     * Put the stating screen on the terminal.
     * @param textGraphics is the texGraphics object used to draw on the terminal.
     * */
    static void startScreen(TextGraphics textGraphics) {
        String info = "Bli kvitt gruff ved å drikke kaffekoppene.";
        String info2 = "Men pass deg for slitsomme kollegaer...";
        textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
        textGraphics.putString(32, 6, "Morgengretten ¦:(", SGR.BOLD); // ☹ gets cut off
        textGraphics.putString(20, 8, info, SGR.ITALIC);
        textGraphics.putString(20, 9, info2, SGR.ITALIC);

        textGraphics.putString(28, 12, "Trykk spacebar for å starte!", SGR.BLINK);
        textGraphics.putString(28, 13, "Trykk q for å avslutte!", SGR.BLINK);
    }

    /**
     * Method called when updating player score on screen.
     * @param terminal is the terminal running the game
     * @param screen is the screen object that is a part of the terminal
     * @param textGraphics is the texGraphics object used to draw on the terminal.
     * @param cupScore is the counter for number of cups taken
     * @param veggFarge ANSI text color for the color to draw the background of cup score
     * */
    static void updateScore(Terminal terminal, Screen screen, TextGraphics textGraphics, int cupScore, TextColor.ANSI veggFarge) throws IOException {
        terminal.setCursorVisible(false);
        textGraphics.setBackgroundColor(veggFarge);
        textGraphics.setForegroundColor(Main.textAndCoffeeColor);
        textGraphics.putString(33, 0, "High Score: " + cupScore, SGR.BOLD);
        screen.refresh();
        terminal.resetColorAndSGR();
        terminal.setCursorVisible(false);
    }

    /**
     * Method called to draw the lines from the List of lines making up all walls and obstacles.
     * @param lineList is the list of line objects.
     * @param terminal is the terminal running the game.
     * */
    public static void drawLine(List<Line> lineList, Terminal terminal) throws IOException {
        for (Line line : lineList) {
            line.makeLine(line, terminal);
            }
        terminal.flush();
    }
}
