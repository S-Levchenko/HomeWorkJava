package com.pb.levchenko.hw11;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) throws UnsupportedOperationException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(LocalDateTime.class, new LocalDateSerializer());
        simpleModule.addDeserializer(LocalDateTime.class, new LocalDateDeserializer());
        objectMapper.registerModule(simpleModule);

        // Элементы которые можно записать в телефонную книгу :
        Person person1 = new Person("Ивашкина Светлана Федоровна", "22.10.1975",
                "556-058-85, 050-06-54-564", "Никополь, Угловая 5/1", LocalDateTime.now());
        Person person2 = new Person("Иванов Иван Федорович", "12.11.1998",
                "385-569-26 , 050-56-08-534", "Запорожье , Южная 15", LocalDateTime.now());
        Person person3 = new Person("Грант Федор Иванович", "11.07.1986", "568-254-56 , 099-58-08-563",
                "Днепр, площадь Победы 5, кв 8", LocalDateTime.now());
        Person person4 = new Person("Солнцева Галина Константиновна", "01.12.1994",
                "568-896-25 , 098-25-02-534", "Трускавец, Василия Стуса 22б, 45",
                LocalDateTime.now());
        Person person5 = new Person("Андреева Ирина Александровна", "03.07.1990",
                "568-226-23 , 458-897-11", "Белая Церковь 15,41", LocalDateTime.now());
        Person person6 = new Person("Лермонтов Лев Васильевич", "05.10.1964", "213-453-22 , 050-25-35-564",
                "Львов, Рыночная площадь 15б, 61", LocalDateTime.now());
        Person person7 = new Person("Стругацкий Борис Петрович", "03.06.1976",
                "534-489-97 , 050-66-56-232", "Львов , Ивана Франка 235, 12", LocalDateTime.now());
        Person person8 = new Person("Семченко Наталья Александровна", "15.02.1963",
                "567-862-22 , 098-75-58-925", "Херсон, Малая 12/5", LocalDateTime.now());


        // телефоная книга которую видит пользователь в начале программы
        ArrayList<Person> phoneBook = new ArrayList<>();
        phoneBook.add(0, person1);
        phoneBook.add(1, person2);
        phoneBook.add(2, person3);
        phoneBook.add(3, person4);
        //  System.out.println(phoneBook);
        // смотрим как запишется в файл (корректно ли)
        String phoneBookJson = objectMapper.writeValueAsString(phoneBook);
        System.out.println(phoneBookJson);

        // запись в файл
        try {
               objectMapper.writeValue(new File("phoneBook.json"), phoneBook);
               } catch (final Exception e){
              e.printStackTrace();
                }
        //чтение с файла
        ArrayList<Person> map = objectMapper.readValue(Paths.get("phoneBook.json").toFile(),ArrayList.class);
        System.out.println(map);

        // просим пользователя выбрать нужную функцию
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выбирите нужную функцию" + "\n" +
                "Если Вы хотите ДОБАВИТЬ элемент нажмите 1" + "\n" + "Если Вы хотите УДАЛИТЬ элемент нажмите 2" + "\n" +
                "Если Вы хотите НАЙТИ элемент по ФИО нажмите 3" + "\n" +
                "Если Вы хотите СОРИТИРОВАТЬ телефоную книгу по ИМЕНИ нажмите 4" + "\n" +
                "Если Вы хотите СОРИТИРОВАТЬ телефоную книгу по АДРЕСУ нажмите 5" + "\n" +
                "Если Вы хотите РЕДАКТИРОВАТЬ элемент нажмите 6" + "\n" +
                "Если Вы хотите просмотреть телефонную книгу нажмите 8");
        int function = scanner.nextInt();
        if (function == 1) {
            System.out.println("Выбирите элемент который хотите добавить"
                    + "\n" + "Добавить элемент 5 - нажмите 5"
                    + "\n" + "Добавить элемент 6 - нажмите 6"
                    + "\n" + "Добавить элемент 7 - нажмите 7"
                    + "\n" + "Добавить элемент 8 - нажмите 8");
            int add = scanner.nextInt();
            if (add == 5) {
                phoneBook.add(person5);
                System.out.println("Элемент добавлен");
                System.out.println(phoneBook);
            } else if (add == 6) {
                phoneBook.add(person6);
                System.out.println("Элемент добавлен");
                System.out.println(phoneBook);
            } else if (add == 7) {
                phoneBook.add(person7);
                System.out.println("Элемент добавлен");
                System.out.println(phoneBook);
            } else if (add == 8) {
                phoneBook.add(person8);
                System.out.println("Элемент добавлен");
                System.out.println(phoneBook);
            }
        } else if (function == 2) {
            System.out.println("Выбирите элемент который хотите удалить"
                    + "\n" + "Удалить элемент 1 - нажмите 1"
                    + "\n" + "Удалить элемент 2 - нажмите 2"
                    + "\n" + "Удалить элемент 3 - нажмите 3"
                    + "\n" + "Удалить элемент 4 - нажмите 4"
                    + "\n" + "Удалить элемент 5 - нажмите 5"
                    + "\n" + "Удалить элемент 6 - нажмите 6"
                    + "\n" + "Удалить элемент 7 - нажмите 7"
                    + "\n" + "Удалить элемент 8 - нажмите 8");
            int remove = scanner.nextInt();
            if (remove == 1) {
                phoneBook.remove(person1);
                System.out.println("Элемент удален");
                System.out.println(phoneBook);
            } else if (remove == 2) {
                phoneBook.remove(person2);
                System.out.println("Элемент удален");
                System.out.println(phoneBook);
            } else if (remove == 3) {
                phoneBook.remove(person3);
                System.out.println("Элемент удален");
                System.out.println(phoneBook);
            } else if (remove == 4) {
                phoneBook.remove(person4);
                System.out.println("Элемент удален");
                System.out.println(phoneBook);
            } else if (remove == 5) {
                phoneBook.remove(person5);
                System.out.println("Элемент удален");
                System.out.println(phoneBook);
            } else if (remove == 6) {
                phoneBook.remove(person6);
                System.out.println("Элемент удален");
                System.out.println(phoneBook);
            } else if (remove == 7) {
                phoneBook.remove(person7);
                System.out.println("Элемент удален");
                System.out.println(phoneBook);
            } else if (remove == 8) {
                phoneBook.remove(person8);
                System.out.println("Элемент удален");
                System.out.println(phoneBook);
            }
        } else if (function == 3) {
            String search = scanner.next();
            if (person1.getName().contains(search)) {
                System.out.println("Пользователь найден");
            } else if (person2.getName().contains(search)) {
                System.out.println("Пользователь найден");
            } else if (person3.getName().contains(search)) {
                System.out.println("Пользователь найден");
            } else if (person4.getName().contains(search)) {
                System.out.println("Пользователь найден");
            } else
                System.out.println("Пользователь не найден");
        } else if (function == 4) {
            phoneBook.sort(Comparator.comparing(p -> p.name));
            System.out.println("Сортировка по полю ФИО: " + phoneBook);
        } else if (function == 5) {
            phoneBook.sort(Comparator.comparing(p -> p.address));
            System.out.println("Сортировка по полю Адрес: " + phoneBook);
        } else if (function == 6) {
            System.out.println("Редактировать имя 1го элемента нажмите 1" +
                    "\n" + "Редактировать имя 2го элемента нажмите 2" +
                    "\n" + "Редактировать имя 3го элемента нажмите 3" +
                    "\n" + "Редактировать имя 4го элемента нажмите 4" +
                    "\n" + "Редактировать имя 5го элемента нажмите 5" +
                    "\n" + "Редактировать имя 6го элемента нажмите 6" +
                    "\n" + "Редактировать имя 7го элемента нажмите 7" +
                    "\n" + "Редактировать имя 8го элемента нажмите 8");
            int edit = scanner.nextInt();
            if (edit == 1) {
                System.out.println(person1.getName());
                person1.setName(scanner.next(), LocalDateTime.now());
                System.out.println(phoneBook);
            } else if (edit == 2) {
                System.out.println(person2.getName());
                person1.setName(scanner.next(), LocalDateTime.now());
                System.out.println(phoneBook);
            } else if (edit == 3) {
                System.out.println(person3.getName());
                person1.setName(scanner.next(), LocalDateTime.now());
                System.out.println(phoneBook);
            } else if (edit == 4) {
                System.out.println(person4.getName());
                person1.setName(scanner.next(), LocalDateTime.now());
                System.out.println(phoneBook);
            } else if (edit == 5) {
                System.out.println(person5.getName());
                person1.setName(scanner.next(), LocalDateTime.now());
                System.out.println(phoneBook);
            } else if (edit == 6) {
                System.out.println(person6.getName());
                person1.setName(scanner.next(), LocalDateTime.now());
                System.out.println(phoneBook);
            } else if (edit == 7) {
                System.out.println(person7.getName());
                person1.setName(scanner.next(), LocalDateTime.now());
                System.out.println(phoneBook);
            } else if (edit == 8) {
                System.out.println(person4.getName());
                person1.setName(scanner.next(), LocalDateTime.now());
                System.out.println(phoneBook);
            }
        } else if (function == 8) {
            System.out.println(phoneBook);
        }



            phoneBook.sort(Comparator.comparing(p -> p.name));
            //   System.out.println("Сортировка по полю ФИО: "+ phoneBook);

            phoneBook.sort(Comparator.comparing(p -> p.address));
            //  System.out.println("Сортировка по полю Адрес: " + phoneBook);

            // поиск элементов
            // String searchAddress = scanner.nextLine();
            //  phoneBook.stream().filter(p ->p.getAddress().equals(searchAddress)).collect(Collectors.toList());

            //  String searchName = scanner.nextLine();
            //  phoneBook.stream().forEach(p ->p.getName().equals(searchName));


            // String userSearch = scanner.next();
            //  System.out.println(person1.getAddress().equalsIgnoreCase(userSearch));

            //  Stream stream = phoneBook.stream();
            //  phoneBook.stream();
            // phoneBook.stream().filter(p ->p.getName().equals(search)).forEach(System.out::println);


        }
    }




