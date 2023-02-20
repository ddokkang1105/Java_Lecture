// OOD(Object Oriented Design) - 객체 지향 디자인
//		실생활을 디자인

// 지역변수 (Local Variable)
//		메소드 속에서 만든 변수
//		그 행동을 하는 동안만 필요한 임시변수...
// 메소드 파라미터 (Parameter)
//		그 행동을 하는데 필요한 재료
// 리턴되는 값
//		그 행동을 한 후의 결과물
// 멤버변수 (Member Variable)
//		그 객체의 속성




public class OMain1 {
	public static void main(String[] args) {
//		Hospital h = new Hospital();
//		h.d.doctorName = "길동";
//		h.d.doctorAge = 50;
//		
//		h.p.patientName = "둘리";
//		h.p.patientAge = 10;
//		
//		h.printDocInfo();
//		System.out.println("==========================");
//		h.printPatiInfo();
//		System.out.println("==========================");
		
		Doctor d = new Doctor();
		Patient p = new Patient();
		d.doBMIProgram(p);
	}
}
