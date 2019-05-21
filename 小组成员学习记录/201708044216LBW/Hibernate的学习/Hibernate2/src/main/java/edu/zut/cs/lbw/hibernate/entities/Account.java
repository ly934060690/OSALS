package edu.zut.cs.lbw.hibernate.entities;

/**
 * @Auther: LBW
 * @Date: 2019/4/25
 * @Description: edu.zut.cs.lbw.hibernate.entities
 * @version: 1.0
 */
public class Account {

    private Integer Id;

    private String username;

    private int balance;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}
