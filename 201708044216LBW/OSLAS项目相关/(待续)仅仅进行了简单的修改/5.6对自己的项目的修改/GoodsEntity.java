package edu.zut.cs.software.dao;

import javax.persistence.*;

/**
 * @Auther: LBW
 * @Date: 2019/5/6
 * @Description: edu.zut.cs.software.dao
 * @version: 1.0
 */
@Entity
@Table(name = "goods", schema = "goods", catalog = "")
public class GoodsEntity {
    private String goodId;
    private String goodName;
    private Integer number;

    @Id
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

        if (goodId != null ? !goodId.equals(that.goodId) : that.goodId != null) return false;
        if (goodName != null ? !goodName.equals(that.goodName) : that.goodName != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = goodId != null ? goodId.hashCode() : 0;
        result = 31 * result + (goodName != null ? goodName.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }
}
