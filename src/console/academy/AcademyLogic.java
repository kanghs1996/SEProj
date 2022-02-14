package console.academy;

import java.util.Scanner;

public class AcademyLogic {
	//[멤버 상수]
	public static final int MAX_PERSON = 3;//최대 인원수
	//[멤버변수]
	Person[] person;
	//[생성자]
	public AcademyLogic() {
		person = new Person[MAX_PERSON];
	}
	//[멤버 메소드]
	/*
	 * 1]메뉴 출력용 메소드
	 * 매개변수:NO
	 * 반환타입:void
	 */
	public void printMainMenu() {
		System.out.println("===================메인 메뉴=====================");
		System.out.println("1.입력 2.출력 3.수정 4.삭제. 5.검색 6.파일저장 9.종료");
		System.out.println("===============================================");
		System.out.println("메인 메뉴번호를 입력하세요?");
	}/////////////////printMainMenu
	/*
	 * 2]메뉴 번호 입력용 메소드
	 * 매개변수:NO
	 * 반환타입:int
	 */
	public int getMenuNumber() {
		Scanner sc = new Scanner(System.in);
		String menuString=sc.nextLine();
		return Integer.parseInt(menuString);
	}
	/*
	 * 3]메뉴 번호에 따른 분기용 메소드
	 * 매개변수:int(메인메뉴)
	 * 반환타입:void
	 */
	public void seperateMainMenu(int mainMenu) {
		switch(mainMenu) {
			case 1://입력
				while(true) {
					//서브메뉴 출력]
					printSubMenu();
					//서브메뉴번호 입력받기]
					int subMenu = getMenuNumber();
					if(subMenu==3) break;
					//1이나 2인 경우 입력처리]
					switch(subMenu) {
						case 1:
						case 2:setPerson(subMenu);break;
						default:System.out.println("서브 메뉴에 없는 번호입니다");
					}
				}	
				
				break;
			case 2://출력
				printPerson();
				break;
			case 3://수정
				updatePerson();
				break;
			case 4://삭제
				deletePerson();
				break;
			case 5://검색
				searchPerson();
				break;
			case 6://파일저장
				break;
			case 9://프로그램 종료
				System.out.println("프로그램을 종료합니다");
				System.exit(0);
				break;
			default:System.out.println("메뉴에 없는 번호입니다");
		}
		
	}/////////////////seperateMainMenu	
	
	
	
