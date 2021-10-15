package com.pb.levchenko.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int operand1;
        int operand2;
        String symbol;

        System.out.println("Пожалуйста, введите целое число");
        operand1 = scan.nextInt();
        System.out.println("Пожалуйста, введите знак , например +,-,*,/");
        symbol = scan.next();
        System.out.println("Пожалуйста, введите целое число");
        operand2 = scan.nextInt();
        int result;
        switch (symbol) {
            case "+":
                result = operand1 + operand2;
                System.out.println("Ответ : " + result);
                break;
            case "-":
                result = operand1 - operand2;
                System.out.println("Ответ : " + result);
                break;
            case "*":
                result = operand1 * operand2;
                System.out.println("Ответ : " + result);
                break;
            case "/":
                if (operand2 == 0) {
                    System.out.println("не делите на 0");
                System.exit(0);}
                    else {
                        System.out.println("Ответ : " + (operand1 / operand2));
                    }
                    }
                }
        }










