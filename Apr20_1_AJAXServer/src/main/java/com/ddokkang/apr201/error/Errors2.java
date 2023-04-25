package com.ddokkang.apr201.error;

import java.util.List;

// Error 하나하나를 List의 형태로 내보내기 위해서 !
public class Errors2 {
	private List<Error> error;
	
	public Errors2() {
		// TODO Auto-generated constructor stub
	}

	public Errors2(List<Error> error) {
		super();
		this.error = error;
	}

	public List<Error> getError() {
		return error;
	}

	public void setError(List<Error> error) {
		this.error = error;
	}
	
	
}
