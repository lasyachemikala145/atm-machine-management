package com.model;

public class Account {
	int account_no;
	String holdername; 
	int pin_number;
	int balance;
	
	public int getAccount_no() {
		return account_no;
	}

	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}

	public String getHoldername() {
		return holdername;
	}

	public void setHoldername(String holdername) {
		this.holdername = holdername;
	}

	public int getPin_number() {
		return pin_number;
	}

	public void setPin_number(int pin_number) {
		this.pin_number = pin_number;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Account(int account_no, String holdername, int pin_number, int balance) {
		super();
		this.account_no = account_no;
		this.holdername = holdername;
		this.pin_number = pin_number;
		this.balance = balance;
	}
	public Account() {
		
	}
	public Account(int account_no,int pin_number) {
		this.account_no = account_no;
		this.pin_number = pin_number;
	}

}
