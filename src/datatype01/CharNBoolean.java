package datatype01;

public class CharNBoolean {
	/*
	 * 아스키 코드:1byte로 표현할 수 있는 문자
	 * (영문자 와 숫자)
	 * 십진수로 정의한 값을 아스키 코드라 함.
	 * 예]A의 아스키 코드값:65(이진수 : 1000001)
	 *                 
	 *    키보드에서 A라고 치면 컴퓨터 메모리에 
	 *    1000001로 저장됨.
	 *    소문자 a는 아스키 코드값이 97
	 *         
	 * 유니코드:1BYTE로 표현이 안되는 문자
	 * (한글이나 한자등)
	 * 은 2BYTE가 필요하다.\\u16진수로 정의한 값을
	 * 유니코드라 한다.
	 * 
	 * 가:44032 ->16진수로->AC00
	 *  
	 */
	public static void main(String[] args) {
		//char형:하나의 문자를 저장할 수 있는 
		//     자료형(2byte),0부터 ~2^16-1까지 저장.
		//     값 저장시 하나의 문자를 ''(single quotation)으로 감싼다.
		//     ""(double quotation)으로 감싸면 
		//     무조건 String형
		//char ch1="가";//[x]"가"는 문자열 즉 String타입
		//char ch1 ='가나';//[x]문자는 반드시 하나여야 한다.
		char ch1 ='가';//[o]
		System.out.println("ch1="+ch1);
		
		char ch2 = 'A';
		int num1 =2;
		System.out.println(ch2 + num1);
		//char ch3=ch2+num1;//[x]char형과 int형 연산결과는 int형
		//방법1]int형에 담는다.
		int num2 =ch2 + num1;//[o] 'A'+2 = 65(A의 아스키 코드값)+2=67
		System.out.println("num2(아스키코드):"+num2);
		//※아스키(혹은 유니) 코드값(십진수)을 char형으로 형변환 하면
		//해당 아스키(혹은 유니)코드값에 일치하는 문자로 바꾼다.
		//반대로 어떤 문자를 int형으로 형변환하면 그 문자의 코드값(아스키 혹은 유니코드)을 알 수 있다
		System.out.println("num2(문자):"+(char)num2);
		//방법2]연산결과 전체를 char으로 형변환
		char ch3=(char)(ch2+num1);
		System.out.println("ch3 : "+ch3);
		//규칙2]char형에 값(데이타) 저장시 
		//      ''으로 감싸서 하나의 문자를 저장하거나 
		//      숫자(정수)를 저장하거나 \\u16진수형태의 값을 저장 할수 있다. 
		//      숫자 저장시 그 숫자는 아스키코드/유니코드값으로 처리된다.
		char ch4='1';//숫자 1이 아닌 문자 1(아스키 코드값:49)을 저장
		char ch4_1 = 49;//숫자 49는 아스키 코드값으로 처리됨.
		//위의 두 변수에는 같은 데이타(문자)가 저장됨 즉 문자 1
		System.out.println("ch4="+ch4+",ch4_1="+ch4_1);
		char ch5='a';//문자 a의 아스키 코드값 97
		char ch5_1 = 97;
		System.out.println("ch5="+ch5+",ch5_1="+ch5_1);
		
		char ch6='가';
		char ch6_1 = 44032;//44032는 16진수로 AC00=A(10)*16^3+C(12)*16^2+0+0=40960+3072
		char ch6_2= 0xAC00;
		char ch6_3='\uAC00';//''(싱글쿼테이션)안에서 AC00이 유니코드라는 것을
							//나타내기 위해서 \\u를 추가한다.
		
		System.out.println("ch6="+ch6+",ch6_1="+ch6_1+",ch6_2="+ch6_2+",ch6_3="+ch6_3);
		
		//boolean형:true,false 두 값만 가진다
		//          산술연산(+,-,*,/,%등)이나 
		//          비교 연산(> , <,>=,<=등)에 
		//          참여 할 수 없다.
		//          단, 논리연산은 가능
		boolean b1 = true;
		boolean b2 = false;
		//산술 연산-X]
		//System.out.println(b1 + b2);//[x]
		//비교 연산-X]
		//System.out.println(b1 > b2);//[x]
		//논리 연산-O]
		System.out.println(b1 && b2);//[o]
		boolean b3='가' > 30000;//[o]44032(가의 십진수값) > 30000
		System.out.println(b3);
	}////////////main

}///////////////class
