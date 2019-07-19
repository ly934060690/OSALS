package edu.zut.cs.software.osals.nlp.domain;

import edu.zut.cs.software.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_NLP_NLPABSTRACTEXTRACTION")
public class NlpAbstractExtraction extends BaseEntity {

    private static final long serialVersionUID = -3324144747265117283L;

    @Column(name = "TEXT")
    String text;

    @Column(name = "TEXT1")
    String text1;

    @Column(name = "TEXT2")
    String text2;

    @Column(name = "TEXT3")
    String text3;

    @Column(name = "TEXT4")
    String text4;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getText4() {
        return text4;
    }

    public void setText4(String text4) {
        this.text4 = text4;
    }
}
