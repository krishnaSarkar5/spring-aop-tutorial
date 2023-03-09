package com.springaoptutorial.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
@Aspect
//@EnableAspectJAutoProxy
public class Human {


    // define pointCuts in one place and use it multiple times


//    @Pointcut("execution(public void study())")
//    public void myPointCuts(){}

    @Pointcut("execution(public * study(..))")
    public void myPointCuts(){}


    @Before("myPointCuts()")
    public void wakeUp(JoinPoint joinPoint){

        System.out.println("All parametrs of the jointpoint :  "+ Arrays.toString(joinPoint.getArgs()));
        System.out.println("Method signature of the jointpoint :  "+ joinPoint.getSignature());
        System.out.println("Good Morning !!!");
    }


    @After("myPointCuts()")
    public void sleep(){
        System.out.println("Good Night !!!");
    }
}
