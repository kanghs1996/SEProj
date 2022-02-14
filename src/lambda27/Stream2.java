package lambda27;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Stream2 {

	public static void main(String[] args) {
		System.out.println("[주요 스트림객체 메소드]");
		//map():스트림의 각 요소를 람다식을 적용해 변경하는 함수
		System.out.println("1. map()함수");
		IntStream stream=IntStream.rangeClosed(1, 5);
		stream.map(e->e*e).forEach(x->{System.out.println(x);});
		//reduce():스트림의 요소를 줄이는 함수
		System.out.println("2. reduce()함수");
		//System.out.println(IntStream.range(1, 6).reduce((e1,e2)->e1+e2));//OptionalInt[15]
		System.out.println(IntStream.range(1, 6).reduce((e1,e2)->e1+e2).getAsInt());
		//limit():스트림의 최초 요소부터 설정한 요소 수까지의 요소를 추출해 새로운 stream 반환
		System.out.println("3. limit()함수");
		IntStream.rangeClosed(1, 5).limit(3).forEach(x->System.out.println(x));
		//IntStream.rangeClosed(1, 5).limit(3).forEach(System.out::println);
		//System.out::println 는 x->System.out.println(x)와 동일
		//skip():스트림의 최초 요소부터 설정한 요소 수까지를 제외하고 새로운 stream 반환
		System.out.println("4. skip()함수");
		IntStream.rangeClosed(5, 10).skip(3).forEach(System.out::println);
		//distinct():중복값 제거 후 새로운 스트림 반환(요소들 중 같은 값을 가지는 요소가 있으면 그중 하나만 남기고 나머지는 제거)
		System.out.println("5. distinct()함수");
		Arrays.asList(1,2,5,4,2,3,2,5,1,1).stream().distinct().sorted().forEach(System.out::println);
		//filter():조건을 만족하는 요소만 스트림으로 반환.
		System.out.println("6. filter()함수");
		IntStream.rangeClosed(1, 10).filter(e->e % 2==0).forEach(System.out::println);
		System.out.println("7. count()함수");
		System.out.println(IntStream.rangeClosed(9, 999).filter(e->e % 2==0).count());
		System.out.println("8. sum()함수");
		System.out.println(IntStream.rangeClosed(1, 10).filter(e->e % 2==0).sum());
		System.out.println("9. max()함수");
		System.out.println(IntStream.rangeClosed(1, 10).max().getAsInt());
		System.out.println("10. min()함수");
		System.out.println(IntStream.rangeClosed(1, 10).min().getAsInt());
		System.out.println("11. findAny()함수");
		System.out.println(IntStream.rangeClosed(1, 10).findAny().getAsInt());//Stream 요소의 첫번째 요소 반환(불안정)
		System.out.println("12. findFirst()함수");
		System.out.println(IntStream.rangeClosed(1, 10).findFirst().getAsInt());//Stream 요소의 첫번째 요소 반환(안정적)
		//문]1~100까지의 숫자값 중 50이상이고 홀수이면서 5의 배수인 수의 합을 구하라
		// 55+65+75+85....
		// 단,람다식과 스트림만을 이용해서..
		System.out.println(IntStream.rangeClosed(1, 100).skip(49).filter(e->e%2 !=0 && e%5==0).sum());
		
	}//////////main

}//////////////class
