package jdbc25.callable;

import java.sql.Types;

import jdbc25.service.IConnectImpl;

/*
create or replace FUNCTION TO_ASTERISK(val VARCHAR2)
	RETURN VARCHAR2
IS
BEGIN
	RETURN RPAD(SUBSTR(val,1,1),LENGTH(val),'*');
END; 
 
 */
/*
 * 오라클에 정의된 함수나 프로시저를 사용하려면
 * CallableStatement객체를 이용해야 한다.
 * 
 * -자바에서 함수나 프로시저를 실행시에는  무조건 execute()메소드로 실행
*/
public class FunctionCall extends IConnectImpl {

	public FunctionCall() {
		connect(ORACLE_URL, "scott", "scott");
	}
	@Override
	public void execute() throws Exception {
		/*
	  	1]오라클에 정의된 함수를 실행하기 위한   CallableStatement객체 생성
	  
	    -Connection객체의 prepareCall()메소드로  생성
	    -형식
	     prepareCall("{? = call 함수명(?,?...)}");
	     
	    -첫번째 물음표는 반환값을 의미 
	          반환값은 파라미터 설정시 java.sql.Types클래스의 int형 상수로 설정한다.
	         설정시 registerOutParameter()메소드 사용		     
	         매개변수 설정시는 기존 PreparedStatement객체와 동일
		  */
		csmt = conn.prepareCall("{?=call TO_ASTERISK(?)}");
		//2]인파라미터 설정
		//매개변수는 즉 인파라미터는 setXXX()계열 메소드로 설정
		csmt.setString(2, getValue("문자열"));
		//반환값에 해당하는 파라미터는 아웃 파라미터 방식으로
		//설정(registerOutParameter).무조건 인덱스가 1
		csmt.registerOutParameter(1, Types.VARCHAR);
		//4]함수 실행-무조건 execute()메소드로 실행
		System.out.println(csmt.execute());
		//5]반환값은 getXXX()계열로 얻어온다.
		//  단 ,인덱스는 무조건 1이다.		
		System.out.println("함수의 반환값:"+csmt.getString(1));
		//6]자원반납
		close();
	}////////////	
	public static void main(String[] args) throws Exception {
		new FunctionCall().execute();
	}///////////main

}//////////////class
