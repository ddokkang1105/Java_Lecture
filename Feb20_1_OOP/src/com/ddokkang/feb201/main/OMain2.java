// Java GUI Program ( Graphic User Interface )
// AWT, Swing, JavaFX

// AWT : �ڹ� ��â�⿡ ���� GUI ���̺귯��
//		�ü��(OS)�� ���� ����� �� �޶��� ������, ������ ����� �������̾���.
// Swing : AWT �������� ���� ���̺귯��
// 		������ ���α׷� - �ڹٷ� X : ����, �� ����ȭ�� �� C��� ������ �ִ� !
//		������ ���α׷� �� �� ����,,, -> �� / �� ������ �Ѿ�� �߼� !
//		 - ��������δ� ���� !, �����ε� ���� !
//		 - Android App ���� �����ϴµ��� ����ȴ� !
// JavaFX : Swing �� ���� ó���ӵ��� �����ؼ� ��õ�
//		�پ��� ��ɵ��� �߰� + ���� �ܰ� �ٹ̴� �͵� ��������
//		������ �� / �� �ʿ��� �����ϸ� �ǹǷ� ���� .. ?



package com.ddokkang.feb201.main;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.ddokkang.feb201.avengers.Hulk;

public class OMain2 {
	public static void main(String[] args) {
		JFrame jf = new JFrame("Earth");
		JButton jb= new JButton("Ji");
		jf.add(jb);
	
		Hulk h = new Hulk();
		
		jb.addActionListener(h);
		
		jf.setSize(500, 500);
		jf.setVisible(true);
	}
}
