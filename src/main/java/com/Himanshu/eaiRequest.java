package com.Himanshu;

public class eaiRequest {

	private String EAI;
	public eaiRequest(){
		
	}

	public String getEAI() {
		return EAI;
	}

	public void setEAI(String eAI) {
		EAI = eAI;
	}

	@Override
	public String toString() {
		return "Request [EAI=" + EAI + "]";
	}

	public eaiRequest(String eAI) {
		super();
		EAI = eAI;
	}
	
	
}
