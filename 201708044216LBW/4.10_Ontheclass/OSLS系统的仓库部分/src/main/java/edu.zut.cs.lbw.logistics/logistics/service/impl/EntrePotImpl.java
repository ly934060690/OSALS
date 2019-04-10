package edu.zut.cs.lbw.logistics.logistics.service.impl;

import com.logistics.lbw.logistics.repository.ReadMessage;
import com.logistics.lbw.logistics.repository.DataBase;
import com.logistics.lbw.logistics.service.EntrePot;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: LBW
 * @Date: 2019/4/3
 * @Description: com.logistics.lbw.mian
 * @version: 1.0
 */
@Service
@Component
public class EntrePotImpl implements EntrePot
{
    private List<String> stuff;
    private List<String> Goods;
    private List<String> Kinds;    //这里设置货物的种类为

    DataBase db;
    ReadMessage rm;

    public List<String> getStuff() {
        return stuff;
    }

    public void setStuff(List<String> stuff) {
        this.stuff = stuff;
    }

    public List<String> getGoods() {
        return Goods;
    }

    public void setGoods(List<String> goods) {
        Goods = goods;
    }

    @Override
    public String toString() {
        return "EntrePotImpl{" +
                "stuff=" + stuff +
                ", Goods=" + Goods +
                ", Kinds=" + Kinds +
                ", db=" + db +
                ", rm=" + rm +
                '}';
    }


    public List<String> getKinds() {
        return Kinds;
    }

    public void setKinds(List<String> kinds) {
        Kinds = kinds;
    }

    @Override
    public void Print()
    {
          System.out.println("显示本仓库有多少商品！");  //这里要连接数据库
    }

    //////////////////////////////////////////////////////////

    @Override
    public String UpGoods()throws ClassNotFoundException , SQLException
    {
        db.GoodsUp(db.GetConn());
        return null;
    }

    @Override
    public String PutGoods()throws ClassNotFoundException , SQLException
    {
        db.GoodsDown(db.GetConn());
        return null;
    }

    @Override
    public void Check()
    {
          rm.Read();      //这里返回的只要和数据库里的值进行比较

    }

}
