import java.util.Scanner;

// swich-case 

// swich 庚 : 搾嘘 繕闇戚 働舛廃 葵戚蟹 庚切伸析 凶
//	break; 研 戚遂馬食 唖 繕闇戚 幻膳馬檎 switch庚 曽戟馬亀系

//switch (痕呪 or 縦) {
//case 葵 A:
//	痕呪 or 縦税 葵戚 A析 凶 戚 採歳戚 叔楳
//	break;
//case 葵 B:
//	痕呪 or 縦税 葵戚 B析 凶 戚 採歳戚 叔楳
//	break;
//	
//default:
//	A 葵亀 B 葵亀 焼諌 凶 戚 採歳戚 叔楳
//	break;
//}


public class CMain3 {
	
	public static void inputNum(int input) {
		switch (input) {
		case 1:
			System.out.println("せせ");
			break;
		case 2:
			System.out.println("ぞぞ");
			break;
		case 3:
			System.out.println("ばば");
			break;
		default:
			System.out.println("噌形...");
			break;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.printf("舛呪研 脊径馬室推 : ");
		int input = k.nextInt();
		inputNum(input);
//		switch (input) {
//		case 1:
//			System.out.println("せせ");
//			break;
//		case 2:
//			System.out.println("ぞぞ");
//			break;
//		case 3:
//			System.out.println("ばば");
//			break;
//		default:
//			System.out.println("噌形...");
//			break;
//		}
		
	}
}
