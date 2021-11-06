package com.pb.levchenko.hw6;

import java.lang.reflect.Constructor;

public class Veterinarian {


    public static void treatAnimal(Animal animal) {
        System.out.println(animal.getName() + " еда: " + animal.getFood() + "," +
                " " + "место обитания: " + animal.getLocation());
    }

    public static class Main {
        public static void main(String[] args) throws Exception {

            Veterinarian v = new Veterinarian();
            Class clazz = v.getClass();
            System.out.println(clazz.getName());
            Class vetClazz = Class.forName("com.pb.levchenko.hw6.Veterinarian");

            Constructor constructor = vetClazz.getConstructor(new Class[]{String.class});
            Object obj = constructor.newInstance("Ветеринар Айболит");
            if (obj instanceof Veterinarian) {
                ((Veterinarian) obj).treatAnimal();
            }

        }
    }
}







    




