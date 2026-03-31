package com.springboot.track;

public class RecordMain {
	public static void main(String[] args) {
		Person p = new Person("rony", 1, "shimoga");
		System.out.println(p.id());
		System.out.println(p.name());
	}
}
