package edu.zut.cs.software.osals.nlp.domain;

import com.hankcs.hanlp.HanLP;
import edu.zut.cs.software.base.domain.BaseEntity;
import org.hibernate.annotations.Proxy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * @Auther: LBW
 * @Date: 2019/6/16
 * @Description: edu.zut.cs.software.osals.nlp.domain
 * @version: 1.0
 */
@Entity
@Table(name = "T_NLP_KEYWORDEXTRACTION")
@Proxy(lazy = false)
public class NlpKeywordExtraction extends BaseEntity {

    private static final long serialVersionUID = -2748027099895603067L;

    @Column(name = "text")
    String  text;

    @Column(name = "text_1")
    String word_1;

    @Column(name = "text_2")
    String word_2;

    @Column(name = "text_3")
    String word_3;

    @Column(name = "text_4")
    String word_4;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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
