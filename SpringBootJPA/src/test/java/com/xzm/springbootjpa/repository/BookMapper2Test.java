package com.xzm.springbootjpa.repository;

import com.xzm.springbootjpa.ApplicationTest;
import com.xzm.springbootjpa.entity.Book;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class BookMapper2Test extends ApplicationTest {

    //持久层对象
    @Resource
    private BookMapper2 bookMapper;

    //自定义测试方法===============================

    @Test
    public void test(){
        /*
        //默认增加了基本的查询操作

        //返回表中数据总行数
        Long count = this.bookMapper.count();

        //返回所有数据的对象集合
        List<Book> list = this.bookMapper.findAll();

        //指定id的数据是否存在，返回true或false
        Boolean flag = this.bookMapper.existsById(Integer id);

        //提供一个集合，所有id相同的数据对象列表
        List<Book> list = this.bookMapper.findAllById(List<Integer> list);

        //按照id检索一个对象
        Book book = this.bookMapper.findById(Integer id);
        */
    }


    //测试默认提供的方法，接口中无定义

    //默认方法： save(对象)
    // 如果没有主键id，执行insert
    // 如果有主键id，执行update，where id
    @Test
    public void test_save_insert(){
        //测试新增数据，没有主键值
        Book book = new Book();
        //book.setBookid()主键缺省
        book.setBookname("SpringBoot手册");
        book.setAuthor(555);
        book.setPrice(5.00);
        book.setNum(100);
        //调用方法
        this.bookMapper.save(book);
        //结果
        System.out.println("添加成功！");

        //====================================
        //如果提供一个Book的集合，调用saveAll()，就批量添加
        //List<Book> list = new ArrayList<Book>();
        //this.bookMapper.saveAll(list);
    }

    //只要有id值，自动执行更新
    //不知道需要更新谁，每一个属性的值都会update
    //因此，默认 业务逻辑首先查找，然后替换属性值，在更新
    @Test
    public void test_save_update(){
        Book book = new Book();
        book.setBookid(1);//where bookid=1
        book.setBookname("葫芦娃");
        book.setAuthor(999);
        book.setPrice(100.0);
        book.setNum(999);
        //调用方法
        this.bookMapper.save(book);
        System.out.println("更新成功！");
        //====================================
        //如果提供一个Book的集合，调用saveAll()，就批量更新
        //List<Book> list = new ArrayList<Book>();
        //this.bookMapper.saveAll(list);
    }

    @Test
    public void test_delete(){

        //按照指定id删除
        //this.bookMapper.deleteById(Integer id);

        //无条件，删除所有数据【通常不会使用】
        //this.bookMapper.deleteAll();

        //按照集合中的book对象，逐个删除
        // 用于 checkbox多选，然后批量删除
        //【集合中的对象，必须所有的值都对应，才删除】
        //this.bookMapper.deleteAll(List<Book> list);

        //删除指定对象
        //【对象中，所有的值都必须对应，才删除】
        //this.bookMapper.delete(Book book);

        this.bookMapper.deleteById(10);
        System.out.println("删除成功！");

    }




}
