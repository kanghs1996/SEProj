//1]패키지 선언문
package package19;
//2]import선언문
/*
import:다른 패키지에 있는 클래스들을 가져다 쓸때 
사용하는 선언문
패키지명.하위패키지명...클래스명 식으로
단,java.lang패키지 안에 있는 클래스들은 
기본 패키지로 import할 필요 없다.
패키지명.*;   *는 모든 클래스나 인터페이스를 의미
*/
import java.lang.String;//의미없다
//util패키지안에 있는 모든 클래스나 인터페이스를 의미
//util패키지안의 하위 패키지는 포함 안됨.
//import java.util.*;//*(asterik)는 모든의 의미

import java.util.Date;

import common.utility.CommonUtility;
/*
 Runnable jar:실행가능한 jar
 1. 새로운 프로젝트 생성
 2. console.acadmey패키지 복사
 3. 1에서 생성한 프로젝트의 src에 붙여넣기
 4. 새로운 프로젝트 선택후 마우스 우클릭->Export->Java->Runnable Jar file선택후
    Launch Configuration:main메소드가 있는 클래스 선택(자동으로 뜸)
    Export Destination:.jar로 저장할 위치 및 파일명 지정
 5. 4번에서 생성한 .jar가 있는 디렉토리로 이동후
    java -jar 4번에서생성한파일명.jar 
 */
/*
 클래스를 라이브리러(jar)로 배포하기
 1.프로젝트 선택후 마우스 우클릭->Export->Java->Jar file선택
 2.배포하고자하는 패키지 선택(common.utility)후 
 3. Export Destination:.jar로 저장할 위치 및 파일명 지정 그리고 Next~ Finish
 
 jar로 묶는 라이브러리 프로젝트에서 가져다 쓰기
 1. Build Path : 프로젝트마다 빌드 패스 해야 한다
    프로젝트 마우스 우클릭->Build Path->Configure Bulid Path->Libraries탭 메뉴 선택
    ->Add External JARs후 배포한 jar파일 선택
    
 2. 이클립스의 Window->Preferencs->Java->Installed JREs에 설정된 디렉토리로 가서
 	외부 확장라이브러리를 넣는 곳에 배포한 jar파일을 넣는다:프로젝트마다 빌드패스할 필요가 없다
 	예]C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext
 	
 3. 이클립스를 닫았다가 재실행한다.
 
 4. 여전히 레드라인이 가는 경우
    Window->Preferencs->Java->Compiler->Error/Warnings에서
    Deprecated and Restriced API의 
    Forbidden reference(access rule)를 Error에서 ignore로 변경
 
 */

public class PackageApp {

	public static void main(String[] args) {
		//다른 패키지에 있는 클래스 접근 방법]
		//방법1]import해서 사용-패키지 지정 불필요
		Date utilDate = new Date();
		System.out.println(utilDate);
		//방법2]import불필요-직접 패키지 명까지 지정	
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		System.out.println(sqlDate);
		//jar로 묶기
		System.out.println(CommonUtility.isNumber("100"));
		
	}/////////////main

}////////////////class
