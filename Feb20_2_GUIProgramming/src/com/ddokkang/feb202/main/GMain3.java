package com.ddokkang.feb202.main;

import java.awt.*;

import javax.swing.*;

import com.ddokkang.feb202.frame.TempFrame;

public class GMain3 {
	// �����µ� -> ȭ���µ� �ٲٴ� �ŷ� �ٽ� ����� !!
	
//	static JFrame jf = new JFrame();
	
//	public static void makeJFrame() {
//		pl.setLayout(null);
//		pl.setBackground(Color.BLACK);
//		jf.setSize(500, 200);
//		jf.setTitle("GUI Practice");
//		jf.add(pl);
//		jf.setVisible(true);
//	}
//
//	public static void makeButton() {
//		
//	}
//	
//	public static void doProgram() {
//		makeJFrame();
//	}
	
	public static void convert() {
		
	}
	
	public static void main(String[] args) {
//		doProgram();
//		pl.setLayout(null);
		
		JFrame jf = new JFrame();
		JPanel jp = new JPanel();
		jf.add(jp);
		
		JLabel label1 = new JLabel("ȭ���µ� : ");
		JTextField field1 = new JTextField(15);
		JLabel label2 = new JLabel("�����µ� : ");
		JTextField field2 = new JTextField(15);
		JButton button = new JButton("��ȯ");
		
		jp.add(label1);
		jp.add(field1);
		jp.add(label2);
		jp.add(field2);
		jp.add(button);
		
		TempFrame tf = new TempFrame(field1, field2);
		button.addActionListener(tf);
		
		jf.setSize(300, 150);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setTitle("�µ� ��ȯ��");
		jf.setVisible(true);
		
		
	}
}

//	public static void makeJPanel() {
//		JPanel pl1 = new JPanel();
//		pl1.setLayout(null);
//		pl1.setBackground(Color.WHITE);
//		pl1.setSize(200, 50);
//		pl1.setName("ȭ��");
//		pl1.setLocation(200, 50);
//		jf.add(pl1);
//		jf.setVisible(true);
//	}

//		JPanel pl = new JPanel();
//		JLabel la1 = new JLabel("ȭ���µ� : ");
//		JTextField tf1 = new JTextField(1);
//		JLabel la2 = new JLabel("�����µ� : ");
//		JTextField tf2 = new JTextField();
//		JLabel la3 = new JLabel();
//		
//		
//		pl.setLayout(new FlowLayout());
//		la1.setForeground(Color.WHITE);
//		la1.setLocation(0,0);
//		la1.setSize(50,50);
//		pl.add(la1);
//		tf1.setLocation(150, 0);
//		tf1.setSize(100, 20);
//		pl.add(tf1);
//		la2.setForeground(Color.WHITE);
//		la2.setLocation(0,50);
//		la2.setSize(50,50);
//		pl.add(la2);
//		tf2.setLocation(150, 50);
//		tf2.setSize(100, 20);
//		pl.add(tf2);
//		
//		la3.add(new Button("Convert"));
//		la3.setLocation(50, 50);
//		pl.add(la3);
//		
//		pl.setBackground(Color.BLACK);
//		pl.add(new Button("Convert"));
//		jf.setSize(500, 200);
//		jf.setTitle("GUI Practice");
//		jf.add(pl);
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		jf.setVisible(true);