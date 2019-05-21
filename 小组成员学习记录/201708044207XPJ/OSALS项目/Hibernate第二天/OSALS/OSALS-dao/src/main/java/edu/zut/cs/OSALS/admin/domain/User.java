package edu.zut.cs.OSALS.admin.domain;

import javax.persistence.*;

@Table(name = "GOODS-User")
@Entity
public class User {

    @Column(name = "NAME")
    String name;

    @Column(name = "NUMBER")
    String number;

    @Column(name = "KIND")
    String kind;

    @Column(name = "PRICE")
    float price;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

//    @OneToOne()
//    Set<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
