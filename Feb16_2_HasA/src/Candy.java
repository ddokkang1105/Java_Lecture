
//	public class Candy extends Company {
public class Candy {
	String name;
	String taste;
	Company brand;
	
	public Candy() {
		// TODO Auto-generated constructor stub
	}

	public Candy(String name, String taste) {
		super();
		this.name = name;
		this.taste = taste;
	}

	public void printInfo() {
		System.out.printf("Name : %s\n", this.name);
		System.out.printf("Taste : %s\n", this.taste);
	}
	
//	public void printCompany(Company c) {
//		super.printInfo();
//	}
}
