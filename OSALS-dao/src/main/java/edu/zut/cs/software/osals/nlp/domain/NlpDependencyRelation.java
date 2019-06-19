package edu.zut.cs.software.osals.nlp.domain;

import edu.zut.cs.software.base.domain.BaseEntity;
import org.hibernate.annotations.Proxy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Author: hyh
 * @Description: 依赖关系 NlpDependencyRelation Entity
 * @Date:Created in 11:08 2019/6/13
 * @Modified By:
 */
@Entity
@Table(name = "T_NLP_DEPENDENCYRELATION")
@Proxy(lazy = false)
public class NlpDependencyRelation extends BaseEntity {

    @Column(name = "TEXT")
    String text;

    /**
     *@Description: 标注指代
     *@Date: 9:59 2019/6/14
     */
    @Column(name="ANNOTATED")
    String Annotated;

    /**
     *@Description: 依赖关系
     *@Date: 9:59 2019/6/14
     */
    @Column(name="RELATION")
    String relation;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAnnotated() {
        return Annotated;
    }

    public void setAnnotated(String annotated) {
        Annotated = annotated;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
}
