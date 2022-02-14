package common.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtility {

	//[문자열이 숫자 형식이면 true,아니면 false반환]
	public static boolean isNumber(String value) {
		for(int i=0;i < value.length();i++) {
			if(!(value.codePointAt(i) >='0' && value.codePointAt(i) <='9'))
				return false;
		}
		return true;
	}//////
	//두 날짜 차이를 반환하는 메소드]
	//반환타입:long
	//매개변수:String타입의 두 날짜,날짜패턴,구분자(단위)
	public static long getDifferenceDates(
			String stFDate,
			String stSDate,
			String pattern,
			char delim) throws ParseException
	{
		//1]매개변수에 전달된 pattern으로 SimpleDateFormat객체생성
		SimpleDateFormat dateFormat= new SimpleDateFormat(pattern);
		//2]String -> Date:parse()
		Date fDate=dateFormat.parse(stFDate);
		Date sDate=dateFormat.parse(stSDate);
		//3]시간차 구하기:getTime()
		long fTime = fDate.getTime();
		long sTime = sDate.getTime();
		long diff = Math.abs(fTime-sTime);
		//4]매개변수 delim에 따른 날짜 차이 반환
		switch(Character.toUpperCase(delim)) {
			case 'D':return diff/(24*60*60*1000);
			case 'H':return diff/(60*60*1000);
			case 'M':return diff/(60*1000);
			default: return diff/1000;
		}				
	}////////////////
	//이름에서 자음을 구해 반환하는 메소드]
	public static char getJaeum(String name) {
		//김길동->ㄱ,박길동->ㅂ,홍길동->ㅎ
		char[] jaeum = name.trim().toCharArray();
		//방법1]
		char[] startChar= {'가','나','다','라','마','바','사','아','자','차','카','타','파','하'};
		char[] endChar= {'낗','닣','띻','맇','밓','삫','앃','잏','찧','칳','킿','팋','핗','힣'};
		char[] returnJaeum= {'ㄱ','ㄴ','ㄷ','ㄹ','ㅁ','ㅂ','ㅅ','ㅇ','ㅈ','ㅊ','ㅋ','ㅌ','ㅍ','ㅎ'};
		
		for(int i=0;i < startChar.length;i++)
			if(jaeum[0] >=startChar[i] &&  jaeum[0] <= endChar[i])
				return returnJaeum[i];
		
		
		//방법2]
		/*
	 		if(jaeum[0] >='가' && jaeum[0] < '나') return 'ㄱ';
			else if(jaeum[0] >='나' && jaeum[0] <'다') return 'ㄴ';
			else if(jaeum[0] >='다' && jaeum[0] <'라') return 'ㄷ';
			else if(jaeum[0] >='라' && jaeum[0] <'마') return 'ㄹ';
			else if(jaeum[0] >='마' && jaeum[0] <'바') return 'ㅁ';
			else if(jaeum[0] >='바' && jaeum[0] <'사') return 'ㅂ';
			else if(jaeum[0] >='사' && jaeum[0] <'아') return 'ㅅ';
			else if(jaeum[0] >='아' && jaeum[0] <'자') return 'ㅇ';
			else if(jaeum[0] >='자' && jaeum[0] <'차') return 'ㅈ';
			else if(jaeum[0] >='차' && jaeum[0] <'카') return 'ㅊ';
			else if(jaeum[0] >='카' && jaeum[0] <'타') return 'ㅋ';
			else if(jaeum[0] >='타' && jaeum[0] <'파') return 'ㅌ';
			else if(jaeum[0] >='파' && jaeum[0] <'하') return 'ㅍ';
			else if(jaeum[0] >='하' && jaeum[0] <='힣') return 'ㅎ';	 
		 
		 */
		
		return '0';//자음이 아닌 경우
	}///////////////////////
	
	
}
