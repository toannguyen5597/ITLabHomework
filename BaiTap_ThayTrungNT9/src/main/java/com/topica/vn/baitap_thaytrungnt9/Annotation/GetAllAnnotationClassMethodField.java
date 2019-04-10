/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topica.vn.baitap_thaytrungnt9.Annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
 
@myAnnotation()
public class GetAllAnnotationClassMethodField {
 
   @myAnnotation(name = "someOne")
   protected int myField;
   
   protected String myName;
 
   @myAnnotation(Age = 22)
   protected void myMethod(String str) {
 
   }
   
   private void GetAnnotationField(){
       System.out.println(" == Field Annotation In Class == ");
       
       try {
            Field[] fields = GetAllAnnotationClassMethodField.class.getDeclaredFields();
            for (Field field : fields) {
                if(field.isAnnotationPresent(myAnnotation.class))
                System.out.println("Annotation Class: " + field.getName());
            }
       } catch (Exception e) {
           System.out.println(e);
       }
       
   }
   
   private void GetAnnotationMethod(){
       
       System.out.println(" == Method Annotation In Class == ");
       try {
            Method[] methods = GetAllAnnotationClassMethodField.class.getDeclaredMethods();

            for (Method method : methods) {
                if(method.isAnnotationPresent(myAnnotation.class))
                System.out.println("Annotation Method: "+ method.getName());
            }
       } catch(Exception e){
           System.out.println(e);
       }
       
   }
   
   public static void main(String[] args) {
       
       GetAllAnnotationClassMethodField demo = new GetAllAnnotationClassMethodField();
       
       // Lấy ra danh sách các Annotation của các field trong class
       demo.GetAnnotationField();
       
       // Lấy ra danh sách các Annotation của method
       demo.GetAnnotationMethod();
       
       //Ý 2
       
       MyObject myObj = new MyObject(1,"Toan",21,"Ha Tay");
       myObj.SelectAll();
       
   }
}