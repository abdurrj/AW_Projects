package no.academy.lanterna;

import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.List;

public class MoveCheck {


    // for alle linjer i linjelista, sjekk om posisjonen til spiller er en veggposisjon
    /**
     * To check if the new cursor position is occupied by a wall.
     * Returns true if the cursor position is on a wall.
     * @param lineList is the list of all Line objects
     * @param terminal is the terminal running the game
     * @return boolean
     * */
    public static boolean isWall(List<Line> lineList, Terminal terminal) throws IOException {
        for (Line line : lineList) {
            for (int i = 0; i < line.length; i++) {
                int tRow = terminal.getCursorPosition().getRow();
                int tCol = terminal.getCursorPosition().getColumn();
                int[] linePos = line.linePos[i];
                if (tRow == linePos[1] && tCol == linePos[0]) {
                    return true; // Hvis det er vegg, returner true (if wall sjekke oppe)
                }
            }
        }
        return false;
    }

    /**
     * To check if the x,y coordinate is occupied by a wall.
     * Returns true if the coordinate is occupied by a wall.
     * @param lineList is the list of all Line objects
     * @param x is the specific row to check
     * @param y is the specific column to check
     * @return boolean
     * */
    public static boolean isWall(List<Line> lineList, int x, int y) throws IOException {
        for (Line line : lineList) {
            for (int i = 0; i < line.length; i++) {
                int[] linePos = line.linePos[i];
                if (x == linePos[1] && y == linePos[0]) {
                    return true; // Hvis det er vegg, returner true (if wall sjekke oppe)
                }
            }
        }
        return false;
    }

    /**
     * To check if the coWorker object is sharing location with the player.
     * Returns true if the coWorker and player are occupying the same spot.
     * @param coWorkerList is the list of all Line objects.
     * @param player is the player object.
     * @return boolean
     * */
    public static boolean isCoWorker(List<CoWorker> coWorkerList, Player player){
        for (CoWorker g : coWorkerList){
            if (g.xPos == player.xPos && g.yPos == player.yPos){
                return true;
            }
        }
        return false;
    }

    /**
     * To check if the coWorker object is occupying a specific location.
     * Returns true if the coWorker is occupying the given x,y coordinate.
     * @param coWorkerList is the list of all Line objects.
     * @param x is the specific row to check.
     * @param y is the specific column to check.
     * @return boolean
     * */
    public static boolean isCoWorker(List<CoWorker> coWorkerList, int x, int y){
        for (CoWorker g : coWorkerList){
            if (g.xPos == x && g.yPos == y){
                return true;
            }
        }
        return false;
    }


    /**
     * To check if the player is occupying the same location as the coffee cup.
     * Returns true if they share location.
     * @param player is the user object.
     * @param coffeeCup is the cup of coffee
     * @return boolean
     * */
    public static boolean isCoffee(Player player, Coffee coffeeCup){
        return player.xPos == coffeeCup.xPos && player.yPos == coffeeCup.yPos;
    }


    /**
     * To check if the coffee cup is occupying the given x,y location.
     * Returns true if they are not sharing location.
     * @param x is the specific row to check.
     * @param y is the specific column to check.
     * @param coffeeCup is the cup of coffee.
     * @return boolean
     * */
    public static boolean isNotCoffee(int x, int y, Coffee coffeeCup){
        return x != coffeeCup.xPos || y != coffeeCup.yPos;
    }
}
