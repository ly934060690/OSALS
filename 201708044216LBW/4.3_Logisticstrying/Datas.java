package com.logistics.lbw.mian;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Auther: LBW
 * @Date: 2019/4/3
 * @Description: com.logistics.lbw.mian
 * @version: 1.0
 */
public interface Datas
{
    public Connection GetConn()throws SQLException, ClassNotFoundException;

    public  void MysqlConn(Connection str)throws ClassNotFoundException , SQLException;

    public  void GoodsUp(Connection str)throws ClassNotFoundException , SQLException;

    public  void GoodsDown (Connection str)throws ClassNotFoundException , SQLException;

    public  void GoodsPrint (Connection str)throws ClassNotFoundException , SQLException;

}
