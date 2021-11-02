package com.pb.levchenko.hw5;

public class Book {
    // Объекты
    private String bookName;
    private String author;
    private int yearPublishing;
   // Конструктор
    public Book(String bookName, String author, int yearPublishing) {
        this.bookName = bookName;
        this.author = author;
        this.yearPublishing = yearPublishing;
    }
// Гетерры и сеттеры
    public String getBookName(int i) {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYearPublishing() {
        return String.valueOf(yearPublishing);
    }

    public void setYearPublishing(int yearPublishing) {

    }
    // Перегружаем метод toString() чтоб корректно буквы отображались
    public String toString(){
        return "Название книги: " +bookName + " автор : " + author + " год издания: "
                + yearPublishing;
    }


}



