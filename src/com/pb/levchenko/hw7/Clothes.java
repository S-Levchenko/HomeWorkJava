package com.pb.levchenko.hw7;

public abstract class Clothes {
    Size size;
    String color;
    int price;


    public Clothes(Size size, String color, int price) {
        this.size = size;
        this.color = color;
        this.price = price;
    }

    public Size getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }
    public String toString (){
        return "Размер: "+ size +" цвет: " + color + " цена: " + price;
    }
}
