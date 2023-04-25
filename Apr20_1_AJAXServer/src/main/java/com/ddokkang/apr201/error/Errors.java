package com.ddokkang.apr201.error;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.internal.txw2.annotation.XmlElement;

@XmlRootElement
public class Errors {
	private List<Error> error;
	
	public Errors() {
		// TODO Auto-generated constructor stub
	}

	public Errors(List<Error> error) {
		super();
		this.error = error;
	}

	public List<Error> getError() {
		return error;
	}

	@XmlElement
	public void setError(List<Error> error) {
		this.error = error;
	}
	
	
}
