package com.pb.levchenko.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int operand1;
        System.out.println("Введите целое число");
        operand1 = scan.nextInt();
        if (operand1 >= 0 && operand1 <= 14) {
            System.out.println("Ваше число входит в диапазон от 0 до 14 включительно");
        }
        else if (operand1 >= 15 && operand1 <= 35) {
            System.out.println("Ваше число входит в диапазон от 15 до 35 включительно");
        }
        else if (operand1 >= 36 && operand1 <= 50) {
            System.out.println("Ваше число входит в диапазон от 36 до 50 включительно");
        }
        else if (operand1 >= 51 && operand1 <= 100) {
            System.out.println("Ваше число входит в диапазон от 51 до 100 включительно");
        } else {
            System.out.println("Ваше число не входит ни в один из диапазонов");
        }
    }
}
