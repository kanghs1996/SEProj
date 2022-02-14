package operator02;


class Ref{
	int data=100;
}

public class NolliOP {

	public static void main(String[] args) {
		/*
		  -논리연산자(이항연산자 혹은 단항 연산자)의 결과값은 true,false이다.
		  &&: and연산자(논리곱) 두 항이 참일때만 참이다 
		      (~그리고)		
		  ||: or연산자(논리합) 두 항중의 하나라도   참이면 참(~또는 ,혹은)   
		  
		  !(단항연산자): not연산자(논리부정) 단항이 참이면 거짓,		  
		                 거짓이면 참(~아니다)		  
		  ^(이항연산자):xor연산자(배타) 두 항이 서로 배타적일때 참
		                두 항이 서로 같으면 거짓
		 -논리연산자의 우선 순위: ! > && > ||,^		  
		 - && 와 &,|| 와 | 는 둘다 결과값이 같다		  
		 -&&는 첫째항이 거짓이면 두번째항은 계산안한다
		 -&는 첫째항이 거짓이더라도 두번째항을 계산한다		  
		  -산술 > 비교 >논리연산자순으로 우선순위가 적용됨.
		 */	
		int num1=15,num2=10;
		boolean b = num1 >= num2 && num1 == num2;
		System.out.printf("%d >= %d && %d == %d의 결과:%b%n",num1,num2,num1,num2,b);
		b = true || false;
		System.out.printf("%b || %b의 결과:%b%n",true,false,b);
		//논리 연산자(&&,||,!,^)의 각 항에는 반드시 true나false값을
		//갖는 식(비교식)이거나 true,false값이여야 한다.
		//b = num1 + num2 && num1 != num2;//[x]
		
		b = num1 <= num2 ^ num1 !=num2;
		System.out.printf("%d <= %d ^ %d !=%d의 결과:%b%n",num1,num2,num1,num2,b);
		
		b = !(num1 != num2) || num1 >=num2 && num1 == num2;
		//1](num1 !=num2) : true
		//2] !1]번의 결과=!true : false
		//3] num1 >=num2 : true
		//4] num1 == num2: false
		//중간정리:false || true && false
		//5] true && false: false
		//6] false || 5]번의 결과 = false || false: false
		System.out.println("b="+b);
		b = 10 % 3 > 6-2*2 && 10 <= 6*2 || 5 *3 !=10;
		//1]10 % 3 : 1
		//2]2 * 2 : 4
		//3]6 * 2 :12
		//4]5 * 3 : 15
		//중간정리] 1 > 6-4 && 10 <= 12 || 15 !=10
		//5] 6-4 : 2
		//6] 1 > 5]의 결과인 2 : false
		//7] 10 <= 12 : true
		//8] 15 != 10 : true
		//중간정리] false && true || true
		//9] false && true : false
		//10] 9]의 결과인 false || true ======>true
		System.out.println("b="+b);
		
		b = !true || true ^ false && true;
		/*
		 * 1] !true : false
		 * 2] false && true : false
		 * 중간정리] false || true ^ false
		 * 3] false || true : true
		 * 중간정리] true ^ false
		 * 최종 =>true
		 */
		System.out.println("b="+b);
		//&&와 & ,|| 와 |
		/*
		Ref ref = new Ref();
		System.out.println(ref.data);*/
		Ref ref = null;
		//System.out.println(ref.data);//[x]java.lang.NullPointerException
		System.out.println(ref);//null
		System.out.println("[&& 연산자 사용]");
		System.out.println(ref != null && ref.data==100);
		//아래는 오른쪽항이 실행이되서 에러
		//즉 ref.data==100항이 실행되서.....
		System.out.println("[& 연산자 사용]");
		//System.out.println(ref != null & ref.data==100);//[x]java.lang.NullPointerException
	}/////////////////main

}///////////////////class
