package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.student.student;
import DBconnection.dbconnection;

public class studentDBUtil {
    
    public static boolean validate(String userName, String password) {
        boolean isSuccess = false;
        String sql = "SELECT * FROM studentregi WHERE username = ? AND password = ?";
        
        try (Connection con = dbconnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            
            // Set parameters
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    isSuccess = true;
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return isSuccess;
    }
    
    public static List<student> getStudentDetails2(String userName) {
        List<student> studentList = new ArrayList<>();
        String sql = "SELECT * FROM studentregi WHERE username = ?";
        
        try (Connection con = dbconnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            
            // Set parameter
            pstmt.setString(1, userName);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    student stu = new student(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11)
                    );
                    studentList.add(stu);
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return studentList;
    }
    
    public static boolean insertStudent(String studentid, String name, String nic, String dob, String email, String phone, String faculty, String address, String username, String password) {
        boolean isSuccess = false;
        String sql = "INSERT INTO studentregi VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection con = dbconnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            
            // Set parameters
            pstmt.setString(1, studentid);
            pstmt.setString(2, name);
            pstmt.setString(3, nic);
            pstmt.setString(4, dob);
            pstmt.setString(5, email);
            pstmt.setString(6, phone);
            pstmt.setString(7, faculty);
            pstmt.setString(8, address);
            pstmt.setString(9, username);
            pstmt.setString(10, password);
            
            int rowsAffected = pstmt.executeUpdate();
            isSuccess = rowsAffected > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return isSuccess;
    }
    
    public static boolean updateStudent(String id, String studentid, String name, String nic, String dob, String email, String phone, String faculty, String address, String username, String password) {
        boolean isSuccess = false;
        String sql = "UPDATE studentregi SET studentid = ?, name = ?, nic = ?, dob = ?, email = ?, phone = ?, faculty = ?, address = ?, username = ?, password = ? WHERE id = ?";
        
        try (Connection con = dbconnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            
            // Set parameters
            pstmt.setString(1, studentid);
            pstmt.setString(2, name);
            pstmt.setString(3, nic);
            pstmt.setString(4, dob);
            pstmt.setString(5, email);
            pstmt.setString(6, phone);
            pstmt.setString(7, faculty);
            pstmt.setString(8, address);
            pstmt.setString(9, username);
            pstmt.setString(10, password);
            pstmt.setInt(11, Integer.parseInt(id));
            
            int rowsAffected = pstmt.executeUpdate();
            isSuccess = rowsAffected > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return isSuccess;
    }
    
    public static boolean deleteStudent(String id) {
        boolean isSuccess = false;
        String sql = "DELETE FROM studentregi WHERE id = ?";
        
        try (Connection con = dbconnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            
            pstmt.setInt(1, Integer.parseInt(id));
            
            int rowsAffected = pstmt.executeUpdate();
            isSuccess = rowsAffected > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return isSuccess;
    }
}
