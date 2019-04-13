/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topica.vn.baitap_thaytrungnt9.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Queue;

/**
 *
 * @author khong
 */
public class PoolConnect {
    Queue<Connection> lisConnection;
    static final Config config = new Config("root","12345", "jdbc:mysql://localhost:3306/testdb","com.mysql.jdbc.Driver", 5);

    public synchronized void PoolConnect() {
        while(CheckPoolFull()){
            lisConnection.add(createConnection());
        }
    }
    
    
    private boolean CheckPoolFull(){
        final int POOLMAXSIZE = config.getMaxConnection();
        
        if(lisConnection.size() < POOLMAXSIZE) return true;
        return false;
    }
    
    private Connection createConnection(){
        try {
            Class.forName(config.getDriver());
            Connection con = DriverManager.getConnection(config.getUrl(),config.getUsername(), config.getPassword());
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        
    }
    
    public synchronized Connection getConnection(){
        Connection con = null;
        if(lisConnection.size() > 0){
            con = lisConnection.element();
        }
        return con;
    }
    
    public synchronized void returnConnection(Connection con){
        lisConnection.add(con);
    }
}
