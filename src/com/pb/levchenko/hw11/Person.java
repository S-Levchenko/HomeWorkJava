package com.pb.levchenko.hw11;

import java.time.LocalDateTime;

class Person implements Comparable<Person>{
    String name;
    String dateBirch;
    String phone;
    String address;
    LocalDateTime timeStamp;

    public String getName() {
        return name;
    }

    public void setName(String name,LocalDateTime timeStamp) {
        this.name = name;
        this.timeStamp=timeStamp;
    }

    public String getDateBirch() {
        return dateBirch;
    }

    public void setDateBirch(String dateBirch) {
        this.dateBirch = dateBirch;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Person(String name, String dateBirch, String phone, String address, LocalDateTime timeStamp){
        this.name = name;
        this.dateBirch = dateBirch;
        this.phone = phone;
        this.address = address;
        this.timeStamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Запись: {" +
                "ФИО: '" + name + '\'' +
                ", Дата рождения: ' " + dateBirch + '\'' +
                ", Телефоны:  '" + phone + '\'' +
                ", Адрес:  '" + address +
                ", Дата изменения: ' " + timeStamp +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }

}
