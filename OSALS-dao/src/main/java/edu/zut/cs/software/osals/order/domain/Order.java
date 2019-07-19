package edu.zut.cs.software.osals.order.domain;

import edu.zut.cs.software.base.domain.BaseTreeEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "T_ORDER")
@NamedQueries({ @NamedQuery(name = "Order.getRoot", query = "select s from Order s where s.parent is null") })
public class Order extends BaseTreeEntity<Order> {


    private static final long serialVersionUID = -1879756456515933021L;
    @Column(name = "NAME")
    String name;

    @Column(name = "PRICE")
    float price;

    @Column(name="ORDER_NUM")
    float order_num;
    @Column(name="PAYMENT_METHOD")
    String payment_method;

    @Column(name="CREATE_TIME")
    String create_time;
    @Column(name="PAYMENT_TIME")
    String payment_time;
    @Column(name="DELIVER_TIME")
    String deliver_time;
    @Column(name = "SUCCESS_TIME")
    String success_time;
    @Column(name="STATE")
    String state;
    @OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    Set<OrderGoods> order_goods;

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

    public float getOrder_num() {
        return order_num;
    }

    public void setOrder_num(float order_num) {
        this.order_num = order_num;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getPayment_time() {
        return payment_time;
    }

    public void setPayment_time(String payment_time) {
        this.payment_time = payment_time;
    }

    public String getDeliver_time() {
        return deliver_time;
    }

    public void setDeliver_time(String deliver_time) {
        this.deliver_time = deliver_time;
    }

    public String getSuccess_time() {
        return success_time;
    }

    public void setSuccess_time(String success_time) {
        this.success_time = success_time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
