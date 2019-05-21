package edu.zut.cs.OSALS.admin.domain;

import edu.zut.cs.OSALS.base.domain.BaseTreeEntity;

import javax.persistence.*;


@Table(name = "Shop")
@Entity
@NamedQueries({ @NamedQuery(name = "Group.getRoot", query = "select g from Shop g where g.parent is null") })
public class Shop extends BaseTreeEntity<Shop> {

    private static final long serialVersionUID = 283067102456049073L;

    @Column(name = "Name")
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
