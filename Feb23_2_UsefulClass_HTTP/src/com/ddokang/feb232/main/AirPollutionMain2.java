package com.ddokang.feb232.main;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.ddokkang.http.client.DdokkangHttpClient;

// �̼����� -> �Ľ� -> ������ -> txt���Ͽ� ���
// (���α׷� �����) ��¥, ������, �̼�����, �ʹ̼�����, ����, �̻�ȭ����, �ϻ�ȭź��, �ƻ�ȭ���� ���
// ��¥���� : ��-��-��-����/����-��-����
// ���� X

public class AirPollutionMain2 {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		BufferedWriter bw = null;
		try {
			fos = new FileOutputStream("C:\\Users\\sdedu\\Desktop\\Java_Test\\encoding\\SeoulAirPollution.txt", true);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		OutputStreamWriter osw = null;
		try {
			osw = new OutputStreamWriter(fos, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		bw = new BufferedWriter(osw);
		
		try {
			Date now = new Date();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-a-hh-E");
			String nowTime = sdf.format(now);
						
			String address = "http://openAPI.seoul.go.kr:8088/4f626857416f6c6c3632586a416843/xml/RealtimeCityAir/1/25/";

			InputStream is = DdokkangHttpClient.download(address);

			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is, "UTF-8");

			int type = xpp.getEventType();
			String tagName = null;
			while (type != XmlPullParser.END_DOCUMENT) {
				if (type == XmlPullParser.START_TAG) {
					tagName = xpp.getName();
				} else if (type == XmlPullParser.TEXT) {
					if (tagName.equals("MSRSTE_NM")) {
						bw.write(nowTime + ",");
						bw.append(xpp.getText() + ",");
					} else if (tagName.equals("PM10")) {
						bw.append(xpp.getText() + ",");
					} else if (tagName.equals("PM25")) {
						bw.append(xpp.getText() + ",");
					} else if (tagName.equals("O3")) {
						bw.append(xpp.getText() + ",");
					} else if (tagName.equals("NO2")) {
						bw.append(xpp.getText() + ",");
					} else if (tagName.equals("CO")) {
						bw.append(xpp.getText() + ",");
					} else if (tagName.equals("SO2")) {
						bw.append(xpp.getText());
						bw.append("\r\n");
					}

				} else if (type == XmlPullParser.END_TAG) {
					tagName = "";
				}
				xpp.next();
				type = xpp.getEventType();
			}
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
////////////////////////////////////////////////////////////////////////////////////
		// Ǯ�� ����
////////////////////////////////////////////////////////////////////////////////////
//		FileOutputStream fos1 = null;
//		try {
//			fos1 = new FileOutputStream("C:\\Users\\sdedu\\Desktop\\Java_Test\\encoding\\SAPSolution.txt", true);
//			OutputStreamWriter osw1 = new OutputStreamWriter(fos1, "UTF-8");
//			BufferedWriter bw1 = new BufferedWriter(osw1);
//			
//			Date now = new Date();
//			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd-a-hh-E");
//			String nowStr = sdf1.format(now);
//			
//			String address = "http://openAPI.seoul.go.kr:8088/4f626857416f6c6c3632586a416843/xml/RealtimeCityAir/1/25/";
//			
//			InputStream is = DdokkangHttpClient.download(address);
//			
//			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
//			XmlPullParser xpp = xppf.newPullParser();
//			xpp.setInput(is, "UTF-8");
//			
//			int type = xpp.getEventType();
//			String tagName = null;
//			
//			while (type != XmlPullParser.END_DOCUMENT) {
//				if (type == XmlPullParser.START_TAG) {
//					tagName = xpp.getName();
//				} else if (type == XmlPullParser.TEXT) {
//					// ����
//					if (tagName.equals("MSRSTE_NM")) {
//						bw1.write(nowStr + ",");
//						bw1.append(xpp.getText() + ",");
//					} else if (tagName.equals("PM10")) {
//						bw1.append(xpp.getText() + ",");
//					} else if (tagName.equals("PM25")) {
//						bw1.append(xpp.getText() + ",");
//					} else if (tagName.equals("O3")) {
//						bw1.append(xpp.getText() + ",");
//					} else if (tagName.equals("NO2")) {
//						bw1.append(xpp.getText() + ",");
//					} else if (tagName.equals("CO")) {
//						bw1.append(xpp.getText() + ",");
//					} else if (tagName.equals("SO2")) {
//						bw1.append(xpp.getText() + "\r\n");
//						bw1.flush();
//					}
//
//				} else if (type == XmlPullParser.END_TAG) {
//					tagName = "";
//				}
//				xpp.next();
//				type = xpp.getEventType();
//			}
//			System.out.println("���� ���� �Ϸ� !");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			fos1.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
// ���� ����
//		FileOutputStream fos = null;
//		BufferedWriter bw = null;
//		try {
//			fos = new FileOutputStream("C:\\Users\\sdedu\\Desktop\\Java_Test\\encoding\\SeoulAirPollution.txt", true);
//		} catch (FileNotFoundException e1) {
//			e1.printStackTrace();
//		}
//		
//		OutputStreamWriter osw = null;
//		try {
//			osw = new OutputStreamWriter(fos, "UTF-8");
//		} catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//		}
//		
//		bw = new BufferedWriter(osw);
//		
//		try {
//			bw.write("����ð�" + "\r\n");
//			bw.append("=======================================" + "\r\n");
//			Date now = new Date();
//			
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-a-hh-E");
//			String nowTime = sdf.format(now);
//			bw.append(nowTime + "\r\n");
//			
//			bw.append("=======================================" + "\r\n");
//			bw.append("����� �ǿ��� �ǽð� ���ȯ�� ��Ȳ" + "\r\n");
//			bw.append("=======================================" + "\r\n");
//			String address = "http://openAPI.seoul.go.kr:8088/4f626857416f6c6c3632586a416843/xml/RealtimeCityAir/1/25/";
//			
//			InputStream is = DdokkangHttpClient.download(address);
//			
//			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
//			XmlPullParser xpp = xppf.newPullParser();
//			xpp.setInput(is, "UTF-8");
//			
//			int type = xpp.getEventType();
//			String tagName = null;
//			while (type != XmlPullParser.END_DOCUMENT) {
//				if (type == XmlPullParser.START_TAG) {
//					tagName = xpp.getName();
//				} else if (type == XmlPullParser.TEXT) {
//					if (tagName.equals("MSRSTE_NM")) {
//						bw.append("���� �� : " + xpp.getText() + "\r\n");
//					} else if (tagName.equals("PM10")) {
//						bw.append("�̼����� : " + xpp.getText() + "\r\n");
//					} else if (tagName.equals("PM25")) {
//						bw.append("�ʹ̼����� : " + xpp.getText() + "\r\n");
//					} else if (tagName.equals("O3")) {
//						bw.append("���� : " + xpp.getText() + "\r\n");
//					} else if (tagName.equals("NO2")) {
//						bw.append("�̻�ȭ���� : " + xpp.getText() + "\r\n");
//					} else if (tagName.equals("CO")) {
//						bw.append("�ϻ�ȭź�� : " + xpp.getText() + "\r\n");
//					} else if (tagName.equals("SO2")) {
//						bw.append("��Ȳ�갡�� : " + xpp.getText() + "\r\n");
//						bw.append("=======================================" + "\r\n");
//					}
//					
//				} else if (type == XmlPullParser.END_TAG) {
//					tagName = "";
//				}
//				xpp.next();
//				type = xpp.getEventType();
//			}
//			bw.flush();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			bw.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}
