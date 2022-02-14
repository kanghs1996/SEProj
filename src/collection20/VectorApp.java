package collection20;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import console.academy.Student;

//Vector:List계열 컬렉션
public class VectorApp {

	public static void main(String[] args) {
		//컬렉션 객체 생성]
		List<Student> vec = new Vector<>();
		//컬렉션에 저장할 객체 생성
		Student stu1 = new Student("가길동", 30, "2015학번");
		Student stu2 = new Student("나길동", 25, "2018학번");
		Student stu3 = new Student("라길동", 35, "2000학번");
		Student stu4 = new Student("다길동", 19, "2021학번");
		//객체 저장]
		vec.add(stu1);
		vec.add(stu2);
		vec.add(stu3);
		vec.add(stu4);
		
		//출력]
		System.out.println("[일반 for문]");
		for(int i=0;i < vec.size();i++) vec.get(i).print();
		System.out.println("[확장 for문]");
		for(Student s:vec) s.print();
		System.out.println("[반복기]");
		Iterator<Student> it= vec.iterator();
		while(it.hasNext()) it.next().print();
		/*
		 * 열거형으로 꺼내오기:elements()메소드로 Enumeration  타입얻기
		 * Enumeration타입의 주요 메소드]
		 * hasMoreElements():저장된 객체가 있으면  true,없으면 false반환
		 * nextElement();저장된 객체 얻을때
		 */
		System.out.println("[열거형]");
		Enumeration<Student> em= ((Vector)vec).elements();
		while(em.hasMoreElements()) em.nextElement().print();
		//삭제]
		//인덱스로 삭제]
		//System.out.println("삭제된 학생의 이름:"+vec.remove(1).name);
		//인스턴스(주소)로 삭제]
		//System.out.println(vec.remove(stu2));
		//문]vec컬렉션에 저장된 Student객체들을
		//   나이가 높은 순으로 재 배치후
		//   출력하여라.
		//단,List계열의 get(인덱스) 및 set(인덱스,객체)메소드 사용
		/*
		for(int i=0;i < vec.size()-1;i++)
			for(int k=i+1;k<vec.size();k++)
				if(vec.get(i).age < vec.get(k).age) {
					Student temp = vec.get(k);
					vec.set(k, vec.get(i));
					vec.set(i, temp);
				}*/
		//Collections.sort(vec)로 정렬하기(아래의 적용규칙 먼저)
		
		Collections.sort(vec);
		System.out.println("[재배치후]");
		for(Student s:vec) s.print();
		System.out.println("[리스트계열 컬렉션에 저장된 객체 정렬하기]");
		/*
		[리스트계열 컬렉션에 저장된 객체 정렬하기]
		방법1. Comparable인터페이스 구현		
		1.리스트계열 컬렉션이어야 하고
		2.리스트계열 컬렉션에 저장된 객체는 Comparable인터페이스를 구현해야 한다.
		3.compareTo()메소드 오버라이딩해서 정렬하고자는 필드로 정렬 수식 작성
		방법2.익명클래스로 Comparator인터페이스 구현
		     역시 리스트계열 컬렉션이어야 한다
		*/
		//샘플용 리스트 컬렉션 생성
		/*
		List<String> names = new Vector<>();
		names.add("나길동");
		names.add("홍길동");
		names.add("다길동");
		names.add("박길동");*/
		//아래는 위 5줄과 같다
		List<String> names = Arrays.asList("나길동","홍길동","다길동","박길동");
		//[첫번째 방법]
		//오름차순으로 정렬하기]
		//Collections.sort(names); //혹은
		//names.sort(Comparator.naturalOrder());//JDK 8에서 추가		
		//내림차순으로 정렬하기]
		//Collections.sort(names,Collections.reverseOrder());
		//names.sort(Comparator.reverseOrder());//JDK 8에서 추가	
		//[두번째 방법]
		/*
		Collections.sort(names,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {				
				//return o1.compareTo(o2);//오름차순
				return o2.compareTo(o1);//내림차순
			}			
		});*/
		names.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {				
				//return o1.compareTo(o2);//오름차순
				return o2.compareTo(o1);//내림차순
			}			
		});		
		System.out.println(names.toString());
		
		
		
	}///////main
}///////////class
