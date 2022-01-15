package com.pb.levchenko.hw15.Connection;

import java.io.Serializable;
import java.util.Set;

public class Message implements Serializable {
    private MessageType typeMessage; // тип смс
    private String textMessage; // текст смс
    private Set<String> listUsers; // множество имен уже подлючившихся пользователей

    public Message(MessageType typeMessage,String textMessage){
        this.typeMessage = typeMessage;
        this.textMessage=textMessage;
        this.listUsers=null;
    }
    public Message(MessageType typeMessage,Set<String>listUsers){
        this.typeMessage=typeMessage;
        this.textMessage=null;
        this.listUsers=listUsers;
    }
    public Message(MessageType typeMessage){
        this.typeMessage=typeMessage;
        this.textMessage=null;
        this.listUsers=null;
    }
    public MessageType getTypeMessage(){
        return typeMessage;
    }
    public Set<String>getListUsers(){
        return listUsers;
    }
    public String getTextMessage(){
        return textMessage;
    }
}
