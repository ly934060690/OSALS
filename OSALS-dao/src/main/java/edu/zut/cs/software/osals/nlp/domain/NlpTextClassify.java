package edu.zut.cs.software.osals.nlp.domain;

import edu.zut.cs.software.base.domain.BaseEntity;
import org.hibernate.annotations.Proxy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "T_NLP_TEXTCLASSIFY")
@Proxy(lazy = false)
public class NlpTextClassify extends BaseEntity {
    @Column(name = "TEXT")
    String text;
    public String getText() {
            return text;
        }
        public void setText(String text) {
            this.text = text;
        }
}

