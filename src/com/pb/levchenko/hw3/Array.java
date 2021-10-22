package com.pb.levchenko.hw3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 10 целых чисел, пожалуйста");
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("Ваш массив: " + "[" + array[0] +","+ array[1] + "," + array[2] +","+ array[3] +","+ array[4] + "," + array[5] +","+ array[6] +","+ array[7] + "," + array[8] +","+ array[9] + ","+ "]");
        int total = IntStream.of(array).sum();
        System.out.println("Сумма всех элементов Вашего массива: " + total);
        int positive = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                positive++;
            }
        }
        System.out.println("Количество положительных элементов в Вашем массиве: " + positive);

        for (int i = 0; i < array.length; i++) {
            boolean Sort = false;
            int buf;
            while (!Sort) {
                Sort = true;
                for (i = 0; i < array.length - 1; i++) {
                    if (array [i] > array [i+1]) {
                        Sort = false;

                        buf = array[i];
                        array[i] = array[i+1];
                        array[i+1] = buf;
                    }
                }
            }
            System.out.println("Отсортированный массив: " + Arrays.toString(array));
        }
    }
}








