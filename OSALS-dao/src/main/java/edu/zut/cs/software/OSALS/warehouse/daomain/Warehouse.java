package edu.zut.cs.software.OSALS.warehouse.daomain;

import edu.zut.cs.software.OSALS.Goods.daomain.Goods;
import edu.zut.cs.software.base.domain.BaseTreeEntity;

import javax.persistence.*;
import java.util.Set;

/**
 * @Auther: LBW
 * @Date: 2019/5/16
 * @Description: edu.zut.cs.software.OSALS.warehouse.daomain
 * @version: 1.0
 */
@Entity
@Table(name = "T_WAREHOUSE")
//这里的Warehouse.getRoot与下面的WareDaoTest有关
@NamedQueries({ @NamedQuery(name = "Warehouse.getRoot", query = "select w from Warehouse w where w.parent is null") })
public class Warehouse extends BaseTreeEntity<Warehouse> {

    private static final long serialVersionUID = 1017387340500414123L;

    @Column(name = "NAME")
    String housename;

    /**
     * 这里的mappedBy = "warehouse"有要求名字的命名方式吗
     */
    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    Set<Goods> goods;

    public String getHousename() {
        return housename;
    }

    public void setHousename(String housename) {
        this.housename = housename;
    }
}
