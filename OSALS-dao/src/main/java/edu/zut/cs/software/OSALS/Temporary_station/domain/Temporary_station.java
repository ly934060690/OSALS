package edu.zut.cs.software.OSALS.Temporary_station.domain;

import edu.zut.cs.software.OSALS.Post_station.domain.Post_station;
import edu.zut.cs.software.base.domain.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "T_TEMPORARY_STATION")
public class Temporary_station extends BaseEntity {
    private static final long serialVersionUID = 3301340415367292193L;

    @Column(name = "NAME")
    String name;

    @Column(name = "ADRESS")
    String address;

    @Column(name = "NUMBER")
    String number;

    @ManyToOne
    @JoinColumn(name = "POST_STATION_ID")
    Post_station post_station;

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

    public Post_station getPost_station() {
        return post_station;
    }

    public void setPost_station(Post_station post_station) {
        this.post_station = post_station;
    }
}
