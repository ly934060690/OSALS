package edu.zut.cs.lbw.logistics.repository.impl;

import edu.zut.cs.lbw.logistics.repository.DataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
import java.util.Map;

/**
 * @Auther: LBW
 * @Date: 2019/4/3
 * @Description: com.logistics.lbw.mian
 * @version: 1.0
 */
@Repository("DataBase")   //这里我设置此类为持久层
@Component
public class DataBaseImpl extends JdbcDaoSupport implements DataBase  //这里设置数据库操作为接口类以便接下来的类使用
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void GoodsUp(String goodsname , int number)   //这个函数只能给特定的列更新数据
    {
         String sql = " update Clothes set '男士牛仔裤' = '男士牛仔裤' + ? where goodsname = ?";
         jdbcTemplate.update(sql , number , goodsname);
    }

    @Override
    public void GoodsDown(String goodsname , int number)
    {
        String sql2 = " update Clothes set '男士牛仔裤' = '男士牛仔裤' - ? where goodsname = ?";
        jdbcTemplate.update(sql2 , number , goodsname);
    }

    @Override
    public void GoodsPrint()  //
    {
         String sql3 = "select * from Clothes";
         List<Map<String , Object>> maps = jdbcTemplate.queryForList(sql3);
         System.out.println(maps);
    }

}

