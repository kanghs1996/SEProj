package lambda27;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Stream01 {

	public static void main(String[] args) {
		System.out.println("[데이타 소스:배열]");
		String[] mountains = {"한라산","지리산","덕유산","치악산","비슬산"};
		Stream<String> stream1=Arrays.stream(mountains);//stream()는 제너릭 메소드
		stream1.forEach(x->System.out.println(x));//최종 연산후 스트림은 닫힌다
		//stream1.forEach(y->System.out.println(y));//[x]stream has already been operated upon or closed
		//System.out.println("[Arrays.sort()로 배열정렬:원본 배열이 변경된다]");
		//Arrays.sort(mountains);
		//for(String mountain:mountains) System.out.println(mountain);
		System.out.println("[스트림객체의 sorted()로 배열정렬:원본 배열이 변경 안된다]");
		//스트림 객체 다시 생성
		stream1=Arrays.stream(mountains);
		//stream1.sorted().forEach(x->System.out.println(x));//오름차순
		stream1.sorted((x,y)->y.compareTo(x)).forEach(x->System.out.println(x));//내림차순
		System.out.println("[원본 배열 출력]");
		for(String mountain:mountains) System.out.println(mountain);
		System.out.println("[데이타 소스:컬렉션]");
		/*
		List<String> list = new Vector<String>();		
		list.add("치악산");
		list.add("지리산");
		list.add("덕유산");
		list.add("설악산");*/
		List<String> lists=Arrays.asList("치악산","지리산","덕유산","설악산");//asList()제너릭 메소드
				
		//스트림객체 생성
		Stream<String> stream2=lists.stream();
		//System.out.println("[정렬:Collections.sort()사용- 원본 컬렉션이 변경됨]");
		//Collections.sort(lists);
		System.out.println("[정렬:스트림객체의 sorted()사용- 원본 컬렉션이 변경 안됨]");
		//stream2.sorted().forEach(x->System.out.println(x));//오름차순
		stream2.sorted((x,y)->y.compareTo(x)).forEach(x->System.out.println(x));//내림차순
		System.out.println("[원본 컬렉션]");
		for(String mountain:lists) System.out.println(mountain);
		
	}/////////main

}///////////////class
