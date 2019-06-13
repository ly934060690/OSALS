package edu.zut.cs.software.osals.nlp.domain;

import edu.zut.cs.software.base.domain.BaseEntity;
import org.hibernate.annotations.Proxy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Author: hyh
 * @Description:
 * @Date:Created in 11:08 2019/6/13
 * @Modified By:
 */
@Entity
@Table(name = "T_NLP_DEPENDENCYRELATION")
@Proxy(lazy = false)
public class NlpDependencyRelation extends BaseEntity {

    @Column(name = "TEXT")
    String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
