package com.springaoptutorial.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
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

        System.out.println("All parameters of the joinpoint :  "+ Arrays.toString(joinPoint.getArgs()));
        System.out.println("Method signature of the joinpoint :  "+ joinPoint.getSignature());
        System.out.println("only Method name of the joinpoint :  "+ joinPoint.getSignature().getName());
        System.out.println("class name of the joinpoint :  "+ joinPoint.getTarget().getClass().getName());
        System.out.println("Good Morning !!!");
    }


//    @After("myPointCuts()")
    public void sleep(){
        System.out.println("Good Night !!!");
    }


    @AfterReturning(pointcut = "execution( int doingHomework(..))" , returning = "value")
    public void homeWorkAdvise(JoinPoint joinPoint,int value){
        System.out.println(" executed method : "+joinPoint.getSignature().getName());
        System.out.println(" returned value from executed method : "+value);
    }

    //AfterThrowing annotation can be used to log the exception in db

    @AfterThrowing(pointcut = "execution( int doOperation(..))" , throwing = "ex")
    public void exceptionAdvise(JoinPoint joinPoint,Exception ex){
        System.out.println(" executed method : "+joinPoint.getSignature().getName());
        System.out.println(" exception occur in executed method : "+ex);
    }

    @Around("execution(int calculateMultiplication(..))")
    public Object calculateProcessTime(ProceedingJoinPoint proceedingJoinPoint){

        LocalDateTime startTime = LocalDateTime.now();

        Object res = null;

        try {
            res = proceedingJoinPoint.proceed(); // this will trigger the joinPoint method
        }catch (Throwable e){
            e.printStackTrace();
        }

        LocalDateTime endtime = LocalDateTime.now();

        System.out.println("Total time taken in seconds "+ Duration.between(startTime,endtime).toSeconds());

        return  res;
    }



}
