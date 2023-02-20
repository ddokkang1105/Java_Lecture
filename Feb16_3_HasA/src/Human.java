
public class Human {
	String name;
	String sex;
	String phoneNum;
	
	public Human() {
		// TODO Auto-generated constructor stub
	}

	public Human(String name, String sex, String phoneNum) {
		super();
		this.name = name;
		this.sex = sex;
		this.phoneNum = phoneNum;
	}
	
	public void printInfo() {
		System.out.printf("NAME : %s\n", this.name);
		System.out.printf("SEX : %s\n", this.sex);
		System.out.printf("PHONE NUMBER : %s\n", this.phoneNum);
		
	}
}
