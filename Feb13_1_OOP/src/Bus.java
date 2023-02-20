
public class Bus {
	int num;
	String type;
	String company;
	String driverName;
	String startingPoint;
	
	public void printInfo() {
		System.out.printf("버스 번호 : %d\n", this.num);
		System.out.printf("버스 종류 : %s\n", this.type);
		System.out.printf("버스 회사 : %s\n", this.company);
		System.out.printf("기사님 성함 : %s\n", this.driverName);
		System.out.printf("버스 출발지 : %s\n", startingPoint);
	}
	
	public void go() {
		System.out.println("부릉부릉 ~ ");
	}
}
