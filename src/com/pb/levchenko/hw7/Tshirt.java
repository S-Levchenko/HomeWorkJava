package com.pb.levchenko.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes{

    public Tshirt(Size size, String color, int price) {
        super(size, color, price);
    }
    String name = "футболка ";

    @Override
    public void dressMan() {
        System.out.println("Название одежды: "+ name +
                " размер: "+ size +  size.getDescription() +  " евроразмер: "+size.getEuroSize() +" цена: "+ price+" грн"+ " цвет: "+ color);

    }

    @Override
    public void dressWomen() {
        System.out.println("Название одежды: "+ name +
                " размер: "+ size +  size.getDescription() +  " евроразмер: "+size.getEuroSize() +" цена: "+ price+ " грн"+" цвет: "+ color);

    }
}
