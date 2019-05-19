package edu.zut.cs.software.OSALS.temporaryStation.domain;

import edu.zut.cs.software.OSALS.postStation.domain.PostStation;
import edu.zut.cs.software.base.domain.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "T_TEMPORARY_STATION")
public class TemporaryStation extends BaseEntity {
    private static final long serialVersionUID = 3301340415367292193L;

    @Column(name = "NAME")
    String name;

    @Column(name = "ADRESS")
    String address;

    @Column(name = "NUMBER")
    String number;

    @ManyToOne
    @JoinColumn(name = "POSTSTATION_ID")
    PostStation postStation;

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

    public PostStation getPostStation() {
        return postStation;
    }

    public void setPostStation(PostStation postStation) {
        this.postStation = postStation;
    }
}
