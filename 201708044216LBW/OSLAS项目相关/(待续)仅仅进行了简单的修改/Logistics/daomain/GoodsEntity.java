package edu.zut.cs.software.daomain;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Auther: LBW
 * @Date: 2019/5/14
 * @Description: edu.zut.cs.software.daomain
 * @version: 1.0
 */
@Entity
@Table(name = "goods", schema = "goods")
public class GoodsEntity {
    private String goodId;
    private String goodName;
    private Integer number;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "good_id")
    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    @Basic
    @Column(name = "good_name")
    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    @Basic
    @Column(name = "number")
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsEntity that = (GoodsEntity) o;
        return Objects.equals(goodId, that.goodId) &&
                Objects.equals(goodName, that.goodName) &&
                Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodId, goodName, number);
    }
}
