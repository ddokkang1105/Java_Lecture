package com.ddokkang.mar283.main;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class Doctor {
	public static void calculate(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("EUC-KR");
			
			String path = request.getServletContext().getRealPath("img");
			System.out.println(path);
			
			MultipartRequest mr = new MultipartRequest(request, path,
					10 * 1024 * 1024, "EUC-KR", new DefaultFileRenamePolicy());
			
			String name = mr.getParameter("name");
			double height = Double.parseDouble(mr.getParameter("height"));
			double weight = Double.parseDouble(mr.getParameter("weight"));
			double bmi = weight / ((height / 100) * (height / 100));
			String bmiResult = null;
			
			// BMI 수치 => 소수점 둘째자리까지만 (*** 아래에서는 안되니까 여기서 해결 !!)
			String bmi2 = String.format("%.2f", bmi);
			double bmi3 = Double.parseDouble(bmi2);
			
			if (bmi >= 40) {
				bmiResult = "Severe obesity";
			} else if (bmi >= 30) {
				bmiResult = "Moderate obesity";
			} else if (bmi >= 25) {
				bmiResult = "Mild obesity";
			} else if (bmi >= 23) {
				bmiResult = "Overweight";
			} else if (bmi >= 18.5) {
				bmiResult = "Normal weight";
			} else {
				bmiResult = "Underweight";
			}
			
			String image = mr.getFilesystemName("image");
			
			image = URLEncoder.encode(image, "EUC-KR");
			image = image.replace("+", " ");
			
			// 객체를 만들어서 한꺼번에 보내자
			Patient p = new Patient(name, height, weight, bmi3, image, bmiResult);
			request.setAttribute("p", p);
			
		} catch (Exception e) {
			
		}
		
	}
	
//	private Patient p;
//	private String pName;
//	private int pAge;
//	private int pHeight;
//	private int pWeight;
//	private String pImage;
//	
//	public Doctor() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public Doctor(Patient p, String pName, int pAge, int pHeight, int pWeight, String pImage) {
//		super();
//		this.p = p;
//		this.pName = pName;
//		this.pAge = pAge;
//		this.pHeight = pHeight;
//		this.pWeight = pWeight;
//		this.pImage = pImage;
//	}
//
//	public Patient getP() {
//		return p;
//	}
//
//	public void setP(Patient p) {
//		this.p = p;
//	}
//
//	public String getpName() {
//		return pName;
//	}
//
//	public void setpName(String pName) {
//		this.pName = pName;
//	}
//
//	public int getpAge() {
//		return pAge;
//	}
//
//	public void setpAge(int pAge) {
//		this.pAge = pAge;
//	}
//
//	public int getpHeight() {
//		return pHeight;
//	}
//
//	public void setpHeight(int pHeight) {
//		this.pHeight = pHeight;
//	}
//
//	public int getpWeight() {
//		return pWeight;
//	}
//
//	public void setpWeight(int pWeight) {
//		this.pWeight = pWeight;
//	}
//
//	public String getpImage() {
//		return pImage;
//	}
//
//	public void setpImage(String pImage) {
//		this.pImage = pImage;
//	}

	
	
	
}
