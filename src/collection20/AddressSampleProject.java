package collection20;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

import common.utility.CommonUtility;

/* 1차 개인 프로젝트시 참고 코드 */
public class AddressSampleProject {
	
	public static void main(String[] args) {
		
		Map<Character,List<Address>> addressBook = new HashMap<>();
		//1]밸류 타입을 null로 초기화
		List<Address> valueList = null;		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("이름을 입력하세요?");
			String name = sc.nextLine();
			//EXIT입력시 while문 빠져 나가기(종료)
			if("EXIT".equalsIgnoreCase(name.trim())) break;
			//2]자음 (ㄱ,ㄴ,ㄷ,.....ㅎ)얻기
			char jaeum=CommonUtility.getJaeum(name);
			//System.out.println(jaeum);
			if(jaeum=='0') {
				System.out.println("한글명이 아닙니다");
				continue;
			}
			System.out.println("주소를 입력하세요?");
			String addr=sc.nextLine();
			System.out.println("연락처를 입력하세요?");
			String contact=sc.nextLine();
			System.out.println("나이를 입력하세요?");
			int age=Integer.parseInt(sc.nextLine());
			//맵컬렉션(addressBook)에 jaeum 키값이 존재하는지 판단
			if(!addressBook.containsKey(jaeum)) {//키값이 없는 경우.즉 맵컬렉션에 해당 키값이 저장이 안되어 있는 경우
				//value타입인 List<Address>객체 생성
				valueList = new Vector<>();
			}
			else {//키값이 존재한다면
				//해당 키값으로 기존에 저장된 객체를 얻어온다
				valueList=addressBook.get(jaeum);
			}
			//입력한 객체를 추가
			valueList.add(new Address(name, age, addr, contact));
			//4]맵 컬렉션에 jaeum키값으로 저장
			addressBook.put(jaeum, valueList);
		}
		//출력]
		Set<Character> keys=addressBook.keySet();
		for(Character key:keys) {
			System.out.printf("[%c로 시작하는 명단]%n",key);
			List<Address> vals=addressBook.get(key);			
			for(Address val:vals)
				System.out.println(val);
		}
		/*
    	문]찾고자 하는 사람의 이름을 입력받아
          위 맵 컬렉션(addressBook)에 저장된 사람의 정보를 출력하자.
          만약 해당하는 사람이 없으면 "해당하는 사람이 없어요"라고 출력하여라.
       	  찾을때까지 계속 입력받도록 하여라.
       */
		while(true) {
			System.out.println("찾는 사람은 누굽니까?");
			String searchName = sc.nextLine();
			char searchKey = CommonUtility.getJaeum(searchName);
			if(!addressBook.containsKey(searchKey)) {//키값이 존재하지 않는 경우
				System.out.println("해당하는 사람이 없어요(키값 존재하지 않는 경우)");
				continue;
			}
			//키값 존재하는 경우
			List<Address> values= addressBook.get(searchKey);
			boolean isExist=false;//이름 찾는 경우 while문을 빠져나가기 위한 플래그 변수
			for(Address value:values) {
				if(value.name.equals(searchName)) {//이름을 찾았네
					System.out.println(value);
					isExist=true;
					break;
				}
			}
			if(isExist) break;
			System.out.println("해당하는 사람이 없어요(키값 존재하는 경우)");			
		}//while
		
		
	}///////////////main
}////////////////class
