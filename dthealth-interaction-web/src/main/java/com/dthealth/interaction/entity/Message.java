package com.dthealth.interaction.entity;


public class Message {


    private String id;


    private String myId;


    private String objectId;


    private String createTime;


    private char state;


    private char type; // 0: send 1:receive


    private String content;

    public Message(String id, String myId, String objectId, String createTime, char state, char type, String content) {
        this.id = id;
        this.myId = myId;
        this.objectId = objectId;
        this.createTime = createTime;
        this.state = state;
        this.type = type;
        this.content = content;
    }

    public Message() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMyId() {
        return myId;
    }

    public void setMyId(String myId) {
        this.myId = myId;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public char getState() {
        return state;
    }

    public void setState(char state) {
        this.state = state;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
