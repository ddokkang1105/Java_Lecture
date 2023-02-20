
public class Army extends Person {
	String rank;
	
	public Army() {
		// TODO Auto-generated constructor stub
	}

	public Army(String name, int age, String affiliation, String rank) {
		super(name, age, affiliation);
		this.rank = rank;
	}

	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.printf("Rank : %s\n", rank);
	}
}
