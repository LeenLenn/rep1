package com.xzm.springbootjpa.service.impl;

import com.xzm.springbootjpa.entity.User;
import com.xzm.springbootjpa.repository.UserMapper;
import com.xzm.springbootjpa.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService implements IUserService {

    //数据持久对象
    @Resource
    private UserMapper userMapper;

    //测试持久层jpa默认方法
    @Override
    public void Test() {

        //测试默认提供的findAll()方法，返回所有用户列表
        List<User> list = this.userMapper.findAll();
        for(User user : list){
            System.out.println( user.getUserid() + user.getUsername() );
        }

    }
}
