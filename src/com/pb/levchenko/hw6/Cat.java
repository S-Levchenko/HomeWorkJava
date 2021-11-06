package com.pb.levchenko.hw6;

import java.util.Objects;

public class Cat extends Animal {
    private String feed;
    private String color;

    public Cat(String name, String food, String location) {
        super(name, food, location);
    }


    @Override
    public void makeNoise() {
        System.out.println(getName() + "Мяу-мяу");
        super.makeNoise();
    }

    @Override
    public void eat() {
        System.out.println(getName() + "сухой корм");
        super.eat();
    }

    public void sleep() {
        System.out.println(getName() + " и мечтает");
        super.sleep();
    }

    @Override
    public String toString() {
        return "Cat{" +
                "feed='" + feed + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(feed, cat.feed) && Objects.equals(color, cat.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(feed, color);
    }
}
