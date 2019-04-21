package edu.zut.cs.lbw.logistics.repository;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Auther: LBW
 * @Date: 2019/4/3
 * @Description: com.logistics.lbw.mian
 * @version: 1.0
 */
public interface DataBase
{
    public  void GoodsUp(String str , int number);

    public  void GoodsDown(String str , int number);

    public  void GoodsPrint();

}


//货物上货下货时返回值的规定未完成