package com.sungju.statement;

import java.sql.Date;

public class StatementDTO {
	
	private int stateNumber;
	private String acnumber;
	private Date acdate;
	private long deposit;
	private long withdraw;
	private long balance;
	
	public int getStateNumber() {
		return stateNumber;
	}
	public void setStateNumber(int stateNumber) {
		this.stateNumber = stateNumber;
	}
	public String getAcnumber() {
		return acnumber;
	}
	public void setAcnumber(String acnumber) {
		this.acnumber = acnumber;
	}
	public Date getAcdate() {
		return acdate;
	}
	public void setAcdate(Date acdate) {
		this.acdate = acdate;
	}
	public long getDeposit() {
		return deposit;
	}
	public void setDeposit(long deposit) {
		this.deposit = deposit;
	}
	public long getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(long withdraw) {
		this.withdraw = withdraw;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
}
