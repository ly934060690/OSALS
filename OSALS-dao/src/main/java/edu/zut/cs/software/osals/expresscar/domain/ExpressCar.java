package edu.zut.cs.software.osals.expresscar.domain;

import edu.zut.cs.software.base.domain.BaseTreeEntity;
import edu.zut.cs.software.osals.enwrap.domain.Enwrap;

import javax.persistence.*;
import java.util.Set;

/**
 * @Author: hyh
 * @Description: 快递车类 OneToMany
 * @Date:Created in 18:34 2019/5/16
 * @Modified By:
 */
@Entity
@Table(name="T_EXPRESSCAR")
@NamedQueries({@NamedQuery(name="ExpressCar.getRoot",query ="select e from ExpressCar e where e.parent is null" )})
public class ExpressCar extends BaseTreeEntity<ExpressCar> {

    private static final long serialVersionUID = -1188355074838765858L;

    @Column(name="NAME")
    String name;

    @OneToMany(mappedBy = "expressCar", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    Set<Enwrap> enwraps;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
