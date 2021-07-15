package com.xzm.springbootjpa.repository;

import com.xzm.springbootjpa.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// CrudRepository接口，
// 它 extends继承 Repository接口，这里可以使用Repository中所有内容
// 它 在原有基础上，扩展了 C增，U更新，D删除的基本操作
// 它 同时提供最基本的查询操作
@Repository
public interface BookMapper2 extends CrudRepository<Book,Integer> {
}
