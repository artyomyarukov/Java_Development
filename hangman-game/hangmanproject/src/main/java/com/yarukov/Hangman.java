package com.yarukov;

public class Hangman {
    private int unrightWords = 0;
    private final static String[] hangmanArray = {
            "\n\n\n",
            " 0 \n\n\n",
            " 0 \n | \n\n",
            " 0 \n-| \n\n",
            " 0 \n-|- \n\n",
            " 0 \n-|- \n/\n",
            " 0 \n-|- \n/ \\\n",
    };

    public Hangman() {
    }

    public void miss() {
        ++unrightWords;
    }

    public int getUnrightWords() {
        return unrightWords;
    }

    public void getCurrentHangman() {
        System.out.println(hangmanArray[unrightWords]);
    }
}
