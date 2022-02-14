package io24.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WindowExplorer {
	
	private static void printLine(int size,char symbol) {
		for(int i=0;i<size;i++) {
			System.out.print(symbol);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		File f = new File("src/io24/node");
		
		printLine(106, '=');
		System.out.println(String.format("%-50s%-32s%-14s%s","이름","수정한 날짜","유형","크기"));
		printLine(106, '=');
		
		//문]윈도우 탐색기처럼 상기 디렉토리 안에 있는
		//   하위디렉토리나 파일을 출력하여라,
		//   단, 디렉토리부터...
		StringBuffer sbDir = new StringBuffer();
		StringBuffer sbFile = new StringBuffer();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd a h:mm");
		File[] files=f.listFiles();
		
		for(File file:files) {
			//파일명 혹은 디렉토리명]
			String name = file.getName();
			//최근 수정된 시간]
			String lastModified= dateFormat.format(new Date(f.lastModified()));
			if(file.isFile()) {//파일인 경우
				//파일 유형]
				String ext=name.substring(name.lastIndexOf(".")+1).toUpperCase();
				//파일 크기]
				int size = (int)Math.ceil(file.length()/1024.0);
				sbFile.append(String.format("%-50s%-32s%-14s%sKB%n",name,lastModified,ext+" 파일",size));
				
			}
			else {//디렉토리인 경우
				sbDir.append(String.format("%-50s%-32s%-14s%n", name,lastModified,"파일 폴더"));
			}
			
		}///for
		System.out.println(sbDir+sbFile.toString());
		
		
	}/////////main

}//////////////class
