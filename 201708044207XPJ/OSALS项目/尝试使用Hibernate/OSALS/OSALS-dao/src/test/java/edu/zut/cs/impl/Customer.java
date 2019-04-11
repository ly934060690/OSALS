package edu.zut.cs.impl;

import edu.zut.cs.OSALS.admin.domain.User;
import edu.zut.cs.OSALS.admin.utile.JPAUtile;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Customer {
    @Test
    public void test1(){
        //创建客户对象
        User user = new User();
        user.setName("pen");
        user.setId(0);
        user.setKind("日用品");
        user.setNumber("000001");
        user.setPrice(10);
        //1.获取EntityManager
        EntityManager em= JPAUtile.createEntityManager();
        //2.获取事务对象，并开启事务
        EntityTransaction tx=em.getTransaction();
        tx.begin();
        //3.执行保存操作
        em.persist(user);
        //4.提交事务
        tx.commit();
        //5.关闭资源
        em.close();
    }
}
