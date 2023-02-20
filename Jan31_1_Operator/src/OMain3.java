import java.util.Scanner;

// 논리연산자
//		결과가 boolean
// <, <=, ==, !=, >=, >

// ~이고 : &&
// ~또는 : ||
// 결과를 부정할 때(NOT) : !
// XOR(eXclusive OR) : ^
//		-> 두 입력이 서로 다를 때 '1' 결과값을 출력 !

// A && B
// A || B

public class OMain3 {

	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);

		System.out.print("키를 입력하세요 : ");
		double height = k.nextDouble();

		System.out.print("나이를 입력하세요 : ");
		int age = k.nextInt();
		System.out.println("===========================");
		System.out.printf("입력하신 키는 %.1fcm 입니다.\n", height);
		System.out.printf("입력하신 나이는 %d세 입니다.\n", age);

		boolean ride1 = age > 10;
		System.out.printf("ride1 탑승가능합니까? : %b\n", ride1);

//		if (ride1) {
//			System.out.printf("나이가 %d세이므로 ride1을 탈 수 있습니다.", age);
//		}

		boolean ride2 = age < 5;
		System.out.printf("ride2 탑승가능합니까? : %b\n", ride2);

		boolean ride3 = age == 20;
		System.out.printf("ride3 탑승가능합니까? : %b\n", ride3);

		boolean ride4 = age != 1;
		System.out.printf("ride4 탑승가능합니까? : %b\n", ride4);

		boolean ride5 = (age % 2 == 1);
		System.out.printf("ride5 탑승가능합니까? : %b\n", ride5);

		// 효율적이지 못한 코드 - 가능성
		// boolean ride6 = (age > 3 && (height / 100) > 2);

		// 보다 효울적인 코드
		// 조건을 확인하여 && 를 사용할 때는 확률이 적은 것을 앞에다가 !!
		// 반대로 || 는 확률이 높은 것을 앞에다가 !!
		boolean ride6 = ((height / 100) > 2 && age > 3);
		System.out.printf("ride6 탑승가능합니까? : %b\n", ride6);

		boolean ride7 = (age < 50 || (height / 100) > 1.9);
		System.out.printf("ride7 탑승가능합니까? : %b\n", ride7);

		boolean ride8 = (age < 40 && age > 10);
		System.out.printf("ride8 탑승가능합니까? : %b\n", ride8);

		boolean ride9 = (age >= 10) ^ ((height / 100) >= 1.5);
		System.out.printf("ride9 탑승가능합니까? : %b\n", ride9);
		
		boolean ride10 = ((age >= 10) && !((height / 100) >= 1.5)) 
				|| (!(age >= 10) && ((height / 100) >= 1.5));
		System.out.printf("ride10 탑승가능합니까? : %b\n", ride10);
		
		boolean ride0 = !ride9;
		System.out.printf("ride0 탑승가능합니까? : %b\n", ride0);

	}
}
