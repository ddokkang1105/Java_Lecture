package com.ddokkang.feb202.main;

import com.ddokkang.feb202.frame.MakeFrame;

// Java GUI Program ( Graphic User Interface )
// AWT, Swing, JavaFX

// AWT : 자바 초창기에 나온 GUI 라이브러리
//		운영체제(OS)에 따라서 모양이 다 달랐기 때문에, 종류도 상당히 제한적이었다.
// Swing : AWT 다음으로 나온 라이브러리
// 		윈도우 프로그램 - 자바로 X : 느림, 더 최적화가 된 C언어 라인이 있다 !
//		윈도우 프로그램 잘 안 만듬,,, -> 웹 / 앱 쪽으로 넘어가는 추세 !
//		 - 결론적으로는 별로 !, 디자인도 별로 !
//		 - Android App 구조 이해하는데는 도움된다 !
// JavaFX : Swing 의 느ㄴ린 처리속도를 개선해서 출시됨
//		다양한 기능들이 추가 + 따로 외관 꾸미는 것도 가능해짐
//		여전히 웹 / 앱 쪽에서 구현하면 되므로 굳이 .. ?

// JFrame : Swing에서 윈도우를 나타내는 Class
//		JPanel(보조 프레임), JButton(버튼), Jlabel(라벨), JTestField(글자 입력), ...
// layout : 
//			flowLayout - 일렬 배치(왼쪽 -> 오른쪽)
//			BorderLayout - Frame 형식
//			GridLayout - 격자 형태
//			setLocation, setBounds - 위치 임의로 지정


public class GMain1 {
	public static void main(String[] args) {
		MakeFrame mf = new MakeFrame();
	}
}
