package com.pb.levchenko.hw10;

public class NumBox <T extends java.lang.Number> {
    private T[] numbers;
    private NumBox<T> tNumBox;
    private int fl;

    @SuppressWarnings("unchecked ")
    // конструктор
    public NumBox(int size) {
        // массив из объектов класса Т
        numbers = (T[]) new java.lang.Number[size];
    }


    //  добавить элеммент в массив вариант 2
    public void add(int i, T num) throws Exception {
        if (this.fl >= this.numbers.length) {
            throw new Exception("массив переполнен");
        }
        this.numbers[this.fl] = num;
        this.fl++;
    }

    // возвращающает число по индексу
    public float get(int index) throws IndexException {
        if (index > numbers.length)
            throw new IndexException("Внимание! Элемента по такому индексу нет в массиве");
        else if (index < 0)
            throw new IndexException("Внимание! Элемента по такому индексу нет в массиве");
        else
            return numbers[index].intValue();

    }

    // возвращает текущее количество элементов
    public int length() {
        return numbers.length;
    }


    public double average() {
        double sum = 0.0;
        for (T i : numbers) {
            if (i == null) {
                sum += 0;
            } else sum += i.doubleValue();
        }
        double average = sum / numbers.length;
        return average;
    }

    // сумма всех элементов массива

    public double sum() {
        double sum = 0.0;
        for (T i : numbers) {
            if (i == null) {
                sum += 0;
            } else sum += i.doubleValue();
        }
        return sum;
    }

    public T max() {
        T maxZ = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].doubleValue() > maxZ.doubleValue())
                maxZ = numbers[i];

        }
        return maxZ;
    }
}






