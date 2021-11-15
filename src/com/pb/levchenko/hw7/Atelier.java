package com.pb.levchenko.hw7;

public class Atelier {
    public static void main(String[] args) {
        Clothes skirt = new Skirt(Size.XXS, "черный ", 50);
        Clothes tie = new Tie(Size.XS, "красный", 60);
        Clothes pants = new Pants(Size.L, "синий", 100);
        Clothes tshirt = new Tshirt(Size.M, "белый", 70);
        Clothes[] clothes = new Clothes[]{tie, pants, tshirt,skirt};
        for (Clothes c : clothes) {



        }

        dressMan(clothes);
        dressWoman(clothes);

    }

    public static void dressMan(Clothes[]clothes){
        System.out.println("Здравствуйте! Рады приветсвовать Вас в отделе мужской одежды нашего Ателье");
        System.out.println();
        for (Clothes s: clothes) {
            if (s instanceof ManClothes) {
                ((ManClothes)s).dressMan();
            }
        }
    }
    public static void dressWoman(Clothes[]clothes){
        System.out.println();
        System.out.println("Здравствуйте! Рады приветсвовать Вас в отделе женской одежды нашего Ателье");
        System.out.println();
        for (Clothes s: clothes){
            if (s instanceof WomenClothes) {
                ((WomenClothes)s).dressWomen();
            }
        }
    }
}





