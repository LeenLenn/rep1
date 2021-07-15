package com.xzm.springbootjpa.repository;

import com.xzm.springbootjpa.ApplicationTest;
import com.xzm.springbootjpa.entity.User;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

//用于测试UserMapper的单元测试文件
//继承测试主文件
public class UserMapperTest extends ApplicationTest {

    //项目中持久层对象
    @Resource
    private UserMapper userMapper;

    //自定义方法，定义JavaSE代码，测试
    //测试JPA中，默认的findAll方法
    @Test
    public void test_findAll(){
        List<User> list = this.userMapper.findAll();
        for(User user : list){
            System.out.println( user.getUserid() + user.getUsername() );
        }
    }












}
