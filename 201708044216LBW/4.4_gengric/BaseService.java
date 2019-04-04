package com.atguigu.spring.beans.gengric.di;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Auther: LBW
 * @Date: 2019/4/4
 * @Description: com.atguigu.spring.beans.gengric.di
 * @version: 1.0
 */
public class BaseService <T>
{
    @Autowired
    protected BaseRepository<T> repository;

    public void add()
    {
        System.out.println("add...");
        System.out.println(repository);
    }


}
