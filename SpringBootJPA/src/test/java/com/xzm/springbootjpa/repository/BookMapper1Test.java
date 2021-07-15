package com.xzm.springbootjpa.repository;

import com.xzm.springbootjpa.ApplicationTest;
import com.xzm.springbootjpa.entity.Book;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class BookMapper1Test extends ApplicationTest {

    //持久层对象
    @Resource
    private BookMapper1 bookMapper;

    //自定义测试方法===============================

    //测试And关键字的方法
    @Test
    public void test_findByBookidAndBookame(){
        List<Book> list = this.bookMapper.findByBookidAndBookname(1,"西游记");
        for(Book book : list){
            System.out.println(book.getBookname());
        }
    }

    //测试Or关键字的方法
    @Test
    public void test_findByBookidOrBookame(){
        List<Book> list = this.bookMapper.findByBookidOrBookname(2,"天龙八部");
        for(Book book : list){
            System.out.println(book.getBookname());
        }
    }


    //测试 缺省，Is，Equals 关键字的方法
    @Test
    public void test_findByBookame(){
        List<Book> list = this.bookMapper.findByBookname("天龙八部");
        for(Book book : list){
            System.out.println(book.getBookname());
        }
    }


    //测试大于小于
    @Test
    public void test_findByPriceLessThanEqual(){
        List<Book> list = this.bookMapper.findByPriceLessThanEqual(50.0);
        for(Book book : list){
            System.out.println(book.getBookid()+" : "+book.getBookname());
        }
    }

    //测试 Between
    @Test
    public void test_findByPriceBetween(){
        List<Book> list = this.bookMapper.findByPriceBetween(50.0, 100.0);
        for(Book book : list){
            System.out.println(book.getBookid()+" : "+book.getBookname());
        }
    }


    //测试query自定义sql操作
    @Test
    public void test_queryByBookidSQL(){
        List<Book> list = this.bookMapper.queryByBookidSQL(6);
        for(Book book : list){
            System.out.println(book.getBookid()+" : "+book.getBookname());
        }
    }

}
