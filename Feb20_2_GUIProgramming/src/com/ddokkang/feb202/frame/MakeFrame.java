package com.ddokkang.feb202.frame;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//JFrame : Swing에서 윈도우를 나타내는 Class
//JPanel(보조 프레임), JButton(버튼), Jlabel(라벨), JTestField(글자 입력), ...
//layout : 
//	flowLayout - 일렬 배치(왼쪽 -> 오른쪽)
//	BorderLayout - Frame 형식
//	GridLayout - 격자 형태
//	setLocation, setBounds - 위치 임의로 지정

public class MakeFrame extends JFrame {
	JPanel pl;
	
	// 버튼 10개를 번호 붙여서 ( 1 ~ 10 ) 배치
	
	public MakeFrame() {
		setSize(500, 500); 				// 프레임 사이즈
		setTitle("GUI Practice");		// 프레임 이름
		pl = new JPanel();				// 패널 하나 생성
		pl.setLayout(new FlowLayout());	// 일렬 배치 !
		for (int i = 1; i <= 10; i++) {
			pl.add(new JButton("버튼 : " + i));		// pl안에 button을 넣은 상태
		}
		add(pl);						// JPanel을 JFrame 안에 넣기
		setVisible(true);				// JFrame 보이게 하기 
	}
}
