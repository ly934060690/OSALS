package edu.zut.cs.network.example.collection;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import edu.zut.cs.network.example.base.BaseExample;

public class SetExample extends BaseExample {

	public void doExample() {
		Set<String> set = new TreeSet<String>();
//		Set<String> set = new LinkedHashSet<String>();

		set.add("A_789");
		set.add("A_123");
		set.add("A_456");
		set.add("B_456");
		set.add("B_123");

		this.logger.debug(set);

		Iterator<String> iter = set.iterator();
		while (iter.hasNext())
			this.logger.debug(iter.next());
	}

	public static void main(String[] args) {
		SetExample example = new SetExample();
		example.doExample();
	}
}
