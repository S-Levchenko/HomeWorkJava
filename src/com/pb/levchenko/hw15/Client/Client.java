package com.pb.levchenko.hw15.Client;

import com.pb.levchenko.hw15.Connection.Connection;
import com.pb.levchenko.hw15.Connection.Message;
import com.pb.levchenko.hw15.Connection.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {
    private Connection connection;
    private static ModelGuiClient model;
    private static ViewGuiClient guiClient;
    private volatile boolean isConnect = false; // значение отображает подключен ли

    // клиент к серверу
    public boolean isConnect() {
        return isConnect;
    }

    public void setConnect(boolean connect) {
        isConnect = connect;
    }

    // точка входа в клиентское приложение
    public static void main(String[] args) {
        Client client = new Client();
        model = new ModelGuiClient();
        guiClient = new ViewGuiClient(client);
        guiClient.initFrameClient();
        while (true) {
            if (client.isConnect()) {
                client.nameUserRegistration();
                client.receiveMessageFromServer();
                client.setConnect(false);

            }
        }
    }
    //метод подключения клиента  серверу
    protected void connectToServer(){
        //если клиент не подключен  сервере то..
        if(!isConnect){
            while (true){
                try{
                    String addressServer = guiClient.getServerAddressFromOptionPane();
                       int port = guiClient.getPortServerFromOptionPane();
                    //создаем сокет и объект connection
                    Socket socket = new Socket(addressServer,port);
                    connection = new Connection(socket);
                    isConnect= true;
                    guiClient.addMessage("Сервисное сообщение: Вы подключились к серверу.\n");
                    break;
                }catch (Exception e){
                 guiClient.errorDialogWindow("Произошла ошибка! " +
                         "Возможно Вы ввели не верный адрес сервера или порт. Попробуйте еще раз");
                 break;
                }
            }
        } else guiClient.errorDialogWindow("Вы уже подключены!");
    }
    //метод, реализующий регистрацию имени пользователя со стороны клиентского приложения
    protected void nameUserRegistration(){
        while (true){
            try {
                Message message= connection.receive();
                //приняли от сервера сообщение, если это запрос имени,
                // то вызываем окна ввода имени, отправляем на сервер имя
                if(message.getTypeMessage() == MessageType.REQUEST_NAME_USER){
                    String nameUser = guiClient.getNameUser();
                    connection.send(new Message(MessageType.USER_NAME,nameUser));
                }
                // если сообщение - имя уже используется, выводим соответствующее окно с ошибой,
                // повторяем ввод имени
                if(message.getTypeMessage()==MessageType.NAME_USED){
                    guiClient.errorDialogWindow("Данное имя уже используется, введите другое");
                    String nameUser = guiClient.getNameUser();
                    connection.send(new Message(MessageType.USER_NAME,nameUser));
                }
                // если имя принято, получаем множество всех подключившихся пользователей,
                // выходим из цикла
                if(message.getTypeMessage()==MessageType.NAME_ACCEPTED){
                    guiClient.addMessage("Сервисное сообщение: ваше имя принято!\n");
                    model.setUsers(message.getListUsers());
                    break;
                }
            } catch (Exception e){
                e.printStackTrace();
                guiClient.errorDialogWindow("Произошла ошибка при регистрации имени. " +
                        "Попробуйте снова");
                try {
                    connection.close();
                    isConnect = false;
                    break;
                } catch (IOException ex){
                    guiClient.errorDialogWindow("Ошибка при закрытии соединения");
                }

            }
        }
    }
    // метод отправки сообщения предназначенного для других пользователей на сервер
    protected void sendMessageOnServer(String text){
        try{
            connection.send(new Message(MessageType.TEXT_MESSAGE,text));
        } catch (Exception e){
            guiClient.errorDialogWindow("Ошибка при отправки сообщения");
        }
    }

    // метод принимающий с сервера собщение от других клиентов
    protected void receiveMessageFromServer(){
        while (isConnect){
            try{
                Message message =connection.receive();
                // если тип TEXT_MESSAGE, то добавляем текст сообщения в окно переписки
                if (message.getTypeMessage()==MessageType.TEXT_MESSAGE){
                    guiClient.addMessage(message.getTextMessage());
               // если сообщение с типо USER_ADDED добавляем сообщение в окно переписки о новом пользователе
                    if(message.getTypeMessage()==MessageType.USER_ADDED){
                        model.addUser(message.getTextMessage());
                        guiClient.refreshListUsers(model.getUsers());
                        guiClient.addMessage(String.format("Сервисное сообщение: пользователь %s присоединился к" +
                                " чату.\n",message.getTypeMessage()));
                    }
                    //аналогично для отключения других пользователей
                    if(message.getTypeMessage()==MessageType.REMOVED_USER){
                        model.removeUser(message.getTextMessage());
                        guiClient.refreshListUsers(model.getUsers());
                        guiClient.addMessage(String.format("Сервисное сообщение: пользователь %s покинул чат.\n",
                                message.getTextMessage()));
                    }
                }
            } catch (Exception e){
                guiClient.errorDialogWindow("Ошибка при получении сообщения от сервера.");
                setConnect(false);
                guiClient.refreshListUsers(model.getUsers());
                break;
            }
        }
    }
    //метод реализующий отключение нашего клиента от чата
    protected void disableClient() {
        try {
            if(isConnect) {
              connection.send (new Message(MessageType.DISABLE_USER));
              model.getUsers().clear();
              isConnect = false;
              guiClient.refreshListUsers(model.getUsers());
            } else guiClient.errorDialogWindow("Вы уже отключены от сервера");
        } catch (Exception e){
            guiClient.errorDialogWindow("Сообщение от сервера: произошла ошибка при отключении.");
        }
    }

}
