package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.feedback.feedback;

import DBconnection.dbconnection;


public class feedbackDBUtil {
	
	public static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static boolean validate(String studentId){
		
			
			//validate
			try {
				
				con = dbconnection.getConnection();
				stmt = con.createStatement();
				
			
				String sql = "select * from feedback where studentid='"+studentId+"'";
				rs = stmt.executeQuery(sql);
				
				if(rs.next()) {
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
	
	public static List<feedback> getFeedbackDetails2(String studentId){
		ArrayList<feedback> feedback = new ArrayList<>();
		
		try {
			con = dbconnection.getConnection();
			stmt = con.createStatement();
			
			String sql = "select * from feedback where studentid='"+studentId+"'";
			rs = stmt.executeQuery(sql);//run the sql query
			
			while(rs.next()) {
				int feedbackid = rs.getInt(1);
				 String name = rs.getString(2);
				 String email= rs.getString(3);
				 String studentid = rs.getString(4);
				 String faculty = rs.getString(5);
				 String phone= rs.getString(6); 
				 String message= rs.getString(7);
				 String rating= rs.getString(8);
				 
				feedback cus = new feedback(feedbackid,name,email,studentid,faculty,phone,message,rating);
				
				feedback.add(cus);
			}
			
			
		}
		catch(Exception e){
			
		}
		
		return feedback;
	
}
	//insert 
		public static boolean insertfeedback(String name, String email, String studentid, String faculty, String phone, String message, String rating)  {
			
			
			boolean isSuccess = false;
			
			
			try {
				
				con = dbconnection.getConnection();
				stmt = con.createStatement();
				
				String sql = "insert into feedback values (0,'"+name+"','"+email+"','"+studentid+"','"+faculty+"','"+phone+"','"+message+"','"+rating+"')";//sql query
	    		int rs = stmt.executeUpdate(sql);
	    		
	    		
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
		//update 
		public static boolean updatefeedback(String feedbackid, String name, String email, String studentid, String faculty, String phone, String message, String rating) {//parameters are the variables in updateServlet class
			
			boolean isSuccess = false;
	try {
	    		
	    		con = dbconnection.getConnection();
	    		stmt = con.createStatement();
	    		String sql = "update feedback set name='"+name+"',email='"+email+"',studentid='"+studentid+"',faculty='"+faculty+"',phone='"+phone+"',message='"+message+"',rating='"+rating+"'"
	    				+ "where feedbackid='"+feedbackid+"'";
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
		//retrieve 
		public static List<feedback> getFeedbackDetails(String feedbackid){
			
			int convertedID = Integer.parseInt(feedbackid);
			
			ArrayList<feedback> cus = new ArrayList<>();
			
	try {
	    		stmt = con.createStatement();
	    		String sql = "select * from feedback where feedbackid='"+convertedID+"'";
	    		rs = stmt.executeQuery(sql);
	    		
	    		while(rs.next()) {
	    			int cid = rs.getInt(1);
					 String name = rs.getString(2);
					 String email= rs.getString(3);
					 String studentid = rs.getString(4);
					 String faculty = rs.getString(5);
					 String phone= rs.getString(6); 
					 String message= rs.getString(7);
					 String rating= rs.getString(8);
					
	    			
					feedback c = new feedback(cid,name,email,studentid,faculty,phone,message,rating);
	    			cus.add(c);//pass student object to arraylist object
	    		}
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}	
			
			return cus;
		}
		
		//delete 
		
		public static boolean deleteFeedback(String feedbackid) {
			
			int convId = Integer.parseInt(feedbackid);
			boolean isSuccess = false;
			    	
			    	try {
			    		
			    		con = dbconnection.getConnection();
			    		stmt = con.createStatement();
			    		String sql = "delete from feedback where feedbackid='"+convId+"'";
			    		int r = stmt.executeUpdate(sql);
			    		
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
