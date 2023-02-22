package com.ddokkang.feb224.main;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class SCMain2 {
	public static void main(String[] args) {
		Socket s = null;

		try {
			s = new Socket("192.168.0.164", 3307);
			System.out.println("¿¬°áµÊ !");
			Scanner k = new Scanner(System.in);

			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(isr);

			Robot r = new Robot();
			while (true) {
				String msg = br.readLine();
				if (msg.contains(",")) {
					String[] ab = msg.split(",");
					int x = Integer.parseInt(ab[0]);
					int y = Integer.parseInt(ab[1]);
					r.mouseMove(x, y);
				} else if (msg.equals("l")) {
					r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
					r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				} else if (msg.equals("r")) {
					r.mousePress(InputEvent.BUTTON3_DOWN_MASK);
					r.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
				} else {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
