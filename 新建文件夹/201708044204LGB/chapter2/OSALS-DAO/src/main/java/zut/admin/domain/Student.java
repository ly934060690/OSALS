package zut.admin.domain;


import javax.persistence.*;

@Entity
@Table(name="Student")

public class Student {

    private static final long serialVersionUID=1L;

    @Column(name = "Number")
    Integer Number;
    @Column(name="Dept")
    String Dept;
    @Column(name="Profession")
    String Profession;
    @Column(name="classes")
    String classes;

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    Long Id;
    @Column(name="Name")
    String name;
    @Column(name="Sex")
    String Sex;

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public String getDept() {
        return Dept;
    }

    public void setDept(String dept) {
        Dept = dept;
    }

    public String getProfession() {
        return Profession;
    }

    public void setProfession(String profession) {
        Profession = profession;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }
}
