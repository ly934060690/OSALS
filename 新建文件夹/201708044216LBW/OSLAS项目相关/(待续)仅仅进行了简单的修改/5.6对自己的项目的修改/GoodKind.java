package edu.zut.cs.software.dao;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @Auther: LBW
 * @Date: 2019/4/28
 * @Description: edu.zut.cs.software.dao
 * @version: 1.0
 */
@Entity
@Component
@Table(name = "goodkinds")
public class GoodKind implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String KindNames;
    private Good goods;

    @Id
    @GeneratedValue
    @Column(name = "kind_name" , unique = true , length = 20)
    public String getKindNames() {
        return KindNames;
    }

    public void setKindNames(String kindNames)
    {
        KindNames = kindNames;
    }

    @ManyToOne
    public Good getGoods() {
        return goods;
    }

    public void setGoods(Good goods) {
        this.goods = goods;
    }
}
