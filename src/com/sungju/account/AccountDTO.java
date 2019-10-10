package com.sungju.account;

public class AccountDTO {
	private String id;
	private String acname;
	private String acnumber;
	private int balance;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAcname() {
		return acname;
	}
	public void setAcname(String acname) {
		this.acname = acname;
	}
	public String getAcnumber() {
		return acnumber;
	}
	public void setAcnumber(String acnumber) {
		this.acnumber = acnumber;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

}
