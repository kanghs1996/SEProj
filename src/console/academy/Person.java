package console.academy;

import java.io.Serializable;

public class Person implements Comparable<Person>,Serializable{
	
	//[멤버변수]
	public String name;
	public int age;
	//[기본 생성자]
	public Person() {}
	//[인자 생성자]
	public Person(String name, int age) {		
		this.name = name;
		this.age = age;
	}
	//[멤버 메소드]
	String get() {
		return String.format("이름:%s,나이:%s",name,age);
	}
	void print() {
		System.out.println(get());
	}
	@Override
	public int compareTo(Person target) {		
		//return this.age-target.age;//오름차순
		return target.age-age;//내림차순
	}
	
	
}
