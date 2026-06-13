package com.model;

import java.sql.Timestamp;

public class Transaction {
		int transaction_id;
		int account_no;
		String type; 
		float amount; 
		Timestamp time;
		public Transaction(int transaction_id, int account_no, String type, float amount, Timestamp time) {
			super();
			this.transaction_id = transaction_id;
			this.account_no = account_no;
			this.type = type;
			this.amount = amount;
			this.time = time;
		}
		public Transaction(int account_no, String type, float amount) {
			super();
			this.account_no = account_no;
			this.type = type;
			this.amount = amount;
		}
		public int getAccount_no() {
			return account_no;
		}
		public void setAccount_no(int account_no) {
			this.account_no = account_no;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public float getAmount() {
			return amount;
		}
		public void setAmount(float amount) {
			this.amount = amount;
		}
		
}