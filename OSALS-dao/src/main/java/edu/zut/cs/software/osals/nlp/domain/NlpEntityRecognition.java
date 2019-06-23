package edu.zut.cs.software.osals.nlp.domain;


import edu.zut.cs.software.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_NLP_ENTITYRECOGNITION")
public class NlpEntityRecognition extends BaseEntity {

    private static final long serialVersionUID = 1771195005352106822L;
    @Column(name = "Sentence")
    String Sentence;
    //Sentence:要进行实体识别的句子
    @Column(name="Stanford")
    String Stanford;
    //运用Stanford进行实体识别
    @Column(name="HanLP")
    String HanLP;


    public String getSentence() {
        return Sentence;
    }

    public void setSentence(String sentence) {
        Sentence = sentence;
    }

    public String getStanford() {
        return Stanford;
    }

    public void setStanford(String stanford) {
        Stanford = stanford;
    }

    public String getHanLP() {
        return HanLP;
    }

    public void setHanLP(String hanLP) {
        HanLP = hanLP;
    }
}
