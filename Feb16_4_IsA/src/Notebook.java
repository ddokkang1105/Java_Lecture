
public class Notebook extends Computer {
	double weight;
	int batteryTime;
	
	public Notebook() {
		// TODO Auto-generated constructor stub
	}

	public Notebook(String name, int price, String cpu, int ram, int sdd, double weight, int batteryTime) {
		super(name, price, cpu, ram, sdd);
		this.weight = weight;
		this.batteryTime = batteryTime;
	}
	
	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.printf("WEIGHT : %.1f g\n", weight);
		System.out.printf("BATTERY TIME : %d Hour\n", batteryTime);
	}
}
