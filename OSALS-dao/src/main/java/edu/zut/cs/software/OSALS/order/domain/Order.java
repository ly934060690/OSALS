package edu.zut.cs.software.OSALS.order.domain;

import edu.zut.cs.software.OSALS.order_good.domain.order_good;
import edu.zut.cs.software.base.domain.BaseTreeEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "T_ORDER")
public class Order extends BaseTreeEntity<Order> {


    private static final long serialVersionUID = -1879756456515933021L;
    @Column(name = "NAME")
    String name;

    @Column(name = "PRICE")
    float price;

    @OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    Set<order_good> order_goods;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
