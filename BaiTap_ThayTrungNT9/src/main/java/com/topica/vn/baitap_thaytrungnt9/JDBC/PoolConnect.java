/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topica.vn.baitap_thaytrungnt9.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author khong
 */
public class PoolConnect {
    List<Connection> lisConnection = new ArrayList<>();
    static final Config config = new Config("root","12345", "jdbc:mysql://localhost:3306/testdb","com.mysql.jdbc.Driver", 5);

    public PoolConnect() {
        System.out.println("den day");
        while(CheckPoolFull()){
            lisConnection.add(createConnection());
        }
    }
    
    
    private synchronized boolean CheckPoolFull(){
        final int POOLMAXSIZE = config.getMaxConnection();
        
        if(lisConnection.size() < POOLMAXSIZE) return true;
        return false;
    }
    
    private Connection createConnection(){
        try {
            Class.forName(config.getDriver());
            Connection con = DriverManager.getConnection(config.getUrl(),config.getUsername(), config.getPassword());
            if(con != null) System.out.println("Creadted connection");
            else System.out.println("missCreated");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        
    }
    
    public synchronized Connection getConnection(){
        Connection con = null;
        if(lisConnection.size() > 0){
            con = lisConnection.get(0);
            lisConnection.remove(0);
        }
        return con;
    }
    
    public synchronized void returnConnection(Connection con){
        lisConnection.add(con);
    }
}
