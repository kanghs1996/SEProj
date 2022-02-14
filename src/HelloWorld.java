
import    java.util.Date;

public  class HelloWorld{	
	public static void main(String[] args){

		System.out.println("Hello World");
		
		//한줄 주석 : //
		//자바 교육기관명 출력
		/*  여러줄 주석
		System.out.println("한국");
		System.out.println("소프트웨어");
		System.out.println("인재 개발원");
		*/
		
		//오늘 날짜 출력
		Date today = new Date();
		System.out.print("오늘은 ");
		System.out.println(today );
		
	}

}