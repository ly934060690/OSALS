package edu.zut.cs.lbw.hibernate.entities;

import javax.persistence.*;

/**
 * @Auther: LBW
 * @Date: 2019/4/27
 * @Description: edu.zut.cs.lbw.hibernate.entities
 * @version: 1.0
 */
@Entity
@Table(name = "h1", schema = "hibernate")  //" catalog = "H1" " 这里的catalog指的是数据库表明
public class H1Entity {
    private String name;
    private String id;
    private String address;
    private Integer number;

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "Number")
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        H1Entity h1Entity = (H1Entity) o;

        if (name != null ? !name.equals(h1Entity.name) : h1Entity.name != null) return false;
        if (id != null ? !id.equals(h1Entity.id) : h1Entity.id != null) return false;
        if (address != null ? !address.equals(h1Entity.address) : h1Entity.address != null) return false;
        if (number != null ? !number.equals(h1Entity.number) : h1Entity.number != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }
}
