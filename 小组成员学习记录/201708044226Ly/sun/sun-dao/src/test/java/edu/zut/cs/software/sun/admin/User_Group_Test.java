package edu.zut.cs.software.sun.admin;

import org.junit.Test;

import edu.zut.cs.software.sun.admin.domain.Group;
import edu.zut.cs.software.sun.admin.domain.User;

public class User_Group_Test {

	@Test
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User u1 = new User("01", "user01");
		User u2 = new User("02", "user02");
		User u3 = new User("03", "user03");
		
		Group group1 = new Group("01", "group01");
		Group group2 = new Group("02", "group02");
		Group group3 = new Group("03", "group03");
		
		u1.setGroup(group1);
		u2.setGroup(group1);
		u3.setGroup(group1);
		
		group1.setUser(new User[] {u1, u2, u3});
		
		group1.setGroup(new Group[] {group1, group2, group3});
		
		System.out.println(group1.toString());
		for(int i = 0; i < group1.getUser().length; i++) {
			System.out.println(group1.getUser()[i].toString());
		}
		
		System.out.println("-------------------------------------------");
		System.out.println(group1.toString());
		for(int i = 0; i < group1.getGroup().length; i++) {
			System.out.println(group1.getGroup()[i].toString());
		}
		
	}

}
