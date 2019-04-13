/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topica.vn.baitap_thaytrungnt9.JDBC;

import java.util.*;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author khong
 */
public class ConnectionPool {
    
}

class Config {
    private String username;
    private String password;
    private String url;
    private String driver;
    private int maxConnection;

    public Config(String username, String password, String url, String driver, int maxConnection) {
        this.username = username;
        this.password = password;
        this.url = url;
        this.driver = driver;
        this.maxConnection = maxConnection;
    }
}

class PoolConnect {
    List<Connection> availableConnections = new ArrayList<Connection>();
}


