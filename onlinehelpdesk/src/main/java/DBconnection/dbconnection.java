package DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconnection {
	//create database connection
			static String url = "jdbc:mysql://localhost:3306/onlinehelpdesk";//link database
			static String user = "root";
			static String Pass = "D@2216@u";//database password
			private static Connection con;//save the connection in an object

			public static Connection getConnection() {//return connection

				try {

						Class.forName("com.mysql.jdbc.Driver");

						con = DriverManager.getConnection(url, user, Pass);

					}
				catch (Exception e) {
						System.out.println("Database connection is not success!!!");
				}

				return con;
				
				
	}
}
