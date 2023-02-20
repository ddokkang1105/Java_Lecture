
public class Job extends Human {
	String job;
	
	
	public Job() {
		// TODO Auto-generated constructor stub
	}


	public Job(String name, int age, String job) {
		super(name, age);
		this.job = job;
	}

	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.printf("Job : %s\n", job);
	}
	
}
