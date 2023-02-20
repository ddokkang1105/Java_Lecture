package com.ddokkang.feb177.main;

import com.ddokkang.feb177.player.Player;

// 디자인 패턴 프로그래밍 중...
//		*** 싱글톤 패턴 (Singleton Pattern)
// 클래스가 최초 한번ㅁ나 메모리 할당하고(static) 그 메모리에 객체를 만들어서 사용하는 디자인 패턴
// 고정된 메모리 영역을 얻으면서 한번의 new 로 객체를 사용하기 때문에 메모리 낭비를 방지할 수 있음

public class SMain1 {
	public static void main(String[] args) {
		Player p1 = Player.getPlayer();
		System.out.println(p1);
		p1.printInfo();
		System.out.println("===========================");

		Player p2 = Player.getPlayer();
		System.out.println(p2);
		p2.printInfo();
		System.out.println("===========================");
	}
}
