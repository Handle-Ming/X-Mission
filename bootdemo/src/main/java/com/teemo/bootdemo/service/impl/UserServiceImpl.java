package com.teemo.bootdemo.service.impl;

import com.teemo.bootdemo.dao.domain.User;
import com.teemo.bootdemo.dao.mapper.UserMapper;
import com.teemo.bootdemo.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Teemo.dana
 * @since 2019-05-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
