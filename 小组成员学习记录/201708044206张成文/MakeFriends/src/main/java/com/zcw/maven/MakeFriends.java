package com.zcw.maven;

import com.zcw.HelloFriend.HelloFriend;

public class MakeFriends {
	public String makeFriends(String name){
		HelloFriend friend = new HelloFriend();
		friend.sayHelloToFriend("litingwei");
		String str = "Hey,"+friend.getMyName()+" make a friend please.";
		System.out.println(str);
		return str;
	}
}
