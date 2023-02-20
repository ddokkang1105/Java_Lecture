
public class Mask {
	String maskName;
	String maskBuyPlace;
	int maskPrice;
	
	public void printInfo() {
		System.out.printf("이름 : %s\n", maskName);
		System.out.printf("구매처 : %s\n", maskBuyPlace);
		System.out.printf("가격 : %,d원\n", maskPrice);
	}
}
