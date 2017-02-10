package com.Java;

import org.json.simple.JSONObject;

public class eaiRequest {

	private String EAI;
	private JSONObject result;
	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}

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
