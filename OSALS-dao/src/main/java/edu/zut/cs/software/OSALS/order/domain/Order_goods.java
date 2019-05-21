package edu.zut.cs.software.OSALS.order.domain;


import edu.zut.cs.software.OSALS.order.domain.Order;
import edu.zut.cs.software.base.domain.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "T_ORDER_GOODS")
public class Order_goods extends BaseEntity {


    private static final long serialVersionUID = 1141495265359441678L;


    @Column(name = "NAME")
    String name;

    @Column(name = "PRICE")
    float price;

    @Column(name = "NUMBER")
    int number;
    @ManyToOne
    @JoinColumn(name = "ORDER_ID")

    Order order;

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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
