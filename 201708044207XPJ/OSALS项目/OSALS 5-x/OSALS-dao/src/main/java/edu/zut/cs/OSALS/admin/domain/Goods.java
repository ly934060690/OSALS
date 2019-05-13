package edu.zut.cs.OSALS.admin.domain;

import edu.zut.cs.OSALS.base.domain.BaseEntity;

import javax.persistence.*;

@Table(name = "Goods")
@Entity
public class Goods extends BaseEntity {
    private static final long serialVersionUID = -8623515898467852986L;

    @Column(name = "NAME")
    String name;

    @ManyToOne
    @JoinColumn(name = "Shop_ID")
    Shop shop;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
