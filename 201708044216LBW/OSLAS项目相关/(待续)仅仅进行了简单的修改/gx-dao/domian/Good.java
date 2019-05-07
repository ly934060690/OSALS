package edu.zut.cs.software.domian;

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
@NamedQueries({@NamedQuery(name = "FindGoodById" , query = "select good_name from goods where good_id = ?")})
public class Good implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String GoodId;
    private String GoodNames;
    private Integer Numbers;

    public Good(){}

    public Good(String goodId, String goodNames, Integer numbers) {
        GoodId = goodId;
        GoodNames = goodNames;
        Numbers = numbers;
    }

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

    @Override
    public String toString() {
        return "Good{" +
                "GoodId='" + GoodId + '\'' +
                ", GoodNames='" + GoodNames + '\'' +
                ", Numbers=" + Numbers +
                '}';
    }
}
