package edu.zut.cs.software.osals.nlp.domain;

import edu.zut.cs.software.base.domain.BaseEntity;
import org.hibernate.annotations.Proxy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "T_NLP_ENTITYRELATION")
@Proxy(lazy = false)
public class NlpEntityRelation extends BaseEntity {
    @Column(name = "paragraph")
    String paragraph;
    @Column(name = "extractor_1")
    String extractor_1;
    @Column(name = "extractor_2")
    String extractor_2;
    @Column(name = "extractor_3")
    String extractor_3;
    @Column(name = "extractor_4")
    String extractor_4;

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public String getExtractor_1() {
        return extractor_1;
    }

    public void setExtractor_1(String extractor_1) {
        this.extractor_1 = extractor_1;
    }

    public String getExtractor_2() {
        return extractor_2;
    }

    public void setExtractor_2(String extractor_2) {
        this.extractor_2 = extractor_2;
    }

    public String getExtractor_3() {
        return extractor_3;
    }

    public void setExtractor_3(String extractor_3) {
        this.extractor_3 = extractor_3;
    }

    public String getExtractor_4() {
        return extractor_4;
    }

    public void setExtractor_4(String extractor_4) {
        this.extractor_4 = extractor_4;
    }
}
