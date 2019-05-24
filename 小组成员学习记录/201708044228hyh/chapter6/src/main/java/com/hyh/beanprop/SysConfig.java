package com.hyh.beanprop;

import javax.sql.DataSource;

/**
 * @Author: hyh
 * @Description: 提供配置信息的类
 * @Date:Created in 14:23 2019/5/18
 * @Modified By:
 */
public class SysConfig {

    public int getSessionTimeout() {
        return sessionTimeout;
    }

    private int sessionTimeout;

    public int getMaxTabPageNum() {
        return maxTabPageNum;
    }

    private int maxTabPageNum;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private DataSource dataSource;

   /**
   *@Description: 模拟从数据库中获取配置值并设置相应属性
   *@Date: 14:29 2019/5/18
   */
    public void initFormDB(){
        this.sessionTimeout=30;
        this.maxTabPageNum=10;
    }
}
