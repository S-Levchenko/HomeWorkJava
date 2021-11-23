package com.pb.levchenko.hw9;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileNumbers {
    public static void main(String[] args) throws IOException {
        createNumbersFile();
        createOddNumbersFile();
    }

    public static void createNumbersFile() throws IOException {
        File file = new File("numbers.txt");
        System.out.println(Files.exists(Paths.get("numbers.txt")));


        try (final FileWriter writer = new FileWriter("numbers.txt", false)) {
            int[][] array = new int[10][10];
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    array[i][j] = ((int) (Math.random() * 99 + 1));
                    System.out.println(array[i][j] + " ");
                    writer.write(array[i][j] + " ");
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            System.out.println("Файл не записан");
        }

    }

    //  public static void createOddNumbersFile() throws IOException {
    //   try (FileReader fileReader = new FileReader("numbers.txt")) {
    //     Scanner scanner = new Scanner(new File("numbers.txt"));
    //    int[][] a = new int[scanner.nextInt()][scanner.nextInt()];
    //   for (int i = 0; i < a.length; i++) {
    //     for (int j = 0; j < a.length; j++) {
    //        a[i][j] = scanner.nextInt();
    //  }

    //    }
    //  } catch (IOException e) {
    //      System.out.println("Файл не прочитан");
    //   }


    // public void createOddNumbersFile(){
    //  FileReader fileReader = new FileReader("numbers.txt");
    //    char [] ch = new char[200];
    //   fileReader.read(ch);

    //   for (char c: ch){
    //      System.out.println(c);
    //      fileReader.close();
    //    }
    public static void createOddNumbersFile() throws IOException {
        try (Scanner in = new Scanner(new File("numbers.txt"))) {
            PrintWriter pw = new PrintWriter(new File("odd-numbers.txt"));
            System.out.println("Вывод чисел , с учетом замены целых четных чисел на '0':");
            while (in.hasNextLine()) {
                Scanner line = new Scanner(in.nextLine());
                while (line.hasNextInt()) {
                    int ch = line.nextInt();
                    if (ch % 2 == 0) {
                        System.out.println("0");
                        ch = 0;
                    } else
                        System.out.println(ch + " ");
                    pw.println(ch + " ");

                }
                line.close();
                pw.println();

            }
            System.out.println();
            pw.close();
        } catch (IOException ioException) {
            System.out.println("Файл не записан" + ioException);
        }
    }
}


//}




