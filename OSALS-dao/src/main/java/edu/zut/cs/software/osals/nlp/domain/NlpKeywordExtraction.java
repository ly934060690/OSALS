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

    @Column(name = "content")
    String  content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
