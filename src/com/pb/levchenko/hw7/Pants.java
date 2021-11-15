package com.pb.levchenko.hw7;

public class Pants extends Clothes implements ManClothes, WomenClothes{

    public Pants(Size size, String color, int price) {
        super(size, color, price);
    }
String name = "брюки ";
    @Override
    public void dressMan() {
        System.out.println("Название одежды: "+ name +
                " размер: "+ size +  size.getDescription() +  " евроразмер: "+size.getEuroSize() +" цена: "+ price+ " грн"+" цвет: "+ color);

    }


    @Override
    public void dressWomen(){
        System.out.println("Название одежды: "+ name +
                " размер: "+ size +  size.getDescription() +  " евроразмер: "+size.getEuroSize() +" цена: "+ price+ " грн"+" цвет: "+ color);

    }
}
