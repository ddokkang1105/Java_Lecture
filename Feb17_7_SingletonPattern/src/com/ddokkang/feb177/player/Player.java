package com.ddokkang.feb177.player;

public class Player {
	private String name;
	private int age;
	private String nickname;
	
	private static final Player PLAYER = new Player("Park", 19, "Ji");
	
	public Player() {
		// TODO Auto-generated constructor stub
	}

	public Player(String name, int age, String nickname) {
		super();
		this.name = name;
		this.age = age;
		this.nickname = nickname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public static Player getPlayer() {
		return PLAYER;
	}
	
	public void printInfo() {
		System.out.printf("Name : %s\n", name);
		System.out.printf("Age : %s\n", age);
		System.out.printf("NickName : %s\n", nickname);
	}
}
