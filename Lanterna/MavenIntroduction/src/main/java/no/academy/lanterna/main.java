package no.academy.lanterna;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalFactory;

import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException, InterruptedException {

        TerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal t = terminalFactory.createTerminal();
        t.setCursorPosition(1,1);
        t.putCharacter('A');
        t.flush();
        for (int column = 4; column<10;column++){
            t.setCursorPosition((column), 4);
            t.putCharacter('X');
        }
        t.flush();

        String testString = "This is a tring printed out in Lanterna by iterating over the characters";
        char[] chArray = testString.toCharArray();

        for (int i = 0; i<chArray.length;i++){
            System.out.println(chArray[i]);
            t.setCursorPosition((i), 4);
            t.putCharacter(chArray[i]);
        }

        KeyStroke keyStroke = null;


        do {
            Thread.sleep(5); // might throw InterruptedException
            keyStroke = t.pollInput();
        } while (keyStroke == null);
        t.flush();
    }
}
