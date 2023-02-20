package com.ddokkang.feb202.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class CharacterFrame implements ActionListener {
	private JTextField lvtf;
	private JTextField exptf;
	private JLabel lvlb;
	private JLabel explb;
	private JLabel rlb;
	
	public CharacterFrame() {
		// TODO Auto-generated constructor stub
	}

	public CharacterFrame(JTextField lvtf, JTextField exptf, JLabel lvlb, JLabel explb, JLabel rlb) {
		super();
		this.lvtf = lvtf;
		this.exptf = exptf;
		this.lvlb = lvlb;
		this.explb = explb;
		this.rlb = rlb;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double lv = Double.parseDouble(lvtf.getText());
		double exp = Double.parseDouble(exptf.getText());
		if (exp >= 100) {
			lv++;
			exp = Math.abs(100 - exp); 
		}
		
		
		String lvs = new DecimalFormat("###").format(lv);
		lvlb.setText(lvs);
		String exps = new DecimalFormat("##.##").format(exp);
		explb.setText(exps);
		String result = String.format("Level : %s, Exp : %s", lv, exp);
		rlb.setText(result);
		
	}
}
