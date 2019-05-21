package com.atguigu.spring.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
/**
 * @Auther: LBW
 * @Date: 2019/4/13
 * @Description: com.atguigu.spring.jdbc
 * @version: 1.0
 */
public class JDBCTest
{
    private ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    private JdbcTemplate jdbcTemplate;

    {
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
    }

    /**
     * 执行Insert update delete
     * @throws SQLException
     */
    @Test
    public void testUpdate(){
        String sql = "insert into lbw (name , ID) values (? , ?)";
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{"UZI" , 2017});
        batchArgs.add(new Object[]{"MLXG" , 2018});
        batchArgs.add(new Object[]{"Ming" , 2019});
        batchArgs.add(new Object[]{"Letme" , 2020});
        batchArgs.add(new Object[]{"XiaoHu" , 2021});

        jdbcTemplate.update(sql , batchArgs );
    }


    @Test
    public void testDataSource() throws SQLException
    {

        DataSource dataSource = (DataSource)ctx.getBean("dataSource");   //WHY?
        System.out.println(dataSource.getConnection());

    }
}
