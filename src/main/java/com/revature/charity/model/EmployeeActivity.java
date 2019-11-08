package com.revature.charity.model;

public class EmployeeActivity {
	private int id;
	private String request;
	private double fund;


	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public double getFund() {
		return fund;
	}

	public void setFund(double fund) {
		this.fund = fund;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	@Override
	public String toString() {
		return "EmployeeActivity [id=" + id + ", request=" + request + ", fund=" + fund + "]";
	}
	
}
