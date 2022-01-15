package com.pb.levchenko.hw15.Server;

import com.pb.levchenko.hw15.Connection.Connection;

import java.util.HashMap;
import java.util.Map;

public class ModelGuiServer {
        // модель хранит карту со всеми подключившимися клиентами ключ - имя клиента, значение - объект connecton
        private Map<String, Connection> allUsers = new HashMap<>();
        protected Map<String,Connection> getAllUsers(){
            return allUsers;
        }
        protected void addUsers(String nameUsers, Connection connection){
            allUsers.put(nameUsers, connection);
        }
        protected void removeUser (String nameUsers){
            allUsers.remove(nameUsers);
        }
}
