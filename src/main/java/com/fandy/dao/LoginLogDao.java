package com.fandy.dao;

/**
 * Created by Administrator on 2014/7/13.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fandy.domain.LoginLog;

@Repository
public class LoginLogDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertLoginLog(LoginLog loginLog) {
        String sqlStr = "INSERT INTO t_login_log(user_id,ip,login_datetime) "
                + "VALUES(?,?,?)";
        Object[] args = {loginLog.getUserId(), loginLog.getIp(),
                loginLog.getLoginDate()};
        jdbcTemplate.update(sqlStr, args);
    }
}
