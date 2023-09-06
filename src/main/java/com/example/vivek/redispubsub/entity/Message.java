package com.example.vivek.redispubsub.entity;

public class Message {
    private String message;
    private String user;
    public Message() {
    }
    public Message(String message, String user) {
        this.message = message;
        this.user = user;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    @Override
    public String toString() {
        return "Message [message=" + message + ", user=" + user + "]";
    }
}
