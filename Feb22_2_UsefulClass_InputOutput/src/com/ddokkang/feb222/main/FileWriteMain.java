package com.ddokkang.feb222.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// CPU		: ������ġ
// RAM		: ������ġ(�ӽ�) - ������ϸ� ���ư�
// 				static / stack - ���α׷��� ����(�����ϸ�) ���ư�
//				heap - �ڵ����� ���ư����� �ʴµ�, Garbage Collector�� ������ �ڵ����� ���ư�
// HDD(SSD)	: ������ġ(����) - ����
// GPU		: �׷���ó���� ( GPU + RAM + HDD )

// ���α׷������� �����͸� �ܺο��� �а�, �ٽ� �ܺη� ����ϴ� �۾��� ���� �Ͼ�µ�
// �����ʹ� ����ڷκ��� Ű���带 ���ؼ� �Էµ� ���� �ְ�, (Scanner)
// ����.��Ʈ��ũ������ �Էµ� �� ����				       (Input)

// �ݴ��, �����ʹ� ����͸� ���ؼ� ��µ� ���� �ְ�, (System.out.println)
// ����.��Ʈ��ũ�ε� ��µ� �� ����				      (Output)

// System.in  -> InputStream
// System.out -> PrintStream

// 'Stream' : '����' -> I/O Device �� Program�� �������ִ� �����̶�� ���� !
//		�⺻��
//			InputStream			: ��ġ(Ű����, ����, ��Ʈ��ũ, ...) => ���α׷����� �Է� ( 1 byte �� )
//			InputStreamReader	: ��ġ => ���α׷� ( 2 byte �� )
//			BufferedReader		: ��ġ => ���α׷� ( 1 String - 1line )

//			OutputStream		: ���α׷��� ����� => ��ġ(Ű����, ����, ��Ʈ��ũ, ...) ( 1 byte �� )
//			OutputStreamWritter	: ( 2 byte �� )
//			BufferedWritter		: ( 1 String - 1line )

//		������ (Ư�������� �°�)
//			PrintStream (OutputStream ����)		 	- ���� ���ϰ� ������ �޼ҵ�� �߰�
//			FileReader 	(InputStreamReder ����)		- ���Ͽ��� �����͸� �о���� ���ϰ�
//			FileWritter (OutputStreamWritter ����)	- �����͸� ����ϱ� ���ϰ�
//			...

// System.in : �ܼ�â -> ���α׷� ( InputStream )
// JDK 1.5�� Scanner�� �߰�
// InputStream�� ����ϱ� ���ϰ� ����Ʈ !
// Scanner k = new Scanner(System.in);
// System.out.print("�Է� : ");
// String cmt = k.next();

// System.out : ���α׷� -> �ܼ�â ( PrintStream)
// System.out.println("===========================");

// FileWritter
//		���α׷� => ���� ( OutpurStreamWritter ������ )
//		������ ������ ����� �ֱ⵵ ��
//		������ �� ����� �� ^&^
//		Linux�� ���	: C:/Users/sdedu/Desktop/Java_Test/filewrite/test.txt 		=> /�� ��� ����
//		Windows�� ���	: C:\\Users\\sdedu\\Desktop\\Java_Test\\filewrite\\test.txt	=> \\�� ���� + / �ϳ��ε� ����
//																					   \ �ϳ��δ� �ȴ� !
// 		Java�� \�� : \t, \r, \n, \0, ... �� ��� (�̽������� ����)
//		����, ������ ��Ÿ, ... => ����ó��

//		// fw ���� bw ���� ����
//		// �ϳ��� �ݾ��ָ� �������� �˾Ƽ� ������.
//		BufferedWriter bw = null;
//		try {
//			// ������ ������ �̹� �����ϰ� ������ ����� ������
//			// ������ �ִ� ������ ������ ������� ��
//			// ������ ���� �ڿ� �����̰� �ʹٸ� ( �����͸� �߰��ϰ� �ʹٸ� )
//			// �� ��° �Ķ���� ������ true�� �ָ� �� !
//			// FileWriter fw = new FileWriter("��¼�� ��¼��", true);
//			
//			// Encoding ��� ���� X -> ANSI�� ���ڵ���
//			FileWriter fw = new FileWriter("C:\\Users\\sdedu\\Desktop\\Java_Test\\filewrite\\test.txt", true);
//			
//			// �� ����Ʈ �� ������ϴ� �ͺ��ٴ�
//			// '����'�� �̿��ؼ� �ѹ��� ���� ����Ʈ�� ������ϴ°� �� ����
//			//		=> ��κ��� ����� �۾����� ���
//			// ���� : CPU�� HDD ���̿��� ���Ǵ� �ӽ� ���� ����
//			// ���۸� : <������>�� ���۷� �����ϴ� ����
//			//		=> ���༺�� ��� ��ų �� ����
//			bw = new BufferedWriter(fw);
//			bw.write(cmt + "\r\n");
//			bw.write("--------------\r\n");
//			bw.flush();		// **�߿�** ���� �뷮�� �� ��ä������ ���������� �������� (��� ������ �� ������)
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			bw.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//		}

public class FileWriteMain {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.print("�Է� : ");
		String cmt = k.next();
		
		
		// fw ���� bw ���� ����
		// �ϳ��� �ݾ��ָ� �������� �˾Ƽ� ������.
		BufferedWriter bw = null;
		try {
			// ������ ������ �̹� �����ϰ� ������ ����� ������
			// ������ �ִ� ������ ������ ������� ��
			// ������ ���� �ڿ� �����̰� �ʹٸ� ( �����͸� �߰��ϰ� �ʹٸ� )
			// �� ��° �Ķ���� ������ true�� �ָ� �� !
			// FileWriter fw = new FileWriter("��¼�� ��¼��", true);
			
			// Encoding ��� ���� X -> ANSI�� ���ڵ���
			FileWriter fw = new FileWriter("C:\\Users\\sdedu\\Desktop\\Java_Test\\filewrite\\test.txt", true);
			
			// �� ����Ʈ �� ������ϴ� �ͺ��ٴ�
			// '����'�� �̿��ؼ� �ѹ��� ���� ����Ʈ�� ������ϴ°� �� ����
			//		=> ��κ��� ����� �۾����� ���
			// ���� : CPU�� HDD ���̿��� ���Ǵ� �ӽ� ���� ����
			// ���۸� : <������>�� ���۷� �����ϴ� ����
			//		=> ���༺�� ��� ��ų �� ����
			bw = new BufferedWriter(fw);
			bw.write(cmt + "\r\n");
			bw.write("--------------\r\n");
			bw.flush();		// **�߿�** ���� �뷮�� �� ��ä������ ���������� �������� (��� ������ �� ������)
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	
	
	
	
	}
}
