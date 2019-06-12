package edu.zut.cs.software.osals.courier.domain;

import edu.zut.cs.software.base.domain.BaseEntity;

import javax.persistence.*;

@Table(name ="T_COURIER")
@Entity

public class Courier extends BaseEntity {

    private static final long serialVersionUID = -1751952224371998469L;


    @Column(name="NAME")
    String Name;
    @Column(name="SEX")
    String Sex;
    @Column(name="PHONENUMBER")
    String PhoneNumber;

    @ManyToOne
    @JoinColumn(name = "COURIERCOMPANY_ID")
    CourierCompany courierCompany;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public CourierCompany getCourierCompany() {
        return courierCompany;
    }

    public void setCourierCompany(CourierCompany courierCompany) {
        this.courierCompany = courierCompany;
    }
}
