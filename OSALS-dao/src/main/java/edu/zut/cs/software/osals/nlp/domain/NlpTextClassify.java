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
    @Column(name = "CLASSIFY1")
    String classify1;

    @Column(name = "CLASSIFY2")
    String classify2;
    @Column(name = "CLASSIFY3")
    String classify3;
    @Column(name = "CLASSIFY4")
    String classify4;

    public String getClassify4() {
        return classify4;
    }

    public void setClassify4(String classify4) {
        this.classify4 = classify4;
    }

    public String getClassify3() {
        return classify3;
    }

    public void setClassify3(String classify3) {
        this.classify3 = classify3;
    }

    public String getClassify1() {
        return classify1;
    }

    public void setClassify1(String classify1) {
        this.classify1 = classify1;
    }

    public String getClassify2() {
        return classify2;
    }

    public void setClassify2(String classify2) {
        this.classify2 = classify2;
    }

    public String getText() {
            return text;
        }
        public void setText(String text) {
            this.text = text;
        }
}

