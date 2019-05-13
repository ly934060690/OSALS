package zut.admin.domain;

import zut.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Student")

public class Student extends BaseEntity {

    private static final long serialVersionUID=1L;

    @Column(name = "Number")
    int Number;
    @Column(name="Dept")
    String Dept;
    @Column(name="Profession")
    String Profession;
    @Column(name="classes")
    String classes;
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

    @Override
    public Long getId() {
        return Id;
    }

    @Override
    public void setId(Long id) {
        Id = id;
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
