package polymorphism14;

/*
[instanceof 연산자]
- 두 클래스간의 형변환이 가능한지 판단하는 연산자
- 해당 인스턴스 변수가 어떤 타입의 변수인지 판단하는 연산자
- 두 클래스간의 상속관계가 있어야 한다.
    즉 is a 관계가 성립해야 한다.
- 해당 인스턴스변수가  해당 타입이면  true ,아니면 false

형식]
   인스턴스변수 instanceof 클래스타입

*/
class Super{}
class Normal extends Super{}

public class InstanceOfOP {

	public static void main(String[] args) {
		//1]두 클래스간 상속관계가 존재 하지 않을때
		String str = new String("JAVA");
		StringBuffer buf = new StringBuffer("JAVA");
		//상속관계 미 존재시 대입 연산 및 형변환 불가
		//str = buf;//[x]
		//str =(String)buf;//[x]
		//buf = str;//[x]
		//buf = (StringBuffer)str;//[x]
		System.out.println(str instanceof String ? "str은 String타입이다" :"str은 String타입이 아니다");
		System.out.println(str instanceof Object ? "str은 Object타입이다" :"str은 Object타입이 아니다");
		System.out.println(buf instanceof StringBuffer);
		System.out.println(buf instanceof Object);
		//※상속관계가 없을때 instanceOf연산자 사용시 컴파일 에러
		//System.out.println(str instanceof StringBuffer);//[x]
		//System.out.println(buf instanceof String);//[x]
		//2]두 클래스간 상속관계가 존재 할때
		//instanceOf연산자로 先 판단하지 않고 형변환시]
		/*
		 * 상속 관계는 존재하나 형변환이 불가한 경우
		 * 컴파일 에러는 발생하지 않으나 실행시 에러 발생
		 * -ClassCastException
		 * 
		 * 실행시 에러를 피하기위해 반드시 instanceOf로 판단후 
		 * 형변환 
		 */
		 Object obj = new Object();
		 //String strObj = (String)obj;//[x]실행시 에러
		 System.out.println(obj instanceof String);//false
		//instanceof연산자로 선 판단후 형변환]
		 if(obj instanceof String) {
			 String strObj = (String)obj;
			 System.out.println("형변환이 일어났어요");
		 }
		 
		 obj = new String("JAVA");
		 String strObj = (String)obj;//[o]실행시 정상
		 System.out.println(obj instanceof String);//true
		 
		 Super s = new Super();
		 System.out.println(s instanceof Super);
		 System.out.println(s instanceof Object);
		 System.out.println(s instanceof Normal);
		 //Normal n = (Normal)s;//[x]java.lang.ClassCastException
		 s = new Normal();
		 System.out.println(s instanceof Super);
		 System.out.println(s instanceof Object);
		 System.out.println(s instanceof Normal);
		 Normal n = (Normal)s;//[o]
		 
	}/////////////main
}////////////////class
