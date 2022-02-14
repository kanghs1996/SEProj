package jdbc25.etc;

import java.sql.ResultSetMetaData;
import java.sql.Types;
import java.util.List;
import java.util.Vector;

import jdbc25.service.IConnectImpl;

public class ResultSetMetaDataSQL extends IConnectImpl {
	
	public ResultSetMetaDataSQL() {
		super(ORACLE_URL,"scott","scott");
	}
	@Override
	public void execute() throws Exception {
		try {
			//1]쿼리문 준비
			String sql=getQueryString();
			//2]PreparedStatement객체 생성
			psmt= conn.prepareStatement(sql);
			//3]쿼리 실행
			rs=psmt.executeQuery();
			/* SELECT쿼리 실행시 컬럼에 대한 정보 얻기*/
			//가]ResultSet객체의 getMetaData()로 ResultSetMetaData얻기
			ResultSetMetaData rsmd= rs.getMetaData();
			//나]총 컬럼수 얻기-ResultSetMetaData의 int getColumnCount()
			int columnCount=rsmd.getColumnCount();
			System.out.println("총 컴럼수:"+columnCount);
			//다]컬럼명 얻기-ResultSetMetaData의 String getColumnName(int column)
			for(int i=1;i <=columnCount;i++) {
				String columnName=rsmd.getColumnName(i);
				int length = columnName.length()+2;//2칸 여백
				System.out.print(String.format("%-"+length+"s",columnName));
			}
			//라]컬럼타입 얻기-int getColumnType(int column)
			//   타입과 관련된 상수는 java.sql.Types클래스에 정의됨.
			System.out.println("\r\n[자바의 컬럼타입으로 얻기]");
			for(int i=1;i <=columnCount;i++) {
				int columnType=rsmd.getColumnType(i);
				switch(columnType) {
					case Types.VARCHAR:
						System.out.println("오라클의 VARCHAR2");break;
					case Types.NVARCHAR:
						System.out.println("오라클의 NVARCHAR2");break;
					case Types.CHAR:
						System.out.println("오라클의 CHAR");break;
					case Types.NCHAR:
						System.out.println("오라클의 NCHAR");break;
					case Types.TIMESTAMP:
						System.out.println("오라클의 DATE");break;
					case Types.NUMERIC:
						System.out.println("오라클의 NUMBER");break;
					default:System.out.println("오라클의 기타 자료형");
				}
			}
			//마]String getColumnTypeName(int column)
			//오라클의 타입명으로 반환
			System.out.println("\r\n[오라클의 컬럼타입으로 얻기]");
			for(int i=1;i <=columnCount;i++) {
				String columnTypeName=rsmd.getColumnTypeName(i);
				System.out.println(columnTypeName);
			}
			//바]컬럼의 NULL허용여부 :int isNullable(int column) 
			//   NULL허용 :1,NOT NULL:0
			System.out.println("[컬럼의 널 여부 얻기]");
			for(int i=1;i <=columnCount;i++) {
				int isNull=rsmd.isNullable(i);
				System.out.println(isNull==1 ? "널 허용":"NOT NULL");
			}
			//사]컬럼의 크기 얻기 -getPrecision(int column)
			//()괄호 없는 자료형은 0반환
			for(int i=1;i <=columnCount;i++) {
				int columnSize=rsmd.getPrecision(i);
				System.out.println(columnSize);
			}
			//각 컬럼의 자리수 설정하기
			/*
			 * 오라클처럼
			 * NUMBER타입(자리수 지정 안한 NUMBER포함)은 10자리
			 * DATE타입은 10자리(원래 오라클은 8자리)
			 * CHAR게열(VARCHAR2)는 해당 자리수로 설정하는데
			 * 단 NCHAR계열은 자리수의 2배로 설정
			 * 오라클 처럼 컬럼명 밑에  ---------  를 표시하기위한 작업
			 */
			List<Integer> dashCount = new Vector<>();
			for(int i=1;i <=columnCount;i++) {
				//컬럼타입]
				int types=rsmd.getColumnType(i);
				//컬럼의 자리수]
				int length = rsmd.getPrecision(i);
				switch(types) {
					case Types.NCHAR:
					case Types.NVARCHAR:
						dashCount.add(length*2);break;
					case Types.TIMESTAMP:
					case Types.NUMERIC:
						dashCount.add(10);break;
					default:dashCount.add(length);
				}///switch
				//컬럼명 출력]				
				//컬럼명의 길이가 대쉬의 숫자(자료형 크기)보다 크다면
				//예]GENDER CHAR(1) 
				/*
				 * G
				 * -
				 * 
				 */
				String columnName = rsmd.getColumnName(i).length() > dashCount.get(i-1) ?
								    rsmd.getColumnName(i).substring(0,dashCount.get(i-1)) :
								    rsmd.getColumnName(i);	
				System.out.print(String.format("%-"+(dashCount.get(i-1)+1)+"s", columnName));
				
			}
			System.out.println();//줄바꿈
			//(-)DASH출력]
			for(Integer count:dashCount) {
				for(int i=0;i<count;i++) System.out.print("-");
				System.out.print(" ");
			}
			System.out.println();//줄바꿈
			//데이터 출력]
			while(rs.next()) {
				//각 컬럼값 뽑아오기]
				for(int i=1;i <=columnCount;i++) {
					int type=rsmd.getColumnType(i);
					String columnValue;
					if(type==Types.TIMESTAMP)
						columnValue =rs.getDate(i).toString();
					else
						columnValue = rs.getString(i);
					System.out.print(String.format("%-"+(dashCount.get(i-1)+1)+"s", 
							columnValue==null?"":columnValue));
				}
				System.out.println();//줄바꿈
			}
			
		}
		finally {
			close();
		}
	}///////////execute

	public static void main(String[] args) throws Exception {
		new ResultSetMetaDataSQL().execute();
	}

}
