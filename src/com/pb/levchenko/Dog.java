package com.pb.levchenko;

import com.pb.levchenko.hw6.Animal;

import java.util.Objects;

public class Dog extends Animal {
    private String breed;
    private String dogCollar;

    public Dog(String name, String food, String location) {
        super(name, food, location);
    }


    @Override
    public void makeNoise() {
        System.out.println(getName() + "'Гав-гав'");
        super.makeNoise();
    }

    @Override
    public void eat(){
        System.out.println(getName() + "корм");
        super.eat();
    }

    @Override
    public void sleep() {
        System.out.println(getName() + "и мечтает");
        super.sleep();
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                ", dogCollar='" + dogCollar + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(breed, dog.breed) && Objects.equals(dogCollar, dog.dogCollar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(breed, dogCollar);
    }
}
