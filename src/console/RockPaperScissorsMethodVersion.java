package console;

import java.util.Scanner;

import common.utility.CommonUtility;

public class RockPaperScissorsMethodVersion {
	//상수 정의]
	//가위.바위.보
	public static final int SCISSORS=1;
	public static final int ROCK=2;
	public static final int PAPER=3;
	public static final int REMENU=4;
	public static final int QUIT=9; 
	//메뉴번호 처리용 상수	
	public static final char EXIT = 'E';//프로그램 종료
	public static final char CONTINUE = 'C';//메뉴 다시보여주고 처음부터 다시 시작
	//특정 조건시에만 위의 두 char형 상수를 반환하기때문에
	//char 반환타입의 메소드를 문법적으로 맞추기위한 상수
	public static final char NORMAL = 'N';
	
	//메뉴번호
	static int[] menus= {1,2,3,4,9};
	
	//메뉴 출력용 메소드
	static void showMenu() {
		System.out.println("============[메뉴 번호]=============");
		System.out.println("1. 가위 2. 바위 3. 보 4. 메뉴 다시보기 9. 종료");
		System.out.println("==================================");
	}//////////////showMenu()
	//숫자를 랜덤하게 발생시키는 메소드-컴퓨터용
	static int getComputerNumber(int start,int end) {
		
		return (int)(Math.random()*(end-start+1))+start;
	}////////////////getComputerNumber
	//사용자 숫자 입력받아서 반환하는 메소드
	static int getUserNumber() {
		Scanner sc = new Scanner(System.in);
		//문]정상적인 메뉴 번호를 입력할때까지 계속 입력 받도록 하여라
		//  즉 숫자가 아닌 문자 입력시에는 "메뉴 번호만.."을 출력하고
		//  다시 입력 받도록 하여라
		System.out.println("메뉴 번호를 입력하세요?");
		String menuNumber;
		while(true) {
			menuNumber= sc.nextLine();
			if(!CommonUtility.isNumber(menuNumber)) {
				System.out.println("메뉴번호만...");
				continue;
			}
			break;
		}		
		return Integer.parseInt(menuNumber);
		//return sc.nextInt();
	}/////////////////getUserNumber
	//상수값에 따라 문자열을 반환하는 메소드
	static String getSRPValue(int value) {
		//return value==SCISSORS  ? "가위"  : value==ROCK ? "바위" :"보" ;
		switch(value) {
			case SCISSORS:return "가위";
			case ROCK:return "바위";
			default:return "보";
		}
	}//////////////////////getSRPValue	
	//승리여부 판단후 출력용 메소드
	static void showResult(int user,int computer) {		
		System.out.printf("[컴퓨터:%s,당신:%s] ",getSRPValue(computer),getSRPValue(user));
		if(user==SCISSORS && computer==ROCK || 
		   user==ROCK && computer==PAPER    || 
		   user==PAPER && computer==SCISSORS) System.out.println("당신이 졌어요");
		else if(user==computer) System.out.println("비겼어요");
		else System.out.println("당신이 이겼어요");
	}////////////showResult	
	
	//메뉴 번호 체크용 메소드
	static char checkMenu(int user) {//user는 사용자가 입력한 번호
		if(user==QUIT) return EXIT;//9번 메뉴 입력시 EXIT
		else if(user==REMENU) {//4번 메뉴 입력시 메뉴 다시보여주고 처음부터 다시 시작
			showMenu();
			return CONTINUE;
		}
		//없는 메뉴 번호 입력시
		boolean bFlag = false;
		for(int i=0;i < menus.length;i++) {
			if(user== menus[i]) {
				bFlag=true;
				break;
			}
		}///
		if(!bFlag) {//없는 메누번호 입력시
			System.out.println("없는 메뉴 번호 입니다");
			return CONTINUE;
		}
		return NORMAL;		
	}/////////////////checkMenu	
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		//1]메뉴 출력
		showMenu();
		while(true) {			
			//2]컴퓨터는 숫자를 랜덤하게 발생시킨다
			int computer =getComputerNumber(1,3);	
			//3]사용자 숫자 입력 받기			
			int user = getUserNumber();	
			/*
			//메뉴 체크를 메소드로 처리하지 않는 경우(9나4를 상수로 정의하지 않은 경우)
			if(user==9) {				
				break;
			}
			else if(user==4) {//메뉴 다시 보여기주기
				showMenu();
				continue;
			}*/
			//메뉴번호 체크를 메소드로 처리
			char checks=checkMenu(user);
			if(checks==EXIT) break;
			else if(checks==CONTINUE) continue;
			//4]승리여부 판단후 출력 
			showResult(user, computer);
		}///while
		System.out.println("다음기회에....");
	}///////////main

}//////////////class
