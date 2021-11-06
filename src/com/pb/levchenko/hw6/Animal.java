package com.pb.levchenko.hw6;

public class Animal {
    private String name;
    private String food;
    private String location;

    public Animal (String name,String food, String location) {
        this.name = name;
        this.food = food;
        this.location = location;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFood() {
        return food;
    }

    public String getLocation() {
        return location;
    }
    public void makeNoise() {
        System.out.println(name + "издает звук ");
    }
    public void eat() {
        System.out.println(name + "кушает");
    }
    public void sleep() {
        System.out.println(name + "спит");
    }

    @Override
    public String toString() {
        return "Animal{" +
                " Имя: '" + name + '\'' +
                ", еда: '" + food + '\'' +
                ", место обитания: '" + location + '\'' +
                '}';
    }
}
