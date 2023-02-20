package com.ddokkang.feb202.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JTextField;

public class TempFrame implements ActionListener {
	private JTextField field1;
	private JTextField field2;
	
	public TempFrame() {
		// TODO Auto-generated constructor stub
	}

	public TempFrame(JTextField field1, JTextField field2) {
		super();
		this.field1 = field1;
		this.field2 = field2;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		double fahrenheit = Double.parseDouble(field1.getText());
		double celcius = (double) 5 / 9 * (fahrenheit - 32);
		
		String c = new DecimalFormat("##.####").format(celcius);
		field2.setText(c);
	}
}
