package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CRUD_Test {
	
    public static void main(String[] args) {
    	CRUD_Test objTest = new CRUD_Test();
    	System.out.println("Create data");
    	objTest.create_data("001", "Shraddha Mune", "1997-08-27", "2021-12-09");
    	objTest.create_data("002", "Mune", "1995-09-07", "2011-11-09");
    	System.out.println("read data using student no");
    	objTest.read_data("001");
    	System.out.println("read all the data in the table");
    	objTest.all_data();
    	System.out.println("update the data");
    	objTest.update_data("001","003","new","1997-08-27","2021-12-09");
    	System.out.println("delete the data using student no");
    	objTest.delete_data("002");
    }
	
	public void create_data(String student_no, String student_name,String student_dob, String student_doj) {
		DB_Connection obj_DB_Connection = new DB_Connection();
		Connection connection = obj_DB_Connection.get_connection();
		
		PreparedStatement ps= null;
		
		try {
			String query="insert into student(student_no,student_name,student_dob,student_doj) values (?,?,?,?)";
			ps=connection.prepareStatement(query);
			ps.setString(1, student_no);
			ps.setString(2, student_name);
			ps.setString(3, student_dob);
			ps.setString(4, student_doj);
			System.out.println(ps);
			ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void read_data(String student_no) {
		DB_Connection obj_DB_Connection = new DB_Connection();
		Connection connection = obj_DB_Connection.get_connection();
		
		PreparedStatement ps= null;
		ResultSet rs=null;
		
		try {
			String query="select * from student where student_no=?";
			ps=connection.prepareStatement(query);
			ps.setString(1, student_no);
			
			System.out.println(ps);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("student no ="+rs.getString("student_no"));
				System.out.println("student name ="+rs.getString("student_name"));
				System.out.println("student dob ="+rs.getString("student_dob"));
				System.out.println("student no ="+rs.getString("student_doj"));
				
				System.out.println("-------------------------");
				
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void all_data() {
		DB_Connection obj_DB_Connection = new DB_Connection();
		Connection connection = obj_DB_Connection.get_connection();
		
		PreparedStatement ps= null;
		ResultSet rs=null;
		
		try {
			String query="select * from student";
			ps=connection.prepareStatement(query);
			
			System.out.println(ps);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("student no ="+rs.getString("student_no"));
				System.out.println("student name ="+rs.getString("student_name"));
				System.out.println("student dob ="+rs.getString("student_dob"));
				System.out.println("student no ="+rs.getString("student_doj"));
				
				System.out.println("-------------------------");
				
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void update_data(String student_no,String new_student_no, String student_name,String student_dob, String student_doj) {
		DB_Connection obj_DB_Connection = new DB_Connection();
		Connection connection = obj_DB_Connection.get_connection();
		
		PreparedStatement ps= null;
		
		try {
			String query="update student set student_no=?,student_name=?,student_dob=?,student_doj=? where student_no=?";
			ps=connection.prepareStatement(query);
			ps.setString(1, new_student_no);
			ps.setString(2, student_name);
			ps.setString(3, student_dob);
			ps.setString(4, student_doj);
			ps.setString(5, student_no);
			System.out.println(ps);
			ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void delete_data(String student_no) {
		DB_Connection obj_DB_Connection = new DB_Connection();
		Connection connection = obj_DB_Connection.get_connection();
		
		PreparedStatement ps= null;
		
		try {
			String query="delete from student where student_no=?";
			ps=connection.prepareStatement(query);
			ps.setString(1, student_no);
			
			System.out.println(ps);
			ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
