
// 가위바위보
// 1. 등장인물 누구 ? => 심판 / 동생 / 친구
//		=> 다 같이 한 자리에 있음
//		=> 심판한테는 룰북이 있음
//		1 가위 / 2 바위 / 3 보
// 2. 각 객체들 속성 ? 행동 ?
// 3. 한 판 질 동안에 몇 승 / 몇 무 했는지? -> 동생 vs 친구 , user vs com
// 


public class OMain1 {
	public static void main(String[] args) throws InterruptedException {
//		Brother b = new Brother();
//		Friend f = new Friend();
//		Referee r = new Referee();
//		
//		r.start(b, f);
		
		Judge j = new Judge();
		Maru m = new Maru();
		Sister s = new Sister();
		
		j.start(m, s);
		
	}
}
