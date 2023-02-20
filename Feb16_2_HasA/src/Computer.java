
public class Computer {
	String cpu;
	int ram;
	int hdd;
	Company brand;
	
	public Computer() {
		// TODO Auto-generated constructor stub
	}
	
	public Computer(String cpu, int ram, int hdd, Company brand) {
		super();
		this.cpu = cpu;
		this.ram = ram;
		this.hdd = hdd;
		this.brand = brand;
	}

	public void printInfo() {
		System.out.printf("CPU : %s\n", this.cpu);
		System.out.printf("RAM : %d GB\n", this.ram);
		System.out.printf("HDD : %d GB\n", this.hdd);
		System.out.println();
		System.out.println("¡ØComputer Company Information¡Ø");
		brand.printInfo();
	}
}
