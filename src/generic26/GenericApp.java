package generic26;

import java.util.Arrays;
import java.util.List;

import console.academy.Student;

public class GenericApp {

	public static void main(String[] args) {
		System.out.println("[타입 파라미터 미 지정]");
		MyGeneric generic1 = new MyGeneric();	
		generic1.setField("문자열");//setField(Object)
		String value=(String)generic1.getField();//Object getFiled()
		System.out.println("문자열의 갯수:"+value.length());
		
		System.out.println("[타입 파라미터 지정]");
		MyGeneric<Student> generic2 = new MyGeneric<>();
		//generic2.setField("문자열");//[x]컴파일시 타입 체크.Student타입만 가능
		generic2.setField(new Student("가길동", 20, "2021학번"));//setField(Student)
		generic2.getField().print();//Student getFiled(). 형변환 불필요
		
		System.out.println("[제너릭 메소드 호출:정적 메소드]");
		//메소드 호출시 타입파라미터 지정:클래스명.<Integer>메소드명()-인자로 Integer타입 배열만 가능.이때는 반환타입이 무조건 Integer
		System.out.println(MyGeneric.<Integer>getEndValue1(1,2,3,4,5));
		//메소드 호출시 타입파라미터 미 지정:인자로 전달한 타입으로 반환 타입을 추정
		System.out.println(MyGeneric.getEndValue1(new String[] {"한라산","설악산","덕유산","소백산"}));
		System.out.println("[제너릭 메소드 호출:인스턴스 메소드]");
		System.out.println(generic2.getEndValue2("한라산","설악산","덕유산","소백산"));
		
		System.out.println("[파라미터의 타입 제한하기:NON 제너릭 메소드]");
		
		List<Character> lists1=Arrays.asList('가','나','다','라');//asList도 정적 제너릭 메소드
		//MyGeneric.noReturnGeneric(lists1);//[x] 타입체크
		MyGeneric.noGeneric(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		System.out.println("[파라미터의 타입 제한하기:제너릭 메소드]");
		//MyGeneric.yesGeneric(lists1);//[x] 타입체크
		MyGeneric.yesGeneric(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
	}

}
