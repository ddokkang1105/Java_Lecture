import java.util.Scanner;


public class KIMain2 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
//		System.out.print("직사각형의 가로 길이를 입력하세요 : ");
//		double width = keyboard.nextDouble();
//		System.out.print("직사각형의 세로 길이를 입력하세요 : ");
//		double length = keyboard.nextDouble();
//		double recArea = width * length;
//		System.out.printf("직사각형의 넓이는 : \"%.02f\"입니다.\n", recArea);
//		
//		System.out.println();
//		System.out.print("반지름을 입력하세요 : ");
//		double radius = keyboard.nextDouble();
//		// double cirArea = radius * radius * 3.14;
//		// Math.PI -> 수학 관련 도구
//		double cirArea = Math.PI * Math.pow(radius, 2);
//		System.out.printf("원의 넓이는 : \"%.2f\"입니다.\n", cirArea);

		System.out.print("시간이나 분을 알고 싶은 초를 입력하세요 : ");
		int sec = keyboard.nextInt();
		double min = (double) sec / 60;
		double hour = min / 60;
		System.out.printf("%d초는 %.2f분입니다.\n", sec, min);
		System.out.printf("%.2f분은 %.2f시간입니다.\n", min, hour);
		
		
	}
}
