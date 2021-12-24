package com.pb.levchenko.hw13;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Double> listDouble = new LinkedList<>();
        int size = 5;
Thread prodThread=new Thread(new Producer(listDouble,size),"Производитель");
Thread customerThread = new Thread(new Customer(listDouble),"Потребитель");
prodThread.start();
customerThread.start();
    }
}
