package jdbc25.callable;

import java.sql.Types;

import jdbc25.service.IConnectImpl;
/*
 create or replace PROCEDURE SP_ISMEMBER(
	id_ member.id%TYPE,
	pwd_ member.pwd%TYPE,
	rtval OUT NUMBER
)
IS
	flag NUMBER(1);
BEGIN
	SELECT COUNT(*) INTO flag FROM member
	WHERE id= id_;

	IF flag = 0 THEN
		rtval := -1;
	ELSE  -- 아이디 일치
		SELECT COUNT(*) INTO flag FROM member
		WHERE id= id_ AND pwd = pwd_;
		IF flag= 0	THEN --비번 불일치
			rtval := 0;
		ELSE --회원
			rtval :=1;
		END IF;
	END IF;
END; 
  
 */
public class IsMemberProc extends IConnectImpl{
	public IsMemberProc() {
		connect(ORACLE_URL,"CTRLUSER","CTRLUSER");
	}
	@Override
	public void execute() throws Exception {
		//1]프로시저를 실행하기 위한 CallableStatement객체 얻기
		csmt = conn.prepareCall("{call SP_ISMEMBER(?,?,?)}");
		//2]파라미터 설정
		String user=getValue("아이디");
		csmt.setString(1, user);
		csmt.setString(2, getValue("비밀번호"));
		csmt.registerOutParameter(3, Types.NUMERIC);
		//3]프로시저 실행-execute()
		csmt.execute();
		//4]out파라미터에 저장된 값 읽어 오기
		int code = csmt.getInt(3);
		if(code == -1) System.out.println("아이디가 일치하지 않아요");
		else if(code == 0) System.out.println("아이디는 일치하나 비번이 틀려요");
		else System.out.println(user+"님 즐감하세요...");
	}
	public static void main(String[] args) throws Exception {
		new IsMemberProc().execute();
	}//////////main

}//////////////////class
