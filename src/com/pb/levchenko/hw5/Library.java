package com.pb.levchenko.hw5;


public class Library {
    public static void main(String[] args) {

            Book book1 = new Book("'Дети капитана Гранта'", "Жюль Верн", 1865);
            Book book2 = new Book("'Гордость и предубеждение'", "Джейн Остин", 1831);
            Book book3 = new Book("'Отверженные'", "Виктор Гюго", 1862);
         System.out.println("Книги: " );
        System.out.println();
            Book [] books = {book1,book2,book3};
        for (Book b: books) {
            System.out.println(b.toString());

        }
            Reader reader1 = new Reader("Иванова А.А. ", " 8545, ",
                    " Экономический, ", " 12.05.1995, ", 50568534);
            Reader reader2 = new Reader("Сова О.О. ", " 8544, ",
                    " Исторический, ", "12.04.1996, ", 995808526);
            Reader reader3 = new Reader("Чайка Т.Ю. ", " 8463, ",
                    " Исторический, ", " 11.03.1998, ", 985408563);
        System.out.println("Читатели: ");
        System.out.println();
        Reader [] readers = {reader1,reader2,reader3};
        for (Reader r: readers) {
            System.out.println(r.toString());
        }
        System.out.println();

        System.out.println("Демонстрация работы методов: ");
        System.out.println();
        reader1.takeBook(8);
        reader1.returnBook(8);
        reader2.takeBook("'Емма'","'Хроники Нарнии'","'Дама с камелиями'");
        reader2.returnBook("'Емма'");
        reader3.takeBook(book1,book2);
        reader3.returnBook(book1,book2);






    }
}


