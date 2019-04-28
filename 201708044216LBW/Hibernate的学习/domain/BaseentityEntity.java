package edu.zut.cs.software.sun.admin.domain;

import org.springframework.data.annotation.Id;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @Auther: LBW
 * @Date: 2019/4/28
 * @Description: edu.zut.cs.software.sun.admin.domain
 * @version: 1.0
 */
@Entity
@Table(name = "baseentity", schema = "sun", catalog = "")
public class BaseentityEntity {
    private Integer id;
    private String entityName;

    @Id
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ENTITY_NAME")
    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseentityEntity that = (BaseentityEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(entityName, that.entityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, entityName);
    }
}
