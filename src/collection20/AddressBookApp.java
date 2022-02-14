package collection20;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import common.utility.CommonUtility;

//한 명의 이름/나이/주소/전번을 저장하는 클래스]
//방법1. Comparable인터페이스 구현
class Address /*implements Comparable<Address>*/{
	
	//정렬시 구분자로 사용할 정적 필드
	static int sortOrder = 1;//1일때는 name,2:age,3:addr,4:contact
	
	//[멤버변수]
	String name;
	int age;
	String addr;
	String contact;
	//[인자 생성자]
	public Address(String name, int age, String addr, String contact) {		
		this.name = name;
		this.age = age;
		this.addr = addr;
		this.contact = contact;
	}////////////////////
	@Override
	public String toString() {
		return String.format("[이름:%s,나이:%s,주소:%s,연락처:%s]",name,age,addr,contact);
	}
	/*
	 * 방법1으로 정렬시 오버라이딩
	@Override
	public int compareTo(Address target) {	
		switch(sortOrder) {		
			case 1:
				return name.compareTo(target.name);
			case 2:
				return age-target.age;
			case 3:
				return addr.compareTo(target.addr);
			default:	
				return contact.compareTo(target.contact);
		}		
	}*/
	
	
}

public class AddressBookApp {

	//방법2를 사용한 정렬]-Comparable인터페이스를 구현할 필요가 없다
	static void sort(int flag,List<Address> values) {
		
		Collections.sort(values,new Comparator<Address>() {
			@Override
			public int compare(Address src, Address target) {
				switch(flag) {
					case 1:return src.name.compareTo(target.name);
					case 2:return src.age-target.age;
					case 3:return src.addr.compareTo(target.addr);
					default:return src.contact.compareTo(target.contact);
				}				
			}			
		});
	}////////////
	
