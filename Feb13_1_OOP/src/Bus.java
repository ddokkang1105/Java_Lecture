
public class Bus {
	int num;
	String type;
	String company;
	String driverName;
	String startingPoint;
	
	public void printInfo() {
		System.out.printf("���� ��ȣ : %d\n", this.num);
		System.out.printf("���� ���� : %s\n", this.type);
		System.out.printf("���� ȸ�� : %s\n", this.company);
		System.out.printf("���� ���� : %s\n", this.driverName);
		System.out.printf("���� ����� : %s\n", startingPoint);
	}
	
	public void go() {
		System.out.println("�θ��θ� ~ ");
	}
}
