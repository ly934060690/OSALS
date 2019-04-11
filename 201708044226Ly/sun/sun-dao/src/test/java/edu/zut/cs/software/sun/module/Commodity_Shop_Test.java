package edu.zut.cs.software.sun.module;

import edu.zut.cs.software.sun.module.domain.Commodity;
import edu.zut.cs.software.sun.module.domain.Shop;

public class Commodity_Shop_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Commodity commodity1 = new Commodity("01", "commodity01");
		Commodity commodity2 = new Commodity("02", "commodity02");
		Commodity commodity3 = new Commodity("03", "commodity03");
		
		Shop shop1 = new Shop("01", "shop01");
		Shop shop2 = new Shop("02", "shop02");
		Shop shop3 = new Shop("03", "shop03");
		
		commodity1.setShop(shop1);
		commodity1.setShop(shop1);
		commodity1.setShop(shop1);
		
		shop1.setCommodity(new Commodity[] {commodity1, commodity2, commodity3});
		
		shop1.setShop(new Shop[] {shop1, shop2, shop3});
		
		System.out.println(shop1.toString());
		for(int i = 0; i < shop1.getCommodity().length; i++) {
			System.out.println(shop1.getCommodity()[i].toString());
		}
		
		System.out.println("--------------------------------------------");
		
		System.out.println(shop1.toString());
		for(int i = 0; i < shop1.getShop().length; i++) {
			System.out.println(shop1.getShop()[i].toString());
		}
	}

}
