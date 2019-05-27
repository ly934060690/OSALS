package edu.zut.cs.software.osals.expresscar.domain;

import edu.zut.cs.software.base.domain.BaseEntity;
import edu.zut.cs.software.osals.expresscar.domain.ExpressCar;

import javax.persistence.*;

/**
 * @Author: hyh
 * @Description: 包裹类 ManyToOne
 * @Date:Created in 18:50 2019/5/16
 * @Modified By:
 */
@Entity
@Table(name="T_ENWRAP")
public class Enwrap extends BaseEntity {

    private static final long serialVersionUID = 7443202658298788849L;

    @Column(name = "NAME")
    String name;

    @Column(name="TELEPHONE")
    String telephone;

    @Column(name="ADDRESS_END")
    String addressEnd;

    @Column(name="ADDRESS_ORIGIN")
    String addressOrigin;

    @ManyToOne
    @JoinColumn(name="EXPRESSCAR_ID")
    ExpressCar expressCar;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddressEnd() {
        return addressEnd;
    }

    public void setAddressEnd(String addressEnd) {
        this.addressEnd = addressEnd;
    }

    public String getAddressOrigin() {
        return addressOrigin;
    }

    public void setAddressOrigin(String addressOrigin) {
        this.addressOrigin = addressOrigin;
    }

    public ExpressCar getExpressCar() {
        return expressCar;
    }

    public void setExpressCar(ExpressCar expressCar) {
        this.expressCar = expressCar;
    }
}
