package etcclass12;

import java.util.Random;

public class MathClass {
	//문]Math클래스의 abs() 메소드와 같은 기능을 하는
    //   메소드를 정의해라
	private static int abs(int value) {		
		return value >= 0 ? value : -value;
	}
	//문]Math클래스의 round() 메소드와 같은 기능을 하는
    //   메소드를 정의해라	
	private static long round(double value) {
		
		return value > 0 ? (long)(value+0.5)   : (long)(value-0.4) ;
	}
	//문]Math클래스의 pow() 메소드와 같은 기능을 하는
    //   메소드를 정의해라
	private static int pow(int num, int loop) {
		int sum=1;
		for(int i=0; i < loop;i++) sum*=num;
		return sum;
	}
	
	public static void main(String[] args) {
		//Math클래스는 인스턴스화(객체화/HEAP영역에 메모리 생성) 불가]	
		//Math math = new Math();//[x]
		System.out.println(Math.PI);
		/* Math클래스의 주요 메소드 */
		//절대값:static 반환타입 abs(매개변수):
		//             반환타입은 매개변수의 타입에 따라 결정됨.
		float f=-3.14F;
		double d= -100.9;
		int num =10;
		System.out.println("[abs()메소드]");
		System.out.println(Math.abs(f));
		System.out.println(Math.abs(d));
		System.out.println(Math.abs(num));
		System.out.println("[내가 만든 abs()메소드]");
		System.out.println(abs(-100));//100
		System.out.println(abs(100));//100
		System.out.println(abs(-99));//99
		//올림값 :static double ceil(double a)
		//소수점에서 큰 수로 가장 가까운 정수를 찾는다.
		//3.4 -> 4,3.9->4 -3.4 ->-3
		System.out.println("[ceil()메소드]");
		System.out.println(Math.ceil(3.4));
		System.out.println(Math.ceil(3.9));
		System.out.println(Math.ceil(-3.4));
		//내림값 : static double floor(double a)  
		//소수점에서 작은 수로 가장 가까운 정수를 찾는다.
		//3.4->3 ,-3.4->-4 3.9->3]
		System.out.println("[floor()메소드]");
		System.out.println(Math.floor(3.4));
		System.out.println(Math.floor(3.9));
		System.out.println(Math.floor(-3.4));
		//반올림:무조건 소수점 첫째자리에서 반올림
		//static long round(double a) 
		//static int round(float a )
		System.out.println("[round()메소드]");
		System.out.println(Math.round(3.49));
		System.out.println(Math.round(3.51));
		System.out.println(Math.round(-1.4));
		System.out.println(Math.round(-1.8));
		System.out.println(Math.round(-0.4));
		System.out.println(Math.round(-0.8));
		System.out.println(Math.round(-1.5));
		System.out.println("[내가 만든 round()메소드]");
		System.out.println(round(3.49));
		System.out.println(round(3.51));
		System.out.println(round(-1.4));
		System.out.println(round(-1.8));
		System.out.println(round(-0.4));
		System.out.println(round(-0.8));
		System.out.println(round(-1.5));
		System.out.println("[max/min()메소드]");
		//두 숫자 중 큰값 혹은 작은값 반환:max(),min()
		System.out.println("최대값:"+Math.max(100, 10));
		System.out.println("최소값:"+Math.min(100, 10));
		//지수: static double pow(double a, double b)  
		//      a의 b승을 의미   
		// pow(2,3) : 2의 3승 ->2 * 2* 2
		System.out.println("[pow()메소드]");
		System.out.println(Math.pow(2, 3));
		System.out.println(Math.pow(3, 3));
		System.out.println("[내가 만든 pow()메소드]");
		System.out.println(pow(2, 3));
		System.out.println(pow(3, 3));
		System.out.println("[random()메소드]");
		//Math.random() 과 같은 기능을 제공해주는 
		//Random클래스
		//5부터 10까지 랜덤하게 발생
		//(int)(Math.random()*(차이값+1))+시작값
		
		//Random클래스의 인스턴스변수.nextInt(차이값+1)+시작값
		Random rand = new Random();
		//seed:난수를 발생시키는 알고리즘이 사용하는 씨앗값
		//seed값 설정:동일한 패턴의 난수를 발생시킨다
		rand.setSeed(1004);
		for(int i=0;i<10;i++) {
			int random=rand.nextInt(10)+1;
			System.out.printf("%-3d",random);
		}
		
	}///////////////main
	

	

}//////////////////class
