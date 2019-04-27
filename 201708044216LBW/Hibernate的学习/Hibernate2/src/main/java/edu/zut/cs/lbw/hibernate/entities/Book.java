package edu.zut.cs.lbw.hibernate.entities;

/**
 * @Auther: LBW
 * @Date: 2019/4/25
 * @Description: edu.zut.cs.lbw.hibernate.entities
 * @version: 1.0
 */
public class Book {
    private Integer id;
    private String bookname;
    private String isbn;
    private int price;
    private int stock;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
