import java.util.Iterator;

public class PMain2 {

	public static void main(String[] args) {

		int h24 = 1 << 0;
		int parking = 1 << 1;
		int wifi = 1 << 2;
		int smoking = 1 << 3;

		int cafe1 = 10;
		int num = 0;

//		for (int i = 0; i < 4; i++) {
//			if ((cafe1 & (1 << i)) != 0) {
//				switch (1 << i) {
//				case 1:
//					System.out.println("24시간");
//					break;
//				case 2:
//					System.out.println("주차장");
//					break;
//				case 4:
//					System.out.println("Wifi");
//					break;
//				case 8:
//					System.out.println("흡연실");
//					break;
//				}
//				System.out.println(1 << i);
//			}
//		}

//		if (cafe1 >= (1 << 3)) {
//			System.out.println("흡연실");
//			cafe1 -= (1 << 3);
//		}
//		if (cafe1 >= (1 << 2)) {
//			System.out.println("Wifi");
//			cafe1 -= (1 << 2);
//		}
//		if (cafe1 >= (1 << 1)) {
//			System.out.println("주차장");
//			cafe1 -= (1 << 1);
//		}
//		if (cafe1 >= (1 << 0)) {
//			System.out.println("24시간");
//			cafe1 -= (1 << 0);
//		}

		int cafe2 = 13;
		String[] option = { "24시간", "주차장", "Wifi", "흡연실" };
		for (int i = option.length - 1; i >= 0; i--) {
			if (cafe2 >= (1 << i)) {
				System.out.println(option[i]);
				cafe2 -= (1    << i);
			}
		}
		System.out.println(cafe2);
	}
}
