package com.teemo.bootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class BootdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootdemoApplication.class, args);
    }

}
