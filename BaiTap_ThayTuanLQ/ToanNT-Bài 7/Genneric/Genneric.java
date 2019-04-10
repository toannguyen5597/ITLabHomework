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
public class Genneric <H,T> {
    
    private H FistName;
    private T Name;

    public Genneric(H FistName, T Name) {
        this.FistName = FistName;
        this.Name = Name;
    }

    public Genneric() {
    }

    public H getFistName() {
        return FistName;
    }

    public void setFistName(H FistName) {
        this.FistName = FistName;
    }

    public T getName() {
        return Name;
    }

    public void setName(T Name) {
        this.Name = Name;
    }

    
}
