package lambda27;

public class MyCalculator {
	
	//인자(매개변수)에 남다식(익명함수)을 받는 메소드]
	static void paramFunc(MyInterface lambda,int a,int b) {
		System.out.println(lambda.calc(a, b));
	}
	//남다식(익명함수)을 반환하는 메소드]
	static MyInterface returnFunc(int z) {
		//lambda expression's parameter x cannot redeclare another local variable defined in an enclosing scope
		//즉 람다식 정의시 지역변수와 충돌하는 변수 사용 불가
		return (x,y)->x*y+z;
	}
	
	public static void main(String[] args) {
		System.out.println("[인터페이스를 구현한 클래스파일 사용:더하기만 가능]");
		//방법1]인터페이스를 구현한 클래스파일 사용
		//더하기만 가능.단 재사용 가능(MyInterfaceImpl타입 객체 또 생성가능)
		MyInterface my1 = new MyInterfaceImpl();
		System.out.println(my1.calc(10, 5));
		System.out.println("[익명 클래스로 구현:다른 연산 가능]");
		//방법2]익명 클래스로 구현 즉 별도의 클래스파일 불필요.방법1 보다 코드 간결. 단 재사용 불가 
		MyInterface my2 = new MyInterface() {			
			@Override
			public int calc(int a, int b) {				
				return a+b;
			}
		};
		System.out.println(my2.calc(10, 5));
		MyInterface my3 = new MyInterface() {			
			@Override
			public int calc(int a, int b) {				
				return a-b;
			}
		};
		System.out.println(my3.calc(10, 5));
		System.out.println("[람다식으로 구현:다른 연산 가능]");
		//방법3] 람다식 사용.클래스파일 불필요.방법2 보다 코드 더 간결. 단 재사용 불가
		//      추상 메소드 하나로 다양한 기능 구현.
		//※람다식은 MyInterface의 추상메소드 형태 여야한다
		MyInterface lambdaPlus = (a,b)->a+b;
		System.out.println(lambdaPlus.calc(10, 5));
		MyInterface lambdaMinus = (a,b)->a-b;
		System.out.println(lambdaMinus.calc(10, 5));
		MyInterface lambdaMultiple = (a,b)->a*b;
		System.out.println(lambdaMultiple.calc(10, 5));
		MyInterface lambdaDivide = (a,b)->a/b;
		System.out.println(lambdaDivide.calc(10, 5));
		System.out.println("[람다식(익명함수)을 메소드의 인자로 전달]");
		//함수의 인자로 남다식(익명함수) 전달
		paramFunc((x, y)->x%y,10, 5);
		System.out.println("[람다식(익명함수)을 반환하는 메소드]");		
		System.out.println(returnFunc(100).calc(10, 5));
		
	}/////main

}////////class
