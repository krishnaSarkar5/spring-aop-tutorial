package com.springaoptutorial.example;

import org.springframework.stereotype.Service;

@Service
public class Student {



    public void study(){
        System.out.println("Reading books ... ");
    }
    public int study(int a , int b){
        System.out.println("Reading books ... ");
        return a+b;
    }

    public int doingHomework(int a, int b){
        return a+b;
    }

    public int doOperation(int a, int b){
        return a/0;
    }
}
