
public class Dog extends Animal {
	String inhabit;
	
	public Dog() {
		// TODO Auto-generated constructor stub
	}

	public Dog(String sort, int age, String inhabit) {
		super(sort, age);
		this.inhabit = inhabit;
	}

	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.printf("INHABIT : %s\n", inhabit);
	}
	
	
}
