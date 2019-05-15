package com.atguigu.spring.tx;

/**
 * @Auther: LBW
 * @Date: 2019/4/14
 * @Description: com.atguigu.spring.tx
 * @version: 1.0
 */
public interface BookShopDao
{
    //根据书单号获取书的价钱
    public int findBookPriceByIsbn(String isbn);

    //更新书的库存 -1
    public void updateBookStock(String isbn);

    //更新账户余额 usename -= price
    public void updateUserAccount(String username , int price);
}
