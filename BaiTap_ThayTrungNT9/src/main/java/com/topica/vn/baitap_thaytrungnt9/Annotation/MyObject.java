/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topica.vn.baitap_thaytrungnt9.Annotation;

import static com.oracle.webservices.internal.api.databinding.DatabindingModeFeature.ID;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 *
 * @author khong
 */

@Table(nameTable = "MyObject")
public class MyObject {
    private int PrimKey;
    private String Name;
    private int Age;
    private String Address;

    public MyObject() {
    }

    
    public MyObject(int Primkey,String Name, int Age, String Address) {
        setName(Name);
        setAddress(Address);
        setAge(Age);
        setPrimKey(PrimKey);
    }

    public int getPrimKey() {
        return PrimKey;
    }
    
    @PrimKey()
    @Column(nameCol = "ID")
    public void setPrimKey(int PrimKey){
        this.PrimKey = PrimKey;
    }
    
    public String getName() {
        return Name;
    }

    @Column(nameCol = "name")
    public void setName(String Name) {
        this.Name = Name;
    }

    public int getAge() {
        return Age;
    }
    
    @Column(nameCol = "Age")
    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getAddress() {
        return Address;
    }

    @Column(nameCol = "Address")
    public void setAddress(String Address) {
        this.Address = Address;
    }
    
    public void SelectAll(){
        aClass = MyObject.class;
        Annotation annotation = aClass.getAnnotations()[0];
       
        Table gen = (Table)annotation;
        if(gen.Status()){
               System.out.println("Select *from "+gen.nameTable());
        }
    }
    
    public void Insert(String nameTable, Object obj){
        
        
    }
    
    private Class<?> aClass;
  
}
