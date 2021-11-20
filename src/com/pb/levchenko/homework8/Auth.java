package com.pb.levchenko.homework8;

import java.util.regex.Pattern;

public class Auth {
    String login, password;

    public Auth(String login1, String password1) {
        this.login = login1;
        this.password = password1;
    }

    public void singUp(String login, String password, String confirmPassword) throws WrongLoginException1,
            WrongPasswordException1 {
        if (Pattern.matches("[a-zA-Z0-9] {5,20}", login)) {
            this.login = login;
            System.out.println("Логин сохранен");
        } else
            throw new WrongLoginException1("Не верный логин");
        if (!(Pattern.matches("\\w{5,20}", password))) {
            throw new WrongPasswordException1();
        } else if (!(password.equals(confirmPassword))) {
            throw new WrongPasswordException1();

        } else
            this.password = password;
        System.out.println("Пароль сохранен");
    }

    public void singIn(String login1, String password1) throws WrongLoginException1 {
        if (login.equals(login1) && (password.equals(password1))) {
            System.out.println("Вход выполнен");
        } else
            throw new WrongLoginException1();
    }
}

