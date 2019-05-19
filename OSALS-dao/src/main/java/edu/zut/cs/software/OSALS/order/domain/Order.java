package edu.zut.cs.software.OSALS.order.domain;

import edu.zut.cs.software.OSALS.order_goods.domain.Order_goods;
import edu.zut.cs.software.base.domain.BaseTreeEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "T_ORDER")
//命名查询
@NamedQueries({ @NamedQuery(name = "Order.getRoot", query = "select s from Order s where s.parent is null") })
public class Order extends BaseTreeEntity<Order> {


    private static final long serialVersionUID = -1879756456515933021L;
    @Column(name = "NAME")
    String name;
    @Column(name = "ORDER_PRICE")
    float order_price;
    @Column(name = "ORDER_ID")
    String order_id;
    @Column(name = "GOODS")
    String goods;
    @Column(name = "CONSIGNEE_ADDRESS")
    String consignee_address;
    @Column(name = "ORDER_TIME")
    Date order_time;
    @Column(name = "CONSIGNEE_TEL")
    String consignee_tel;
    //在xml文件中映射
    @OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    Set<Order_goods> order_goods;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getOrder_price() {
        return order_price;
    }

    public void setOrder_price(float order_price) {
        this.order_price = order_price;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public String getConsignee_address() {
        return consignee_address;
    }

    public void setConsignee_address(String consignee_address) {
        this.consignee_address = consignee_address;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    public String getConsignee_tel() {
        return consignee_tel;
    }

    public void setConsignee_tel(String consignee_tel) {
        this.consignee_tel = consignee_tel;
    }

    public Set<Order_goods> getOrder_goods() {
        return order_goods;
    }

    public void setOrder_goods(Set<Order_goods> order_goods) {
        this.order_goods = order_goods;
    }
}
