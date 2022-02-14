package operator02;

public class BeeKyoOP {

	public static void main(String[] args) {
		/*
		  -비교연산자(이항연산자)의 결과는 
		   true아니면 false(boolean값)
		  > : ~보다 크다
		  >=: ~보다 크거나 같다
		  < : ~보다 작다
		  <=: ~보다 작거나 같다
		  !=: 같지 않다
		  ==: 같다
		  -비교연산자는 모두 우선 순위가 같다
		  -산술연산자가 비교 연산자보다 우선 순위가 높다
		  -비교 연산자를 사용한 식은 비교식
		 */
		int num1=10,num2=20;
		System.out.println(num1 > num2);
		boolean b = num1 == num2;
		System.out.printf("%d == %d의 결과:%b%n",num1,num2,b);
		b = num1 != num2;
		System.out.printf("%d != %d의 결과:%b%n",num1,num2,b);
		b = 15 % 3 * 2 + 4 > (10-2) * 4 != true;
		//1](10-2) : 8		
		//2]15 % 3 : 0		
		//3] 2]의결과 * 2 : 0		
		//4] 1]의 결과 * 4 : 32
		//중간정리: 0 + 4 > 32 != true
		//5]0+ 4 : 4
		//  4 > 32 != true
		//6] 4 > 32 : false
		//  false != true : true
		System.out.printf("15 %% 3 * 2 + 4 > (10-2) * 4 != true의 결과:%s",b);
	}//////////main

}///////////class
