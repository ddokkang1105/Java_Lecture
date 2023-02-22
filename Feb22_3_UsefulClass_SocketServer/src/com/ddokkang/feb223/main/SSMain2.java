package com.ddokkang.feb223.main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SSMain2 {
	public static void main(String[] args) {
		ServerSocket ss = null;

		try {
			ss = new ServerSocket(3307);
			System.out.println("...");

			Socket s = ss.accept();
			System.out.println("¿¬°áµÊ !");

			Scanner k = new Scanner(System.in);
			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);

			while (true) {
				System.out.print("³ª] ");
				String msg = k.next();
				bw.write(msg + "\r\n");
				bw.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();

			try {
				ss.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