	/*
	 * 5]서브메뉴에 따른 학생 및 교사 데이타 입력용 메소드
	 * 매개변수:int(서브메뉴)
	 * 반환타입:void
	 */
	private void setPerson(int subMenu) {
		//정원이 찼는지 여부 판단]
		int index = -1;//채워지지 않은 Person형 배열(null인 배열요소)의 인덱스를 저장할 변수
		for(int i=0;i < MAX_PERSON;i++)
			if(person[i]==null) {
				index= i;
				break;
			}
		if(index == -1) {//이미 정원이 찬 경우
			System.out.println("정원이 찼어요.. 더 이상 입력할 수 없어요");
			return;
		}
		//정원이 안찬 경우 즉 index가 -1이 아닌 경우...
		//이름과 나이는 둘다 공통]
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요?");
		String name= sc.nextLine().trim();
		System.out.println("나이를 입력하세요?");
		int age = Integer.parseInt(sc.nextLine().trim());
		//학생과 교사를 구분해서 입력받기]
		switch(subMenu) {
			case 1://학생인 경우
				System.out.println("학번을 입력하세요?");
				String stNumber = sc.nextLine();
				person[index]=new Student(name, age, stNumber.trim());
				break;
			default://교사인 경우
				System.out.println("과목을 입력하세요?");
				String subject = sc.nextLine();
				person[index]=new Teacher(name, age, subject.trim());				
		}///////switch		
	}///////////////setPerson
	/*
	 * 4]서브메뉴 출력용 메소드
	 * 매개변수:NO
	 * 반환타입:void
	 */
	private void printSubMenu() {		
		System.out.println("===================서브 메뉴=====================");
		System.out.println("1.학생 2.교사 3.메인 메뉴로 이동");
		System.out.println("===============================================");
		System.out.println("서브 메뉴번호를 입력하세요?");
	}////////////////////
	/*
	 * 6]출력용 메소드
	 * 매개변수:NO
	 * 반환타입:void
	 */
	private void printPerson() {
		System.out.println("[학생/교사 구분없이 출력하기]");
		for(int i=0;i < MAX_PERSON;i++)
			if(person[i] !=null) person[i].print();
		
		//문] 학생과 교사를 구분해서 출력하여라
		/*
		    [학생 목록]
		    이름:가학생,나이:28,학번:2014
		    이름:나학생,나이:28,학번:2015
		    [교사 목록]
		    이름:가교사,나이:30,과목:자바		
		 */
		System.out.println("[학생/교사 구분해서 출력하기]");
		StringBuffer student = new StringBuffer("[학생 목록]\r\n");
		StringBuffer teacher = new StringBuffer("[교사 목록]\r\n");
		for(int i=0;i< MAX_PERSON;i++)
			if(person[i] !=null)
				if(person[i] instanceof Student)
					student.append(person[i].get()+"\r\n");
				else
					teacher.append(person[i].get()+"\r\n");
		
		System.out.println(student.toString()+teacher);
		
	}//////////////////////printPerson
	/*
	 * 7]이름으로 검색하는 메소드
	 * 매개변수:String(수정/삭제/검색용 타이틀)
	 * 반환타입:Person타입
	 */
	 
	private Person findPersonByName(String title) {
		System.out.println(title+"할 사람의 이름을 입력하세요?");
		Scanner sc = new Scanner(System.in);
		String name=sc.nextLine().trim();
		for(int i=0;i<MAX_PERSON;i++) {
			if(person[i] !=null) {
				if(person[i].name.equals(name)) {
					return person[i];
				}
			}
					
		}///for
		//갬색된 이름이 없는 경우
		System.out.println(name+"로(으로) 검색된 정보가 없어요");
		return null;		
	}/////////////findPersonByName
	//8]검색용 메소드
	private void searchPerson() {//찾은 사람의 정보 출력
		Person findPerson=findPersonByName("검색");
		if(findPerson!=null) {
			System.out.printf("[%s로(으로) 검색한 결과]%n",findPerson.name);
			findPerson.print();
		}////		
	}//////////////////searchPerson
	//9]수정용 메소드
	private void updatePerson() {
		Person findPerson=findPersonByName("수정");
		if(findPerson !=null) {
			Scanner sc = new Scanner(System.in);
			//나이 수정
			System.out.println("몇 살로 수정 하시겠습니까?");
			findPerson.age = Integer.parseInt(sc.nextLine().trim());
			
			//학생인지 교사인지 판단
			if(findPerson instanceof Student) {//학생
				//학번 수정
				System.out.println("몇 학번으로 수정하시겠습니까?");
				((Student) findPerson).stNumber=sc.nextLine();
			}
			else {//교사
				//과목 수정
				System.out.println("어떤 과목으로 수정하시겠습니까?");
				((Teacher)findPerson).subject=sc.nextLine();
			}
			System.out.printf("[%s가 아래와 같이 수정되었습니다]%n",findPerson.name);
			//수정내용을 확인하기 위한 출력
			findPerson.print();
			
		}///////if
		
	}///////////////updatePerson
	//10]삭제용
	private void deletePerson() {
		Person findPerson=findPersonByName("삭제");
		if(findPerson !=null) {
			for(int i=0;i < MAX_PERSON;i++) {
				if(findPerson.equals(person[i])) {
					person[i]=null;
					System.out.printf("[%s가 삭제되었습니다]%n",findPerson.name);
					break;
				}
			}
			
		}
	}//////////////////
	
	
	
}
