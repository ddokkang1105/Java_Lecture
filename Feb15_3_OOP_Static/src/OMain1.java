// JAR ( Java Archive, 자바 아카이브 ) 파일
//		: 기계어 상태로 바꿔서 압축을 해놓은 형태

// .java 파일 : 사람이 보려고 만든 것
// .class 파일 : 실제로 자바에서 구동하는 것

// 기계어 / 바이트코드로 변환해서 돌리는 이유
//		- 바이트코드르 사용하면 실행이 빠르다 !
//		- 소스를 노출하게 되면 이게 무슨 프로그램인지 알 수 있기 때문에
//			보안 상의 이유로 !!
//	=> 다른 사람에게 기능을 넘겨줄 때 소스를 알려주지 말고, 그 기능만을 사용하게 하자 !
//	=> .java 파일 말고 .jar 파일로 !!

// JavaDoc
// JavaDoc의 역할 : 제품설명서
// 우리가 만든 프로그램을 보기 쉽~~게 HTML 형식, WEB형식으로
// 만들어서 보기 편하게 문서화 시킨것!

// JavaDoc 의 특징
//	- 주석은 /** (내용) */
//	- 주석 안쪽은 크게 2가지로 나뉨
//		1. 설명문
//			주석의 시작에서 첫번째 태그 섹션까지의 부분
//			설명문은 HTML로 설명되기 때문에 단순히 주석 작성 당시에
//			엔터를 쳐서 줄을 바꿔서 입력했다 하더라도
//			그대로 이어져서 출력됨
//			줄바꿈 처리를 하고 싶다면 <p>를 작성하면 됨 !
//		2. 태그 섹션
//			첫번째 문자가 '@'로 시작한다
//				- @author : 이 프로그램의 작성자, 기본값으로 Windows 계정 ID
//				- @version : 말 그대로 이 프로그램의 버전
//				- @param : 파라미터에 대한 설명
//				- @throws : 예외처리에 대한 설명
//				- @return : 메소드가 void가 아닌 반환 값이 있을 때 그것에 대한 설명

public class OMain1 {
	public static void main(String[] args) {
//		GameCharater g1 = new GameCharater();
//		g1.nickname = "Ji Sung Park";
//		g1.printInfo();

		GameCharater g1 = new GameCharater("JiSungPark");
		g1.printInfo();
		
	}
}
