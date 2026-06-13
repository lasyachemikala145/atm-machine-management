package com.imp;

import java.util.Scanner;

//import com.model.Account;

public class Main {
	static int i=3;
	public static void main(String[] args) {

		//initally i need to read account number and pin number
		System.out.println("Please enter the Account Number:");
		Scanner sc=new Scanner(System.in);
		//scan ac no
		int ac1=sc.nextInt();
		//object creation
		Atmimp ai=new Atmimp();
		//calling userlogin method and pass ac no
		int ac_no=ai.userLogin(ac1);

		if(ac_no!=0) {
			//System.out.println(ac_no);
			System.out.println("Please enter valid pin number:");
			int pin1=sc.nextInt();
			ai.checkPin(ac1,pin1);

		}
		else {
			System.out.println("invalid account number and pin number");
		}



	}

}
/*
 * 
 * else if(i>0) {
			 System.out.println("invalid pin please enter correct pin you have more "+i--+"chances");
			 System.out.println("enetr pin number:");
			 int pin_number2=sc.nextInt();
			 pin_no= ai.getPin(pin_number);
			 
		 }
		 */
