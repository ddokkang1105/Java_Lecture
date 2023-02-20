
public class RMain2 {

	public static void main(String[] args) throws InterruptedException {

//		int hour = 0;
//		int min = 0;
//		int sec = 0;
//		int day = 7;
//		
//		for (int time = 0; true; time++) {
//			sec = time;
//			min = sec / 60;
//			hour = min / 60;
//			System.out.printf("[Day %02d] %02d:%02d:%02d\n", day, hour, min, sec);
//			Thread.sleep(1000);
//		}

//		for (int day = 0; day < 30; day++) {
//			for (int hour = 0; hour < 24; hour++) {
//				for (int min = 0; min < 60; min++) {
//					for (int sec = 0; sec < 60; sec++) {
//						System.out.printf("[Day %02d] %02d:%02d:%02d\n", day, hour, min, sec);
//						Thread.sleep(1000);
//
//					}
//				}
//			}
//		}

//		int sum = 0;
//		
//		for (int i = 1; i <= 100; i++) {
//			if (i % 6 == 0) {
//				sum += i;
//			}
//		}
//		System.out.println(sum);

		for (int x = 1; x <= 10; x++) {
			for (int y = 1; y <= 10; y++) {
				if ((4 * x + 5 * y) == 60) {
					System.out.printf("(%d, %d)\n", x, y);
				}
			}
		}

	}
}
