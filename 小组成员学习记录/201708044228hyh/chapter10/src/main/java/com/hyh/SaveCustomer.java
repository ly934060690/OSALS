package com.hyh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author: hyh
 * @Description: jdbc数据访问(使用模版)和回调机制,传统的带事务的数据访问程序
 * @Date:Created in 11:57 2019/5/19
 * @Modified By:
 */
public class SaveCustomer {

    public void setSaveCustomer(Customer customer){

        Connection con=null;
        PreparedStatement stmt=null;

        try {
            // -1 获取资源
            //con=getConnection();

            // -2 启动事务
            //con.setAutoCommit(false);

            //具体的数据访问和操作（业务相关变化的部分）,其他为固定部分
            stmt=con.prepareStatement("insert into CUSTOMERS(ID,NAME) values(?,?)");
            //stmt.setLong(1,customerID);
            //stmt.setString(2,customer.getName());
            stmt.execute();

            // -4 提交事务
            con.commit();
        } catch (Exception e) {
            try {
                //事务回滚
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
