package stringclass11;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//이메일형식의 패턴 문자열만들기
		//이메일 주소는 알파벳으로 시작하고 @와 .반드시 있어야한다
		//String regex="\\w+@\\w+\\.\\w+";//숫자로 시작해도되는 이메일 패턴		
		//String regex="[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+";
		//String regex="^[a-zA-Z]\\w+@\\w+\\.\\w+";//숫자로 시작해서는 안되는 이메일 패턴	(co.kr는 false)
		String regex="^[a-zA-Z]\\w+@(\\w+\\.\\w+|\\w+\\.\\w+\\.\\w+)";
		
		
		//1.Pattern객체 생성 : Pattern Pattern.compile("패턴문자열")
		Pattern pattern=Pattern.compile(regex);		
		//String pattern():패턴 문자열 반환
		System.out.println(pattern.pattern());
		//2.Matcher객체 생성:Matcher Pattern객체.matcher("패턴과 일치하는지 검증할 대상 문자열")
		System.out.println("이메일을 입력하세요?");
		String value=sc.nextLine();
		Matcher matcher= pattern.matcher(value);
		//matches():대상 문자열과 패턴이 일치할 경우 true 반환
		System.out.println(matcher.matches());
		if(matcher.matches()) {//패턴이 일치한다면
			//start() : 매칭되는 문자열 시작 위치 반환.
			System.out.println(matcher.start());
			//end() : 매칭되는  문자열 끝 다음 문자위치 반환.
			System.out.println(matcher.end());
		}	
		
		System.out.println("[실제 로그 파일 적용]");
		value="[17.07.11 23:29:11] [INFO ]  [eclipse.galileo-bean-thread-50618297 galileo.site.SiteBean:317 ] - ##galileo_bean end. MessageExchange_ID:ID:localhost-15a6308ba1c-6:86071562";
		
		//방법1:\d 사용
		//pattern = Pattern.compile("\\[(\\d{2}\\.\\d{2}\\.\\d{2}\\s\\d{2}:\\d{2}:\\d{2})\\]\\s\\[(.+)\\]\\s\\s\\[(.+)\\]\\s-\\s(.+)");		//아래에서 group(0)번은 전체 임으로 필요없고 1,2,3
		//방법2:[0-9]사용
		//pattern = Pattern.compile("\\[([0-9]{2}\\.[0-9]{2}\\.[0-9]{2}\\s[0-9]{2}:[0-9]{2}:[0-9]{2})\\]\\s\\[(.+)\\]\\s\\s\\[(.+)\\]\\s-\\s(.+)");
		//방법3:러프하게
		pattern = Pattern.compile("\\[(.+)\\]\\s\\[(.+)\\]\\s\\s\\[(.+)\\]\\s-\\s(.+)");
		matcher= pattern.matcher(value);
		//groupCount() : 패턴내 그룹핑한(괄호지정) 전체 갯수를 반환
		System.out.println(matcher.groupCount());
		//아래에서 group(0)번은 전체 대상문자열 임으로 필요없고 1,2,3,4
		if(matcher.matches()) {//패턴이 일치한다면
			System.out.println(matcher.group(0));//의미없다
			System.out.println(matcher.group(1));
			System.out.println(matcher.group(2));
			System.out.println(matcher.group(3));
			System.out.println(matcher.group(4));			
		}
		value="00000  000%  1. Before Marshalling";		
		//pattern = Pattern.compile("(\\d{5})\\s{2}(\\d{3}[%])\\s{2}(.+)");
		pattern = Pattern.compile("([0-9]{5})\\s{2}([0-9]{3}[%])\\s{2}(.+)");
		matcher = pattern.matcher(value);
		System.out.println(matcher.matches());
		if(matcher.matches()) {
			for(int i=0; i <= matcher.groupCount();i++ )
				System.out.printf("group(%d):%s%n",i,matcher.group(i));
		}
		//두번째 입사 문제
		value="2005-04-30 17:16:14 95 45.114.2.130 200 TCP_MISS 2222 404 GET http images.netmechanic.com /images/webtools/webmaster_tools.gif - - DIRECT images.netmechanic.com image/gif \"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0; CAWORLD2k4; .NET CLR 1.1.4322; .NET CLR 1.0.3705)\" PROXIED Computers/Internet - 192.16.170.44 SG-HTTP-Service - none -";
	
		
		
		//문]위 로그에서 아이피(45.114.2.130),응답코드(200),캐시결과(TCP_MISS),HTTP메소드(GET)를 
		//  정규표현식을 이용하여 추출하여라
		pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}\\s\\d{1,}\\s(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})\\s(\\d{3})\\s(.+)\\s\\d{4}\\s\\d{3}\\s([A-Z]{3,})\\s.+");
		matcher = pattern.matcher(value);
		System.out.println("[입사시험문제 두번째]");
		if(matcher.matches()) {
			for(int i=1; i <= matcher.groupCount();i++ )
				System.out.printf("group(%d):%s%n",i,matcher.group(i));
		}
		
	}///////////main
}////////////class
