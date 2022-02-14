package generic26;

import java.util.List;

public class MyGeneric<T> {
	private T field;
	//public static T staticFiled;//Cannot make a static reference to the non-static type T[x]
	
	public T getField() {
		return field;
	}
	public void setField(T field) {
		this.field = field;
	}
	
	//※아래 제너릭 메소드의 타입파라미터인 T는 MyGeneric<T>의 T와 관련이 없다
	
	//정적 메소드에는 타입 파라미터 사용불가.단, 제너릭 메소드에는 static사용가능
	//Cannot make a static reference to the non-static type T[x]
	/*
	public static T staticMethod1() {return field;}
	*/
	//Cannot make a static reference to the non-static type T[x]
	//public static void staticMethod2(T field) {}
	//제너릭 메소드.인스턴스화 없이 클래스명으로 접근.
	public static <T> T getEndValue1(T ... t) {
		return t[t.length-1];
	}
	//제너릭 메소드.인스턴스화 해서 인스턴스변수로 접근.
	public <T> T getEndValue2(T ... t) {
		//return field;//[x] 즉 MyGeneric<T>의 T와 getEndValue2()의 반환타입인 T는 타입이 다르다
		return t[t.length-1];
	}
	
	//[타입 제한하기]
	//제너릭 메소드가 아닌 일반 메소드로 메소드 파라미터의 타입 제한
	//즉 컬렉션에 저장할 요소 객체를 숫자로 제한(<? extends Number>)
	//  그리고 요소의 모든 합을 구하는 메소드
	public static void noGeneric(List<? extends Number> lists) {
		int total=0;
		for(Number number:lists) {
			total+=number.intValue();
		}
		System.out.println("컬렉션에 저장된 요소의 총합:"+total);
	}
	
	//[위 메소드를 제너릭 메소드로 변환]
	//아래는 매개변수 타입인 List<T>의 T는 MyGeneric<T>의 T로 컴파일된다.
	//?를 T로 해야 MyGeneric<T>의 T가 아닌 <T> 반환타입형태의 T로 컴파일된다
	//public static <? extends Number> void yesGeneric(List<T> lists) { //[x]
	public static <T extends Number> void yesGeneric(List<T> lists) {
		int total=0;
		for(Number number:lists) {
			total+=number.intValue();
		}
		System.out.println("컬렉션에 저장된 요소의 총합:"+total);
	}
	
	
}
