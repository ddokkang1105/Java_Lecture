package com.ddokkang.feb174.dog;

// 접근 제어자 ( Access Modifier )
//	멤버변수 또는 클래스에서 사용
//	외부에서 접근하지 못하도록 제한하는 역할
//		=> 뭐에 대한 접근 ... ?
//		=> 멤버변수나 클래스에 !!

public class Dog {
							// 접근범위
	public int a;			// 접근 제한 없음
	protected int b;		// 같은 패키지 or
							// 다른 패키지라면 그 하위 클래스

	/*default*/ int c;		// 같은 패키지 내
	private int d;			// 클래스 내부에서만 !! / 외부에서는 사용 X
}
