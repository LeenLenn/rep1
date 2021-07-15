package com.xzm.springbootjpa.repository;

import com.xzm.springbootjpa.entity.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

// PagingAndSortingRepository接口
// 它 extends继承 CrudRepository接口，前面所有的接口方法它都可以使用
// 它在原有的基础上，扩展了针对： 分页 和 排序的 操作
// 缺点：主要方法中不能代入条件
//      是对表中所有数据进行分页和排序

@Repository
public interface BookMapper3 extends PagingAndSortingRepository<Book,Integer> {
}
