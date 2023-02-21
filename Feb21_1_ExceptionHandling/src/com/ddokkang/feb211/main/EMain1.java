package com.ddokkang.feb211.main;

import java.util.InputMismatchException;
import java.util.Scanner;

// error
//			한국어 - 번역 -> 영어
//			사과			apple
//			바나나			banana
//			띱퀭			????
//		Java의 문법에 안 맞게 써서 컴파일이 불가능한 상태
//		개발자의 잘못 !
//		완성본은 나오지 않음

// warning
//		지저분한 코드
//		개발자의 잘못 !
//		컴파일은 가능하니 => 완성본은 나옴 ( 실행하는 데 문제 없음 ! )
//		이클립스가 잔소리를 함...
//		ex > Scanner 객체 만들고 나서 기능을 안 닫은 경우

// exception
//		프로그램은 100% 완성 !
//		실행할 때 뭔가 외부적인 요인에 의해서 작동이 제대로 안되는 상황...
//		개발자 잘못은 아님
//		개발자 입장 -> 개발자가 상황을 예측해서 대책은 세워놓자 ...!

// Exception 처리를 할 수 있는 방법 !
// try-catch !!
//try {
//		일단 이 부분을 실행 - (내용)
//} catch (예외유형명 변수명) {
//		try쪽을 실행하다가 해당 유형의 Exception이 발생하면 이 부분을 실행
//		만약, 예외 없이 정상적으로 실행됐을 경우, catch 부분은 그냥 지나치고
//		그 다음 코드를 진행
//} finally {
//		정상적으로 프로그램 실행, 예외 발생 상관없이 실행
//		return 보다 먼저 실행
//}

// 두가지 문제가 동시에 터진 경우 ? => 먼저 나온 catch의 내용만 실행 !
// Java 의 입장에서 첫번째 예외가 발생했을 때
// 즉시 실행 중지 후 해당 예외처리 부분으로 넘어가기 때문에 !

// Exception
// 모 ~ 든 Exception을 잡아주는 ~

// e.printStackTrace();
// 상황 출력 (개발자용)

public class EMain1 {
	public static void main(String[] args) {
		
		Scanner k = new Scanner(System.in);
		int x = 0;
		int y = 0;
//		while (true) {
//			try {
//				System.out.print("X : ");
//				x = k.nextInt();
//				System.out.print("Y : ");
//				y = k.nextInt();
//				System.out.println(x + y);
//				System.out.println(x - y);
//				System.out.println(x * y);
//				System.out.println(x / y);
//				break;
//			} catch (InputMismatchException e) {
//				System.out.println("다시 입력해주세요.");
//			} finally {
//				k = new Scanner(System.in);
//			}
//		}
		
		System.out.print("X : ");
		x = k.nextInt();
		System.out.print("Y : ");
		y = k.nextInt();
		System.out.println(x + y);
		System.out.println(x - y);
		System.out.println(x * y);
//		System.out.println(x / y);

		// x : 10, y : 0 => 76,77,78,86,87,91,92
		// x : 10, y : 1 => 76,77,78,86,87,88,89,90,93,94
		// x : 2, y : 1 => 76,77,78,86,87,88,89,90
		
//		try {
//			int d = x / y;
//			System.out.println(d);
//			int[] ar = {1, 2, 3};
//			System.out.println(ar[x]);
//		} catch (ArithmeticException ae) {
//			System.out.println("0으로 어떻게 나눠요 ㅡ.ㅡ");
//		} catch (IndexOutOfBoundsException iobe) {
//			System.out.println("배열 인덱스 ㅡ.ㅡ");
//		}
		
		try {
			int d = x / y;
			System.out.println(d);
			int[] ar = {1, 2, 3};
			System.out.println(ar[x]);
		} catch (Exception e) {
			System.out.println("ㅡ.ㅡ");
			e.printStackTrace();
		} finally {
			System.out.println("ㅋㅋㅋㅋ");
		}
	}
}
