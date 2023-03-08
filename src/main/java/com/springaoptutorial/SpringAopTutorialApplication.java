package com.springaoptutorial;

import com.springaoptutorial.example.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class SpringAopTutorialApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringAopTutorialApplication.class, args);
	}

}
