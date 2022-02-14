//1]패키지 선언부- 클래스나 인터페이스를 종류별로 묶어서 관리하기 
//                 위한  선언. 디렉토리 선언의 의미다
// 예]package mypkg;  //아래 클래스는 mypkg안에 있다

//2]import선언부- 내가 만든 클래스에서 필요한 자바 클래스들을
//               가져다 쓰기 위한 선언
//java.lang패키지 안에 있는 클래스는 import불 필요(해도 상관없다)
//java.lang패키지안에 있는 클래스들은 자동으로 import된다.

import java.lang.String;
import java.text.SimpleDateFormat;
import java.util.Date;

//3]클래스 선언부
/*
클래스 선언방법]

public class 클래스명{

}
-클래스명은 대문자로 시작(권장사항)
-파일명은 클래스명.java 여야한다.(필수)
*/


public class ChoiCheolHwan 
{//클래스 시작
	
	/*
	자바의 실행파일인 .class파일을 실행시킬때
	JVM의 인터프리터가 main메소드를 찾아서
	순차적으로 즉 위에서 아래로
	한 줄 한줄 실행해 나간다

	자바로 만든 콘솔이나 윈도우(응용) 어플리케이션은 
	반드시 main()메소드가 하나 존재해야 한다.

	main메소드가 없으면 컴파일은 되나 실행은 안된다.

	*/ 
	public static void main(String[] args) 
	{//main 시작
		//오늘 날짜 출력하기
		Date day = new Date();
		System.out.println(day);
		//2021-08-19 오후 17:00:01 형식으로 출력
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");
		String today = dateFormat.format(day);
		System.out.println(today);
		DTO dto = new DTO();
		System.out.println(dto.getA() != null);
		DTO dto1 = null;
		if(dto1 == null)
			System.out.println("a");		
		
	}//main 끝

}//클래스 끝
