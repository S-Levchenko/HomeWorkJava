package com.pb.levchenko.hw7;

public class Tie extends Clothes implements ManClothes {

    public Tie(Size size, String color, int price) {
        super(size, color, price);
    }

    String name = "галстук";

    @Override
    public void dressMan() {
        System.out.println("Название одежды: " + name + " размер: " + size + size.getDescription() + " евроразмер: " +size.getEuroSize() + " цена: " + price + " грн" +" цвет: " + color);

    }

}
