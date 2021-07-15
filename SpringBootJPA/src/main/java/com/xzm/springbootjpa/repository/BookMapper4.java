package com.xzm.springbootjpa.repository;

import com.xzm.springbootjpa.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository接口
// 它 extends继承 PageingAndSortingRepository接口，
// 之前三个接口中的内容，全部可以使用
// 它的作用就是把之前所有内容进行了汇总，同时又增加了一点可以操作返回结果的方法

@Repository
public interface BookMapper4 extends JpaRepository<Book,Integer> {
}
