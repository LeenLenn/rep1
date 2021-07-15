package com.xzm.springbootjpa.repository;

import com.xzm.springbootjpa.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

//JpaSpecificationExecutor接口
//  它是独立的接口对象
//  主要提供多条件查询的[支持]，并且在查找中添加分页，排序等。
//  它不是单独使用的，配合前面四个接口使用的
@Repository
public interface BookMapper5
        extends
        JpaRepository<Book, Integer>,
        JpaSpecificationExecutor<Book> {

    //把五个接口，全部继承到这里来
    //使用的extends，也证明了 OOP课程中讲解的：接口多重继承

}
