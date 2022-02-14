package collection20;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import console.academy.Student;

/*
ArrayList: List(인터페이스)계열의 컬렉션 클래스
- 중복 저장 가능
- 순서 있게 저장
- 데이타 꺼내올때: iterator()/get(index)
*/
public class ArrayListApp {

	public static void main(String[] args) {
		//1]List 계열 컬렉션 객체 생성(Raw Type)
		List list = new ArrayList();
		
		
		//1-1]객체 저장:add() 계열
		/*
		boolean add(Object obj):계속 추가되면서
		                        인덱스는 0부터 자동 부여
		boolean add(int index,Object element);
		                     :계속 추가되면서 저장시
		                       인덱스 위치 부여 할 수 있다.
		                       인덱스번호 재배치됨.
		*/
		System.out.println(list.add("가산")?"저장 성공":"저장 실패");//인덱스 0번방에 저장
		list.add("나산");//인덱스 1번방에 저장
		list.add("다산");//인덱스 2번방에 저장
		//※인덱스 지정시는 순차적으로 다음 인덱스를 지정하거나
		//  기존에 존재하는 인덱스로 지정
		//list.add(5,"라산");//[x]런타임시 오류
		list.add(3,"라산");//[o]
		list.add(list.size(),"마산");
		list.add(list.size(),"바산");
		System.out.println("중복 저장 전 객체 수:"+list.size());
		//1-2]중복저장:허용
		System.out.println(list.add("가산")?"저장 성공":"저장 실패");
		System.out.println("중복 저장 후 객체 수:"+list.size());
		
		//1-3]출력
		System.out.println("[일반 for문:get(index)]");
		for(int i=0;i < list.size();i++) {
			Object obj=list.get(i);
			System.out.println(obj);
		}
		System.out.println("[확장 for문]");
		for(Object obj:list) 
			System.out.println(obj);
		System.out.println("[반복기 사용]");
		Iterator it= list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		/*1-4]특정 위치의 인덱스에 저장된 객체를 대체:
    	set(int index,Object obj)
    	특정 인덱스 위치에 새로운 객체가 저장이되고
    	기존 객체는 삭제됨. 
		 */
		list.set(4,"MASAN으로 대체 하기");
		System.out.println("[set으로 객체 저장후]");
		for(Object obj:list) System.out.println(obj);
		list.add(4,"MASAN으로 추가 하기");
		System.out.println("[add으로 객체 저장후]");
		for(Object obj:list) System.out.println(obj);
		//1-5]검색
		System.out.println(list.contains("다산"));
		System.out.println(list.contains("아산"));
		//1-6]삭제
		//인스턴스(주소)로 삭제:boolean remove(Object obj)
		//인덱스로 삭제:Object remove(int index):삭제된 객체(주소)를 반환
		
		Object obj=list.remove(1);
		System.out.println("삭제된 객체:"+obj);
		System.out.println(list.remove("MASAN으로 대체 하기"));
		System.out.println(list.remove("MASAN으로 추가 하기"));
		//※삭제후에는 자동으로 인덱스가 다시 부여된다
		System.out.println("인덱스 1번:"+list.get(1));
		//전체 삭제:boolean removeAll(Collection<?> col) 혹은void clear()
		//list.clear();	
		//중복된 객체 삭제하기-인덱스가 빠른거가 삭제된다 즉 앞에 객체가 삭제됨
		list.remove("가산");
		System.out.println("[삭제후 출력]");
		for(Object o:list) System.out.println(o);
		//1-7]특정 위치의 인덱스 찾기:int indexOf(Object)
		//    주소로 인덱스 찾을때 해당 주소가 없는 경우 -1반환
		System.out.println("'다산'의 인덱스:"+list.indexOf("다산"));
		//2]타입 파라미터 지정:<Student>
		List<Student> list2 = new ArrayList<>();
		//2-1]컬렉션에 저장할 객체 생성
		Student stu1 = new Student("가길동", 20, "2021학번");
		Student stu2 = new Student("나길동", 30, "2015학번");
		Student stu3 = new Student("다길동", 40, "2000학번");
		Student stu4 = new Student("라길동", 50, "1988학번");
		//2-1]객체 저장
		list2.add(stu1);
		list2.add(stu2);
		list2.add(stu3);
		list2.add(stu4);
		list2.add(stu2);//중복 저장
		System.out.println("[중복 저장후]");
		for(Student s:list2) s.print();
		list2.remove(stu2);//인스턴스(주소)로 중복저장된 객체 삭제-하나만 삭제됨(인덱스가 빠른거)
		System.out.println("[중복 저장된 객체를 주소로 삭제후]");
		for(Student s:list2) s.print();
		//2-2]출력
		System.out.println("[일반 for문]");
		for(int i=0;i < list2.size();i++)
			list2.get(i).print();
		System.out.println("[확장 for문]");
		for(Student s:list2) s.print();
		System.out.println("[반복기]");
		Iterator<Student> it2= list2.iterator();
		while(it2.hasNext()) it2.next().print();
		//2-3]삭제
		//인덱스로 삭제]
		System.out.println("삭제된 객체(학생)의 이름:"+list2.remove(2).name);
		/*문]사용자로부터 이름을 입력받아 그 이름으로 검색해서
		   인덱스 위치(indexOf사용)를 알아내서 해당 인덱스로
		   그 객체를 삭제하고 삭제된 객체의 정보(이름,나이,학번)를
		   출력하여라
		*/
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 학생의 이름 입력?");
		String searchName = sc.nextLine();
		for(Student s:list2) {
			if(searchName.equals(s.name)) {
				int idx=list2.indexOf(s);
				list2.remove(idx).print();
				break;
			}
		}
		
		
	}/////////////main

}///////////////class
