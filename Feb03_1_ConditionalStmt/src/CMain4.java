import java.util.Scanner;

// switch-case (ex: 권한 설정)


public class CMain4 {
	
	
	
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.print("당신의 계급은 무엇입니까? : ");
		String classes = k.next();
		
		switch (classes) {
		case "이병":
			System.out.println("눈치, 관등성명, 훈련, 잠");
			break;
		case "일병":
			System.out.println("관등성명, 훈련, 잠");
			break;
		case "상병":
			System.out.println("훈련, 잠");
			break;
		case "병장":
			System.out.println("잠");
			break;
		
		default:
			System.out.println("넌 뭐야?");
			break;
		}
	}
}
