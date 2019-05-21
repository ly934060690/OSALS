package edu.zut.cs.software.domian;

import javax.persistence.*;

/**
 * @Auther: LBW
 * @Date: 2019/5/6
 * @Description: edu.zut.cs.software.dao
 * @version: 1.0
 */
@Entity
@Table(name = "goodkinds", schema = "goods")
public class GoodkindsEntity {
    private String kindName;

    @Id
    @Column(name = "kind_name")
    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodkindsEntity that = (GoodkindsEntity) o;

        if (kindName != null ? !kindName.equals(that.kindName) : that.kindName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return kindName != null ? kindName.hashCode() : 0;
    }
}
