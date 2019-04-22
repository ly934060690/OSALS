package edu.zut.cs.network.example.collection;

import java.util.HashMap;
import java.util.TreeMap;

import edu.zut.cs.network.example.base.BaseExample;

public class MapExample extends BaseExample {

	String s = "Have a good day.Have a good class.Have a good visit. Have fn!";
	String[] word = s.split("[ .!?]");
	HashMap<String, Integer> hash = new HashMap<String, Integer>();

	MapExample() {
		this.init();
	}

	public void init() {
		for (int i = 0; i < word.length; i++)
			if (hash.get(word[i]) != null) {
				int value = hash.get(word[i]).intValue();
				value++;
				hash.put(word[i], value);
			} else
				hash.put(word[i], 1);

		System.out.println(hash);
		TreeMap<String, Integer> tree = new TreeMap<String, Integer>(hash);
		System.out.println(tree);
	}

	public static void main(String[] args) {
		MapExample example = new MapExample();

	}
}
