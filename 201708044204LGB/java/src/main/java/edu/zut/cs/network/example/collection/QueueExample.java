package edu.zut.cs.network.example.collection;

import java.util.Collections;
import java.util.PriorityQueue;

public class QueueExample {
	public static void main(String[] args) {

		PriorityQueue<String> que = new PriorityQueue<String>();
		que.add("zhengzhou");
		que.offer("taiyuan");
		que.offer("nanjing");
		que.offer("taiyuan");
		System.out.println(que);
		PriorityQueue<String> que1 = new PriorityQueue<String>(4, Collections.reverseOrder());
		que1.add("zhengzhou");
		que1.offer("taiyuan");
		que1.offer("nanjing");
		que1.offer("taiyuan");
		System.out.println(que1);
	}
}
