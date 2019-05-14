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
@Table(name = "goodkinds", schema = "goods")
public class GoodkindsEntity {
    private String kindName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
        return Objects.equals(kindName, that.kindName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kindName);
    }
}
