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
//					System.out.println("24�ð�");
//					break;
//				case 2:
//					System.out.println("������");
//					break;
//				case 4:
//					System.out.println("Wifi");
//					break;
//				case 8:
//					System.out.println("����");
//					break;
//				}
//				System.out.println(1 << i);
//			}
//		}

//		if (cafe1 >= (1 << 3)) {
//			System.out.println("����");
//			cafe1 -= (1 << 3);
//		}
//		if (cafe1 >= (1 << 2)) {
//			System.out.println("Wifi");
//			cafe1 -= (1 << 2);
//		}
//		if (cafe1 >= (1 << 1)) {
//			System.out.println("������");
//			cafe1 -= (1 << 1);
//		}
//		if (cafe1 >= (1 << 0)) {
//			System.out.println("24�ð�");
//			cafe1 -= (1 << 0);
//		}

		int cafe2 = 13;
		String[] option = { "24�ð�", "������", "Wifi", "����" };
		for (int i = option.length - 1; i >= 0; i--) {
			if (cafe2 >= (1 << i)) {
				System.out.println(option[i]);
				cafe2 -= (1    << i);
			}
		}
		System.out.println(cafe2);
	}
}
