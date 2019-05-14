package zut.admin.domain;


import javax.persistence.*;
import java.util.Set;

@Table(name="Courier")
@Entity

public class Courier <Courier> {

    private static final long serialVersionUID = -1751952224371998469L;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="ID")
    String ID;
    @OneToMany(mappedBy = "group",cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)

    Set<Parcel> Parcles;
    @Column(name="Name")
    String Name;
    @Column(name="Sex")
    String Sex;
    @Column(name="PhoneNumber")
    String PhoneNumber;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

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
}
