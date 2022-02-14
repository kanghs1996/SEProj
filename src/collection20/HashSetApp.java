package collection20;

import java.sql.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import console.academy.Student;


public class HashSetApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		/*
		 컬렉션 클래스들 : Generic Type에 속한다 즉 인스턴스화 할때 타입 파라미터(<T>또는 <E>)를 지정한다
		                예] HashSet<E>형태다
		                <E>를 지정하지 않은 타입을 Raw Type이라 한다
		 */
		//1]<T>타입 파라미터에 타입을 지정 안 한경우] 
		//  -어느 타입의 객체든 저장 가능.		
		//1-1]컬렉션 생성	
		HashSet set = new HashSet();//이때 HashSet는 raw type
		
		//1-2]컬렉션에 저장할 객체 생성
		String stringObj1 ="JAVA";
		String stringObj2 = new String("WORLD");
		Date dateObj = new Date(new java.util.Date().getTime());
		Integer intObj=new Integer(100);
		Student studentObj = new Student("가길동", 20, "2021학번");
		//1-3]컬렉션에 객체 저장-boolean add(Object)
		System.out.println(set.add(stringObj1)?"저장 성공":"저장 실패");
		System.out.println(set.add(stringObj2));
		System.out.println(set.add(dateObj));
		System.out.println(set.add(intObj));
		System.out.println(set.add(studentObj));
		//1-4]컬렉션에 저장된 객체수 얻기:int size()
		System.out.println("중복 저장 전  저장된 객체 수:"+set.size());
		//1-5]중복저장[x]-에러는 안나지만 저장이 안됨(즉 add()메소드가 false반환)
		System.out.println(set.add(stringObj1)?"저장 성공":"저장 실패");
		System.out.println("중복 저장 후  저장된 객체 수:"+set.size());
		//1-6]저장된 객체 꺼내오기
		//    -순서없이 저장됨(반복기를 통해서 꺼내오기)
		/*
		  Iterator의 주요 추상 메소드]
		  ※데이타가 순서 있게 저장된 자료구조(List 계열)
		   나 순서 없이 저장된 자료구조(Set계열)
		   에서 데이타를 꺼내올때 사용하는 타입(인터페이스)
		   단,확장 for문 써도 무방
		  
		  hasNext():꺼내올 객체가 있으면 true반환
		                       없으면 false반환.               
		  hasNext()메소드로 판단후 
		  next()메소드로 꺼내온다               
		  */ 
		//1-6-1]iterator()메소드로 Iterator타입의 인스턴스 얻기
		Iterator it= set.iterator();
		System.out.println("[반복기 사용]");
		while(it.hasNext()) {//1-6-2]hasNext()로 꺼내올 객체의 유무여부 판단
			Object obj=it.next();
			if(obj instanceof String) System.out.println("String타입:"+obj);
			else if(obj instanceof Date) System.out.println("Date타입:"+obj);
			else if(obj instanceof Integer) System.out.println("Integer타입:"+obj);
			else System.out.println("Student타입:"+((Student)obj).get());
		}
		//※모든 객체 꺼내온 후 next()호출시 실행 오류발생]
	    /* next()메소드 호출시마다 하나씩 꺼내온다
	     * 만약 컬렉션에 꺼내올 객체가 없는데 next()를
	     * 호출한다면 예외 발생(java.util.NoSuchElementException)
	     */
		//it.next();//[x]실행 오류 발생
		/*
	   	확장 for문: 배열이나 컬렉션에 저장된 값(객체)을 꺼내올때 
	                           사용하는  for문의 확장형    
	   	형식]
	   	for(자료형 객체를담을변수 : 배열명이나 혹은 컬렉션명){   
	   
	   	}	   	
	     */ 
		System.out.println("[확장 for문 사용]");
		for(Object obj:set) {
			if(obj instanceof String) System.out.println("String타입:"+obj);
			else if(obj instanceof Date) System.out.println("Date타입:"+obj);
			else if(obj instanceof Integer) System.out.println("Integer타입:"+obj);
			else System.out.println("Student타입:"+((Student)obj).get());
		}
		String[] mountains = {"비슬산","덕유산","태백산","속리산"};
		for(String mountain:mountains) 
			System.out.println(mountain);
		//1-7]검색:boolean contains(Object e)
		System.out.println(set.contains(stringObj2)?"stringObj2 있다":"stringObj2 없다");
		System.out.println(set.contains(100));
		System.out.println(set.contains("WORLD"));
		System.out.println(set.contains("KOSMO"));
		//1-8]삭제:boolean remove(Object e)
		System.out.println(set.remove(stringObj1)?"삭제 성공":"삭제 실패");
		System.out.println(set.remove(stringObj1)?"삭제 성공":"삭제 실패");
		System.out.println("삭제후 저장된 객체수:"+set.size());
		//1-9]전체 삭제 :boolean removeAll(Collection c)
		//set.removeAll(set);
		set.clear();
		System.out.println("전체 삭제후 저장된 객체수:"+set.size());
		//2]<?>타입파라미터 사용- 해당 타입(?)만 저장 가능. 즉 컴파일시 타입체크 가능(타입 안정성:Type Safety)
		//HashSet<Student> set2 = new HashSet<Student>(); 
		HashSet<Student> set2 = new HashSet<>(); //new HashSet<Student>()에서 Student생략가능(JDK 1.7부터)
		                                         //HashSet<Student> 제너릭타입(제너릭 클래스)
		//2-1]컬렉션에 저장할 객체 생성
		Student stu1 = new Student("가길동", 20, "2021학번");
		Student stu2 = new Student("나길동", 30, "2015학번");
		Student stu3 = new Student("다길동", 40, "2000학번");
		//2-2]객체 저장
		set2.add(stu1);
		set2.add(stu2);
		set2.add(stu3);
		//set2.add(stringObj2);//[x]제너릭에 지정한 타입만 저장 가능.컴파일시 타입체크가 됨
		//2-3]객체 꺼내오기
		System.out.println("[반복기 사용]");
		Iterator<Student> it2= set2.iterator();
		while(it2.hasNext()) {	
			/*
			    * next()메소드는 호출 할때마다 객체를
			    * 무조건 하나씩 꺼내온다
			    * 고로 아래는 반복 한번에
			    * 세개의 Student객체를 꺼내오는것
			    * 만약 더 이상 꺼내올 객체가 없는데
			    * next()를 호출하면
			    * java.util.NoSuchElementException예외 발생

			*/
			/*
			System.out.println(
					String.format("이름:%s,나이:%d,학번:%s",
								it2.next().name,
								it2.next().age,
								it2.next().stNumber
							));*/
			Student st=it2.next();
			st.print();
			/*
			System.out.println(
					String.format("이름:%s,나이:%d,학번:%s",
								st.name,
								st.age,
								st.stNumber
							));		*/	
		}///while
		System.out.println("[확장 for문 사용]");
		for(Student st:set2) st.print();
		//2-4]검색
		System.out.println(set2.contains(stu1));
		System.out.println(set2.contains(new Student("가길동", 20, "2021학번")));
		//2-5]삭제
		//set2.remove(stu1);
		//set2.clear();
		System.out.println("삭제후 저장된 객체수:"+set2.size());
		
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 이름을 입력하세요?");
		String searchName = sc.nextLine().trim();
		/*문]컬렉션 set2에 저장된 객체를
    	이름으로 검색하자.있는 이름으로 검색해 보고
   		없는 이름으로 검색해보자.
   		있으면 해당 학생의  정보를 출력하고 
   		없으면 "해당 학생이 없어요"라는 메시지 출력] */
		boolean isExist=false;
		for(Student s:set2) {
			if(searchName.equals(s.name)) {
				s.print();
				isExist=true;
				break;
			}
		}///////////////
		if(!isExist) System.out.println("해당 학생이 없어요");
		
		
	}//////////main

}/////////////class
