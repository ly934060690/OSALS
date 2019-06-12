package edu.zut.cs.software.osals.poststation.domain;

import edu.zut.cs.software.base.domain.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "T_TEMPORARY_STATION")
public class TemporaryStation extends BaseEntity {
    private static final long serialVersionUID = 3301340415367292193L;

    @Column(name = "ADRESS")
    String address;

    @Column(name = "IDNUMBER")
    String idnumber;

    @ManyToOne
    @JoinColumn(name = "POSTSTATION_ID")
    PostStation postStation;

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PostStation getPostStation() {
        return postStation;
    }

    public void setPostStation(PostStation postStation) {
        this.postStation = postStation;
    }
}
