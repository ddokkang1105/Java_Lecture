package com.ddokkang.feb224.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class SCMain1 {
	public static void main(String[] args) {
		Socket s = null;
		try {
			s = new Socket("192.168.0.164", 3306);
			System.out.println("연결됨 !");
			Scanner k = new Scanner(System.in);
			
			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			
			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			while (true) {
				System.out.printf("상대] %s\n", br.readLine());
				
				System.out.print("나] ");
				String msg = k.next();
				bw.write(msg + "\r\n");
				bw.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				s.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		
		
	}
}
