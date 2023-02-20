package com.ddokkang.feb202.main;

import java.awt.*;

import javax.swing.*;

import com.ddokkang.feb202.frame.CharacterFrame;

public class GMain5 {
	public static void main(String[] args) {
		JFrame jf = new JFrame("Character");
		
		GridLayout gl = new GridLayout(3,3);
		jf.setLayout(gl);
		
		JLabel levelLb = new JLabel("Level : ");
		jf.add(levelLb);
		
		JTextField levelTf = new JTextField(5);
		jf.add(levelTf);
		
		JLabel levelResultLb = new JLabel();
		jf.add(levelResultLb);
		
		JLabel expLb = new JLabel("EXP : ");
		jf.add(expLb);
		
		JTextField expTf = new JTextField(5);
		jf.add(expTf);
		
		JLabel expResultLb = new JLabel();
		jf.add(expResultLb);
		
		JLabel resultLb = new JLabel("Result : ");
		jf.add(resultLb);
		
//		JLabel xx = new JLabel();
//		jf.add(xx);
		
		JButton action = new JButton("Action");
		jf.add(action);
		
		CharacterFrame ch = new CharacterFrame(levelTf, expTf, levelResultLb, expResultLb, resultLb);
		action.addActionListener(ch);
		
		jf.setSize(500, 500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
}
