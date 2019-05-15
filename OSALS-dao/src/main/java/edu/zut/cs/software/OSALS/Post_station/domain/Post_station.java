package edu.zut.cs.software.OSALS.Post_station.domain;

import edu.zut.cs.software.OSALS.Temporary_station.domain.Temporary_station;
import edu.zut.cs.software.base.domain.BaseTreeEntity;

import javax.persistence.*;
import java.util.Set;

/*
*驿站
* 驿站->暂存处    1->n
 */
@Entity
@Table(name = "T_POST_STATION")
@NamedQueries({ @NamedQuery(name = "Post_station.getRoot", query = "select s from Post_station s where s.parent is null") })    //有待理解
public class Post_station extends BaseTreeEntity<Post_station> {

    private static final long serialVersionUID = 1048201139754335120L;
    /**
     *
     */
    @Column(name = "NAME")
    String name;

    @Column(name = "ADRESS")
    String address;

    @Column(name = "NUMBER")
    String number;

    @OneToMany(mappedBy = "post_station", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    Set<Temporary_station> temporary_stations;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
