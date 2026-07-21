package com.yarukov;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Game {
    private Scanner scan = new Scanner(System.in);
    private Hangman hangman;
    private String mysteryWord;
    private StringBuilder userWord;
    HashSet<Character> unlock;

    public void newGame() {
        hangman = new Hangman();
        try {
            mysteryWord = Words.getWord();
            userWord = new StringBuilder("*".repeat(mysteryWord.length()));
            unlock = new HashSet<>();
            process(mysteryWord, userWord);
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public void process(String mysteryWord, StringBuilder userWord) {
        while (true) {
            System.out.println("Загаданное слово:");
            System.out.println(userWord);
            hangman.getCurrentHangman();
            System.out.println("Введите букву");
            String userString = scan.nextLine();
            if (userString.length() != 1) {
                System.out.println("Введите одну букву русского алфавита");
                continue;
            }
            if (!isRussianLetter(userString.charAt(0))) {
                System.out.println("Введите одну букву русского алфавита");
                continue;
            }

            char userIn = userString.toLowerCase().charAt(0);
            if (wasLetter(userIn)) {
                System.out.println("Вы уже вводили эту букву");
                continue;
            }
            unlock.add(userIn);
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
                System.out.println("Вы проиграли(\nЗагаданное слово: " + mysteryWord);
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

    private boolean isRussianLetter(char ch) {
        return String.valueOf(ch).matches("[а-яёА-ЯЁ]");
    }

    private boolean wasLetter(char ch) {
        return (unlock.contains(ch));
    }


}
