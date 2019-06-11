package edu.zut.cs.software.osals.hanlp.domain;

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
@Table(name = "T_HANLP")
@Proxy(lazy = false)
public class Hanlp extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = -3324144747265117283L;

    @Column(name = "TEXT")
    String text;
    @Column(name = "WORD")
    String word;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
