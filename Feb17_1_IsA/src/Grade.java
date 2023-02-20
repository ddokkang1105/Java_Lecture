
public class Grade extends Job {
	String grade;
	
	public Grade() {
		// TODO Auto-generated constructor stub
	}

	public Grade(String name, int age, String job, String grade) {
		super(name, age, job);
		this.grade = grade;
	}
	
	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.printf("Grade : %s\n", grade);
	}
}
