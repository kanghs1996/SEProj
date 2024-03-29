package controlstatement03;

import java.io.IOException;

public class IfStatement02 {

	public static void main(String[] args) throws IOException {
		/*
		 * if문 기본형식2]
		 * if(조건식){
		 * 	조건식이 참일때 실행할 명령문;
		 * }		  
		 * else{
		 * 	조건식이 거짓일때 실행할 명령문;
		 * }		 * 
		 * 역시 실행할 명령문이 하나일때는 
		 * {} 생략 가능
		 */
		int num1 = 100;
		System.out.println("[if문 형식 첫번째로 짝/홀수 판단]");
		//조건식이 두번 실행됨.
		if(num1 % 2==0) System.out.println("짝수");
		if(num1 % 2!=0) System.out.println("홀수");
		
		System.out.println("[if문 형식 두번째로 짝/홀수 판단]");
		//조건식이 한번 실행됨.
		if(num1 % 2==0) System.out.println("짝수");
		else System.out.println("홀수");
		/*
		  -삼항 연산자 
		 if ~else문과 같다.
		 코드를 짧게 표현할때 주로 사용(if ~else문 
		 대신에)
		 구문]
		 변수 = 조건식 ? 참일때 값 : 거짓일때 값 ;		  
		*/
		System.out.println("[삼항 연산자로 짝/홀수 판단]");
		//String result = num1 % 2==0 ? "짝수"  : "홀수"  ;
		//System.out.println(result);
		System.out.println(num1 % 2==0 ? "짝수"  : "홀수");
		
		System.out.println("[짝/홀수 판단후 짝수인 경우 100이상인지 판단-if ~else문]");
		if(num1 % 2==0) {//짝수인 경우
			if(num1 >=100) System.out.println("짝수이면서 100이상");
			else System.out.println("짝수이면서 100미만");
		}
		System.out.println("[짝/홀수 판단후 짝수인 경우 100이상인지 판단-삼항 연산자]");
		System.out.println(num1 % 2==0 ? num1 >=100 ? "짝수이면서 100이상" :  "짝수이면서 100미만"  : "" );
		//※else는 항상 if문과 짝을 이루어야 한다. 단독 사용불가
		if(num1 % 2 !=0)// {
			System.out.println("num1은 "+num1);
			System.out.println(num1+"은 홀수");//if문과 무관
		//}
		//[x]아래 else는 짝을 이루는 if문이 없다
		//else System.out.println(num1+"은 짝수");//[x]
		
		//문]한 문자를 입력받아 숫자인지 아닌지
		//  if ~else문 과 삼항 연산자를 이용하여 판단하여라.
		System.out.println("한 문자를 입력하세요?");
		int ascii = System.in.read();
		boolean isNumber = ascii >='0' && ascii <='9';
		System.out.println("[if ~else문 사용]");
		if(isNumber) System.out.println("숫자다");
		else System.out.println("숫자가 아니다");
		System.out.println("[삼항 연산자 사용]");
		System.out.println(isNumber ? "숫자다" : "숫자가 아니다");
		
		System.in.skip(2);
		System.out.println("다시 한 문자를 입력하세요?");
		char word = (char)System.in.read();
		/*
		문]숫자인지 판단후 2의 배수를 판단하고
		   2의 배수면 "2의 배수" 출력,아니면 "2의배수가 아님"출력
		   또한 숫자가 아니고
		   알파벳이라면 대소문자를 판단한후
		   대문자인경우 "대문자" 출력, 소문자인 경우 
		  "소문자"출력
		   가정]숫자나 알파벳만 입력한다고 가정하자.
		*/
		isNumber = word >='0' && word <='9';
		System.out.println("[if ~ else문 사용]");
		if(isNumber) {//숫자라면
			if((word-'0') % 2==0) System.out.println("2의 배수");
			else System.out.println("2의배수가 아님");
		}
		else {//알파벳이라면
			if(word >='A' && word <='Z') System.out.println("대문자");
			else System.out.println("소문자");
		}
		System.out.println("[삼항 연산자 사용]");
		System.out.println( isNumber ? (word-'0') % 2==0 ? "2의 배수" : "2의배수가 아님" :word >='A' && word <='Z' ? "대문자" : "소문자");
	}/////////////////main

}///////////////////class
