package com.xzm.springbootjpa.repository;

import com.xzm.springbootjpa.ApplicationTest;
import com.xzm.springbootjpa.entity.Book;
import org.junit.Test;
import org.springframework.data.jpa.domain.Specification;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class BookMapper5Test extends ApplicationTest {

    //持久层对象
    @Resource
    private BookMapper5 bookMapper;

    //自定义测试方法===============================

    //组合条件查询
    @Test
    public void test_where1(){

        //Specification：查询条件利用代码方式描述的对象
        //利用<Book>指定了，组合条件针对的模型与表
        Specification<Book> specification = new Specification<Book>() {
            //这里是类中的内容,重写父类方法，
            // return返回出来的Predicate对象，封装了单独一个查询条件
            // 方法中三个参数：
            //      root：查询的封装对象
            //      query：封装了要执行查询操作中，语句各部分信息（select, from, order by, .....）
            //      builder：查询条件的构造器，用于构造不同的查询条件
            @Override
            public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

                //只构建单独一个条件
                //Predicate是封装整个条件的对象，赋予的值就是利用
                //方法第三个参数去构建的条件（用代码方式描述）
                //  where `bookid`=5
                Predicate pre = builder.equal(root.get("bookid"),5);

                //返回这个条件
                return pre;
            }
        };
        //-----------------------------------

        //调用查收方法，代入条件
        List<Book> list = this.bookMapper.findAll(specification);
        for(Book book : list){
            System.out.println(book.getBookid()+":"+book.getBookname());
        }

    }

    //如果有多个条件：
    @Test
    public void test_where2(){

        //定义条件
        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder builder) {

                // bookid=1 and bookname='葫芦娃'
                //创建数组或集合，每一个元素就是一个条件，默认全部都是 and

                /*
                    //数组方式：必须定义好多少个条件
                    Predicate[] arr = new Predicate[2];
                    arr[0] = builder.equal(root.get("bookid"),1);
                    arr[1] = builder.equal(root.get("bookname"),"葫芦娃");
                    //返回：构建对象加入数组，每个之间都是and
                    return builder.and(arr);
                */


                    //集合：条件个数自定义的
                    List<Predicate> list = new ArrayList<Predicate>();
                    list.add(builder.equal(root.get("bookid"),1));//第一个条件
                    list.add(builder.equal(root.get("bookname"),"葫芦娃"));//第二个条件
                    //集合转换数组转类型再返回
                    Predicate[] arr = new Predicate[list.size()];
                    arr = (Predicate[]) list.toArray();
                    return builder.and(arr);
            }
        };
        //========================================
        //调用查收方法，代入条件
        List<Book> list = this.bookMapper.findAll(specification);
        for(Book book : list){
            System.out.println(book.getBookid()+":"+book.getBookname());
        }

    }


    //
    @Test
    public void test_where3(){

        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder builder) {

                /*
                //两个条件，中间是and
                return builder.and(
                        builder.equal(root.get("bookid"),1) ,
                        builder.equal(root.get("bookname"),"葫芦娃"));
                */


                //两个条件，又有and，又有or
                //一层一层包住
                // where bookid=3 or bookid=1 and bookname="葫芦娃"
                return builder.or(
                        builder.equal(root.get("bookid"),3),
                        builder.and(
                                builder.equal(root.get("bookid"),1),
                                builder.equal(root.get("bookname"),"葫芦娃")
                        )
                );

            }
        };
        //========================================
        //调用查收方法，代入条件
        List<Book> list = this.bookMapper.findAll(specification);
        for(Book book : list){
            System.out.println(book.getBookid()+":"+book.getBookname());
        }
    }






}
