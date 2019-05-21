package edu.zut.cs.OSALS.admin.domain;

import javax.persistence.*;
import java.util.Set;

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

    @OneToOne()
    Set<User> users;
}
