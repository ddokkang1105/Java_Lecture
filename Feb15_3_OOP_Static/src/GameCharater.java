
/**
 * @author Ji
 * @version 1.1.14
 * <p>
 * ���� ĳ������ ������ ������ �ִ� Ŭ����
 */


public class GameCharater {
	String nickname;
	int level;
	String job;
	String weapon;
	
	
	/**
	 * ���� ĳ���͸� �����մϴ�.
	 * <p> �⺻ ����� ��, �⺻ ������ �ʺ����Դϴ�.
	 * @param nickname ĳ������ �̸�; ���̴� 3 - 10�� 
	 * @throws IllegalArgumentException ĳ������ �̸��� ������ ����� ��,
	 * ��, ({@code nickname < 3 || nickname > 10}) �̸� �߻�
	 * 
	 */
	public GameCharater(String nickname) {
		this.level = 1;
		this.job = "Learner";
		this.weapon = "Sord";
		if (nickname.length() < 3 || nickname.length() > 10) {
			throw new IllegalArgumentException("Character name is 3 to 10.");
		}
		this.nickname = nickname;
	}

	/**
	 * ĳ������ ������ �÷��ִ� �޼ҵ�
	 */
	public void levelUp() {
		this.level++;
	}
	
	/**
	 * ĳ������ ������ �����ϴ� �޼ҵ�
	 * @param job ĳ������ ������ ����
	 * @throws IllegalArgumentException 10�� ���� ������ �߻�
	 */
	public void setJob(String job) {
		if (this.level < 10) {
			throw new IllegalArgumentException("Low Level ! To be 10.");
		}
		this.job = job;
	}
	
	
	/**
	 * ������ ĳ������ ������ �����ִ� �޼ҵ�
	 */
	public void printInfo() {
		System.out.printf("NickName : %s\n", this.nickname);
		System.out.printf("Level : %s\n", level);
		System.out.printf("Job : %s\n", job);
		System.out.printf("Weapon : %s\n", weapon);
	}
}
