package com.wachira.symptomserver.entities;

public class OkResponse {

	private String result;
	
	public OkResponse (String res){
		this.result = res;
	}
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
