/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topica.vn.baitap_thaytrungnt9.JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author khong
 */
public class CallableStatementJDBC {

    
    //Tạo kết nối đến database
    private static Connection myConnection(String dbName, String user, String password){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName,user,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    
    //In ra kết quả câu truy vấn select *
    private void PrintResult(ResultSet result){
        try {
            while(result.next()){
            System.out.println(result.getInt(1) +"\t"+ result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    static CallableStatement cst=null;
    private static ResultSet result = null;
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        CallableStatementJDBC jdbc = new CallableStatementJDBC();
        Connection con = myConnection("testdb", "root", "12345");
        if(con != null) System.out.println("Ket noi thanh cong toi database");
        try {
            Statement st = con.createStatement();
            
            //Tạo một table trong db
            //st.execute("Create table Student(ID INT NOT NULL AUTO_INCREMENT, NAME VARCHAR(50) NOT NULL, ADDRESS VARCHAR(50), AGE INT, PRIMARY KEY (ID));");
            
            //Thêm dữ liệu vào table
            for(int i = 0;i < 10; i++){
                st.execute("INSERT INTO STUDENT(NAME, ADDRESS, AGE) VALUES ('NGUYEN VAN TOAN', 'HA TAY', 21)");    
            }
            
            //Tạo produre lấy ra toàn bộ student 
//            st.execute("CREATE PROCEDURE GETALLSTUDENT ()\n" +
//                            "BEGIN\n" +
//                            "SELECT *FROM STUDENT;" +
//                            "END");
            
            //Tạo produre lấy ra sinh viên theo id 
//            st.execute("CREATE PROCEDURE GETSTUDENTBYID (IDSTUDENT INT)\n" +
//                            "BEGIN\n" +
//                            "SELECT *FROM STUDENT WHERE ID = IDSTUDENT;" +
//                            "END");
            
            //Thực hiện các produre bằng CallableStatenment
            cst = con.prepareCall("{CALL GETALLSTUDENT()}");
            result = cst.executeQuery();
            jdbc.PrintResult(result);
            
            cst = con.prepareCall("{CALL GETSTUDENTBYID(?)}");
            cst.setInt(1,new Scanner(System.in).nextInt());
            result = cst.executeQuery();
            jdbc.PrintResult(result);
           
            //Ngắt kết nối tới db sau khi sử dụng xong
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
