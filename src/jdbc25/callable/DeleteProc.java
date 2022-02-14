package jdbc25.callable;

import java.sql.Types;

import jdbc25.service.IConnectImpl;
/*
 create or replace PROCEDURE SP_DEL_MEMBER(
	id_ member.id%TYPE,
	appected OUT NUMBER

)
IS
BEGIN
	DELETE member WHERE id= id_;
	IF SQL%FOUND THEN
		DBMS_OUTPUT.PUT_LINE(id_ || '가 삭제 되었어요');
		appected := SQL%ROWCOUNT;
		COMMIT;
	ELSE
		DBMS_OUTPUT.PUT_LINE(id_ || '가 존재하지 않아요');
		appected := 0;
	END IF;

	EXCEPTION
	WHEN OTHERS THEN
		ROLLBACK;
		DBMS_OUTPUT.PUT_LINE('자식이 참조하고 있어요');
		appected := -1;

END; 
  
 */
public class DeleteProc extends IConnectImpl {
	public DeleteProc(String url,String user,String password) {
		connect(url,user,password);
	}
	@Override
	public void execute() throws Exception {
		//1]프로시저를 실행하기 위한 CallableStatement객체 얻기
		csmt = conn.prepareCall("{call SP_DEL_MEMBER(?,?)}");
		//2]파라미터 설정
		String user = getValue("삭제할 아이디");
		csmt.setString(1, user);
		csmt.registerOutParameter(2, Types.NUMERIC);
		//3]프로시저 실행-execute()
		csmt.execute();
		//4]out파라미터에 저장된 값 읽어 오기
		int rtnum=csmt.getInt(2);
		switch(rtnum) {
			case -1:System.out.println("삭제불가:자식이 참조하고 있어요");break;
			case 0:System.out.println(user+"는(은) 존재하지 않는 아이디 입니다");break;
			default:System.out.println(user+"(이)가 삭제 되었습니다");
		}
		//5]자원반납
		close();
	}
	public static void main(String[] args) throws Exception {
		new DeleteProc(ORACLE_URL,"CTRLUSER","CTRLUSER").execute();
	}

}
