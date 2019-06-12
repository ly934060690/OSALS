package edu.zut.cs.software.osals.nlp.domain;

import edu.zut.cs.software.base.domain.BaseEntity;
import org.hibernate.annotations.Proxy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @ClassName HanLP
 * @Description TODO
 * @Author 研哥哥
 * @Date 2019/6/11 9:52
 * @Version 1.0
 */
@Entity
@Table(name = "T_NLP_WORDTAGGING")
@Proxy(lazy = false)
public class NlpWordTagging extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = -3324144747265117283L;

    @Column(name = "TEXT")
    String text;
    @Column(name = "WORD_1")
    String word_1;
    @Column(name = "WORD_2")
    String word_2;
    @Column(name = "WORD_3")
    String word_3;
    @Column(name = "WORD_4")
    String word_4;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getWord_1() {
        return word_1;
    }

    public void setWord_1(String word_1) {
        this.word_1 = word_1;
    }

    public String getWord_2() {
        return word_2;
    }

    public void setWord_2(String word_2) {
        this.word_2 = word_2;
    }

    public String getWord_3() {
        return word_3;
    }

    public void setWord_3(String word_3) {
        this.word_3 = word_3;
    }

    public String getWord_4() {
        return word_4;
    }

    public void setWord_4(String word_4) {
        this.word_4 = word_4;
    }
}
