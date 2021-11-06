package com.pb.levchenko.hw6;

import java.util.Objects;

public class Horse extends Animal {
    private String mane;
    private String horseshoe;

    public Horse(String name, String food, String location) {
        super(name, food, location);
    }


    @Override
    public void makeNoise() {
        System.out.println(getName() + "'Иго-го'");
        super.makeNoise();
    }

    @Override
    public void eat() {
        System.out.println(getName()+"довольна");
        super.eat();
    }

    public void sleep() {
        System.out.println(getName() + ", отдыхает");
        super.sleep();
    }

    @Override
    public String toString() {
        return "Horse{" +
                "mane='" + mane + '\'' +
                ", horseshoe='" + horseshoe + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return Objects.equals(mane, horse.mane) && Objects.equals(horseshoe, horse.horseshoe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mane, horseshoe);
    }

}



