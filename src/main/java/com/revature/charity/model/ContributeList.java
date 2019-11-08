package com.revature.charity.model;

public class ContributeList {
	

	private int id ;
	private int userid ;
	 private int requestid ;
	private double amountdonated ;
	private String name;
	  
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	 public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getRequestid() {
		return requestid;
	}
	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}
	public double getAmountdonated() {
		return amountdonated;
	}
	public void setAmountdonated(double amountdonated) {
		this.amountdonated = amountdonated;
	}

	
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "ContributeList [id=" + id + ", userid=" + userid + ", requestid=" + requestid + ", amountdonated="
				+ amountdonated + ", name=" + name + "]";
	}
	
	

}
