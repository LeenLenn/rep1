package com.xzm.springbootjpa.repository;

import com.xzm.springbootjpa.ApplicationTest;
import com.xzm.springbootjpa.entity.Book;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;
import java.util.List;

public class BookMapper4Test extends ApplicationTest {

    //持久层对象
    @Resource
    private BookMapper4 bookMapper;

    //自定义测试方法===============================

    // 按照主键id返回一个对象
    @Test
    public void test_getOne(){

        //Repositore接口中，返回的统一是集合
        //当前接口中，追加了一个方法，按照主键id，返回一个对象
        Book book = this.bookMapper.getOne(1);

        System.out.println(book.getBookid() +": "+ book.getBookname());
    }




}
