package jdbc25;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {

	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt = null;
		ResultSet rs=null;
		try {
			
			Properties props = new Properties();
			props.load(new FileReader("src/jdbc25/config.properties"));
			
			
			/*
			 1]오라클용 JDBC드라이버 메모리에 로딩
			Class.forName("패키지를 포함한 클래스명"):클래스명으로
			해당 클래스를 찾아서 메모리에 로딩하는 메소드(new하지 않고)
			메모리에 로딩된 드라이버가 DriverManager라는 클래스에 등록됨.
			*/
			//Class.forName("oracle.jdbc.OracleDriver");
			Class.forName(props.getProperty("driver"));
			
			/*
			2]DriverManger클래스의 getConnection()메소드로 오라클에 연결시도
	        연결되면 주소반환,실패하면 null반환.
	        오라클 주소 설정: 
	        드라이버종류:@오라클이 설치된 주소:포트:전역데이타베이스명(SID)
			예]jdbc:oracle:thin-드라이버 종류
		   	localhost 혹은 127.0.0.1 - 오라클이 설치된 주소(내 PC인 경우)
		   */
			//오라클이 설치된 주소]
			//String url="jdbc:oracle:thin:@localhost:1521:xe";
			String url= props.getProperty("url");
			//접속 계정 정보]
			//String user="scott";
			String user=props.getProperty("user");
			//String password="scott";
			String password=props.getProperty("password");
			conn= DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공:"+conn);
			try {
				//3]쿼리문(SQL)전송을 위한 Statement계열의 객체 생성
				//  연결된 Connection객체(conn)를 통해서 생성
				stmt=conn.createStatement();
				//쿼리문 작성
				String sql="SELECT * FROM emp ORDER BY hiredate DESC";
				try {
					//4]Statement계열 클래스(stmt)의 execute계열 메소드를 
					//  이용해서 쿼리문 실행(오라클에 명령전송)	
					rs=stmt.executeQuery(sql);
					//ResultSet에 담긴 select쿼리 결과를, 커서를 아래로(forward)
					//이동하면서 각 컬럼에 있는 값 꺼내오자.
					while(rs.next()) {//next():더 이상 꺼내올 레코드가 없으면 false반환
						int empno=rs.getInt(1);
						String ename = rs.getString(2);
						String job = rs.getString("job");
						int sal = rs.getInt(6);
						Date hiredate = rs.getDate(5);
						System.out.println(String.format("%-5s%-11s%-10s%-6s%s",
								empno,ename,job,sal,hiredate));
					}
				}
				catch(SQLException e) {
					System.out.println("SELECT쿼리 실행 실패:"+e.getMessage());
				}
			}
			catch(SQLException e) {
				System.out.println("Statement객체 생성 실패:"+e.getMessage());
			}
			
		}
		catch(ClassNotFoundException e) {
			System.out.println("오라클 드라이버 클래스가 없어요:"+e.getMessage());
		}
		catch(SQLException e) {
			System.out.println("데이타 베이스 연결 실패:"+e.getMessage());
		}
		catch(IOException e) {
			System.out.println("구성파일 로드 실패:"+e.getMessage());
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(stmt !=null) stmt.close();
				if(conn !=null) conn.close();
			}
			catch(SQLException e) {}
		}
		

	}//////////main

}/////////////class
