package com.pb.levchenko.hw7;

public class Skirt extends Clothes implements  WomenClothes  {
    public Skirt(Size size, String color, int price) {
        super(size, color, price);
    }
String name = "юбка ";
    @Override
    public void dressWomen() {
        System.out.println("Название одежды: "+ name +
                " размер: "+ size + size.getDescription() + "евроразмер: " +size.getEuroSize() + " цена: "+ price+" грн"+ " цвет: "+ color);
    }


}
