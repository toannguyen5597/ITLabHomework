/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Genneric;

/**
 *
 * @author khong
 */
public class MainGeneric {
    public static void main(String[] args){
        Genneric<String,String> genString = new Genneric<>("Nguyễn Trọng","Toàn");
        System.out.println(genString.getFistName()+" "+genString.getName());
        
        Genneric<String,Integer> genInt = new Genneric<>("Trọng Toàn",21);
        
        System.out.println(genInt.getFistName()+": "+genInt.getName()+" Tuổi");
    }
}
