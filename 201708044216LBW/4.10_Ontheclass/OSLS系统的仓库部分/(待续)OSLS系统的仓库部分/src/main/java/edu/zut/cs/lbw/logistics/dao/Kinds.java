package edu.zut.cs.lbw.logistics.dao;

import java.util.List;

/**
 * @Auther: LBW
 * @Date: 2019/4/11
 * @Description: edu.zut.cs.lbw.logistics.dao
 * @version: 1.0
 */
public interface Kinds
{
    public List<String> clotches = null;         //衣服

    public List<String> foods = null;           //食物

    public List<String> electric_devices = null;   //电子产品

    public List<String> accessories = null;   //配饰

    public List<String> books = null;

    public List<String> getClotches() ;

    public void setClotches(List<String> clotches) ;

    public List<String> getFoods() ;

    public void setFoods(List<String> foods) ;

    public List<String> getElectric_devices() ;

    public void setElectric_devices(List<String> electric_devices) ;

    public List<String> getAccessories() ;

    public void setAccessories(List<String> accessories) ;

    public List<String> getBooks() ;

    public void setBooks(List<String> books) ;


}
