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

        student.study();


        return "test";
    }
}
