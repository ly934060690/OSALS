package edu.zut.cs.OSALS.admin.domain;

import edu.zut.cs.OSALS.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Table(name = "Student")
@Entity
public class Student extends BaseEntity {
    private static final long serialVersionUID = 283067102456049073L;

    @Column(name = "Sdept")
    String Sdept;

    @Column(name = "Major")
    String Major;

    @Column(name = "Class_num")
    String Class_num;

    @Column(name = "Student_num")
    String Student_num;

    @Column(name = "Name")
    String Name;

    @Column(name = "Ssex")
    String Ssex;

    public String getSdept() {
        return Sdept;
    }

    public void setSdept(String sdept) {
        Sdept = sdept;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public String getClass_num() {
        return Class_num;
    }

    public void setClass_num(String class_num) {
        Class_num = class_num;
    }

    public String getStudent_num() {
        return Student_num;
    }

    public void setStudent_num(String student_num) {
        Student_num = student_num;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSsex() {
        return Ssex;
    }

    public void setSsex(String ssex) {
        Ssex = ssex;
    }
}
