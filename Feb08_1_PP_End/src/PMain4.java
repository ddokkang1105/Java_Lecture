// for-each (신형 for 문)
//		배열의 요소를 변경할 때는 사용 X !
// 			: 원본을 쓰는게 아닌 임시로 복사해서 쓰는 개념 !
//			: 원본에는 영향 X !
// 		순서 조절 불가능
//			: i(인덱스)가 없어서 원하는 값만을 사용할 수는 없다.
//			그래서 활용도가 떨어짐...

// for (자료형 변수명 : 대상배열) {
// 		내용
// }	



public class PMain4 {
	
	
	
	
	public static void main(String[] args) {
		String[] ss = { "ㅋㅋ", "ㅎㅎ", "ㅇㅇ", "^_^" };
//		for (int i = 0; i < ss.length; i++) {
//			System.out.println(ss[i]);
//		}
		
		for (String s2 : ss) {
			System.out.print(s2);
		}
	}
}
