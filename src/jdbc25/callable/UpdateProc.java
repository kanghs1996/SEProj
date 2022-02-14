package jdbc25.callable;

import java.sql.Types;

import jdbc25.service.IConnectImpl;
/*
 create or replace PROCEDURE SP_UDT_MEMBER(
	id_ member.id%TYPE,
	pwd_ member.pwd%TYPE,
	name_ member.name%TYPE,
	rtval OUT CHAR
)
IS
BEGIN
	UPDATE member SET pwd=pwd_,name = name_
	WHERE id = id_;

	IF SQL%FOUND THEN
		rtval :='SUCCESS';
		COMMIT;
	ELSE
		rtval := 'FAIL:NOT FOUND ID';
	END IF;

	EXCEPTION
	WHEN OTHERS THEN
	BEGIN
		ROLLBACK;
		rtval := 'FAIL:TOO MUCH VALUE';

	END;

END;
 */
public class UpdateProc extends IConnectImpl {
	public UpdateProc(String url,String user,String password) {
		connect(url,user,password);
	}
	@Override
	public void execute() throws Exception {
		//1]프로시저를 실행하기 위한 CallableStatement객체 얻기
		csmt = conn.prepareCall("{call SP_UDT_MEMBER(?,?,?,?)}");
		//2]파라미터 설정
		String user = getValue("수정할 아이디");
		csmt.setString(1, user);
		csmt.setString(2, getValue("비밀번호"));
		csmt.setString(3, getValue("이름"));
		csmt.registerOutParameter(4, Types.CHAR);
		//3]프로시저 실행-execute()
		csmt.execute();
		//4]out파라미터에 저장된 값 읽어 오기
		System.out.println(csmt.getString(4).trim());
		
		//5]자원반납
		close();
	}
	public static void main(String[] args) throws Exception {
		new UpdateProc(ORACLE_URL,"CTRLUSER","CTRLUSER").execute();
	}

}
