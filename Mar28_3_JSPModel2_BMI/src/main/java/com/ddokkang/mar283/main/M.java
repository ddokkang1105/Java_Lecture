package com.ddokkang.mar283.main;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class M {
	public static void resultBMI(HttpServletRequest request) throws IOException {
//		String path = request.getServletContext().getRealPath("img");
//		System.out.println(path);
//		
//		MultipartRequest mr = new MultipartRequest(request, path,
//				10 * 1024 * 1024, "EUC-KR", new DefaultFileRenamePolicy());
//		
//		
//		
//		Doctor d = new Doctor();
//		d.setP(new Patient());
//		d.setpName(mr.getParameter("name"));
//		System.out.println(d.getpName());
//		d.setpAge(Integer.parseInt(mr.getParameter("age")));
//		d.setpHeight(Integer.parseInt(mr.getParameter("height")));
//		d.setpWeight(Integer.parseInt(mr.getParameter("weight")));
//		d.setpImage(mr.getParameter("image"));
//		
//		double heightToMeter = (double) d.getpHeight() / 100;
//		double bmi = (double) (d.getpWeight() / (heightToMeter * heightToMeter));
//		
//		
//		String bmiResult = null;
//		if (bmi >= 40) {
//			bmiResult = "Severe obesity";
//		} else if (bmi >= 30) {
//			bmiResult = "Moderate obesity";
//		} else if (bmi >= 25) {
//			bmiResult = "Mild obesity";
//		} else if (bmi >= 23) {
//			bmiResult = "Overweight";
//		} else if (bmi >= 18.5) {
//			bmiResult = "Normal weight";
//		} else {
//			bmiResult = "Underweight";
//		}
//		
//		String fileName = mr.getFilesystemName("image");
//		
//		fileName = URLEncoder.encode(fileName, "EUC-KR");
//		fileName = fileName.replace("+", " ");
//		
//		
//		request.setAttribute("bmi", bmi);
//		request.setAttribute("bmiResult", bmiResult);
//		
//		System.out.println(request.getAttribute("bmi"));
//		System.out.println(request.getAttribute("bmiResult"));
//		
//		
//		
//		
////		String bmiToString = String.format("%.2f", bmi);
////		request.setAttribute("bmi", bmiToString);
//	}
//	
//	public static void resultBMI(HttpServletRequest request, Doctor d) throws IOException {
//		
//		
//		String path = request.getServletContext().getRealPath("img");
//		System.out.println(path);
//		
//		MultipartRequest mr = new MultipartRequest(request, path,
//				10 * 1024 * 1024, "EUC-KR", new DefaultFileRenamePolicy());
//		
//		d.setP(new Patient());
//		d.setpName(mr.getParameter("name"));
//		System.out.println(d.getpName());
//		d.setpAge(Integer.parseInt(mr.getParameter("age")));
//		d.setpHeight(Integer.parseInt(mr.getParameter("height")));
//		d.setpWeight(Integer.parseInt(mr.getParameter("weight")));
//		d.setpImage(mr.getParameter("image"));
//		
//		double heightToMeter = (double) d.getpHeight() / 100;
//		double bmi = (double) (d.getpWeight() / (heightToMeter * heightToMeter));
//		
//		
//		String bmiResult = null;
//		if (bmi >= 40) {
//			bmiResult = "Severe obesity";
//		} else if (bmi >= 30) {
//			bmiResult = "Moderate obesity";
//		} else if (bmi >= 25) {
//			bmiResult = "Mild obesity";
//		} else if (bmi >= 23) {
//			bmiResult = "Overweight";
//		} else if (bmi >= 18.5) {
//			bmiResult = "Normal weight";
//		} else {
//			bmiResult = "Underweight";
//		}
//		
//		String fileName = mr.getFilesystemName("image");
//		
//		fileName = URLEncoder.encode(fileName, "EUC-KR");
//		fileName = fileName.replace("+", " ");
//		
//		request.setAttribute("fileName", fileName);
//		request.setAttribute("bmi", bmi);
//		request.setAttribute("bmiResult", bmiResult);
//		
//		System.out.println(request.getAttribute("bmi"));
//		System.out.println(request.getAttribute("bmiResult"));
//		
////		String bmiToString = String.format("%.2f", bmi);
////		request.setAttribute("bmi", bmiToString);
		
		
		
		
		
	}
}
