package edu.zut.cs.software.dao;

import edu.zut.cs.software.domian.Good;

import java.util.List;

/**
 * @Auther: LBW
 * @Date: 2019/5/7
 * @Description: edu.zut.cs.software.dao.domian
 * @version: 1.0
 */
public interface GoodsManager
{

    public void Add(String GoodId , String GoodNames , Integer Numbers);
    public void Delete(String GoodId );
    public void update(String GoodId , String GoodNames , Integer Numbers);
    public List<Good> query(String GoodId);
}
