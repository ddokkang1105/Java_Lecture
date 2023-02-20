package com.ddokkang.feb202.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class BMIFrame implements ActionListener {
	private JTextField htf;
	private JTextField wtf;
	private JLabel rlb;

//	private JTextField field3;
//
//	public BMIFrame() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public BMIFrame(JTextField field1, JTextField field2, JTextField field3) {
//		super();
//		this.field1 = field1;
//		this.field2 = field2;
//		this.field3 = field3;
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		double height = (Double.parseDouble(field1.getText()) / 100);
//		double weight = Double.parseDouble(field2.getText());
//		double bmi = weight / (height * height);
//		String bmiResult = null;
//		if (bmi >= 40) {
//			bmiResult = "고도비만";
//		} else if (bmi >= 35) {
//			bmiResult = "중증도비만";
//		} else if (bmi >= 30) {
//			bmiResult = "경도비만";
//		} else if (bmi >= 25) {
//			bmiResult = "과체중";
//		} else if (bmi >= 18.5) {
//			bmiResult = "정상체중";
//		} else {
//			bmiResult = "저체중";
//		}
//
//		String bmiText = new DecimalFormat("#.##").format(bmi);
//		field3.setText(bmiText + ", " + bmiResult);
//	}

	public BMIFrame() {
		// TODO Auto-generated constructor stub
	}

	public BMIFrame(JTextField htf, JTextField wtf, JLabel rlb) {
		super();
		this.htf = htf;
		this.wtf = wtf;
		this.rlb = rlb;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Calculate");
		double h = Double.parseDouble(htf.getText());
		double w = Double.parseDouble(wtf.getText());
		h /= 100;

		double bmi = w / (h * h);
		String result = "저체중";
		if (bmi >= 40) {
			result = "고도비만";
		} else if (bmi >= 35) {
			result = "중증도비만";
		} else if (bmi >= 30) {
			result = "경도비만";
		} else if (bmi >= 25) {
			result = "과체중";
		} else if (bmi >= 18.5) {
			result = "정상체중";
		} 
		
//		String r = new DecimalFormat("##.##").format(bmi);
		String finalResult = String.format("BMI: %.2f이고, 당신은 %s입니다.", bmi, result);
		rlb.setText(finalResult);
	}

}
