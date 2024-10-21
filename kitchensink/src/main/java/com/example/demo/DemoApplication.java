package com.example.demo;

//Importing required classes
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//Annotation
@SpringBootApplication
@ComponentScan({"com.example"})

public class DemoApplication
{
	   // Main driver method
    public static void main(String[] args)
    {
        SpringApplication.run(DemoApplication.class, args);
    }
}
