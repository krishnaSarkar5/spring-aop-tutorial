package com.springaoptutorial.controller;

import com.springaoptutorial.example.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private Student student;

    @GetMapping("/test")
    public String test(){

        student.study(4,12);

        return "test";
    }

    @GetMapping("/homework")
    public int homework(){

       int result = student.doingHomework(8,9);

        return result;
    }

    @GetMapping("/do-operation")
    public int operation(){

        int result = student.doOperation(5,6);

        return result;
    }


    @GetMapping("/do-multiplication")
    public int multiplication(){

        int result = student.calculateMultiplication(5,6);

        return result;
    }
}
