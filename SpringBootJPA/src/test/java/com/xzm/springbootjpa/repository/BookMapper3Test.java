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

public class BookMapper3Test extends ApplicationTest {

    //持久层对象
    @Resource
    private BookMapper3 bookMapper;

    //自定义测试方法===============================

    @Test
    public void test(){

        //继承父类接口，自己重写了父类接口中的方法
        //允许定义 排序Sort和分页Pageable
        //this.bookMapper.findAll(Sort sort);
        //this.bookMapper.findAll(Pageable pageable);
    }


    // Sort排序
    @Test
    public void Test_sort(){
        //创建排序规则对象 Sort.Order，定义排序规则
        //规则：
        //  Sort.Direction.ASC   升序
        //  Sort.Direction.DESC  降序
        //字符串：
        //  列名
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"bookid");

        //创建排序对象，传入排序规则
        //如果有多个规则，上面创建多个order
        //这里传入的是一个新的 new Sort(order,order1,order2,...)
        Sort sort = Sort.by(order);

        //调用方法，传入排序
        //返回的是一个泛型对象，需要手动转型的
        List<Book> list = (List<Book>)this.bookMapper.findAll(sort);

        for(Book book : list){
            System.out.println(book.getBookid()+":"+book.getBookname());
        }

    }

    //分页
    @Test
    public void test_page(){

        int p=1;    //路径中获取的页数，程序中从0开始，第一页
        int rows=5; //固定的每页多少行

        //创建分页对象(页数-1，每页多少条)
        //程序的页数要把实际页数-1
        Pageable pageable = PageRequest.of(p-1,rows);

        //调用方法，传入分页，获取返回的对象
        //得到的是一个Page类对象，里面有方法，有属性，可以获取各种信息
        Page<Book> page = this.bookMapper.findAll(pageable);


        //界面显示：
        // 查询结果：????条
        // 首页1   上一页-1    下一页+1   末页

        //获取Page中的数据
        System.out.println("总条数："+ page.getTotalElements() );
        System.out.println("总页数："+ page.getTotalPages() );

        //所有数据都在Page里面，通过方法会自动按照pageable截取一部分返回出来
        List<Book> list = page.getContent();
        for(Book book : list){
            System.out.println(book.getBookid()+":"+book.getBookname());
        }
    }


    //排序+分页
    @Test
    public void test_sort_page(){

        int p=1;    //页数
        int rows=5; //每页多少行

        //定义排序规则和对象
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "bookid");
        Sort sort = Sort.by(order);

        //创建分页对象，同时代入排序对象
        Pageable pageable = PageRequest.of(p-1, rows, sort);

        //调用方法
        Page<Book> page = this.bookMapper.findAll(pageable);

        //获取Page中的数据
        System.out.println("总条数："+ page.getTotalElements() );
        System.out.println("总页数："+ page.getTotalPages() );

        //所有数据都在Page里面，通过方法会自动按照pageable截取一部分返回出来
        List<Book> list = page.getContent();
        for(Book book : list){
            System.out.println(book.getBookid()+":"+book.getBookname());
        }

    }









}
