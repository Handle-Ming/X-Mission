package com.teemo.bootdemo.service.impl;

import com.teemo.bootdemo.dao.domain.Role;
import com.teemo.bootdemo.dao.mapper.RoleMapper;
import com.teemo.bootdemo.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
