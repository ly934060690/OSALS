package edu.zut.cs.software.osals.poststation.service;


import edu.zut.cs.software.base.service.GenericTreeManagerTestCase;
import edu.zut.cs.software.osals.poststation.domain.PostStation;
import edu.zut.cs.software.osals.shop.service.ShopManagerTestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PostStationManagerTest extends GenericTreeManagerTestCase<Long, PostStation, PostStationManager>  {
    /**
     * Logger for this class
     * 考虑以下几个问题
     *      1.logger的作用
     *      2.postStationManager为什么不需要注入，而是用set方法
     *      3.PostStationManagerTest()方法的作用
     */
    private static final Logger logger = LogManager.getLogger(ShopManagerTestCase.class.getName());

    PostStationManager postStationManager;

    public PostStationManagerTest(){
        super(PostStation.class);
    }

    @Autowired
    public void setShopManager(PostStationManager postStationManager) {
        this.postStationManager = postStationManager;
        this.manager = this.postStationManager;
    }

    /**
     * 以下方法测试：
     *      1.增添驿站
     *      2.查找驿站
     *      3.查找驿站中的驿站分部
     *      4.修改驿站的信息
     *      5.删除驿站及其驿站分部
     */

    @Test
    public void findByIdnumber(){
        PostStation postStation = this.postStationManager.findByIdnumber("0102");
        if (logger.isInfoEnabled()) {
            logger.info("findByIdnumber() - PostStation poststation={}"); //输出的结果较多
        }
    }

/*
    @Test
    //@Rollback(false)
    public void deleteByIdnumber(){
        PostStation postStation = this.postStationManager.findByIdnumber("0103");
        this.postStationManager.delete(postStation.getId());
        System.out.println(postStation.getId());
    }
*/

}
