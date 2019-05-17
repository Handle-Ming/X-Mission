package com.teemo.bootdemo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.teemo.bootdemo.dao.domain.User;
import com.teemo.bootdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Teemo.dana
 * @since 2019-05-17
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private IUserService userService;

    @GetMapping(value = "test")
    public void test(){

        //测试逻辑删除
        User user = userService.getById(1);

        System.out.println("user:"+user.toString());
        //测试分页
        IPage<User> pageuser = userService.page(new Page<User>(1, 10), new QueryWrapper<>());
        System.out.println("pageuser:"+pageuser.toString());

        List<User> list = pageuser.getRecords();
        System.out.println(list.toString());

    }



}

