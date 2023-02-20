
public class YMain {

	public static void main(String[] args) throws InterruptedException {
		System.out.printf("몇 시간 잤습니까? : %.1f시간\n", 3.5);
		System.out.printf("아침 식사 메뉴는? : %s\n", "안 먹었습니다.");
		System.out.printf("주말에는 무엇을 했나요? : %s\n", "게임을 했습니다.");
		System.out.printf("어제는 몇 시에 잤나요? : %02d시 %02d분\n", 3, 30);
		System.out.printf("월요일을 맞은 소감은 어떤가요? : %s\n", "빨리 주말이 되었으면 좋겠습니다.");
		System.out.printf("오늘 컨디션은 어느정도 입니까? : %.2f%%\n", 55.55);

		Thread.sleep(5000);
	}

}
	