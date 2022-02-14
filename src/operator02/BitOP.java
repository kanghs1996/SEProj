package operator02;

public class BitOP {

	public static void main(String[] args) {
		//비트 연산는 비트 단위로 계산
		/*		
		[쉬프트(Shift) 연산자(이항연산자)]
		-두 항이 반드시 정수여야한다
		 정수 <<  비트수: 왼쪽으로 비트수만큼 이동하고 
		                  오른쪽에     남은 비트는 0으로 채운다

		 정수 >> 비트수 : 오른쪽으로 비트수만큼 이동하고
		 	              왼쪽에 남은 비트는 부호비트로 
		 	              채운다(1:음수,0:양수)
		*/
		byte b1 = 10,bit1=2;
		int result = b1 << bit1;
		/*
		 * 10 : 00001010 
		 * <<
		 * 2
		 * ----------------------------
		 * 00000000 00000000 00000000 00101000
		 */
		System.out.printf("%d << %d의 결과:%d%n",b1,bit1,result);
		b1 = -9;
		result = b1 >> bit1;
		/*
		 * -9 : 11110111
		 * >>
		 * 2
		 * ---------------
		 * 	    11111101
		 * 
		 * 
		 */
		System.out.printf("%d >> %d의 결과:%d%n",b1,bit1,result);
		b1 = 3;
		byte b2 = -15;
		System.out.println("논리 연산자로 사용된 경우:"+(false & 10 > 5));
		System.out.println("비트 연산자로 사용된 경우(and 연산):"+(3 & -15));
		/*
		 * 3:  0000 0011
		 * &
		 * -15:1111 0001
		 * ----------------
		 *     0000 0001
		 * 
		 */		
		System.out.printf("%d & %d의 결과:%d%n",b1,b2,b1 & b2);
		
		/*
		 * 3:  0000 0011
		 * |
		 * -15:1111 0001
		 * ----------------
		 *     1111 0011
		 * 
		 */		
		System.out.printf("%d | %d의 결과:%d%n",b1,b2,b1 | b2);
		/*
		
		 * -15:1111 0001
		 * ~
		 * ----------------
		 *     0000 1110
		 * 
		 */		
		System.out.printf("%d ^ %d의 결과:%d%n",b1,b2,b1 ^ b2);
		System.out.printf("~%d의 결과:%d%n",b2,~b2);
		
		
	}///main

}////class
