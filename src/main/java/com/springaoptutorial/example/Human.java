package com.springaoptutorial.example;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


@Component
@Aspect
//@EnableAspectJAutoProxy
public class Human {


    // define pointCuts in one place and use it multiple times


    @Pointcut("execution(public void study())")
    public void myPointCuts(){}


    @Before("myPointCuts()")
    public void wakeUp(){
        System.out.println("Good Morning !!!");
    }


    @After("myPointCuts()")
    public void sleep(){
        System.out.println("Good Night !!!");
    }
}
