package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ticketraise.ticketraise;

import DBconnection.dbconnection;

public class ticketraiseDBUtil {
	public static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static boolean validate(String studentId){
		
			
			//validate
			try {
				
				con = dbconnection.getConnection();//create connection(connection inside try catch is checking errors in db connection)
				stmt = con.createStatement();
				
			
				String sql = "select * from ticketraise where studentid='"+studentId+"'";//sql query to select the suitable user and get details
				rs = stmt.executeQuery(sql);//run the sql query(Using exceptions in sql)
				
				if(rs.next()) {//check the username and password correct or wrong
					isSuccess = true;	
				}
				else {
					isSuccess = false;
				}
				
			}
			catch(Exception e){ //catch the error
				e.printStackTrace();//print the error
				
			}
			
			return isSuccess;
			
		}
	
	public static List<ticketraise> getTicketDetails2(String studentId){
		ArrayList<ticketraise> ticketraise = new ArrayList<>();
		
		try {
			con = dbconnection.getConnection();
			stmt = con.createStatement();
			
			String sql = "select * from ticketraise where studentid='"+studentId+"'";//sql query to select the suitable user and get details
			rs = stmt.executeQuery(sql);//run the sql query
			
			while(rs.next()) {
				int ticketid = rs.getInt(1);
				 String name = rs.getString(2);
				 String email= rs.getString(3);
				 String studentid = rs.getString(4);
				 String faculty = rs.getString(5);
				 String phone= rs.getString(6);
				 String inquiry =rs.getString(7);
				 String subinquiry =rs.getString(8);
				
				 String subject= rs.getString(9);
				 String message= rs.getString(10);
				 
				ticketraise cus = new ticketraise(ticketid,name,email,studentid,faculty,phone,inquiry,subinquiry,subject,message);
				
				ticketraise.add(cus);
			}
			
			
		}
		catch(Exception e){
			
		}
		
		return ticketraise;
	
}
	//insert data
		public static boolean insertticket(String name, String email, String studentid, String faculty, String phone,String inquiry, String subinquiry, String subject, String message)  {
			
			
			boolean isSuccess = false;
			
			
			try {//try the content inside block
				
				con = dbconnection.getConnection();
				stmt = con.createStatement();
				
				String sql = "insert into ticketraise values (0,'"+name+"','"+email+"','"+studentid+"','"+faculty+"','"+phone+"','"+inquiry+"','"+subinquiry+"','"+subject+"','"+message+"')";//sql query
	    		int rs = stmt.executeUpdate(sql);//store executeUpdate value in integer variable
	    		//executeUpdate statement return 2 values as 0 and 1
	    		//if value 0 unsuccess and if value 1 Success
	    		if(rs > 0) {
	    			isSuccess = true;
	    		} else {
	    			isSuccess = false;
	    		}
	    		
	    	}
	    	catch (Exception e) {//catch if there is an error
	    		e.printStackTrace();//print that error
	    	}
			
			
			
			return isSuccess;	
			
		}
		//update data
		public static boolean updateticket(String ticketid, String name, String email, String studentid, String faculty, String phone,String inquiry, String subinquiry, String subject, String message) {//parameters are the variables in updateServlet class
			
			boolean isSuccess = false;
	try {
	    		
	    		con = dbconnection.getConnection();
	    		stmt = con.createStatement();
	    		String sql = "update ticketraise set name='"+name+"',email='"+email+"',studentid='"+studentid+"',faculty='"+faculty+"',phone='"+phone+"',inquiry='"+inquiry+"',subinquiry='"+subinquiry+"',subject='"+subject+"',message='"+message+"'"
	    				+ "where ticketid='"+ticketid+"'";
	    		int rs = stmt.executeUpdate(sql);
	    		
	    		if(rs > 0) {
	    			isSuccess = true;//rs=1
	    		}
	    		else {
	    			isSuccess = false;//rs=0 
	    		}
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}
			
			return isSuccess;	
			
		}
		//retrieve data
		public static List<ticketraise> getTicketDetails(String ticketid){//list of student details
			
			int convertedID = Integer.parseInt(ticketid);//convert string value into integer value
			
			ArrayList<ticketraise> cus = new ArrayList<>();
			
	try {
	    		stmt = con.createStatement();
	    		String sql = "select * from ticketraise where ticketid='"+convertedID+"'";
	    		rs = stmt.executeQuery(sql);
	    		
	    		while(rs.next()) {
	    			int cid = rs.getInt(1);
					 String name = rs.getString(2);
					 String email= rs.getString(3);
					 String studentid = rs.getString(4);
					 String faculty = rs.getString(5);
					 String phone= rs.getString(6);
					 String inquiry =rs.getString(7);
					 String subinquiry =rs.getString(8);
					
					 String subject= rs.getString(9);
					 String message= rs.getString(10);
					
	    			//pass the values to the object in a student class through a constructor
					ticketraise c = new ticketraise(cid,name,email,studentid,faculty,phone,inquiry,subinquiry,subject,message);//parameterize constructor
	    			cus.add(c);//pass the student object to arraylist object
	    		}
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}	
			
			return cus;
		}
		
		//delete profile
		
		public static boolean deleteTicket(String ticketid) {
			
			int convId = Integer.parseInt(ticketid);
			boolean isSuccess = false;
			    	
			    	try {
			    		
			    		con = dbconnection.getConnection();
			    		stmt = con.createStatement();
			    		String sql = "delete from ticketraise where ticketid='"+convId+"'";
			    		int r = stmt.executeUpdate(sql);//executeUpdate method is use for insert, update, delete
			    		
			    		if (r > 0) {
			    			isSuccess = true;
			    		}
			    		else {
			    			isSuccess = false;
			    		}
			    		
			    	}
			    	catch (Exception e) {
			    		e.printStackTrace();
			    	}
					
					
					return isSuccess;
				}

}
