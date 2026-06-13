package DAOatm;

import com.model.Account;

public interface Methods {
		// TODO Auto-generated method stub
		public int userLogin(int account_no);
		int checkPin(int account_no,int pin_number);
		int getPin(int account_no,int pin_number);
		int balanceChecking(int account_no);
		void withDraw(int amount,int account_no);
		void deposite(int amount,int account_no);
		void changePin(int account_no,int pin1);
		


}
