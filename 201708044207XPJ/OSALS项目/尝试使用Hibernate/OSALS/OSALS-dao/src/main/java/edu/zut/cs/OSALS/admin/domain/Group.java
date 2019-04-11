package edu.zut.cs.OSALS.admin.domain;


import javax.persistence.*;

@Table(name = "GOODS-Group")
@Entity
public class Group {
    @Column(name = "NAME")
    String name;

    @Column(name = "NUMBER")
    String number;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

//    @OneToMany(mappedBy = "group", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
//    Set<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
