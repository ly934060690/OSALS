package com.itheima.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @Auther: LBW
 * @Date: 2019/4/19
 * @Description: com.itheima.jdbctemplate
 * @version: 1.0
 */
public class JDBCTemplate
{
    public static void main(String[] args) {
        /**
         * 这次使用spring的内置数据源
         */

        DriverManagerDataSource dmd = new DriverManagerDataSource();
        dmd.setDriverClassName("com.mysql.jdbc.Driver");
        dmd.setUrl("jdbc:mysql://localhost:3306/mysql");
        dmd.setUsername("root");
        dmd.setPassword("123456");
        JdbcTemplate jt = new JdbcTemplate();
        jt.setDataSource(dmd);

        jt.execute("insert into account(id , name , money ) value(4 , 'lbw' ,'2342352' )");
    }
}
