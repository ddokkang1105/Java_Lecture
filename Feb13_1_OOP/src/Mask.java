
public class Mask {
	String maskName;
	String maskBuyPlace;
	int maskPrice;
	
	public void printInfo() {
		System.out.printf("�̸� : %s\n", maskName);
		System.out.printf("����ó : %s\n", maskBuyPlace);
		System.out.printf("���� : %,d��\n", maskPrice);
	}
}
