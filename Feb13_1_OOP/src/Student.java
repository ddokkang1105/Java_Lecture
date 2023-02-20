// 라이브러리 Class ( API : Application Program Interface)
//		: 다른 Class에서 이용할 목적
// 프로그램에서 실행되는 Class가 여러개, 단 하나를 빼고는 전부 라이브러리용 Class !
//		제외된 하나의 Class : 실행용 Class (Main)

// 		변수 : 생성자, 메소드 내에서만 사용되고,
//				생성자, 메소드 실행이 종료되면 함께 자동으로 사라짐

//		멤버변수 / 필드 : 생성자, 메소드 전체에서 사용이 가능
//							객체가 소멸되지 않는 한 객체와 함께 공존함

// 초기값이 지정되지 않은 멤버변수는 객체 생성시 자동으로 초기 기본값을 설정

// 실행용 Class : 프로그램 실행을 위한 main() method를 제공하는 역할
// 			=> 여기에 라이브러리 Class의 객체를 생성하면
//				라이브러리 Class의 객체를 참조(주솟값 형태)했다. 라고 함
// 객체를 참조할 시에 완전히 독립적인 서로 다른 객체를 만들기 위해서는
// new 클래스이름(); 선언 후에
// 다시 새로운 데이터를 넣어주어야 한다.

public class Student {
	String name;
	String address;
	
	
	
	public void printInfo() {
		System.out.printf("이름 : %s\n", name);
		System.out.printf("주소 : %s\n", address);
	}
}
