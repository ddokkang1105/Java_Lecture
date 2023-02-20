package com.ddokkang.feb172.main;

import com.ddokkang.feb172.product.Computer;

public class PMain1 {
	public static void main(String[] args) {
		Computer co = new Computer("MagicStation", 800000, "i5-1234", 32, 1);
		co.printInfo();
		System.out.println("================================");
		
		com.ddokkang.feb172.product.Scanner s
			= new com.ddokkang.feb172.product.Scanner(" ", 1000);
		s.printInfo();
	}
	
}
