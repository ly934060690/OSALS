package edu.zut.cs.lbw.logistics.dao.impl;

import edu.zut.cs.lbw.logistics.dao.Kinds;

import java.util.List;

/**
 * @Auther: LBW
 * @Date: 2019/4/11
 * @Description: edu.zut.cs.lbw.logistics.dao.impl
 * @version: 1.0
 */
public class KindImpl implements Kinds
{

    public List<String> clotches ;

    public List<String> foods ;

    public List<String> electric_devices ;

    public List<String> accessories ;

    public List<String> books ;


    public List<String> getClotches() {
        return clotches;
    }

    public void setClotches(List<String> clotches) {
        this.clotches = clotches;
    }

    public List<String> getFoods() {
        return foods;
    }

    public void setFoods(List<String> foods) {
        this.foods = foods;
    }

    public List<String> getElectric_devices() {
        return electric_devices;
    }

    public void setElectric_devices(List<String> electric_devices) {
        this.electric_devices = electric_devices;
    }

    public List<String> getAccessories() {
        return accessories;
    }

    public void setAccessories(List<String> accessories) {
        this.accessories = accessories;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "KindImpl{" +
                "clotches=" + clotches +
                ", foods=" + foods +
                ", electric_devices=" + electric_devices +
                ", accessories=" + accessories +
                ", books=" + books +
                '}';
    }


}
