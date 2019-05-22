package edu.zut.cs.software.OSALS.warehouse.service;

import edu.zut.cs.software.OSALS.goods.daomain.Goods;
import edu.zut.cs.software.OSALS.goods.service.GoodsManager;
import edu.zut.cs.software.base.service.GenericManagerTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Auther: LBW
 * @Date: 2019/5/17
 * @Description: edu.zut.cs.software.OSALS.warehouse.service
 * @version: 1.0
 */
public class GoodsManagerTestCase  extends GenericManagerTestCase<Long, Goods, GoodsManager>
{
    GoodsManager goodsManager;

    public GoodsManagerTestCase() {
        super(Goods.class);
    }

    @Autowired
    public void setGoodsManager(GoodsManager goodsManager) {
        this.goodsManager = goodsManager;
        this.manager = this.goodsManager;
    }

    @Test
    public void testSave(){
        Goods goods = new Goods();
        this.goodsManager.save(goods);
    }

    /*
    @Test
    public void testFind()
    {
      System.out.println(goodsManager.findByGoodNames("good_9"));
    }
    */

}
