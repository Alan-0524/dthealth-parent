package com.dthealth.dao.entity;

public class SimpleMessage {

    private String content;

    public SimpleMessage(String content) {

        this.content = content;
    }

    public SimpleMessage() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
