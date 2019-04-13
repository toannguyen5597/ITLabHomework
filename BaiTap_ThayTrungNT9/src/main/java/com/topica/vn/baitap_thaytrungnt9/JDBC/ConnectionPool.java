/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topica.vn.baitap_thaytrungnt9.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author khong
 */
public class ConnectionPool {
    static PoolConnect pool = new PoolConnect();
    
    public static Connection getConnection(){
        Connection con = pool.getConnection();
        if(con!= null) System.out.println("get connection successfull");
        return con;
    }
    
    public static void returnConnection(Connection con){
        pool.returnConnection(con);
        System.out.println("return connection successfull");
    }
    
    public static void main(String[] args){
        for(int i = 0; i < 1; i++){
            MyThread queryThread = new MyThread(getConnection(), "SELECT *FROM STUDENT;");
        }
    }
}

class MyThread extends Thread{
    private Connection connection = null;
    private String query;
    public MyThread(Connection con, String query) {
        this.connection = con;
        this.query = query;
    }
    private void PrintResult(ResultSet result){
        try {
            while(result.next()){
            System.out.println(result.getInt(1) +"\t"+ result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            PrintResult(resultSet);
            sleep(7000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}


