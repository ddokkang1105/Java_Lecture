
public class Computer extends Product {
	String cpu;
	int ram;
	int sdd;
	
	public Computer() {
		// TODO Auto-generated constructor stub
	}

	public Computer(String name, int price, String cpu, int ram, int sdd) {
		super(name, price);
		this.cpu = cpu;
		this.ram = ram;
		this.sdd = sdd;
	}
	
	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.printf("CPU : %s\n", cpu);
		System.out.printf("RAM : %d GB\n", ram);
		System.out.printf("SDD : %d TB\n", sdd);
	}
}
