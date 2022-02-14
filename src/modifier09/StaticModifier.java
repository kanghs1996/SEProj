package modifier09;
/*
- 멤버변수는 크게 정적멤버 변수와 인스턴스형 
  멤버변수로 나눈다
- 멤버메소드도 정적메소드 와 인스턴스형 메소드로 나눈다.

-멤버변수나 멤버 메소드 앞에 static이라는 modifier가 
 붙으면
 정적 멤버 즉 정적 멤버변수이거나 정적 메소드이다.

 예]   int age;//인스턴스형 멤버변수
     static int age;//정적 멤버변수
     
     public void method(){};//인스턴스형 메소드
     public static  void method(){};//정적 메소드
     
     단,class앞에는 static을 붙일 수 없다

※ 정적멤버(상수 ,변수 혹은 메소드)의 메모리는 JVM에서 
   클래스를 로드할 시점에 생기고
   인스턴스형 멤버는 JVM에서 인터프리터 할때 메모리가 
   생성된다.(즉 new연산자로 인스턴스화 할때 생긴다)
   
※ 클래스의 멤버에 접근시 접근 방법
	 
	 1]인스턴스형 멤버 : 인스턴스변수.멤버
	 
	   클래스명 인스턴스변수 = new 생성자();
	   인스턴스변수.멤버;
	  
	 2]정적 멤버 :클래스명.멤버

*/

//static class StaticClass{}//[x]
class MyStatic{
	//[멤버 변수]
	/*
	 * 인스턴스형 멤버변수-반드시 클래스를 인스턴스화(객체화,heap영역에 메모리 생성)
	 * 하여 인스턴스변수로 접근
	 */
	//인스턴스형 멤버변수]
	int instanceVar;
	/*
	 * 정적 멤버변수:인스턴스화 할 필요 없이 
	 * 클래스명으로 접근
	 * 왜냐하면 JVM에서 클래스를 로드할때 
	 * 메모리가 이미 생성됨으로
	 */
	//정적 멤버 변수]
	static int staticVar;
	//[멤버메소드]
	//인스턴스형 메소드]
	void instanceMethod() {
		//인스턴스형 메소드 안에서는 
		//모든 멤버(인스턴스형 혹은 정적멤버)를 
		//사용할 수 있다.
		System.out.println(instanceVar);//[o]
		System.out.println(staticVar);//[o]
	}
	
	static void staticMethod() {
		//정적 메소드 안에서는 
		//인스턴스형멤버(변수,메소드등)를
		//사용할 수 없다.	
		//System.out.println(instanceVar);//[x]
		System.out.println(staticVar);//[o]
	}
	
}////////////////
public class StaticModifier {
	//인스턴스형 멤버]
	int instanceVar;
	void instanceMethod() {}
	//정적 멤버]
	static int staticVar;
	static void staticMethod() {}
	
	public static void main(String[] args) {
		//MyStatic클래스의 정적 멤버 접근]-클래스명.정적멤버
				System.out.println(MyStatic.staticVar);
				MyStatic.staticMethod();
				//MyStatic클래스의 인스턴스형 멤버 접근]-인스턴스변수.인스턴스형 멤버
				MyStatic ms = new MyStatic();
				System.out.println(ms.instanceVar);
				ms.instanceMethod();
				//아래처럼 정적 맴버도 인스턴스 변수로
				//접근 가능하나,인스턴스 멤버로 착각 할 수
				//있기때문에 아래처럼 접근하지은 않는다.
				System.out.println(ms.staticVar);
				ms.staticMethod();
				//StaticModifier의 멤버 접근]
				//정적멤버:클래스명.멤버로 접근하나 자기 클래스 안에서
				//접근하기 때문에 클래스명 보통 생략
				System.out.println(staticVar);
				staticMethod();
				//인스턴스형 멤버:인스턴스화 후 접근
				StaticModifier sm = new StaticModifier();
				System.out.println(sm.instanceVar);
				sm.instanceMethod();
				
				System.out.println("[멤버변수 x,y가 인스턴스형인 경우]");
				Calculator1 cal1 = new Calculator1();
				cal1.x=10;
				cal1.y=10;
				cal1.add();
				
				Calculator1 cal2 = new Calculator1();
				cal2.x=100;
				cal2.y=100;
				cal2.add();
				System.out.println("[cal1 계산기 add()다시 호출]");
				cal1.add();
				
				System.out.println("[멤버변수 x,y가 정적인 경우]");
				Calculator2 c2 = new Calculator2();
				Calculator2.x=10;
				Calculator2.y=10;
				c2.add();
				
				Calculator2 c3 = new Calculator2();
				Calculator2.x=100;
				Calculator2.y=100;
				c3.add();
				System.out.println("[c2 계산기 add()다시 호출]");
				c2.add();
	}
}
/*
 * ※정적 멤버는 인스턴스화된 객체마다
 * 갖고 있는 멤버가 아니라
 * 하나만 생성되서 모든 객체가 
 * 공유한다.
 * 그래서 공통으로 사용하는 변수나 메소드에
 * 주로 static을 붙인다.
 */
//멤버변수가 인스턴스형 인 경우
class Calculator1{
	//멤버변수]
	int x,y;
	//멤버 메소드]
	void add() {
		System.out.println("덧셈결과:"+(x+y));
	}	
}
//멤버변수가 정적멤버인 경우
class Calculator2{
	//멤버변수]
	static int x,y;
	//멤버 메소드]
	void add() {
		System.out.println("덧셈결과:"+(x+y));
	}	
}


