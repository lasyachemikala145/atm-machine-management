package com.utili;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	
		// TODO Auto-generated method stub
		private static final String URL ="jdbc:mysql://localhost:3306/atm";
		private static final String PASSWORD="lasya@5859#2004";
		private static final String USERNAME="root";
		public static Connection con=null;
			//Connection con=null;
		
			public static Connection getConnection() {
				
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(URL,USERNAME, PASSWORD);
				//System.out.println("Connection is establish");
			}
			catch(ClassNotFoundException | SQLException e) {
				System.out.println("Resolve");
//				e.printStackTrace();
			}
			return con;
		



	}
			public static void main(String[] args) {

}
}
