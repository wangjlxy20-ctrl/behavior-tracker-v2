package com.tracker.pojo;

import java.util.Date;

public class Type {
    private int id;
    private int user_id;
    private String type;
    private int value;
    private Date create_time;


    public Type() {
    }

    public Type(int id, int user_id, String type, int value, Date create_time) {
        this.id = id;
        this.user_id = user_id;
        this.type = type;
        this.value = value;
        this.create_time = create_time;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return user_id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * 设置
     * @param user_id
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * 获取
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * 设置
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取
     * @return value
     */
    public int getValue() {
        return value;
    }

    /**
     * 设置
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * 获取
     * @return create_time
     */
    public Date getCreate_time() {
        return create_time;
    }

    /**
     * 设置
     * @param create_time
     */
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String toString() {
        return "Type{id = " + id + ", user_id = " + user_id + ", type = " + type + ", value = " + value + ", create_time = " + create_time + "}";
    }
}
