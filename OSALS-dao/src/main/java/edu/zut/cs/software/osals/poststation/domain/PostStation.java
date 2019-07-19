package edu.zut.cs.software.osals.poststation.domain;

import edu.zut.cs.software.base.domain.BaseTreeEntity;

import javax.persistence.*;
import java.util.Set;

/*
*驿站
* 驿站->暂存处    1->n
 */
@Entity
@Table(name = "T_POST_STATION")
@NamedQueries({ @NamedQuery(name = "PostStation.getRoot", query = "select s from PostStation s where s.parent is null") })    //有待理解
public class PostStation extends BaseTreeEntity<PostStation> {

    private static final long serialVersionUID = 1048201139754335120L;

    @Column(name = "ADRESS")
    String address;

    @Column(name = "IDNUMBER")
    String idnumber;

    @OneToMany(mappedBy = "postStation", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    Set<TemporaryStation> temporaryStations;

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

}
