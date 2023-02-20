package com.ddokkang.feb177.main;

import com.ddokkang.feb177.player.Player;

// ������ ���� ���α׷��� ��...
//		*** �̱��� ���� (Singleton Pattern)
// Ŭ������ ���� �ѹ����� �޸� �Ҵ��ϰ�(static) �� �޸𸮿� ��ü�� ���� ����ϴ� ������ ����
// ������ �޸� ������ �����鼭 �ѹ��� new �� ��ü�� ����ϱ� ������ �޸� ���� ������ �� ����

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
