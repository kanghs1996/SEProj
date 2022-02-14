package method05;

public class CallByRefExample {
	private static void setTotalNAverage(double[][] s) {
		for(int i=0;i < s.length;i++) {
			//총점 구하기]
			for(int k=0;k < 3;k++) {
				s[i][3]+=s[i][k];
			}
			//평균 구하기
			s[i][4]=s[i][3]/3.0;
		}
		
	}////////////
	private static void print(double[][] s) {
		String[] titles= {"국어","영어","수학","총점","평균"};
		for(int i=0;i<s.length;i++) {
			System.out.printf("[%d번째 학생의 성적]",i+1);
			for(int k=0;k<s[i].length;k++) {
				System.out.printf("%s:%-4.0f",titles[k],s[i][k]);
			}
			//줄바끔
			System.out.println();
		}
		
	}/////////////////
	public static void main(String[] args) {
		double [][] scores = {
				{100,100,100,0,0},
				{90,90,90,0,0},
				{95,95,95,0,0}};
		
		//총점 및 평균을 설정하는 메소드 호출
		setTotalNAverage(scores);
		//출력]
		print(scores);
	}/////////////main
	

	

}
