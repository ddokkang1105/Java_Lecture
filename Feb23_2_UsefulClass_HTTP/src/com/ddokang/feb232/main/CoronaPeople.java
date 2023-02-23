package com.ddokang.feb232.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.ddokkang.http.client.DdokkangHttpClient;

public class CoronaPeople {
	public static void main(String[] args) {
		String address = "http://openapi.seoul.go.kr:8088/4f626857416f6c6c3632586a416843/xml/TbCorona19CountStatusJCG/1/25/2023.02.23.00";

		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("C:\\Users\\sdedu\\Desktop\\Java_Test\\encoding\\SeoulCoronaVirusPeople.txt",
					true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);

//			Date now = new Date();
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/E a hh");
//			String nowStr = sdf.format(now);
//			System.out.println(nowStr + "�� ����");

			InputStream is = DdokkangHttpClient.download(address);

			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is, "UTF-8");

			int type = xpp.getEventType();
			String tagName = null;
			int[] seoulSum = new int[25];
			while (type != XmlPullParser.END_DOCUMENT) {
				if (type == XmlPullParser.START_TAG) {
					tagName = xpp.getName();
				} else if (type == XmlPullParser.TEXT) {
					if (tagName.equals("JCG_DT")) {
						String day = xpp.getText();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.hh");
						Date dayToDate = sdf.parse(day);

						SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd a hh");
						String dateStr = sdf1.format(dayToDate);
						System.out.println(dateStr + "�� ����");
						System.out.println("=====================================");
					} else if (tagName.equals("JONGNO")) {
						seoulSum[0] = Integer.parseInt(xpp.getText());
					} else if (tagName.equals("JONGNOADD")) {
						seoulSum[0] += Integer.parseInt(xpp.getText());
						System.out.printf("���α� ��ü : %,d��\r\n", seoulSum[0]);
					} else if (tagName.equals("JUNGGU")) {
						seoulSum[1] += Integer.parseInt(xpp.getText());
					} else if (tagName.equals("JUNGGUADD")) {
						seoulSum[1] += Integer.parseInt(xpp.getText());
						System.out.printf("�߱� ��ü : %,d��\r\n", seoulSum[1]);
					} else if (tagName.equals("YONGSAN")) {
						seoulSum[2] += Integer.parseInt(xpp.getText());
					} else if (tagName.equals("YONGSANADD")) {
						seoulSum[2] += Integer.parseInt(xpp.getText());
						System.out.printf("��걸 ��ü : %,d��\r\n", seoulSum[2]);
					} else if (tagName.equals("SEONGDONG")) {
						seoulSum[3] += Integer.parseInt(xpp.getText());
					} else if (tagName.equals("SEONGDONGADD")) {
						seoulSum[3] += Integer.parseInt(xpp.getText());
						System.out.printf("������ ��ü : %,d��\r\n", seoulSum[3]);
					} else if (tagName.equals("GWANGJIN")) {
						seoulSum[4] += Integer.parseInt(xpp.getText());
					} else if (tagName.equals("GWANGJINADD")) {
						seoulSum[4] += Integer.parseInt(xpp.getText());
						System.out.printf("������ ��ü : %,d��\r\n", seoulSum[4]);
					} else if (tagName.equals("DDM")) {
						seoulSum[5] += Integer.parseInt(xpp.getText());
					} else if (tagName.equals("DDMADD")) {
						seoulSum[5] += Integer.parseInt(xpp.getText());
						System.out.printf("���빮�� ��ü : %,d��\r\n", seoulSum[5]);
					} else if (tagName.equals("JUNGNANG")) {
						seoulSum[6] += Integer.parseInt(xpp.getText());
					} else if (tagName.equals("JUNGNANGADD")) {
						seoulSum[6] += Integer.parseInt(xpp.getText());
						System.out.printf("�߶��� ��ü : %,d��\r\n", seoulSum[6]);
					} else if (tagName.equals("SEONGBUK")) {
						seoulSum[7] += Integer.parseInt(xpp.getText());
					} else if (tagName.equals("SEONGBUKADD")) {
						seoulSum[7] += Integer.parseInt(xpp.getText());
						System.out.printf("���ϱ� ��ü : %,d��\r\n", seoulSum[7]);
					} else if (tagName.equals("GANGBUK")) {
						seoulSum[8] += Integer.parseInt(xpp.getText());
					} else if (tagName.equals("GANGBUKADD")) {
						seoulSum[8] += Integer.parseInt(xpp.getText());
						System.out.printf("���ϱ� ��ü : %,d��\r\n", seoulSum[8]);
					} else if (tagName.equals("DOBONG")) {
						seoulSum[9] += Integer.parseInt(xpp.getText());
					} else if (tagName.equals("DOBONGADD")) {
						seoulSum[9] += Integer.parseInt(xpp.getText());
						System.out.printf("������ ��ü : %,d��\r\n", seoulSum[9]);
					} else if (tagName.equals("NOWON")) {
						seoulSum[10] += Integer.parseInt(xpp.getText());
					} else if (tagName.equals("NOWONADD")) {
						seoulSum[10] += Integer.parseInt(xpp.getText());
						System.out.printf("����� ��ü : %,d��\r\n", seoulSum[10]);
					} else if (tagName.equals("SDM")) {
						seoulSum[11] += Integer.parseInt(xpp.getText());
					} else if (tagName.equals("SDMADD")) {
						seoulSum[11] += Integer.parseInt(xpp.getText());
						System.out.printf("���빮�� ��ü : %,d��\r\n", seoulSum[11]);
					} else if (tagName.equals("MAPO")) {
						seoulSum[12] += Integer.parseInt(xpp.getText());
					} else if (tagName.equals("MAPOADD")) {
						seoulSum[12] += Integer.parseInt(xpp.getText());
						System.out.printf("������ ��ü : %,d��\r\n", seoulSum[12]);
					} else if (tagName.equals("YANGCHEON")) {
						seoulSum[13] += Integer.parseInt(xpp.getText());
					} else if (tagName.equals("YANGCHEONADD")) {
						seoulSum[13] += Integer.parseInt(xpp.getText());
						System.out.printf("��õ�� ��ü : %,d��\r\n", seoulSum[13]);
					} else if (tagName.equals("GANGSEO")) {
						seoulSum[14] += Integer.parseInt(xpp.getText());
					} else if (tagName.equals("GANGSEOADD")) {
						seoulSum[14] += Integer.parseInt(xpp.getText());
						System.out.printf("������ ��ü : %,d��\r\n", seoulSum[14]);
					} else if (tagName.equals("GURO")) {
						seoulSum[15] += Integer.parseInt(xpp.getText());
					} else if (tagName.equals("GUROADD")) {
						seoulSum[15] += Integer.parseInt(xpp.getText());
						System.out.printf("���α� ��ü : %,d��\r\n", seoulSum[15]);
					} else if (tagName.equals("GEUMCHEON")) {
						seoulSum[16] += Integer.parseInt(xpp.getText());
					} else if (tagName.equals("GEUMCHEONADD")) {
						seoulSum[16] += Integer.parseInt(xpp.getText());
						System.out.printf("��õ�� ��ü : %,d��\r\n", seoulSum[16]);
					} else if (tagName.equals("YDP")) {
						seoulSum[17] += Integer.parseInt(xpp.getText());
					} else if (tagName.equals("YDPADD")) {
						seoulSum[17] += Integer.parseInt(xpp.getText());
						System.out.printf("�������� ��ü : %,d��\r\n", seoulSum[17]);
					} else if (tagName.equals("DONGJAK")) {
						seoulSum[18] += Integer.parseInt(xpp.getText());
					} else if (tagName.equals("DONGJAKADD")) {
						seoulSum[18] += Integer.parseInt(xpp.getText());
						System.out.printf("���۱� ��ü : %,d��\r\n", seoulSum[18]);
					} else if (tagName.equals("GWANAK")) {
						seoulSum[19] += Integer.parseInt(xpp.getText());
					} else if (tagName.equals("GWANAKADD")) {
						seoulSum[19] += Integer.parseInt(xpp.getText());
						System.out.printf("���Ǳ� ��ü : %,d��\r\n", seoulSum[19]);
					} else if (tagName.equals("SEOCHO")) {
						seoulSum[20] += Integer.parseInt(xpp.getText());
					} else if (tagName.equals("SEOCHOADD")) {
						seoulSum[20] += Integer.parseInt(xpp.getText());
						System.out.printf("���ʱ� ��ü : %,d��\r\n", seoulSum[20]);
					} else if (tagName.equals("GANGNAM")) {
						seoulSum[21] += Integer.parseInt(xpp.getText());
					} else if (tagName.equals("GANGNAMADD")) {
						seoulSum[21] += Integer.parseInt(xpp.getText());
						System.out.printf("������ ��ü : %,d��\r\n", seoulSum[21]);
					} else if (tagName.equals("SONGPA")) {
						seoulSum[22] += Integer.parseInt(xpp.getText());
					} else if (tagName.equals("SONGPAADD")) {
						seoulSum[22] += Integer.parseInt(xpp.getText());
						System.out.printf("���ı� ��ü : %,d��\r\n", seoulSum[22]);
					} else if (tagName.equals("GANGDONG")) {
						seoulSum[23] += Integer.parseInt(xpp.getText());
					} else if (tagName.equals("GANGDONGADD")) {
						seoulSum[23] += Integer.parseInt(xpp.getText());
						System.out.printf("������ ��ü : %,d��\r\n", seoulSum[23]);
					} else if (tagName.equals("ETC")) {
						seoulSum[24] += Integer.parseInt(xpp.getText());
					} else if (tagName.equals("ETCADD")) {
						seoulSum[24] += Integer.parseInt(xpp.getText());
						System.out.printf("��Ÿ ��ü : %,d��\r\n", seoulSum[24]);
						System.out.println("=====================================");
					}

				} else if (type == XmlPullParser.END_TAG) {
					tagName = "";
				}
				xpp.next();
				type = xpp.getEventType();
			}
			int sum = 0;
			for (int i = 0; i < seoulSum.length; i++) {
				sum += seoulSum[i];
			}
			System.out.printf("����� ��ü : %,d��\n", sum);
			System.out.println("=====================================");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
