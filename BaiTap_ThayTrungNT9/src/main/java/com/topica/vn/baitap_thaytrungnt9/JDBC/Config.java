/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topica.vn.baitap_thaytrungnt9.JDBC;

/**
 *
 * @author khong
 */
public class Config {
    private String username;
    private String password;
    private String url;
    private String driver;
    private int maxConnection;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getMaxConnection() {
        return maxConnection;
    }

    public void setMaxConnection(int maxConnection) {
        this.maxConnection = maxConnection;
    }

    
    public Config(String username, String password, String url, String driver, int maxConnection) {
        this.username = username;
        this.password = password;
        this.url = url;
        this.driver = driver;
        this.maxConnection = maxConnection;
    }
}
