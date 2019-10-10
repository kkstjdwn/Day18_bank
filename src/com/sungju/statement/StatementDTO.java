package com.sungju.statement;

import java.sql.Date;

public class StatementDTO {
	
	private int statementNumber;
	private String acnumber;
	private Date acdate;
	private int deposit;
	private int withdraw;
	private int balance;
	public int getStatementNumber() {
		return statementNumber;
	}
	public void setStatementNumber(int statementNumber) {
		this.statementNumber = statementNumber;
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
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	public int getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

}
