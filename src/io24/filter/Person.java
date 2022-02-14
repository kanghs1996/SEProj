package io24.filter;

import java.io.Serializable;

/*
자바 클래스의 객체는 직렬화가 되야 파일로 저장하거나
네트웍을 통해 전송할 수 있다.

어떤 클래스를 직렬화 하려면 Serializable혹은 Externalizable
인터페이스를 구현(상속)해야 한다. 

*/
public class Person implements Serializable {
	//[멤버 변수]
	private String name;
	private int age;
	private String addr;
	//[생성자]
	public Person(String name, int age, String addr) {		
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	@Override
	public String toString() {
		return String.format("[이름:%s,나이:%s,주소:%s]",name,age,addr);
	}
	
	
}
