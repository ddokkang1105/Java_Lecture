
public class VMain1 {
	public static void main(String[] args) {
		// 컴퓨터의 장치 !
		// CPU / RAM / HDD / GPU
		
		// CPU : 연산장치(Intel, AMD)
		// HDD(SSD) : 파일 형태로 저장하는 장치
		//		-> 영구적으로 저장
		// RAM : 변수 형태로 저장하는 장치
		//		-> 임시적으로 저장
		// GPU : 그래픽처리 or (CPU + HDD + RAM)
		
		// 데이터를 임시보존 -> RAM에 변수로 저장 !
		// 데이터를 영구보존 -> HDD에 파일로 저장 !
		
		// 변수 -> 데이터를 저장하는 공간(그릇)
		// 왜 저장하냐? 나중에 쓸 때 부르려고
		
		// 변수를 선언함으로 RAM에 공간을 확보
		// 변수 선언 후에 변수에 값을 넣어서 초기화시킨다.
		//		-> 초기화 시키기 전에는 쓰레기 값이 들어있음
		
		// 변수명 규칙
		//		1. 숫자로 시작하면 에러 !
		//		2. 특수문자, 띄어쓰기 -> 에러 !
		//		3. 예약어 -> 에러 !
		
		// 자바 문화
		//		4. 다른 사람이 봐도 알 수 있게 변수명 짓기
		//		5. 가독성(_ or 대문자)
		//		6. 한글 X
		
		// Bit : 데이터를 나타내는 최소 단위(이진수)
		// 8 Bit = 1 Byte
		// 8 Bit 의 맨 앞은 부호비트
		//		-> 0 : 양수 / 1 : 음수
		// 8 Bit 의 범위 : 2^(8-1)
		//		-> -1 은 부호비트를 뺀 것
		
		// 기본형
		//		정수
		//			byte : -128 ~ 127
		//			short : 약 -3만 ~ 3만
		//			int : 약 -21억 ~ 21억
		//			long : int를 벗어나는 범위 
		
		//		실수
		//			float : 다른 언어에서 주로 
		//			double : Java에서 주로
		
		//		문자
		//			char : 한 글자
		
		//		논리
		//			boolean : True / False
		
		//		없음
		//			void : 'ㅇ벗음' (나중에)
		
		//		참조형
		//			기본형이 아닌 것들은 전부 참조형 !!
		//			문자열
		//				String : 문자열
		
		//	char vs String
		//	char : 한 글자, ' ' 사용
		//	String : 문자열, " " 사용
		
		// double에 int 값을 넣는게 가능 !
		// 넓게 보면 9는 9.0으로도 표현 가능
		
		// Python 에서는 자료형을 알아서 선택해준다.
		// Java 에서나 Python에서나 서로 다른 자료형으로 연산하였을 때
		// 더 큰 자료형으로 자동으로 변환된다.
		
		// ???
		
		// Stack
		// 프로그램이 종료되면 자동으로 정리
		// 밑에서부터 차곡차곡 쌓이는 형식 <기본형>
		
		// Heap
		// 	프로그램이 종료되어도 여전히 남아있음
		//		-> 예전에는 수동으로 정리해주어야 했다
		//	컴퓨터가 적당하다고 판단하는 어떠한 위치에 생성함 (주솟값)
		
		// String pool
		// https://2jinishappy.tistory.com/293
		
		// Garbage Collection (중요 단어)
		// Heap 영역을 자동으로 정리해주는 시스템 !
		
		CharString();
		
		int intNum = 9;
		double doubleNum = 9;
		System.out.println(intNum + doubleNum);
		
		byte c = (byte) 0b11111111;
		System.out.println(c);
		System.out.println(Math.pow(2, 50));
	}
	public static void CharString() {
		int intFloor = 5;
		char charFloor = '층';
		
		String stringFinger = "손가락";
		int intFinger = 10;
		
		System.out.printf("%01d%c\n",intFloor,charFloor);
		System.out.printf("%s이 %02d개\n",stringFinger,intFinger);
		System.out.println();
		
	}
}
