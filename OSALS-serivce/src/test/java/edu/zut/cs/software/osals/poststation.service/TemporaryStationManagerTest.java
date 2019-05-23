package edu.zut.cs.software.osals.poststation.service;


import edu.zut.cs.software.base.service.GenericManagerTestCase;
import edu.zut.cs.software.osals.poststation.domain.PostStation;
import edu.zut.cs.software.osals.poststation.domain.TemporaryStation;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = {"classpath:/applicationContext-service.xml"})
public class TemporaryStationManagerTest extends GenericManagerTestCase<Long, TemporaryStation, TemporaryStationManager> {
    /**
     *      理解前三部分（类似PostStationManagerTest）
     */

    TemporaryStationManager temporaryStationManager;

    PostStationManager postStationManager;

    public TemporaryStationManagerTest() {
        super(TemporaryStation.class);
    }

    @Autowired
    public void setUserManager(TemporaryStationManager temporaryStationManager) {
        this.temporaryStationManager = temporaryStationManager;
        this.manager = this.temporaryStationManager;
    }
    @Autowired
    public void setUserManager(PostStationManager postStationManager){
        this.postStationManager = postStationManager;
    }


    /**
     * 测试方法
     *      1.在哪个驿站增添驿站分部
     *      2.删除驿站下的驿站分部
     *      3.修改驿站下驿站分部的信息
     *      4.查找驿站分部所属驿站及驿站分部的信息
     */
/*
    @Test
    @Rollback(false)
    public void addTemporaryStation(){
        PostStation postStation = this.postStationManager.findByIdnumber("0103");
        TemporaryStation temporaryStation = new TemporaryStation();
        temporaryStation.setEntityName(postStation.getEntityName()+"下属"+1+"站");
        temporaryStation.setAddress(postStation.getAddress()+"分部"+1);
        temporaryStation.setIdnumber(postStation.getIdnumber()+"0"+1);
        temporaryStation.setPostStation(postStation);
        this.temporaryStationManager.save(temporaryStation);
    }
*/
}
