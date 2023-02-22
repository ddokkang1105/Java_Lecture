package com.ddokkang.feb222.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// CPU		: 연산장치
// RAM		: 저장장치(임시) - 재부팅하면 날아감
// 				static / stack - 프로그램을 끄면(종료하면) 날아감
//				heap - 자동으로 날아가지는 않는데, Garbage Collector가 있으면 자동으로 날아감
// HDD(SSD)	: 저장장치(영구) - 파일
// GPU		: 그래픽처리용 ( GPU + RAM + HDD )

// 프로그램에서는 데이터를 외부에서 읽고, 다시 외부로 출력하는 작업이 자주 일어나는데
// 데이터는 사용자로부터 키보드를 통해서 입력될 수도 있고, (Scanner)
// 파일.네트워크에서도 입력될 수 있음				       (Input)

// 반대로, 데이터는 모니터를 통해서 출력될 수도 있고, (System.out.println)
// 파일.네트워크로도 출력될 수 있음				      (Output)

// System.in  -> InputStream
// System.out -> PrintStream

// 'Stream' : '빨대' -> I/O Device 와 Program을 연결해주는 역할이라고 생각 !
//		기본형
//			InputStream			: 장치(키보드, 파일, 네트워크, ...) => 프로그램으로 입력 ( 1 byte 씩 )
//			InputStreamReader	: 장치 => 프로그램 ( 2 byte 씩 )
//			BufferedReader		: 장치 => 프로그램 ( 1 String - 1line )

//			OutputStream		: 프로그램의 결과를 => 장치(키보드, 파일, 네트워크, ...) ( 1 byte 씩 )
//			OutputStreamWritter	: ( 2 byte 씩 )
//			BufferedWritter		: ( 1 String - 1line )

//		개조형 (특수목적에 맞게)
//			PrintStream (OutputStream 개조)		 	- 쓰기 편하게 유용한 메소드들 추가
//			FileReader 	(InputStreamReder 개조)		- 파일에서 데이터를 읽어오기 편하게
//			FileWritter (OutputStreamWritter 개조)	- 데이터를 출력하기 편하게
//			...

// System.in : 콘솔창 -> 프로그램 ( InputStream )
// JDK 1.5에 Scanner가 추가
// InputStream을 사용하기 편하게 서포트 !
// Scanner k = new Scanner(System.in);
// System.out.print("입력 : ");
// String cmt = k.next();

// System.out : 프로그램 -> 콘솔창 ( PrintStream)
// System.out.println("===========================");

// FileWritter
//		프로그램 => 파일 ( OutpurStreamWritter 개조형 )
//		파일이 없으면 만들어 주기도 함
//		폴더는 안 만들어 쥼 ^&^
//		Linux의 경로	: C:/Users/sdedu/Desktop/Java_Test/filewrite/test.txt 		=> /로 경로 설정
//		Windows의 경로	: C:\\Users\\sdedu\\Desktop\\Java_Test\\filewrite\\test.txt	=> \\로 결정 + / 하나로도 가능
//																					   \ 하나로는 안댐 !
// 		Java의 \는 : \t, \r, \n, \0, ... 에 사용 (이스케이프 문자)
//		권한, 폴더명 오타, ... => 예외처리

//		// fw 위에 bw 덮은 상태
//		// 하나만 닫아주면 나머지는 알아서 닫힌다.
//		BufferedWriter bw = null;
//		try {
//			// 지정된 파일이 이미 존재하고 있으면 덮어쓰기 때문에
//			// 기존에 있던 파일의 내용은 사라지게 됨
//			// 기존의 내용 뒤에 덧붙이고 싶다면 ( 데이터를 추가하고 싶다면 )
//			// 두 번째 파라미터 값으로 true를 주면 됨 !
//			// FileWriter fw = new FileWriter("어쩌고 저쩌고", true);
//			
//			// Encoding 방식 지정 X -> ANSI로 인코딩됨
//			FileWriter fw = new FileWriter("C:\\Users\\sdedu\\Desktop\\Java_Test\\filewrite\\test.txt", true);
//			
//			// 한 바이트 씩 입출력하는 것보다는
//			// '버퍼'를 이용해서 한번에 여러 바이트를 입출력하는게 더 빠름
//			//		=> 대부분의 입출력 작업에서 사용
//			// 버퍼 : CPU와 HDD 사이에서 사용되는 임시 저장 공간
//			// 버퍼링 : <데이터>를 버퍼로 저장하는 동작
//			//		=> 실행성능 향상 시킬 수 있음
//			bw = new BufferedWriter(fw);
//			bw.write(cmt + "\r\n");
//			bw.write("--------------\r\n");
//			bw.flush();		// **중요** 버퍼 용량이 다 안채워져도 강제적으로 내보내기 (모든 데이터 다 보내기)
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			bw.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//		}

public class FileWriteMain {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.print("입력 : ");
		String cmt = k.next();
		
		
		// fw 위에 bw 덮은 상태
		// 하나만 닫아주면 나머지는 알아서 닫힌다.
		BufferedWriter bw = null;
		try {
			// 지정된 파일이 이미 존재하고 있으면 덮어쓰기 때문에
			// 기존에 있던 파일의 내용은 사라지게 됨
			// 기존의 내용 뒤에 덧붙이고 싶다면 ( 데이터를 추가하고 싶다면 )
			// 두 번째 파라미터 값으로 true를 주면 됨 !
			// FileWriter fw = new FileWriter("어쩌고 저쩌고", true);
			
			// Encoding 방식 지정 X -> ANSI로 인코딩됨
			FileWriter fw = new FileWriter("C:\\Users\\sdedu\\Desktop\\Java_Test\\filewrite\\test.txt", true);
			
			// 한 바이트 씩 입출력하는 것보다는
			// '버퍼'를 이용해서 한번에 여러 바이트를 입출력하는게 더 빠름
			//		=> 대부분의 입출력 작업에서 사용
			// 버퍼 : CPU와 HDD 사이에서 사용되는 임시 저장 공간
			// 버퍼링 : <데이터>를 버퍼로 저장하는 동작
			//		=> 실행성능 향상 시킬 수 있음
			bw = new BufferedWriter(fw);
			bw.write(cmt + "\r\n");
			bw.write("--------------\r\n");
			bw.flush();		// **중요** 버퍼 용량이 다 안채워져도 강제적으로 내보내기 (모든 데이터 다 보내기)
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	
	
	
	
	}
}
