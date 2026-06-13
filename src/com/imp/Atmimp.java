package com.imp;
//import com.tap.utility.DBConnection;


import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Time;
//import com.model.Account;
import com.utili.DbConnection;

import DAOatm.Methods;

public class Atmimp implements Methods{
	private static final String SELECT_QUERY="select * from account where account_no=?";
	private static final String SELECT_QUERY1="select * from account where account_no=? and "+
	"pin_number=?";
	private static final String DELETE_QUERY="DELETE FROM account WHERE account_no=?";
	private static final String SELECT_QUERY3="select * from account where account_no=?";
	private static final String UPDATE_SALARY="UPDATE account set balance=? where account_no=?";
	private static final String INSERT_QUERY="INSERT INTO transaction (account_no, type, amount,time) "+
	"VALUES (?, ?, ?,?)";
	private static final String UPDATE_PIN =
	        "UPDATE account SET pin_number=? WHERE account_no=?";
	//int pin=0;
int i=2;
	Scanner sc=new Scanner(System.in);
	Connection con=DbConnection.getConnection();
	//public static void main(String[] args) {
		// TODO Auto-generated method stub


	@Override
	public int  userLogin(int account_no) {
		//1.connection establish 
		//Connection con=DbConnection.getConnection();
		try {
			PreparedStatement pstmt=con.prepareStatement(SELECT_QUERY);
			pstmt.setInt(1,account_no);
			//pstmt.setInt(2,pin_number);
			ResultSet res=pstmt.executeQuery();
			int ac_no = 0;
			
			while(res.next()) {
				ac_no=res.getInt("account_no");
				//pin_no=res.getInt("pin_number");
				
			}
			return ac_no;
	
		}
		catch(SQLException e) {
			e.printStackTrace();			
		}
		
		return 0;
	}
	public int getPin(int account_no,int pin_number) {
		int pin_no = 0;
	//Connection	con=DbConnection.getConnection();
	try {
		PreparedStatement pstmt=con.prepareStatement(SELECT_QUERY1);
		pstmt.setInt(1, account_no);
		pstmt.setInt(2, pin_number);
		ResultSet res=pstmt.executeQuery();	
		while(res.next()) {
			 pin_no=res.getInt("pin_number");
			 System.out.println(pin_no);
		}
		return pin_no;
	}catch(SQLException e) {
		
	}
		return 0;
	}
	public int checkPin(int account_no,int pin_number) {
		//calling getpin
		
		int pin=getPin(account_no,pin_number);
		
		if(pin!=0) {
			System.out.println("enter the type of transaction:");
			String ty = sc.next();
			type(ty,account_no);
		}
		else {
			System.out.println("invalid pin please enter crct pin you hava "+i--+"chances");
			int pin2=sc.nextInt();
			 //int ac2=sc.nextInt();
			 pin=getPin(account_no,pin2);
			 if(pin!=0) {
				 System.out.println("enter the type of transaction:");
				 String ty = sc.next();
				 type(ty,account_no);
			 }
			 else {
				 System.out.println("invalid pin please enter crct pin you hava "+i--+"chances");
				 int pin3=sc.nextInt();
				 pin=getPin(account_no,pin3);
				 if(pin!=0) {
					 String ty = sc.next();
					 type(ty,account_no);
				 }
				 else {
					 
					 System.out.println("Dear user you are blocked ");
					 deleteUser(account_no);
				 }
			 }
			
		}
		return 0;
	}

