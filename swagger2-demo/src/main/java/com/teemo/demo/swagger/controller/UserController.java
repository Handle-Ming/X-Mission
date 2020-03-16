package com.teemo.demo.swagger.controller;

import com.alibaba.fastjson.JSON;
import com.teemo.demo.swagger.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @GetMapping("/get/user")
    public String getUserInfo(){
        String userJsonStr = JSON.toJSONString(new User("张三", "123"));
        return userJsonStr;
    }

    @PostMapping("/add/user")
    public void addUser(@RequestBody User user){

        System.out.println("execute post method Start");

        System.out.println(user.toString());

        System.out.println("execute post method End");
    }




}
