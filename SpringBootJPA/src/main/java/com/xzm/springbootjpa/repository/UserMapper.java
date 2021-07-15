package com.xzm.springbootjpa.repository;

import com.xzm.springbootjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//持久层接口，使用jpa，只要extends继承指定的jpa接口就可以了
//默认，父类接口中，已经实现了很多方法，
//我们可以直接使用，无需定义xml文档，自动参照定义的内容，
//生成匿名类，实现数据库操作
//为了可以自动实现操作，需要定义泛型参数
//<生成的所有操作针对那个对象，主键的属性什么数据类型>
@Repository
public interface UserMapper extends JpaRepository<User, Integer> {
}
