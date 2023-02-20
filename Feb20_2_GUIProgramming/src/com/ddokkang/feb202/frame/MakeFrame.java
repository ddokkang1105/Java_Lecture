package com.ddokkang.feb202.frame;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//JFrame : Swing���� �����츦 ��Ÿ���� Class
//JPanel(���� ������), JButton(��ư), Jlabel(��), JTestField(���� �Է�), ...
//layout : 
//	flowLayout - �Ϸ� ��ġ(���� -> ������)
//	BorderLayout - Frame ����
//	GridLayout - ���� ����
//	setLocation, setBounds - ��ġ ���Ƿ� ����

public class MakeFrame extends JFrame {
	JPanel pl;
	
	// ��ư 10���� ��ȣ �ٿ��� ( 1 ~ 10 ) ��ġ
	
	public MakeFrame() {
		setSize(500, 500); 				// ������ ������
		setTitle("GUI Practice");		// ������ �̸�
		pl = new JPanel();				// �г� �ϳ� ����
		pl.setLayout(new FlowLayout());	// �Ϸ� ��ġ !
		for (int i = 1; i <= 10; i++) {
			pl.add(new JButton("��ư : " + i));		// pl�ȿ� button�� ���� ����
		}
		add(pl);						// JPanel�� JFrame �ȿ� �ֱ�
		setVisible(true);				// JFrame ���̰� �ϱ� 
	}
}
