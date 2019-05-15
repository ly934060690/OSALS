package edu.zut.cs.software.OSALS.Goods.daomain;

import edu.zut.cs.software.OSALS.shop.domain.Shop;
import edu.zut.cs.software.base.domain.BaseTreeEntity;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * @Auther: LBW
 * @Date: 2019/5/15
 * @Description: edu.zut.cs.software.OSALS.Goods.daomain
 * @version: 1.0
 */
@Entity
@Component
@Table(name = "T_GOODS")
public class Goods extends BaseTreeEntity<Goods> {
    private static final long serialVersionUID = 1L;

    public String GoodId;
    public String GoodNames;
    public Integer Numbers;

    public Goods(){}

    public Goods(String goodId, String goodNames, Integer numbers) {
        GoodId = goodId;
        GoodNames = goodNames;
        Numbers = numbers;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "good_id" , unique = true , length = 20)
    public String getGoodId() {
        return GoodId;
    }
    public void setGoodId(String goodId) {
        GoodId = goodId;
    }

    @Column(name = "good_name" , unique = true , length = 20)
    public String getGoodNames() {
        return GoodNames;
    }
    public void setGoodNames(String goodNames) {
        GoodNames = goodNames;
    }

    @Column(name = "number" , unique = true , length = 10)
    public Integer getNumbers() {
        return Numbers;
    }
    public void setNumbers(Integer numbers) {
        Numbers = numbers;
    }

    @Override
    public String toString() {
        return "Good{" +
                "GoodId='" + GoodId + '\'' +
                ", GoodNames='" + GoodNames + '\'' +
                ", Numbers=" + Numbers +
                '}';
    }
}
