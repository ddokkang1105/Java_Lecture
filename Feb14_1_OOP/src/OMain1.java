// OOD(Object Oriented Design) - ��ü ���� ������
//		�ǻ�Ȱ�� ������

// �������� (Local Variable)
//		�޼ҵ� �ӿ��� ���� ����
//		�� �ൿ�� �ϴ� ���ȸ� �ʿ��� �ӽú���...
// �޼ҵ� �Ķ���� (Parameter)
//		�� �ൿ�� �ϴµ� �ʿ��� ���
// ���ϵǴ� ��
//		�� �ൿ�� �� ���� �����
// ������� (Member Variable)
//		�� ��ü�� �Ӽ�




public class OMain1 {
	public static void main(String[] args) {
//		Hospital h = new Hospital();
//		h.d.doctorName = "�浿";
//		h.d.doctorAge = 50;
//		
//		h.p.patientName = "�Ѹ�";
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