package com.intergration.sum;

import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Repository;

import java.util.Scanner;

@Repository
public class SumRepository {

    public String Input(String SoA, String SoB){
        return "Kết quả: "+(Float.parseFloat(SoA) + Float.parseFloat(SoB));
    }
}
