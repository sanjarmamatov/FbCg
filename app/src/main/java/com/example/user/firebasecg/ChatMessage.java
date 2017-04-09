package com.example.user.firebasecg;

/**
 * Created by User on 08.04.2017.
 */

public class ChatMessage {
    private String name;
    private String message;

    public ChatMessage(){}

    public ChatMessage(String name, String message){
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
