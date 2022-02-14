package array04;

public class ArrayType02 {

	public static void main(String[] args) {
		//2차원 배열:1차원 배열이 평면으로 쌓인 것(평면)
		//1]배열선언
		//스택 영역에 주소를 저장할 수 있는 
		//arrNum이라는 이름의 메모리 생성됨.
		int [][]arrNum;//int arrNum[][];
		
		//2]메모리 할당
		//실제 데이타 저장하는 메모리 할당
		/*
		 * heap영역에 메모리 할당
		   []:앞의 [] 행,뒤의 [] 열을 나타냄
		 */
		arrNum = new int[2][3];//2는 행의 수,3은 열의 수
		System.out.println(arrNum);
		System.out.println(arrNum[0][0]);//0행 0열의 데이타
		System.out.println(arrNum[1][2]);//1행 2열의 데이타
		System.out.println("[초기화 전]");
		for(int i=0;i<2;i++) {//i를 행인덱스로
			for(int k=0;k<3;k++) {//k를 열인덱스로
				System.out.printf("arrNum[%d][%d]:%-3d",i,k,arrNum[i][k]);
			}
			System.out.println();//줄바꿈
		}//////////
		//3]초기화
		arrNum[0][0]=1;
		arrNum[0][1]=2;
		arrNum[0][2]=3;
		arrNum[1][0]=4;
		arrNum[1][1]=5;
		arrNum[1][2]=6;
		System.out.println("[초기화 후]");
		for(int i=0;i<2;i++) {//i를 행인덱스로
			for(int k=0;k<3;k++) {//k를 열인덱스로
				System.out.printf("arrNum[%d][%d]:%-3d",i,k,arrNum[i][k]);
			}
			System.out.println();//줄바꿈
		}/////////
		/*
		 2차원 배열에서 행의 수는 배열명.length
		 열의 수는 배열명[행인덱스].length
		*/
		System.out.println("행의 수:"+arrNum.length);
		System.out.println("0행의 열의 수:"+arrNum[0].length);
		System.out.println("1행의 열의 수:"+arrNum[1].length);
		//6]열의 크기를 동적으로 할당
	    //열을 동적으로 할당하기 위해 열의 수 미 지정
		int dynamic[][]=new int[2][];
		System.out.println(dynamic[0]);//null
		System.out.println(arrNum[0]);//0행의 시작주소
		//각 행의 열의 수 동적으로 지정
		dynamic[0]=new int[3];//0행의 열의 수를 3개로 할당 하고
							 // 그 주소를 dynamic[0]에 저장
		System.out.println("0행의 주소:"+dynamic[0]+",0행의 열의 수:"+dynamic[0].length);
		dynamic[1]=new int[1];
		for(int i=0;i<dynamic.length;i++) {//i를 행인덱스로
			for(int k=0;k < dynamic[i].length ;k++) {//k를 열인덱스로
				System.out.printf("dynamic[%d][%d]:%-3d",i,k,dynamic[i][k]);
			}
			System.out.println();//줄바꿈
		}		
		//초기화]
		for(int i=0;i<dynamic.length;i++) {//i를 행인덱스로
			for(int k=0;k < dynamic[i].length ;k++) {//k를 열인덱스로
				dynamic[i][k]=i+k;
			}			
		}	
		System.out.println("[초기화 후]");
		for(int i=0;i<dynamic.length;i++) {//i를 행인덱스로
			for(int k=0;k < dynamic[i].length ;k++) {//k를 열인덱스로
				System.out.printf("dynamic[%d][%d]:%-3d",i,k,dynamic[i][k]);
			}
			System.out.println();//줄바꿈
		}	
		/*
		7]2차원 배열 선언과 동시에 초기화
		바깥 {}는 초기화를 위한 중괄호
		바깥 {}안의 {}의 수가 행의 수를 의미
		안쪽 {}안의 값의 수가 열의 수를 의미
		*/
		int[][] arrInit = {{1,2},{1,2,3},{1}};
		System.out.println("[초기화자 사용]");
		for(int i=0;i<arrInit.length;i++) {//i를 행인덱스로
			for(int k=0;k < arrInit[i].length ;k++) {//k를 열인덱스로
				System.out.printf("(%d행,%d열):%-3d",i,k,arrInit[i][k]);
			}
			System.out.println();//줄바꿈
		}	
		/*   
		   1 9 9 9 9
		   9 1 9 9 9
		   9 9 1 9 9
		   9 9 9 1 9     
	   */
		//문1]2차원 배열을 선언하는데 ,선언과 동시에 메모리를 할당해라.
		int[][] nine= new int[4][5];
		//문2]위의 값을 문1]번에서 선언한 배열에 저장해라.		
		for(int i=0;i< nine.length;i++) {
			for(int k=0;k<nine[i].length;k++) {
				if(i==k) nine[i][k]=1;
				else nine[i][k]=9;
			}			
		}
		//문3]2차원 배열에 저장된 값을 위 모양대로 출력하여라
		for(int i=0;i< nine.length;i++) {
			for(int k=0;k<nine[i].length;k++) {
				System.out.printf("%-2d",nine[i][k]);
			}
			System.out.println();
		}
	}/////////////////main

}
