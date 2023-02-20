
public class VMain2 {
	public static void main(String[] args) {

		String name = "섬유향수";
		int price = 1000;
		int capacity = 80;
		String smell = "체리블라썸";
		double germ = 99.9;
		boolean color = false;
		String company = "다이소";
		boolean recycle = true;

		System.out.printf("이름 : %s\n", name);
		System.out.printf("가격 : %d원\n", price);
		System.out.printf("용량 : %dml\n",capacity);
		System.out.printf("냄새 : %s\n",smell);
		System.out.printf("향균 : %.1f%%\n",germ);
		System.out.println(String.valueOf(color)+"색");
		System.out.println(Boolean.toString(color));
		
		if (color != false) {
			System.out.println(String.valueOf("무색"));
			System.out.printf("색 : %s\n",String.valueOf("무색"));
		}
		System.out.printf("회사 : %s\n",company);
		System.out.printf("재활용 : %b\n",recycle);
	}
}
