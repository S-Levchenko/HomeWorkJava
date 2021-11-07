package com.pb.levchenko.hw6;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;
public class VetClinic<object> extends Veterinarian {
    public VetClinic() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    }

    public static void main(String[] args) throws Exception {
        // Конструктор
        Animal dog = new Animal(" Комиссар Рекс ", " корм ", " полицейский участок");
        Animal cat = new Animal(" Салем ", " сухой корм", " планета Кошек ");
        Animal horse = new Animal(" Таука ", " свежая зелень ", " прерии ");

        // Массив типа Animal, в котором записаны животные всех имеющихся типов
        Animal[] animals = {dog, cat, horse};
        for (Animal a : animals) {
            System.out.println(a.toString());

        }
        // Демонстарациия метода который печатает на экран food и location
        // пришедшего на прием животного
      // Veterinarian.treatAnimal(dog);
      //  Veterinarian.treatAnimal(cat);
      //  Veterinarian.treatAnimal(horse);

        // В цикле животные отправляются на прием к ветеринару.
        Random random = new Random();
        Animal animal = animals[random.nextInt(3)];
        if (animal.equals(dog)) {
            System.out.println(" Пес идет на прием к ветеренару ");
            treatAnimal(dog);
        } else if (animal.equals(cat)) {
            System.out.println(" Кот идет на прием к ветеренару ");
            treatAnimal(cat);
        } else if (animal.equals(horse)) {
            System.out.println("Лошадка идет на прием к ветеренару ");
            treatAnimal(horse);
        } else {
            System.out.println();
        }
    Veterinarian v = new Veterinarian();
    Class clazz = v.getClass();
    Class vetClazz = Class.forName("com.pb.levchenko.hw6.Veterinarian");
    Object obj = vetClazz.newInstance();
    if (obj instanceof Veterinarian) {
        // Тест объекта
        System.out.println();
        ((Veterinarian)obj).treatAnimal(cat);
    }

    }
}


