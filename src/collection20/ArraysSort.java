package collection20;

import java.util.Arrays;
import java.util.List;

public class ArraysSort {

	public static void main(String[] args) {
		/*
		※배열이나 컬렉션(List계열만)에 저장된 객체(데이타) 정렬하기
		배열 : Arrays.sort(배열)
		컬렉션:Collections.sort(List계열 컬렉션,[Comparator<? super T>])
		단,배열의 타입 혹은 List계열 컬렉션에 저장된 객체의 타입은
		반드시 1.Comparable인터페이스를 상속받고 2.compareTo()를 오버라이딩 해야한다		
		 */
		System.out.println("[Arrays클래스의 메소드]");
		String[] stringArray = {"홍길동","가길동","도길동","나길동","마길동"};
		
		System.out.println("1.static void sort(Object[] a)메소드");
		Arrays.sort(stringArray);//원본 배열이 재배치 된다(in-place방식)
		System.out.println("[배열 정렬후 출력]");
		for(String s:stringArray) System.out.println(s);
		System.out.println("2.static String toString(Object[] a)메소드");
		//Arrays.toString(): 배열을 하나의 문자열로 변경 "[요소1,요소2,요소3,...]"
		System.out.println(Arrays.toString(stringArray));
		System.out.println("3.static <T> List<T> asList(T... a)메소드");
		//배열을 List컬렉션으로 변경: Arrays.asList(T...a)
		List<Integer> list=Arrays.asList(200,150,35,1004);//혹은 Arrays.asList(new Integer[]{200,150,35,1004})
		//출력]
		for(Integer e:list) System.out.println(e);
		System.out.println("4.Object[] toArray()메소드");
		//리스트계열 컬렉션을 배열로 변환:리스트계열 컬렉션.toArray()
		Object[] objectArray=list.toArray();
		System.out.println("리스트를 배열로 변환후 출력:"+Arrays.toString(objectArray));
		
	}///////////main
}//////////////class
