package method05;
//메소드 형식 3: 매개변수는 있고 반환값은 없는 경우
/*
접근지정자 [modifier] void 메소드명(매개변수들){

	처리할 일;

}  
*/
//메소드 정의]
/*
* 메소드에서 필요한 값을 매개변수를 통해서 받고
* 그 값으로 일을 처리한 후 결과값을
* 바로 출력하고자 할때 주로 사용

*/
public class MethodShape03 {
	//1]메소드 정의:start부터 end까지 누적합 구하는 메소드
	static void printSum(int start,int end) {
		int sum =0;//누적합을 저장할 변수 선언
		for(int i=start;i <= end;i++) {					
			sum+=i;//sum = sum + i;
		}
		System.out.printf("%d부터 %d까지 누적합:%d%n",start,end,sum);
	}/////////////////
	/*문] 국영수 세 과목의 점수를 매개변수로 전달받아
	평균을 구하고 학점을 출력하는 메소드를 정의해라
	그리고 main 메소드에서 호출하여 결과를 확인해라.*/
	static void printGrade(int kor,int eng,int math) {
		String grade;
		double avg = (kor+eng+math)/3.0;
		switch((int)(avg/10)) {
			case 10:
			case 9:grade="A학점";break;
			case 8:grade="B학점";break;
			case 7:grade="C학점";break;
			case 6:grade="D학점";break;
			default:grade="F학점";
		}
		System.out.printf("평균:%.2f,학점:%s%n",avg,grade);
	}///////////////printGrade
	/*문]
	   이름과 나이를 매개변수에 받아서
	   "이름은 ??? 나이는 ???"라고 바로 출력하는 
	   메서드를 정의해라
	   단, 반환값은 없다.
	   위 정의한 메서드를 main메서드에서 호출하여 
	   그 결과값을 확인 하여라
	*/
	static void printNameNAge(String name,int age) {
		System.out.println("이름은 "+name+" 나이는 "+age);
	}
	/*
	 * 문] 숫자 두개를 매개변수로 입력받아서 즉 시작단 과 끝단을 
	 *     매개변수에 입력받아 해당 구구단을 출력하는 메소드를 정의하고
	       main메소드에서 호출하여라.	 
	 */
	static void printGugudan(int start,int end) {
		for(int k=1 ;k<=end;k++) {
			for(int j=start;j<=end;j++) {
				System.out.printf("%d * %d =%-5d",j,k,k*j);
			}
			//줄바꿈
			System.out.println();
		}
	}///////////////////printGugudan	
	public static void main(String[] args) {
		//2]메소드 호출
		//매개변수에 값 전달:변수에 저장해서 전달
		int start=1,end=10;
		printSum(start,end);
		//매개변수에 값 전달:상수값 직접 전달
		printSum(1,100);
		printSum(100,1000);
		
		printGrade(100,100,100);
		printGrade(98,77,59);
		
		printNameNAge("가길동",20);
		
		//printGugudan(2,9);
		//printGugudan(2,16);
		int[][] score= {
				{97,99,67},
				{88,99,78},
				{100,67,90},
				{77,56,100},
				{50,60,90}};
		//문]위에 정의한 printGrade()메소드를 호출하여
	    //2차원 배열 score에 저장된 5명의 학생의
	    //학점을 출력하여라.
		for(int i=0;i < score.length;i++) {
			printGrade(score[i][0],score[i][1],score[i][2]);		
		}
	}///main

}/////////////class
