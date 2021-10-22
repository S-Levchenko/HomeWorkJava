package com.pb.levchenko.hw3;

import java.util.Random;
import java.util.Scanner;


public class Bingo {
    public static void main (String[] args) {

        Random random = new Random();

        int x = random.nextInt(101);
        System.out.println("rand " + x);
        System.out.println("Ваша задача угадать число от 0 до 100");
        System.out.println("Для выхода из игры напишите - 222");
        final int MAX_ATTEMPT = 101;
        int attempt = 0;
        int y;
        Scanner scanner = new Scanner(System.in);
        while (attempt < MAX_ATTEMPT) {
            attempt++;
            System.out.println("Введите число от 0 до 100");
            System.out.println("Попытка " + attempt + ":");
            y = scanner.nextInt();
            if (y == 222) {
                System.out.println("Вы вышли из программы");
                System.out.println("Игра окончена");
                break;
            }
            if (x == y) {
                System.out.println("Поздравляею, Вы угадали!!!" + "Попытка с которой Вы угадали " + attempt);
                System.out.println("Игра окончена");
                break;
            } else if (y > x) {
                System.out.println("Загаданное число меньше");
            } else {
                System.out.println("Загаданное число больше");

            }
        }
    }
}
