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
    @Column(name = "Per")
    String Per;
    //Per:人名
    @Column(name = "Aper")
    String Aper;
    //Aper:人名简称
    @Column(name="Loc")
    String Loc;
    //Loc:地名
    @Column(name = "Aloc")
    String Aloc;
    //Aloc:地名简称
    @Column(name="Org")
    String Org;
    //Org:机构名
    @Column(name="Tim")
    String Tim;
    //Tim:时间词
    @Column(name="Num")
    String Num;
    //Num:数量词


    public String getSentence() {
        return Sentence;
    }

    public void setSentence(String sentence) {
        Sentence = sentence;
    }

    public String getPer() {
        return Per;
    }

    public void setPer(String per) {
        Per = per;
    }

    public String getAper() {
        return Aper;
    }

    public void setAper(String aper) {
        Aper = aper;
    }

    public String getLoc() {
        return Loc;
    }

    public void setLoc(String loc) {
        Loc = loc;
    }

    public String getAloc() {
        return Aloc;
    }

    public void setAloc(String aloc) {
        Aloc = aloc;
    }

    public String getOrg() {
        return Org;
    }

    public void setOrg(String org) {
        Org = org;
    }

    public String getTim() {
        return Tim;
    }

    public void setTim(String tim) {
        Tim = tim;
    }

    public String getNum() {
        return Num;
    }

    public void setNum(String num) {
        Num = num;
    }
}
