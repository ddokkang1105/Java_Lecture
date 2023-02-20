
public class Restaurant {
	String name;
	String location;
	String number;
	Human h;
	
	public Restaurant() {
		// TODO Auto-generated constructor stub
	}

	public Restaurant(String name, String location, String number, Human h) {
		super();
		this.name = name;
		this.location = location;
		this.number = number;
		this.h = h;
	}
	
	public void printInfo() {
		System.out.printf("NAME : %s\n", this.name);
		System.out.printf("Location : %s\n", this.location);
		System.out.printf("NUMBER : %s\n", this.number);
		h.printInfo();
		}
}
