package com.yarukov;

import java.util.Scanner;

public class Game {
    private Scanner scan = new Scanner(System.in);
    private Hangman hangman;
    private String mysteryWord;
    private StringBuilder userWord;

    public void newGame() {
        hangman = new Hangman();
        mysteryWord = Words.getWord();
        userWord = new StringBuilder("*".repeat(mysteryWord.length()));
        process(mysteryWord, userWord);
    }

    public void process(String mysteryWord, StringBuilder userWord) {
        while (true) {
            System.out.println("Загаданное слово:");
            System.out.println(userWord);
            hangman.getCurrentHangman();
            System.out.println("Введите букву");
            Character userIn = scan.next().charAt(0);
            boolean flag = false;
            for (int j = 0; j < mysteryWord.length(); j++) {
                if (mysteryWord.charAt(j) == userIn) {
                    flag = true;
                    userWord.setCharAt(j, userIn);
                }
            }
            if (!flag) {
                hangman.miss();
            }
            if (hangman.getUnrightWords() == 6) {
                System.out.println("Вы проиграли(");
                hangman.getCurrentHangman();
                break;
            }
            if (userWord.indexOf("*") < 0) {
                System.out.println(mysteryWord);
                System.out.println("Вы выйграли");
                break;
            }
        }
    }

}
