package com.pb.levchenko.hw14ver2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {
    static class Handler implements Runnable{
  private final Socket socket;
  public Handler(Socket socket){
      this.socket = socket;
  }
        @Override
        public void run() {
      try {
          System.out.println(Thread.currentThread().getName() + "Получен запрос от клиента");
          BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

          boolean headerLine;
          while (headerLine=in.readLine().length()!=0) {
              System.out.println(headerLine);
          }
          StringBuilder payload = new StringBuilder();

          while (in.ready()) {
              payload.append((char)in.read());
          }
          System.out.println("\nТело запроса: " + payload);
          int sec = 10;
          System.out.println("Ожидаем " + sec + " секунд обработки запроса");
          Thread.sleep(sec*1000);

          Scanner scanner = new Scanner(System.in);
          String str = scanner.nextLine();
          out.write(str);

          System.out.println("Текущая дата и время: "+LocalDateTime.now()+" Ваше сообщение: "+str);
          out.write("HTTP/1.0 200 OK\r\n");
          out.write("\r\n");
          out.write("<html><body><h1>");
          out.write("Ответ от сервера, текущая дата: ");
          out.write(LocalDateTime.now().toString());
          out.write("</h1></body></html>");
          System.out.println("Соединение закрыто");
          out.close();
          in.close();
      } catch (Exception exception){
          exception.printStackTrace();
      }
      finally {
          try {
              socket.close();
          } catch (Exception e){

          }
      }
        }
    }
    public static void main(String[]args) throws Exception{
        int port = 5531;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Запущен сервер по порту: "+ port);
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        while (true){
            Socket clientSocket= serverSocket.accept();
            threadPool.submit(new Handler(clientSocket));
        }
    }
}
