package com.example.randomvitsabdur;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class RandomVits {
    static Map<Integer, String> jokeMap;
    static List<String> jokeList = new ArrayList<>();

    static String[] jokes = {
            "To steiner skulle over en vei. Først gikk den ene trygt over. Når den andre skulle krysse, ble den påkjørt. Oi sann.",
            "Mye bra med Sveits. Flagget er definetivt et stort pluss.",
            "Joke nr 3",
            "Joke nr 4",
            "Joke nr 5",
            "Joke nr 6",
            "Joke nr 7",
            "Joke nr 8",
            "Joke nr 9",
            "Joke nr 10"
    };
    static int previousjoke = 0;

    public static void generateList(){
        jokeList.add("To steiner skulle over en vei. Først gikk den ene trygt over. Når den andre skulle krysse, ble den påkjørt. Oi sann.");
        jokeList.add("Mye bra med Sveits. Flagget er definetivt et stort pluss.");
        jokeList.add("Joke nr 3");
        jokeList.add("Joke nr 4");
        jokeList.add("Joke nr 5");
        jokeList.add("Joke nr 6");
        jokeList.add("Joke nr 7");
        jokeList.add("Joke nr 8");
        jokeList.add("Joke nr 9");
        jokeList.add("Joke nr 10");
    }

    public static void addJoke(String joke){
        jokeList.add(joke);
    }

    public String displayJoke(){
        int jokenr;
        do {
            jokenr = ThreadLocalRandom.current().nextInt(jokeList.size());
        }while(jokenr == previousjoke);
        previousjoke = jokenr;
        return jokeList.get(jokenr);
    }

}
