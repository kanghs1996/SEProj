package jdbc25.callable;

import java.sql.Types;

import jdbc25.service.IConnectImpl;
/*
 create or replace PROCEDURE SP_INS_MEMBER(
	id IN member.id%TYPE,
	pwd member.pwd%TYPE,
	name member.name%TYPE,
	rtval OUT NVARCHAR2
)
IS

BEGIN
	INSERT INTO member(id,pwd,name)
	VALUES(id,pwd,name);

	IF SQL%FOUND THEN
		rtval := '입력성공';
		COMMIT;
	END IF;

	EXCEPTION
		WHEN OTHERS THEN
			ROLLBACK;
			rtval := '입력실패:중복키나 입력값이 커요';

END; 
  
 */
public class InsertProc extends IConnectImpl {
	public InsertProc() {
		super(ORACLE_URL,"CTRLUSER","CTRLUSER");
	}
	@Override
	public void execute() throws Exception {
		try {
			//1]프로시저를 실행하기 위한 CallableStatement객체 얻기
			/*
		     * Connection객체의 prepareCall("{call 프로시저명(?,?,...)}")
		    *메소드 호출
		    *-인 파라미터 설정시에는 setXXXX(파라미터인덱스,값)로
		    *-아웃 파라미터 설정시에는 
		    *registerOutParameter(파라미터인덱스,java.sql.Types클래스의 int형 상수)
		    */
			csmt = conn.prepareCall("{call SP_INS_MEMBER(?,?,?,?)}");
			/*2]파라미터 설정
		    2-1]인파라미터(?) 설정
		        오라클의 IN 파라미터에 해당하는 ? 설정       setXXXX()로*/
			csmt.setString(1, getValue("아이디"));
			csmt.setString(2, getValue("비밀번호"));
			csmt.setString(3, getValue("이름"));
			//2-2]오라클의 OUT 파라미터에 해당하는 ? 설정
			//    registerOutParameter()로
			csmt.registerOutParameter(4, Types.NVARCHAR);
			//3]프로시저 실행-execute()
			System.out.println(csmt.execute());
			//4]out파라미터에 저장된 값 읽어 오기
			//  CallableStatement객체의 getXXX()계열 메소드.
			System.out.println("프로시저의 아웃 파라미터 값:"+csmt.getString(4));
		}
		catch(Exception e) {
			System.out.println("오류 발생:"+e.getMessage());
		}
		finally {
			//5]자원반납
			close();
		}
		
	}
	public static void main(String[] args) throws Exception {
		new InsertProc().execute();
	}////////////main

}/////////////class
