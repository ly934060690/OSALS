package com.atguigu.spring.jdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

/**
 * @Auther: LBW
 * @Date: 2019/4/14
 * @Description: com.atguigu.spring.jdbc
 * @version: 1.0
 */
public class EmployeeDAO
{
    private JdbcTemplate jdbcTemplate;

    public Employees get(Integer id)
    {
        String sql = "SELECT ID , LAST_NAME lastName, EMAIL , DEPT_ID from employees where ID > ?";
        RowMapper<Employees> rowMapper = new BeanPropertyRowMapper<>(Employees.class);
        Employees employees = jdbcTemplate.queryForObject(sql , rowMapper ,id);

        return employees;
    }
}
