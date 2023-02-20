
public class Company {
	String name;
	String location;
	int companyPeople;
	
	public Company() {
		// TODO Auto-generated constructor stub
	}

	public Company(String name, String location, int companyPeople) {
		super();
		this.name = name;
		this.location = location;
		this.companyPeople = companyPeople;
	}
	
	public void printInfo() {
		System.out.printf("Name : %s\n", this.name);
		System.out.printf("Location : %s\n", this.location);
		System.out.printf("CompanyPeople : %d\n", this.companyPeople);
	}

}