	public static void main(String[] args) {
		/*
		1]자음을 Key값-String 혹은 Character		  
		  List계열 컬렉션을 Value값-List<String>
		  Map계열 컬렉션-Value에는 자음에 해당하는 이름들 저장
		*/
		Map<Character, List<String>> nameAddress = new HashMap<>();
		//1-1]이름 저장용 List계열 컬렉션 객체 생성 및 이름 저장]
		List<String> kieyeok = Arrays.asList("고길동","곽길동","가길동","기길동");
		List<String> nieoun = Arrays.asList("노길동","나길동","남길동");
		//1-2]Map컬렉션(nameAddress)에 이름이 저장된 List계열 컬렉션 저장
		nameAddress.put('ㄱ', kieyeok);
		nameAddress.put('ㄴ', nieoun);
		//1-3-1]키값을 알때
		System.out.println("[키값을 알때]");
		List<String> values=nameAddress.get('ㄱ');
		for(String value:values) 
			System.out.println(value);
		//1-3-2]키값을 모를때
		System.out.println("[키값을 모를때]");
		//1]keySet()으로 Set컬렉션 얻기
		Set<Character> keys= nameAddress.keySet();
		//2]Set컬렉션에 확장 for문 적용
		for(Character key:keys) {
			System.out.println(String.format("[%c로 시작하는 명단]",key));
			//3]get(키값)으로 value얻기
			values=nameAddress.get(key);
			for(String value:values) 
				System.out.println(value);
		}
		/*
		2]초성을 Key값-String 혹은 Character		 
		  List계열 컬렉션을 Value값-List<Map<String,Object>>
		  Map계열 컬렉션-Value에는 초성에 해당하는 이름,주소,전화번호,나이들 저장
		*/
		Map<Character,List<Map<String,Object>>> address=
				new HashMap<>();
	
		//2-1]이름/전번/주소/나이가 저장된 맵 컬렉션을 저장할 리스트계열 컬렉션 객체 생성.
		List<Map<String,Object>> kie = new Vector<>();
		List<Map<String,Object>> nie = new Vector<>();
		//2-2]이름/전번/주소/나이를 저장할 맵 컬렉션 객체 생성
		Map<String,Object> k = new HashMap<String, Object>();
		k.put("name", "고길동");
		k.put("age", 20);
		k.put("addr", "가산동");
		k.put("contact","010-1234-5678");
		kie.add(k);
		k = new HashMap<String, Object>();
		k.put("name", "곽길동");
		k.put("age", 30);
		k.put("addr", "서초동");
		k.put("contact","010-5678-5678");
		kie.add(k);
		
		Map<String,Object> n = new HashMap<String, Object>();
		n.put("name", "나길동");
		n.put("age", 25);
		n.put("addr", "나산동");
		n.put("contact","010-9999-5678");
		nie.add(n);
		n = new HashMap<String, Object>();
		n.put("name", "노길동");
		n.put("age", 35);
		n.put("addr", "방배동");
		n.put("contact","010-7777-5678");
		nie.add(n);
		//주소록 저장하는 맵컬렉션에 리스트 저장]
		address.put('ㄱ',kie);
		address.put('ㄴ',nie);
		/*
		 * 객체 꺼내올때]
		 * Set/List계열 무조건 확장 for문 사용
		 * Map계열은 keySet()으로 키값들이 저장된
		 * Set계열 반환 받은 후 확장 for문 사용	
		 */
		System.out.println("[키값을 알때]");
		List<Map<String,Object>> lists=address.get('ㄱ');
		for(Map<String,Object> map:lists) {
			Set<String> set=map.keySet();
			for(String key:set) {
				Object value=map.get(key);
				System.out.println(String.format("%s:%s",key,value));
			}			
		}///////////////
		System.out.println("[키값을 모를때]");
		keys=address.keySet();
		for(Character key:keys) {
			System.out.printf("[%c로 시작하는 명단]%n",key);
			System.out.println("------------------------------------");
			lists=address.get(key);
			for(Map<String,Object> map:lists) {
				Set<String> set=map.keySet();
				for(String ky:set) {
					Object value=map.get(ky);
					System.out.println(String.format("%s:%s",ky,value));
				}	
				System.out.println("------------------------------------");
			}///////////////
			
		}///for
		//3]Address클래스를 사용해서 2]번 처럼 구현
		Map<Character,List<Address>> addressBook = new HashMap<>();
		//3-1]주소를 저장할 리스트 계열 컬렉션 생성
		List<Address> kiec = new Vector<>();
		List<Address> niec = new Vector<>();
		//3-2]주소 저장
		kiec.add(new Address("곽길동", 40, "가산동", "010"));
		kiec.add(new Address("고길동", 20, "청담동", "019"));
		kiec.add(new Address("가길동", 30, "사당동", "011"));
		
		niec.add(new Address("노길동", 45, "가산동1", "011"));
		niec.add(new Address("나길동", 25, "청담동1", "020"));
		niec.add(new Address("너길동", 35, "사당동1", "012"));
		//3-3]키값으로 리스트 컬렉션 객체를 맵(addressBook)에 저장
		addressBook.put('ㄱ', kiec);
		addressBook.put('ㄴ', niec);
		System.out.println("클래스를 사용해서 구현]");
		keys=addressBook.keySet();
		for(Character key:keys) {
			System.out.printf("[%c로 시작하는 명단]%n",key);
			List<Address> vals=addressBook.get(key);
			
			//[방법1으로 정렬]
			/*
			Address.sortOrder=2;//나이로 정렬(디폴트는 이름으로 정렬)
			Address.sortOrder=3;//주소로 정렬
			Collections.sort(vals);
			*/
			//[방법2으로 정렬]
			//sort(1,vals);//이름으로 정렬	
			sort(100,vals);//연락처로 정렬
			for(Address val:vals)
				System.out.println(val);
		}
		
		
		
	}//////////////main
}////////////////class
