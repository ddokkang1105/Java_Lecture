import java.util.Scanner;

public class CMain5 {
	
	
	
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.print("당신의 계급은 무엇입니까? : ");
		String job = k.next();
		
		switch (job) {
		case "DBA":
			System.out.println("전원관리");
			System.out.println("백업 / 복구");
			System.out.println("명령어로 CRUD");
			System.out.println("서비스활용");
			break;
		case "DBP":
			System.out.println("명령어로 CRUD");
			System.out.println("서비스활용");
			break;
		case "DBU":
			System.out.println("서비스활용");
			break;
		
		default:
			System.out.println("그런거는 없쒀용 ~ ");
			break;
		}
	}

}
