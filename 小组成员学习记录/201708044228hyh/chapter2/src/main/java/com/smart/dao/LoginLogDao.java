package com.smart.dao;

//DAO数据访问对象，记录用户的登陆日志

import com.smart.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginLogDao {
    private JdbcTemplate jdbcTemplate;

    //保存登陆日志
    private final static String INSERT_LOGIN_LOG_SQL=" INSERT INTO " +
            " t_login_log(user_id,ip,login_datetime) VALUES(?,?,?) ";

    //登录日志插入
    public void insertLoginLog(LoginLog loginLog) {
        Object[] args = {loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate()};
        jdbcTemplate.update(INSERT_LOGIN_LOG_SQL, args);
    }

    @Autowired     //自动注入JdbcTemplate的Bean，Autowired（自动装配）
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

}
