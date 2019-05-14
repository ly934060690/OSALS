package zut.admin.domain;


import javax.persistence.*;

@Table(name="Parcel")
@Entity
public class Parcel {
    private static final long serialVersionUID = -4376674977047164142L;

    @Column(name="Receiver")
    String Receiver;
    @ManyToOne
    @JoinColumn(name="Courier_ID")
    Courier courier;

    @Column(name="Number")
    String Number;
    @Column(name="PhoneNumber")
    String PhoneNumber;
    @Column(name ="Adress")
    String Adress;


    public String getReceiver() {
        return Receiver;
    }

    public void setReceiver(String receiver) {
        Receiver = receiver;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "Receiver='" + Receiver + '\'' +
                ", courier=" + courier +
                ", Number='" + Number + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", Adress='" + Adress + '\'' +
                '}';
    }
}
