package edu.zut.cs.software.domian.impl;

import edu.zut.cs.software.domian.Good;
import edu.zut.cs.software.dao.GoodsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: LBW
 * @Date: 2019/5/7
 * @Description: edu.zut.cs.software.dao.domian.impl
 * @version: 1.0
 */
public class GoodsManagerImpl extends Good implements GoodsManager {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    String sql ;


    public void Add(String GoodId , String GoodNames , Integer Numbers) {
        sql = "insert into goods (good_id , good_name , number) values (? , ? , ?)";
        jdbcTemplate.update(sql);
    }

    public void Delete(String GoodId) {
        sql = "delete from goods where GoodId = ?";
        jdbcTemplate.update(sql);
    }

    public void update(String GoodId , String GoodNames , Integer Numbers) {
        sql = "update goods set GoodNames = ?  , Numbers = ? where GoodId = ?";
        jdbcTemplate.update(sql);
    }

    public List<Good> query(String GoodId) {
        sql = "select * from goods where GoodId = ?";
        jdbcTemplate.query(sql ,new AccountRowMapper());
        return null;
    }
}

class AccountRowMapper implements RowMapper<Good>
{
    /**
     * 把结构集中的数据封装到Account中，再由spring将每个account加到集合中
     * sping中的RowMapper可以将数据中的每一行数据封装成用户定义的类。
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    public Good mapRow(ResultSet rs, int rowNum) throws SQLException {
        Good good = new Good();

        good.setGoodId(rs.getString("id"));
        good.setGoodNames(rs.getString("name"));
        good.setNumbers(rs.getInt("number"));
        return good;
    }
}