package edu.zut.cs.software.dao;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @Auther: LBW
 * @Date: 2019/4/28
 * @Description: src.main.java.edu.zut.cs.software.dao
 * @version: 1.0
 */
@Entity
@Component
@Table(name = "goods")
public class Good implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String GoodId;
    private String GoodNames;
    private Integer Numbers;

    @Id
    @GeneratedValue
    @Column(name = "good_id" , unique = true , length = 20)
    public String getGoodId() {
        return GoodId;
    }
    public void setGoodId(String goodId) {
        GoodId = goodId;
    }

    @Column(name = "good_name" , unique = true , length = 20)
    public String getGoodNames() {
        return GoodNames;
    }
    public void setGoodNames(String goodNames) {
        GoodNames = goodNames;
    }

    @Column(name = "number" , unique = true , length = 10)
    public Integer getNumbers() {
        return Numbers;
    }
    public void setNumbers(Integer numbers) {
        Numbers = numbers;
    }
}
