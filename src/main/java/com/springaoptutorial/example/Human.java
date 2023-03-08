package com.springaoptutorial.example;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


@Component
@Aspect
//@EnableAspectJAutoProxy
public class Human {

    @Before(value = "execution(public void study())")
    public void wakeUp(){
        System.out.println("Good Morning !!!");
    }
}
