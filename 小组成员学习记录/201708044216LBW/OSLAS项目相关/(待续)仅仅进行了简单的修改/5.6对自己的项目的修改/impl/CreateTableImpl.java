package edu.zut.cs.software.dao.impl;

import edu.zut.cs.software.dao.CreateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @Auther: LBW
 * @Date: 2019/5/5
 * @Description: edu.zut.cs.software.dao.impl
 * @version: 1.0
 */

@Repository
public class CreateTableImpl implements CreateTable {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    String sql;

    public void CreateTableByJDBC() {
        sql = "create table T_Student " +
                "( sno int primary key , colleage char(20) , major char(20) , class char(20) , num char (20) , name char(20) , sex char (10) )";
        jdbcTemplate.update(sql);
    }
}
