package edu.zut.cs.software.osals.goods.daomain;

import edu.zut.cs.software.base.domain.BaseEntity;
import edu.zut.cs.software.osals.warehouse.daomain.Warehouse;

import javax.persistence.*;

/**
 * @Auther: LBW
 * @Date: 2019/5/15
 * @Description: edu.zut.cs.software.OSALS.Goods.daomain
 * @version: 1.0
 */
@Entity
@Table(name = "T_GOODS")
public class Goods extends BaseEntity {


    private static final long serialVersionUID = -2393699715680994416L;

    @Column(name = "good_name")
    public String GoodNames;

    @Column(name = "number")
    public Integer Numbers;

    @ManyToOne
    @JoinColumn(name = "WAREHOUSE_NAME")
    Warehouse warehouse;

    public String getGoodNames() {
        return GoodNames;
    }
    public void setGoodNames(String goodNames) {
        GoodNames = goodNames;
    }

    public Integer getNumbers() {
        return Numbers;
    }
    public void setNumbers(Integer numbers) {
        Numbers = numbers;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
