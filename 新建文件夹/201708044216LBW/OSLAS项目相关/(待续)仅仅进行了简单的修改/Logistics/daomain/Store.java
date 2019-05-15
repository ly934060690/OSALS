package edu.zut.cs.software.daomain;


import edu.zut.cs.software.base.BaseEntity;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Auther: LBW
 * @Date: 2019/4/28
 * @Description: edu.zut.cs.software.dao
 * @version: 1.0
 */
@Entity
@Component
@Table(name = "store")
public class Store extends BaseEntity implements Serializable
{
     private static final long serialVersionUID = 1L;

     private GoodKind good_kinds;

     @ManyToOne
     public GoodKind getGood_kinds() {
          return good_kinds;
     }

     public void setGood_kinds(GoodKind good_kinds) {
          this.good_kinds = good_kinds;
     }
}
