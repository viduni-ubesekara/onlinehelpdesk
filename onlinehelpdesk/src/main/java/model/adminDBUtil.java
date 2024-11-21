package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.admin.admin;
import com.feedback.feedback;
import com.ticketraise.ticketraise;

import DBconnection.dbconnection;

public class adminDBUtil {
	public static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static boolean validate(String userName, String password){/*First validate customer using username and password after 
		get student details as a list from databse and assign details to the student class variables*/
			
			//validate
			try {
				
				con = dbconnection.getConnection();//create connection(connection inside try catch is checking errors in db connection)
				stmt = con.createStatement();
				
			
				String sql = "select * from admin where username='"+userName+"' and password='"+password+"'";//sql query to select the suitable user and get details
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
	
	public static List<admin> getAdminDetails2(String userName){
		ArrayList<admin> admin = new ArrayList<>();
		
		try {
			con = dbconnection.getConnection();
			stmt = con.createStatement();
			
			String sql = "select * from admin where username='"+userName+"'";//sql query to select the suitable user and get details
			rs = stmt.executeQuery(sql);//run the sql query
			
			while(rs.next()) {
				int adminid = rs.getInt(1);//if username and password valid take details of that student to this class
				 String name = rs.getString(2);
				 String admintype = rs.getString(3);
				 String email= rs.getString(4);
				 String phone= rs.getString(5);
				 String username= rs.getString(6);
				 String userpassword= rs.getString(7);
				 
				 
				 
				 
				admin cus = new admin(adminid,name,admintype,email,phone,username,userpassword);
				
				admin.add(cus);
			}
			
			
		}
		catch(Exception e){
			
		}
		
		return admin;
	
}
	//insert data
		public static boolean insertadmin( String name, String admintype, String email, String phone, String username,String password)  {
			/*connect with database and insert data into database
		that saved in studentinsert servlet*/
			
			boolean isSuccess = false;
			
			
			try {//try the content inside block
				
				con = dbconnection.getConnection();
				stmt = con.createStatement();
				
				String sql = "insert into admin values (0,'"+name+"','"+admintype+"','"+email+"','"+phone+"','"+username+"','"+password+"')";//sql query
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
		public static boolean updateadmin(String adminid, String name, String admintype, String email, String phone, String username,String password) {//parameters are the variables in updateServlet class
			
			boolean isSuccess = false;
	try {
	    		
	    		con = dbconnection.getConnection();
	    		stmt = con.createStatement();
	    		String sql = "update admin set name='"+name+"',admintype='"+admintype+"',email='"+email+"',phone='"+phone+"',username='"+username+"',password='"+password+"'"
	    				+ "where adminid='"+adminid+"'";
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
		public static List<admin> getAdminDetails(String adminid){//list of student details
			
			int convertedID = Integer.parseInt(adminid);//convert string value into integer value
			
			ArrayList<admin> cus = new ArrayList<>();
			
	try {
	    		stmt = con.createStatement();
	    		String sql = "select * from admin where adminid='"+convertedID+"'";
	    		rs = stmt.executeQuery(sql);
	    		
	    		while(rs.next()) {
	    			int cid = rs.getInt(1);//if username and password valid take details of that student to this class
					 String name = rs.getString(2);
					 String admintype = rs.getString(3);
					 String email= rs.getString(4);
					 String phone= rs.getString(5);
					 String username= rs.getString(6);
					 String userpassword= rs.getString(7);
					
	    			//pass the values to the object in a student class through a constructor
					admin c = new admin(cid,name,admintype,email,phone,username,userpassword);//parameterize constructor
	    			cus.add(c);//pass the student object to arraylist object
	    		}
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}	
			
			return cus;
		}
		
		//delete profile
		
		public static boolean deleteAdmin(String adminid) {
			
			int convId = Integer.parseInt(adminid);
			boolean isSuccess = false;
			    	
			    	try {
			    		
			    		con = dbconnection.getConnection();
			    		stmt = con.createStatement();
			    		String sql = "delete from admin where adminid='"+convId+"'";
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
		//display feedback details
		 public static List<feedback> getfeedbackDetails() {
		    	
			    
		    	
		    	ArrayList<feedback> cus = new ArrayList<feedback>();
		    	
		    	try {
		    		
		    		con = dbconnection.getConnection();
		    		stmt = con.createStatement();
		    		String sql = "select * from feedback  ";
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
		    			
		    			
		    			feedback c = new feedback (cid,name,email,studentid,faculty,phone,message,rating);
		    			cus.add(c);
		    		}
		    		
		    	}
		    	catch(Exception e) {
		    		e.printStackTrace();
		    		System.out.println("dbutill display feedback connection error!!");
		    	}	
		    	return cus;	
		    }
		//display ticket details
		 public static List<ticketraise> getticketDetails() {
		    	
			    
		    	
		    	ArrayList<ticketraise> cus = new ArrayList<ticketraise>();
		    	
		    	try {
		    		
		    		con = dbconnection.getConnection();
		    		stmt = con.createStatement();
		    		String sql = "select * from ticketraise  ";
		    		rs = stmt.executeQuery(sql);
		    		
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
		    			
		    			
		    			ticketraise c = new ticketraise (ticketid,name,email,studentid,faculty,phone,inquiry,subinquiry,subject,message);
		    			cus.add(c);
		    		}
		    		
		    	}
		    	catch(Exception e) {
		    		e.printStackTrace();
		    		System.out.println("dbutill display ticket connection error!!");
		    	}	
		    	return cus;	
		    }
}
