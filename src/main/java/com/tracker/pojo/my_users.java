package com.tracker.pojo;

public class my_users {
    private int user_id;
    private String username;
    private String password;

    public my_users() {
    }

    public my_users(int user_id, String username, String password) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
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
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "my_users{user_id = " + user_id + ", username = " + username + ", password = " + password + "}";
    }
}
