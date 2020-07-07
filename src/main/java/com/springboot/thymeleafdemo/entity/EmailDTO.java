package com.springboot.thymeleafdemo.entity;

public class EmailDTO {

    private String message;
    private String receiver;
    private String subject;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "EmailDTO{" +
                "message='" + message + '\'' +
                ", receiver='" + receiver + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
