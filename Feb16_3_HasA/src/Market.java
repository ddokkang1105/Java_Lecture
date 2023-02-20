
public class Market {
	String name;
	String location;
	Plate grill;
	
	public Market() {
		// TODO Auto-generated constructor stub
	}

	public Market(String name, String location, Plate grill) {
		super();
		this.name = name;
		this.location = location;
		this.grill = grill;
	}
	
	public void printInfo() {
		System.out.printf("NAME : %s\n", this.name);
		System.out.printf("LOCATION : %s\n", this.location);
		grill.printInfo();
	}
	
}
