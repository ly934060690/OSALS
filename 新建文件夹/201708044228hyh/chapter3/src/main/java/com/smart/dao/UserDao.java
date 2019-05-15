package com.smart.dao;

//DAO数据访问对象，用于数据的访问和操作

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {
    //根据用户名查询用户的SQL语句
    private final static String MATCH_COUNT_SQL= " SELECT count(*) FROM "+
            " t_user WHERE user_name=? and password=? ";

    private final static String UPDATE_LOGIN_INFO_SQL= " UPDATE t_user SET "+
            " last_visit=?,last_ip=?,credits=? WHERE user_id=? ";

    private JdbcTemplate jdbcTemplate;

    //自动注入JdbcTemplate的Bean，Autowired（自动装配）
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public int getMatchCount(String userName,String password){//用户名和密码是否匹配
        String sqlStr=" SELECT count(*) FROM t_user "+" WHERE user_name=? and password=? ";
        return jdbcTemplate.queryForObject(sqlStr,new Object[]{userName,password},Integer.class);
    }

    public User findUserByUserName(final String userName){//由用户名获取User对象
        final User user=new User();

        jdbcTemplate.query(MATCH_COUNT_SQL, new Object[]{userName}, new RowCallbackHandler() {
            //匿名类的方式实现的回调函数
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                //负责将查询结果从ResultSet装载到类似领域对象的对象实例中
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(userName);
                user.setCredits(resultSet.getInt("credits"));
            }
        });
        return user;
    }

    public void updateLoginInfo(User user){//更新用户积分，最后登录IP及最后登录时间
        jdbcTemplate.update(UPDATE_LOGIN_INFO_SQL,new Object[]{user.getLastVisit(),
                user.getLastIp(),user.getCredits(),user.getUserId()});
    }
}
