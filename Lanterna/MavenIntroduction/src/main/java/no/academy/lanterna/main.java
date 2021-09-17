package no.academy.lanterna;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException, InterruptedException {

        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
        Terminal terminal = defaultTerminalFactory.createTerminal();
        terminal.setCursorVisible(false);
/*        terminal.setCursorPosition(1,1);
        terminal.putCharacter('A');
        terminal.flush();
        for (int column = 4; column<10; column++){
            terminal.setCursorPosition(column, 4);
            terminal.putCharacter('X');
        }
        terminal.flush();

        String text = "This is a String printed out in Lanterna by iterating over the characters";
        char[] charArray = text.toCharArray();
        for (int i = 0; i< charArray.length; i++){
            terminal.setCursorPosition(i, 8);
            terminal.putCharacter(charArray[i]);
        }
        terminal.flush();*/

        int x = 10;
        int y = 10;
        final char player = 'X';
        terminal.setCursorPosition(x, y);
        terminal.putCharacter(player);
        boolean continueReadingInput = true;
        while(continueReadingInput){
            int xPrevious = x;
            int yPrevious = y;
            KeyStroke keyStroke = null;
            do {
                Thread.sleep(5);
                keyStroke = terminal.pollInput();
            }while(keyStroke==null);
            KeyType type = keyStroke.getKeyType();
            Character c = keyStroke.getCharacter();
            switch(type){
                case ArrowDown -> {
                    y++;
                }
                case ArrowUp -> {
                    y--;
                }
                case ArrowLeft -> {
                    x--;
                }
                case ArrowRight -> {
                    x++;
                }
            }
            System.out.println(type);
            System.out.println(c);
            terminal.setCursorPosition(x, y);
            terminal.putCharacter(player);
            terminal.setCursorPosition(xPrevious, yPrevious);
            terminal.putCharacter(' ');
            if (c == Character.valueOf('q')){
                continueReadingInput = false;
                System.out.println("quit");
            }
            terminal.flush();

            

        }






    }
}
