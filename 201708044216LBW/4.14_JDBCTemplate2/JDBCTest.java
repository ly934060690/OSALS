package com.atguigu.spring.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
     * 使用queryForObject(String, Class<long>)
     * 做统计查询
     */
    @Test
    public void testQueryForObject2()
    {
        String sql = " SELECT count(ID) from employees";
        long count = jdbcTemplate.queryForObject(sql , long.class);
        System.out.println(count);
    }

    @Test
    public void testQueryForList()
    {
        String sql = "SELECT ID , LAST_NAME lastName, EMAIL , DEPT_ID from employees where ID > ?";
        RowMapper<Employees> rowMapper = new BeanPropertyRowMapper<>(Employees.class);
        List<Employees> employees = jdbcTemplate.query(sql , rowMapper ,3);  //这里不能调用queryForList方法
        System.out.println(employees);
    }
    /**
     * 从数据库中获取一条记录，实际获取一个对象
     * 注意不是调用这个方法queryForObject（String sql , Class<Employee> requiredType , Object args）
     * 而是要调用queryForObject(String sql , RowMapper<Employee> rowMapper , Object args)
     * 1.RowMapper 指定如何去映射结果集的行 ， 常用的实现类为BeanPropertyRowMapper
     * 2.使用SQL中的列的别名完成列名和属性名的映射 ，LAST_NAME lastName
     * 3.不支持级联属性 ， jdbcTemplate 仅仅是JDBC的小工具， 不是orm的框架
     */
    /*
    @Test
    public void testQueryForObject()
    {
        String sql = "SELECT ID , LAST_NAME lastName, EMAIL , DEPT_ID from employees where ID = ?";
        RowMapper<Employees> rowMapper = new BeanPropertyRowMapper<>(Employees.class);
        Employees employees = jdbcTemplate.queryForObject(sql ,rowMapper , 1);
        //Employees employees = jdbcTemplate.queryForObject(sql ,Employees.class , 1);

        System.out.println(employees);
    }
    */
    /**
     * 执行Insert update delete
     * 批量插入数据 但是我这里有一个错误无法找到要更改数据的表
     * @throws SQLException
     */
    @Test
    public void testUpdate(){
        String sql = "insert into employees (ID , LAST_NAME , EMAIL , DEPT_ID) values (? , ? , ? , ?)";
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{ 45, "UZI" ,"32412.com", 2017});
        batchArgs.add(new Object[]{ 77 , "MLXG" ,"324.com", 2018});
        batchArgs.add(new Object[]{88 , "Ming" ,"23e.com", 2019});
        batchArgs.add(new Object[]{99 ,"Letme" ,"32432.com", 2020});
        batchArgs.add(new Object[]{100,"XiaoHu" ,"456.com", 2021});

        jdbcTemplate.update(sql , batchArgs );
    }


    @Test
    public void testDataSource() throws SQLException
    {

        DataSource dataSource = (DataSource)ctx.getBean("dataSource");   //WHY?
        System.out.println(dataSource.getConnection());

    }
}
