package com.ddokkang.feb202.main;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.ddokkang.feb202.frame.BMIFrame;

public class GMain4 {
	
	public static void main(String[] args) {
	
		JFrame jf = new JFrame();
		
		GridLayout gl = new GridLayout(3, 2);
		jf.setLayout(gl);
		
		JPanel jp = new JPanel();
		JLabel heightLb = new JLabel("Height : ");
		jf.add(heightLb);

		JTextField heightTf = new JTextField(5);
		jf.add(heightTf);
		
		JLabel weightLb = new JLabel("Weight : ");
		jf.add(weightLb);
		
		JTextField weightTf = new JTextField(5);
		jf.add(weightTf);
		
		JLabel resultLb = new JLabel("BMI : ");
		jf.add(resultLb);
		
//		JTextField resultTf = new JTextField(10);
//		jf.add(resultTf);
		
		JButton button = new JButton("Click");
		jf.add(button);

//		jp.add(label1);
//		jp.add(field1);
//		jp.add(label2);
//		jp.add(field2);
//		jp.add(label3);
//		jp.add(field3);
//		jp.add(button);
		
//		BMIFrame bmi = new BMIFrame(heightTf, weightTf, resultTf);
//		button.addActionListener(bmi);

		BMIFrame bf = new BMIFrame(heightTf, weightTf, resultLb);
		button.addActionListener(bf);
		
		jf.setSize(450, 300);
		jf.setTitle("BMI Calculator");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
	}
}
