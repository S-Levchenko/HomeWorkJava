package com.pb.levchenko.homework8;

import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) {
        String password;
        String login;
        String confirmPassword;
        String password1;
        String login1;
        Scanner input = new Scanner(System.in);
        System.out.println("Регистация: ");
        System.out.println("Придумайте логин: ");
        login = input.nextLine();
        System.out.println("Придумайте пароль: ");
        password = input.nextLine();
        System.out.println("Подтвердите пароль: ");
        confirmPassword = input.nextLine();

        Auth auth = new Auth(login, password);


        try {
            auth.singUp(login, password, confirmPassword);

        } catch (WrongLoginException1 | WrongPasswordException1 e) {
            e.printStackTrace();
            return;
        }
        System.out.println("Вход на сайт: ");
        System.out.println("Введите пожалуйста логин: ");
        login1 = input.nextLine();
        System.out.println("Введите пожалуйста пароль: ");
        password1 = input.nextLine();
        try {
        auth.singIn(login1,password1);
        } catch (WrongLoginException1 e1) {
            e1.printStackTrace();


        }
    }
}



