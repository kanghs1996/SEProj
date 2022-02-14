package stringclass11;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TCP_MISS {

	public static void main(String[] args) {
		//Pattern pattern = Pattern.compile("(([A-Z]|[_])+)");
		/*
		   group(1):TCP_MISS
		   group(2):S
		 */
		//Pattern pattern = Pattern.compile("([A-Z]|[_])");
		//문자열이 무조건 한자여야 한다 A~Z중 하나거나 _나 예] A,Z,X,_,......
		Pattern pattern = Pattern.compile("([A-Z]+[_][A-Z]+)");
		//TCP_MISS에 정확하게 부합하는 패턴
		Matcher matcher = pattern.matcher("TCP_MISS");
		System.out.println(matcher.matches());
		System.out.println("그룹수:"+matcher.groupCount());
		System.out.println("[입사시험문제 두번째]");
		
		if(matcher.matches()) {
			for(int i=1; i <= matcher.groupCount();i++ )
				System.out.printf("group(%d):%s%n",i,matcher.group(i));
		}

	}

}
