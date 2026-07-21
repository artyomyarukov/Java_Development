package com.yarukov;

import java.nio.file.Path;
import java.util.Scanner;




public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
         while (true) {
            System.out.println("Начать новую игру (1), завершить (0)");
            int answer = scan.nextLine().charAt(0) - '0';
            if (answer == 1) {
                Game game = new Game();
                game.newGame();
            }
            if (answer == 0) {
                System.out.println("Завершаем игру");
                break;
            } else {
                System.out.println("Введите ответ еще раз 0/1");
            }
        }
    }
}