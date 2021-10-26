package com.pb.levchenko.hw4;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main (String [] args) {
        System.out.println("Введите строку abc, пожалуйста");
        Scanner scanner = new Scanner(System.in);
        String abc = scanner.nextLine();
        System.out.println("Введите строку cba, пожалуйста");
        String cba = scanner.nextLine();
        isAnagram(abc,cba);
        System.out.println("Ваш текст: " + isAnagram(abc,cba));
    }
    public static String isAnagram(String first, String second) {
        if (first == null || second == null || first.equals(" ") || second.equals(" ") || !first.matches("[А-Яа-я,. ]+")
        || !second.matches("[А-Яа-я,. ]+")) {
         return "Не анаграмма";

        }
        String answer = " ";

        String st = first.replaceAll("[,. ]+"," ");
        String nd = second.replaceAll("[,. ]+"," ");

        if (st.equals(" ") || nd.equals(" ")) {
            return "Не анаграмма";
        }
        char[] arraySt = st.toCharArray();
        char[] arrayNd = nd.toCharArray();
        Arrays.sort(arraySt);
        Arrays.sort(arrayNd);

        if (Arrays.equals(arraySt,arrayNd)) {
            answer = "Анаграмма";
        } else {
            answer = "Не анаграмма";
        }
        return answer;
    }
    }



