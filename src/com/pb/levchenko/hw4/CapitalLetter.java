package com.pb.levchenko.hw4;

import java.util.Scanner;

public class CapitalLetter {
    public static void main(String[] args) {
        System.out.println("Введите, пожалуйста строку");
        Scanner scanner = new Scanner(System.in);
        String abc = scanner.nextLine();
        metod(abc);
        System.out.println("Ваша фраза: "+ metod(abc));
    }


   public static String metod (String phrase) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String value: phrase.split(" ")) {
            stringBuilder.append(Character.toUpperCase(value.charAt(0)));
            stringBuilder.append(value.substring(1,value.length()));
            stringBuilder.append(" ");
        }
        return " " + stringBuilder;
   }
    }




