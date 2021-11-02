package com.pb.levchenko.hw5;

// Объекты
public class Reader {
    private String person;
    private String libraryTicket;
    private String department;
    private String dateBirth;
    private int phone;
    // Конструктор
    public Reader(String person, String libraryTicket, String department, String dateBirth, int phone) {
        this.person = person;
        this.libraryTicket = libraryTicket;
        this.department = department;
        this.dateBirth = dateBirth;
        this.phone = phone;
    }
    // Гетерры и сеттеры
    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getLibraryTicket() {
        return libraryTicket;
    }

    public void setLibraryTicket(String libraryTicket) {
        this.libraryTicket = libraryTicket;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getDateBirth() {
        return getDateBirth();
    }

    public void setDateBirth() {
        this.dateBirth = dateBirth;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone() {
        this.phone = phone;
    }
    //Методы
    public void takeBook(int book) {
        System.out.println(person + " взял(а) " + book + " книг(и)");
        System.out.println();
    }

    public void takeBook(String... books) {
        System.out.println(person + "взял(а) книги: ");
        for (String book : books) {
            System.out.println(book);
        }
        System.out.println();
    }
    public void takeBook(Book...books) {
        System.out.println(person + "взяла(а) книги: ");
        for (Book book : books)
            System.out.println(book);
        System.out.println();
    }

    public void returnBook(int book) {
        System.out.println(person + " вернул(а) " + book + " книг(и)");
        System.out.println();
    }
    public void returnBook(String...books) {
        System.out.println(person + "вернул(а) книги: ");
        for (String book: books) {
        System.out.println(book);

        System.out.println();
        }
    }

    public void returnBook(Book... books) {
        System.out.println(person + "вернул(а) книги: ");
        for (Book book : books)
            System.out.println(book);
        System.out.println();
    }
 // Перегружаем метод toString() чтоб корректно буквы отображались
  public String toString(){
        return "ФИО: " + person + " номер читательского билета: " + libraryTicket +
                " день рождения : "
                + dateBirth + " факультет: " + department + " номер телефона : " + phone;
  }
    }



