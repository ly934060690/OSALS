package com.hyh;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: hyh
 * @Description: Spring数据源实现类，该实现类适合单元测试和简单的独立应用
 * @Date:Created in 18:09 2019/5/19
 * @Modified By:
 */
public class DriverManagerDataSourceDemo {

    public static void main(String[] args) throws SQLException {

        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/sampledb");
        ds.setUsername("root");
        ds.setPassword("11q22q33q");
        //每次调用getConnection()方法，只是简单的创建一个新连接
        Connection actualCon=ds.getConnection();
    }

}
