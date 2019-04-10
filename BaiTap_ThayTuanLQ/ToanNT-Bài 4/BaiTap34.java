/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap34;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class BaiTap34 {

    private void GhiFileKetQua(){
        
    }
    private void Swap(int a, int b){
        int k = dem.get(a);
        String sk = St.get(a);
        St.set(a, St.get(b));
        St.set(b, sk);
        dem.set(a, dem.get(b));
        dem.set(b, k);
    }
    private void SapXepQuickSort(int left, int right){
        if(left >= right) return;
        int i = left+1, j = right, chot = left;
        while(i <= j){
            while(dem.get(i) >= dem.get(chot)){
                i++;
            }
            while(dem.get(j) < dem.get(chot)){
                j--;
            }
            if(i <= j){
                Swap(i,j);
                i++;
                j--;
            }
        }
        Swap(chot,j);
        if(left < j-1) SapXepQuickSort(left,j-1);
        if(i < right) SapXepQuickSort(i,right);
    }
    private static ArrayList<String> St = new ArrayList<>();
    private static ArrayList<Integer> dem = new ArrayList<>();
    
    public boolean SearchArray(String key){
        int k = St.size();
        try {
            
            for(int i = 0; i < k; i++){
                if(St.get(i).compareToIgnoreCase(key) == 0){
                    dem.set(i, dem.get(i)+1);
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return false;
    }
    private String XuLy(String key){
        String lsSt = "";
        if(key.length() > 0){
            int leg = key.length()-1;
            int i = 0;
            while(key.charAt(leg)=='.' || key.charAt(leg) == ',' || key.charAt(leg) == ':' || key.charAt(leg) == ';' || key.charAt(leg) == '”' || key.charAt(leg) == '’'){
                if(leg >= 0) leg--;
                else break;
            }
            while(key.charAt(i)=='“' || key.charAt(i) == '’'){
                if(i < leg) i++;
                else break;
            }
            lsSt = key.substring(i, leg+1);
        }
        return lsSt;
    }
    public static void main(String[] args) {
        //System.out.println(dem.get(0));
        BufferedReader br = null;
        BaiTap34 bt = new BaiTap34();
      
        try{
            
            br = new BufferedReader(new FileReader("d:/bai4.txt"));
            
            String line = br.readLine();
        
            while(line != null){
               
                String a[] = line.split(" ");
                for(String s: a){
                    String lsSt = bt.XuLy(s);
                    
                    if(bt.SearchArray(lsSt)==false){
                        St.add(lsSt);
                        dem.add(1);
                    }
                    
                }
                line=br.readLine();
            }
        }catch (FileNotFoundException fnfe){
            System.out.println(fnfe);
        }
        catch (StringIndexOutOfBoundsException e) {
            System.out.println("lại lỗi rồi");
        }
        catch (Exception e){
            System.out.println(e);
        }
        
        int k = St.size();
        for(int i = 0;i < k; i++){
            int u = dem.get(i);
            int imax = i;
            for(int j = i+1; j < k; j++){
                if(dem.get(j) > u) {
                    u = dem.get(j);
                    imax = j;
                }
            }
            bt.Swap(i, imax);
        }
            
            
        System.out.println(k);
        for(int i = 0; i < k-1; i++){
            System.out.println(i+1+": "+dem.get(i) +": "+St.get(i));
        }
    }
    
}
