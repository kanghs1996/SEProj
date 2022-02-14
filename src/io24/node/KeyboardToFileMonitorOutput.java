package io24.node;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

/*
키보드로 데이터를 입력받아 입력 받은 내용을 
파일과 모니터로 출력
 
데이타 소스:키보드
			  바이트 노드 스트림:System.in
데이타 목적지:
			  파일
			  바이트 노드 스트림:FileOutputStream 
			  모니터
			  바이트 노드 스트림:System.out 
*/
public class KeyboardToFileMonitorOutput {

	public static void main(String[] args) throws IOException {
		//1]데이타 입력용 바이트기반의 노드 스트림 생성
		InputStream is = System.in;
		//2-1]파일 출력용
		//window식 디렉토리 표기법  
		//FileOutputStream fos= new FileOutputStream("D:\\CCH\\Workspace\\Java\\Basic\\SEProj\\src\\io24\\node\\Keyboard.txt");
		//유니스/리눅스식 디렉토리 표기법
		//FileOutputStream fos= new FileOutputStream("D:/CCH/Workspace/Java/Basic/SEProj/src/io24/node/Keyboard.txt");
		//파일 경로:src부터 시작]
		FileOutputStream fos= new FileOutputStream("src/io24/node/Keyboard.txt");
		//2-2]모니터 출력용
		PrintStream ps = System.out;
		
		//3]is로 읽고 fos와 ps으로 출력
		int ascii;
		while((ascii=is.read()) !=-1) {
			//파일로 출력]
			fos.write(ascii);
			fos.flush();
			//모니터로 출력]
			ps.write(ascii);
			ps.flush();
		}
		
		//4]스트림 닫기
		fos.close();
	}////////main
}////////////class
