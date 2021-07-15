package com.xzm.springbootjpa.repository;

import com.xzm.springbootjpa.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

//由于当前文件中，有两个Repository对象，
//一个注解，一个接口，同名冲突了，注解换成全路径
//继承Repository接口，泛型中提供了两个对象：
//第一个：实体模型，由于实体模型中注解 @Table(name="book")定义
//       内部抽象方法，自动按照 findBy 生成： select * from `book`
//第二个： 主键的数据类型
@org.springframework.stereotype.Repository
public interface BookMapper1 extends Repository<Book,Integer> {

    /*
        Repository接口，是基础接口，
        没有提供任何默认方法，它提供的是一套按照指定格式，
        自定义方法名称操作，只要按照它的格式定义出方法名称，
        自动生成对应的SQL执行操作
        主要提供：select查询操作

        开始：findBy
        后面就是属性名称与关键字组合
    */

    //定义列名的时候，最终自动截取方法名称，把列名转换成小写，
    //通过实体模型去做对应的映射关系，生成SQL中的where条件



    //关键字：And
    // findBy列名And列名
    // select * from `book` where `bookid`=?  and `bookname`=?;
    List<Book> findByBookidAndBookname(Integer bookid, String bookname);

    //关键字：Or
    // findBy列名Or列名
    // select * from `book` where `bookid`=?  or `bookname`=?;
    List<Book> findByBookidOrBookname(Integer bookid, String bookname);


    //关键字：缺省，Is，Equals
    // findBy列名  ||  findBy列名Is  ||   findBy列名Equals
    // select * from `book` where `bookname`=?;
    List<Book> findByBookname(String bookname);


    //关系中 大于和小于类
    //findBy列名LessThan              <
    //findBy列名LessThanEqual         <=
    //findBy列名GreaterThan           >
    //findBy列名GreaterThanEqual      >=
    //单价小于等于多少的
    List<Book> findByPriceLessThanEqual(Double price);


    //关键字：Between  NotBetween
    List<Book> findByPriceBetween(Double price1, Double price2);

    //关键字：
    /*
        findBy列名After                           where 列名 > ?
        findBy列名Before                          where 列名 < ?
        findBy列名IsNull                          where 列名 is null
        findBy列名IsNotNull / findBy列名NotNull    where 列名 is not null
        findBy列名Like                            where 列名 like '%?%'
        findBy列名NotLike                         where 列名 not like '%?%'
        findBy列名StartingWith                    where 列名 like '?%'
        findBy列名EndingWith                      where 列名 like '%?'
        findBy列名Containing                      where 列名 like '%?%'
        findBy列名****OrderBy列名ASC/DESC          where 列名 ... order by 列名 asc/desc
        findBy列名Not                             where 列名 <> ?
        findBy列名In                              where 列名 in (集合)
        findBy列名NotIn                           where 列名 not in (集合)

     */


    //通过注解，也允许开发者，自定义sql语句，使用我们自定义的sql语句
    //语句的开始，是使用 queryBy定义的，实际上任意的，
    //默认不能运行的，应为是关闭了这个操作，我们需要添加一个参数开启这个操作
    // nativeQuery = true
    @Query(value = "select * from `book` where `bookid`=:id", nativeQuery = true)
    List<Book> queryByBookidSQL(@Param("id") Integer id);



}

