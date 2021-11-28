package com.pb.levchenko.hw10;

public class Main {
    public static void main(String[] args) throws Exception, IndexException {
        NumBox<java.lang.Float> floatNumBox = new NumBox<>(5);
            try {
                floatNumBox.add(0, 4.3F);
                floatNumBox.add(1, 5.5F);
                floatNumBox.add(2, 3.1F);
                floatNumBox.add(3, 8.9F);
                floatNumBox.add(4, 46.5F);
            } catch (Exception e){
                System.out.println("Массив переполнен");
            }
            try {

                float float0 = floatNumBox.get(0);
                float float1 = floatNumBox.get(1);
                float float2 = floatNumBox.get(2);
                float float3 = floatNumBox.get(3);
                float float4 = floatNumBox.get(4);

                System.out.println(float0);
                System.out.println(float1);
                System.out.println(float2);
                System.out.println(float3);
                System.out.println(float4);
            } catch (IndexException indexException) {
                System.out.println("По такому индексу нет элемента в массиве" );
            }

                floatNumBox.length();
                System.out.println("Количество элементов в массиве: " + floatNumBox.length());

                floatNumBox.sum();
                System.out.println("Сумма элементов массива: " + floatNumBox.sum());

                floatNumBox.average();
                System.out.println("Среднеарифметическое элементов массива: " + floatNumBox.average());

                floatNumBox.max();
                System.out.println("Самое большое значение массива: " + floatNumBox.max());


                NumBox<java.lang.Integer> integerNumBox = new NumBox<>(4);
                try {


                    integerNumBox.add(0, 5);
                    integerNumBox.add(1, 6);
                    integerNumBox.add(2, 8);
                    integerNumBox.add(3, 15);
                } catch (Exception e) {
                    System.out.println("Массив переполнен");
                }
                  try {

                      int integer1 = (int) integerNumBox.get(0);
                      int integer2 = (int) integerNumBox.get(1);
                      int integer3 = (int) integerNumBox.get(2);
                      int integer4 = (int) integerNumBox.get(3);
                      System.out.println(integer1);
                      System.out.println(integer2);
                      System.out.println(integer3);
                      System.out.println(integer4);
                  } catch (IndexException indexException){
                      System.out.println("По такому индексу нет элемента в массиве");
                  }


                integerNumBox.length();
                System.out.println("Количество элементов в массиве: " + integerNumBox.length());

                integerNumBox.sum();
                System.out.println("Сумма элементов массива: " + integerNumBox.sum());

                integerNumBox.average();
                System.out.println("Среднеарифметическое элементов массива: " + integerNumBox.average());

                integerNumBox.max();
                System.out.println("Самое большое значение массива: " + integerNumBox.max());
            }
        }


