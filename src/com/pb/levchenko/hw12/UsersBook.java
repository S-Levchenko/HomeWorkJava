package com.pb.levchenko.hw12;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.pb.levchenko.hw11.LocalDateDeserializer;
import com.pb.levchenko.hw11.LocalDateSerializer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class UsersBook {
    public static void main(String[] args) throws IOException {
        // Элементы которые можно записать в телефонную книгу :
        Person user1 = new Person("Греговьева Л.П.", "22.10.1975",
                "556-058-85, 050-06-54-564", "Никополь, Угловая 5/1", LocalDateTime.now());
        Person user2 = new Person("Васильева Л.Р.", "12.11.1998",
                "385-569-26 , 050-56-08-534", "Запорожье , Южная 15", LocalDateTime.now());
        Person user3 = new Person("Рускевич О.К.", "11.07.1986", "568-254-56 , 099-58-08-563",
                "Днепр, площадь Победы 5, кв 8", LocalDateTime.now());
        Person user4 = new Person("Римский А.Е.", "01.12.1994",
                "568-896-25 , 098-25-02-534", "Трускавец, Василия Стуса 22б, 45",
                LocalDateTime.now());

        // телефоная книга которую видит пользователь в начале программы
        ArrayList<Person> userBook = new ArrayList<>();
        userBook.add(user1);
        userBook.add(user2);
        // просим пользователя выбрать нужную функцию
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выбирите нужную функцию" + "\n" +
                "Если Вы хотите ДОБАВИТЬ элемент нажмите 1" + "\n" +
                "Если Вы хотите УДАЛИТЬ элемент нажмите 2" + "\n" +
                "Если Вы хотите НАЙТИ элемент по ФИО нажмите 3" + "\n" +
                "Если Вы хотите СОРИТИРОВАТЬ телефоную книгу по ИМЕНИ нажмите 4" + "\n" +
                "Если Вы хотите СОРИТИРОВАТЬ телефоную книгу по АДРЕСУ нажмите 5" + "\n" +
                "Если Вы хотите РЕДАКТИРОВАТЬ элемент нажмите 6");
        int function = scanner.nextInt();
        if (function == 1) {
            System.out.println("Веведите имя");
            String name = scanner.next();
            System.out.println("Введите номер телефона");
            String phone = scanner.next();
            System.out.println("Введите адрес");
            String address = scanner.next();
            System.out.println("Введите дату рождения");
            String dateBirch = scanner.next();
            try {
                userBook.add(new Person(name, phone, address, dateBirch, LocalDateTime.now()));
                System.out.println("Пользователь сохранен");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(userBook);
        } else if (function == 2) {
            System.out.println("Выбирите элемент который хотите удалить"
                    + "\n" + "Удалить элемент 1 - нажмите 1"
                    + "\n" + "Удалить элемент 2 - нажмите 2"
                    + "\n" + "Удалить элемент 3 - нажмите 3"
                    + "\n" + "Удалить элемент 4 - нажмите 4");
            int remove = scanner.nextInt();
            if (remove == 1) {
                userBook.remove(user1);
                System.out.println("Элемент удален");
                System.out.println(userBook);
            } else if (remove == 2) {
                userBook.remove(user2);
                System.out.println("Элемент удален");
                System.out.println(userBook);
            } else if (remove == 3) {
                userBook.remove(user3);
                System.out.println("Элемент удален");
                System.out.println(userBook);
            } else if (remove == 4) {
                userBook.remove(user4);
                System.out.println("Элемент удален");
                System.out.println(userBook);
            }
            // используем лямбда выражение и стримы
        } else if (function == 3) {

            String s = scanner.next();
            boolean res = userBook.stream()
                    .anyMatch(p->p.getName().contains(s));

            if (res == true) {
               System.out.println("Пользователь найден");


            } else System.out.println("Пользователь не найден");
       // используем лямбда выражение
            } else if (function == 4) {
                userBook.sort(Comparator.comparing(p -> p.name));
                System.out.println("Сортировка по полю ФИО: " + userBook);

            } else if (function == 5) {
                userBook.sort(Comparator.comparing(p -> p.address));
                System.out.println("Сортировка по полю Адрес: " + userBook);
            } else if (function == 6) {
                System.out.println("Редактировать имя 1го элемента нажмите 1" +
                        "\n" + "Редактировать имя 2го элемента нажмите 2" +
                        "\n" + "Редактировать имя 3го элемента нажмите 3" +
                        "\n" + "Редактировать имя 4го элемента нажмите 4");
                int edit = scanner.nextInt();
                if (edit == 1) {
                    System.out.println(user1.getName());
                    user1.setName(scanner.next(), LocalDateTime.now());
                    System.out.println(userBook);
                } else if (edit == 2) {
                    System.out.println(user2.getName());
                    user2.setName(scanner.next(), LocalDateTime.now());
                    System.out.println(userBook);
                } else if (edit == 3) {
                    System.out.println(user3.getName());
                    user3.setName(scanner.next(), LocalDateTime.now());
                    System.out.println(userBook);
                } else if (edit == 4) {
                    System.out.println(user3.getName());
                    user4.setName(scanner.next(), LocalDateTime.now());
                    System.out.println(userBook);
                }
            }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(LocalDateTime.class, new LocalDateSerializer());
        simpleModule.addDeserializer(LocalDateTime.class, new LocalDateDeserializer());
        objectMapper.registerModule(simpleModule);
        // запись в файл
        try {
            objectMapper.writeValue(new File("userBook.json"), userBook);
        } catch (final Exception e){
            e.printStackTrace();
        }
        //чтение с файла
        ArrayList<Person> map = objectMapper.readValue(Paths.get("userBook.json").toFile(),ArrayList.class);
        System.out.println(map);
        }
    }




