
public class VMain3 {
	public static void main(String[] args) {
		// IntroductionMyself();
		TodayLunchGrade();
	}
	
	public static void IntroductionMyself() {
		String myName = "김도깡";
		int year = 2023;
		int month = 1;
		int day = 30;
		String liveIn = "서울";
		double sight = -4.0;
		boolean javaExp = true;

		System.out.printf("이름 : %s\n", myName);
		System.out.printf("오늘 날짜 : %4d년 %02d월 %02d일\n", year, month, day);
		System.out.printf("사는 곳 : %s\n", liveIn);
		System.out.printf("시력 : %.1f\n", sight);
		System.out.printf("Java 경험의 유무 : %b\n", javaExp);		
	}
	
	public static void TodayLunchGrade() {
		String lunchMenu = "돈까스";
		int lunchPrice = 10000;
		int lunchCalorie = 555;
		double lunchGrade = 4.6;
		boolean lunchReVisit = true;
		
		System.out.printf("점심이름 : %s\n", lunchMenu);
		System.out.printf("점심가격 : %d원\n", lunchPrice);
		System.out.printf("점심칼로리 : %d\n", lunchCalorie);
		System.out.printf("점심평점 : %.1f점\n", lunchGrade);
		System.out.printf("나중에 또 먹을 것인지 : %b\n", lunchReVisit);		
		
	}
}
