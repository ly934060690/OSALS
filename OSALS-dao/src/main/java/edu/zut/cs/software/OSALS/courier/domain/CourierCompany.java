package edu.zut.cs.software.OSALS.courier.domain;

import edu.zut.cs.software.base.domain.BaseTreeEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="T_COURIERCOMPANY")
@NamedQueries({ @NamedQuery(name = "CourierCompany.getRoot", query = "select c from CourierCompany c where c.parent is null") })
public class CourierCompany extends BaseTreeEntity<CourierCompany> {


    private static final long serialVersionUID = -8748825454057840907L;


    @Column(name = "NAME")
    String Name;
    @Column(name="ADDRESS")
    String Address;

    @OneToMany(mappedBy = "courierCompany", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    Set<Courier> couriers;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
