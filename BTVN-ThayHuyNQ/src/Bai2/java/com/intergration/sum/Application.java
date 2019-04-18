package com.intergration.sum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Application implements CommandLineRunner {

  @Autowired
  SumRepository sumRepository;

  public static void main(String[] args){
    SpringApplication.run(Application.class);

  }

  @Override
  public void run(String... args) throws Exception {

    String SoA = new Scanner(System.in).next();
    String SoB = new Scanner(System.in).next();
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    SumRepository sumRepository = (SumRepository) context.getBean("sumRepository");

    System.out.println(sumRepository.Input(SoA,SoB));
  }
}
