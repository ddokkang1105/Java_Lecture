package com.ddokkang.feb202.frame;

import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NumberFrame extends JFrame {
	JPanel p = new JPanel();
	JLabel[] l = new JLabel[30];

	public NumberFrame() {
		p.setLayout(null);
		p.setBackground(Color.RED);
		Random r = new Random();
		int x = 0;
		int y = 0;

		for (int i = 0; i < 30; i++) {
			l[i] = new JLabel("" + (i + 1));
			x = r.nextInt(475);
			y = r.nextInt(475);
			l[i].setForeground(Color.BLACK);
			l[i].setLocation(x, y);
			l[i].setSize(25, 25);
			
			p.add(l[i]);
		}
		add(p);
		setTitle("Random Number");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
