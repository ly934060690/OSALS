package edu.zut.cs.software.osals.poststation.service;


import edu.zut.cs.software.base.service.GenericGenerator;
import edu.zut.cs.software.osals.poststation.domain.PostStation;
import edu.zut.cs.software.osals.poststation.domain.TemporaryStation;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PostStationEntityGenerator extends GenericGenerator {

    @Autowired
    PostStationManager postStationManager;
    @Autowired
    TemporaryStationManager temporaryStationManager;

    /**
     * 实体生成器：生成实体，其中具体为PostStation和TemporaryStation及二者对应关系
     */

    @Test
    public void gen_Poststation(){
        PostStation postStation = new PostStation();
        postStation.setEntityName("河南总站");
        postStation.setAddress("郑州");
        postStation.setIdnumber("01");
        this.postStationManager.save(postStation);
        for(int i=1;i<=3;i++){
            PostStation p = new PostStation();
            p.setEntityName("市区"+i);
            p.setAddress("市区地址"+i);
            p.setIdnumber("010"+i);
            p.setParent(postStation);
            this.postStationManager.save(p);
            gen_TempraryStation(p);
        }
    }

    public void gen_TempraryStation(PostStation postStation){
        TemporaryStation temporaryStation;
        for(int i=1;i<=3;i++){
            temporaryStation = new TemporaryStation();
            temporaryStation.setPostStation(postStation);   //不能实现直接获得PostStation下的TemporaryStations
            temporaryStation.setEntityName(postStation.getEntityName()+"下属"+i+"站");
            temporaryStation.setAddress(postStation.getAddress()+"分部"+i);
            temporaryStation.setIdnumber(postStation.getIdnumber()+"0"+i);
            this.temporaryStationManager.save(temporaryStation);
        }
    }

}
