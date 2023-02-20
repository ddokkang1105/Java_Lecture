
/**
 * @author Ji
 * @version 1.1.14
 * <p>
 * 게임 캐릭터의 정보를 가지고 있는 클래스
 */


public class GameCharater {
	String nickname;
	int level;
	String job;
	String weapon;
	
	
	/**
	 * 게임 캐릭터를 생성합니다.
	 * <p> 기본 무기는 검, 기본 직업은 초보자입니다.
	 * @param nickname 캐릭터의 이름; 길이는 3 - 10자 
	 * @throws IllegalArgumentException 캐릭터의 이름이 범위에 벗어났을 때,
	 * 즉, ({@code nickname < 3 || nickname > 10}) 이면 발생
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
	 * 캐릭터의 레벨을 올려주는 메소드
	 */
	public void levelUp() {
		this.level++;
	}
	
	/**
	 * 캐릭터의 직업을 변경하는 메소드
	 * @param job 캐릭터의 변경할 직업
	 * @throws IllegalArgumentException 10이 되지 않으면 발생
	 */
	public void setJob(String job) {
		if (this.level < 10) {
			throw new IllegalArgumentException("Low Level ! To be 10.");
		}
		this.job = job;
	}
	
	
	/**
	 * 생성된 캐릭터의 정보를 보여주는 메소드
	 */
	public void printInfo() {
		System.out.printf("NickName : %s\n", this.nickname);
		System.out.printf("Level : %s\n", level);
		System.out.printf("Job : %s\n", job);
		System.out.printf("Weapon : %s\n", weapon);
	}
}