	@Override
	public int balanceChecking(int account_no) {
	
		
		   // Connection con = DbConnection.getConnection();

		    try {
		        PreparedStatement pstmt = con.prepareStatement(SELECT_QUERY);
		        pstmt.setInt(1, account_no);

		        ResultSet res = pstmt.executeQuery();

		        while(res.next()) {
		           int balence= res.getInt("balance");
		           return balence;
		        }

		    } catch(SQLException e) {
		        e.printStackTrace();
		    }
		    return 0;
	}
	@Override
	public void withDraw(int amount,int account_no) {
		//Connection con=DbConnection.getConnection();
		try {
			PreparedStatement pstmt=con.prepareStatement(SELECT_QUERY);
			pstmt.setInt(1, account_no);
			ResultSet res=pstmt.executeQuery();
			while(res.next()) {
				int beforeBalance=res.getInt("balance");
				if(amount <= 0) {
				    System.out.println("Please enter a valid amount");
				    return;
				}

				if(amount > beforeBalance) {
				    System.out.println("Insufficient Balance");
				    return;
				}

				int afterbalance=beforeBalance-amount;
				System.out.println("Balance Ammount"+afterbalance);
				PreparedStatement pstmt1=con.prepareStatement(UPDATE_SALARY);
				pstmt1.setInt(1,afterbalance);
				pstmt1.setInt(2,account_no);
				pstmt1.executeUpdate();
				//
				PreparedStatement pstmt3= con.prepareStatement(INSERT_QUERY);
				//Timestamp currentTime = new Timestamp(System.currentTimeMillis());
				pstmt3.setInt(1, account_no);
				pstmt3.setString(2, "withdraw");
				pstmt3.setFloat(3, amount); // withdrawn amount
				pstmt3.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
				pstmt3.executeUpdate();				
			}
		}catch(SQLException e) {
			
		}
		}
	@Override
	public void deposite(int amount,int account_no) {
		// TODO Auto-generated method stub
		//Connection con1=DbConnection.getConnection();
		try {
			PreparedStatement pstmt=con.prepareStatement(SELECT_QUERY);
			pstmt.setInt(1, account_no);
			ResultSet res=pstmt.executeQuery();
			while(res.next()) {
				int beforeBalance=res.getInt("balance");
				int afterbalance=beforeBalance+amount;
				System.out.println("Balance Ammount"+afterbalance);
				PreparedStatement pstmt1=con.prepareStatement(UPDATE_SALARY);
				pstmt1.setInt(1,afterbalance);
				pstmt1.setInt(2,account_no);
				pstmt1.executeUpdate();
				//
				PreparedStatement pstmt3= con.prepareStatement(INSERT_QUERY);
				//Timestamp currentTime = new Timestamp(System.currentTimeMillis());
				pstmt3.setInt(1, account_no);
				pstmt3.setString(2, "deposite");
				pstmt3.setFloat(3, amount); // withdrawn amount
				pstmt3.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
				pstmt3.executeUpdate();				
			}
		}catch(SQLException e) {
			
		}
		
	}

	@Override
	public void changePin(int account_no,int pin1) {
		// TODO Auto-generated method stub
		//Connection con4=DbConnection.getConnection();
		try {
			PreparedStatement pstmt5=con.prepareStatement(UPDATE_PIN);
			pstmt5.setInt(1, pin1);
			pstmt5.setInt(2, account_no);
			pstmt5.executeUpdate();
			System.out.println("Successfully pin change:");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	
	}
	
	
	public void deleteUser(int account_number) {
		//Connection con=DbConnection.getConnection();
		try {
			PreparedStatement pstmt=con.prepareStatement(DELETE_QUERY);
			pstmt.setInt(1,account_number);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
;		
	}
	public  void type(String type,int account_no) {
		if(type.equalsIgnoreCase("withdraw")) {
			System.out.println("enter ammount:");
			int amount=sc.nextInt();
			withDraw(amount,account_no);
			return;
		}
		else if(type.equalsIgnoreCase("deposite")) {
			System.out.println("enter ammount:");
			int amount=sc.nextInt();
			System.out.println("enter user account no :");
			int ac3=sc.nextInt();
			deposite(amount,ac3);
			return;
		}
		else if(type.equalsIgnoreCase("balance")) {
			int x=balanceChecking(account_no);
			System.out.println(x);
			return;
		}
		else {
			System.out.println("Enter new pin:");
			int pin1=sc.nextInt();
			changePin(account_no,pin1);
		}
	}

}
