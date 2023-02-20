
public class PMain2 {

	public static void main(String[] args) {
		// Escape Sequence
		// : 특수한 문자나 특수한 기능을 표현할 때
		// \ 역 슬래시를 사용 !

		// \t : Tap 키의 기능
		// \n : New Line(줄만 맞추는 용도)
		// \r : Carriage Return (커서를 맨 앞으로)
		// \r\n : Enter키
		// \b : Backspace키(1 byte만 지움)
		// -> Java에서는 잘 사용하지 않음(because Java는 한 글자당 2 byte)
		// \0 : 빈칸(space키)
		
		// 가볍게 확인용도로 사용하는 콘솔창이라 \r \n 둘 중에 하나만 있어도 Enter키 처리가 가능하지만
		// 파일처리할 시에는 \r, \n 하나만 쓰면 이상하게 표현된다.
		
		
		System.out.println("안녕하세요.\n저는 한국 사람입니다.\n잘 부탁드립니다.\r\n일찍 오겠습니다.");

		System.out.println();
		System.out.println("↖〔∂∇∂〕↗");

		System.out.println();
		System.out.println("\"\\(^_^)/\"");
		
		// \\ : \를 글자로
		// \' , \" : ', " 를 글자로
		
		System.out.println();
		System.out.println("(\".\")");
		
	}

}
