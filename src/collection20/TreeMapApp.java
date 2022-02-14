package collection20;

import java.util.Set;
import java.util.TreeMap;

/*
 
  TreeMap:Map계열 컬렉션
          키값이 정렬된 상태로 저장되어 있음 (디폴트는 오름차순 정렬)
          HashMap보다는 성능이 떨어지나
          정렬된 키값으로 출력하고자 할때 유리..
 */
public class TreeMapApp {
	public static void main(String[] args) {
		TreeMap<Character, String> map = new TreeMap<>();
		//객체 저장]
		map.put('ㄷ', "도길동");
		map.put('ㅎ', "하길동");
		map.put('ㅁ', "마길동");
		map.put('ㄱ', "고길동");
		map.put('ㅎ', "홍길동");
		map.put('ㄱ', "곽길동");		
		System.out.println("[오름차순으로 출력-디폴트]");
		Set<Character> keys= map.keySet();
		for(Character key:keys) {
			String value=map.get(key);
			System.out.println(String.format("%s:%s",key,value));
		}
		System.out.println("[내림차순으로 출력]");
		keys = map.descendingKeySet();
		for(Character key:keys) {
			String value=map.get(key);
			System.out.println(String.format("%s:%s",key,value));
		}
		
		
	}////////////main
}///////////////class
