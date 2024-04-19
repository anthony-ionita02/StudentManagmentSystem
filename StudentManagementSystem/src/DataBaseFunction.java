import java.sql.Statement;
import java.util.HashSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;






/*
 * This class is used to establish connection to the SQLite student database, and contains
 * the methods need to add, remove, update, and display the info regarding students. 
 * It also contains the buildHashSet method which is used to fill studentList in the
 * GUI class.  
 */

public class DataBaseFunction {
	
	
	
	
	
	public Connection DBConnect() {
		
		Connection con = null;
		
		try {
	
			con = DriverManager.getConnection("jdbc:sqlite:StudentDataBase.db");

			 
		}
		catch(SQLException e) {
			
			System.out.println("Error: connection to server not established.");			
		}
		
		return con;
	}
	
	
	
	
	
	public HashSet<Integer> buildHashSet(){
		
		
		HashSet<Integer> returnSet = new HashSet<>();
		
		try {
		Connection con = this.DBConnect();
		
		String sqlCode = "SELECT *"
				+ "FROM Students";
		Statement statement = con.createStatement();
		

			ResultSet rs = statement.executeQuery(sqlCode);
			
			while(rs.next()) {
				returnSet.add(rs.getInt("studentID"));
			}
		} 
		catch (SQLException e) {
			System.out.println("Connection failed.");
		}
		
		return returnSet;
	}
	
	
	
	
	public void addStudent(Student student) {
		
		try {
			
			
			Connection con = this.DBConnect();
			
			String sqlCode = "INSERT INTO Students(firstName,lastName,grade,studentID,contactNum) "
					+ "VALUES(?,?,?,?,?)";
			
			PreparedStatement statement = con.prepareStatement(sqlCode);
			{
				statement.setString(1,student.getFirstName());
				statement.setString(2, student.getLastName());
				statement.setInt(3,student.getGrade());
				statement.setInt(4, student.getStudentID());
				statement.setString(5, student.getContactNum());
				statement.executeUpdate();
			}
			
		}catch(SQLException e) {
			
			System.out.println("Addition of student " + student.getFirstName() + " " + student.getLastName() + " failed.");
			
		}
		
	}
	
	
	
	
	
	
	
	public void removeStudent(Student student) {
		
		try {
			
			Connection con = this.DBConnect();
			String sqlCode = "DELETE FROM Students "
					+ "WHERE studentID = ?";
			
			
			PreparedStatement statement = con.prepareStatement(sqlCode);
			{
				statement.setInt(1, student.getStudentID());
				statement.executeUpdate();
			}
			
			
		}catch(SQLException e) {
			
			System.out.println("Removal of student " + student.getFirstName() + " " + student.getLastName() + " failed.");
			
		}
		
	}
	
	
	
		
	
	
	
	
	public void updateInfo(Student student) {
		
		try {
			Connection con = this.DBConnect();
			
			String sqlCode = "UPDATE Students "
					+ "SET firstName = ?, lastName = ?, grade = ?, studentID = ?, contactNum = ?"
					+ "WHERE studentID = ?;";
			
			PreparedStatement statement = con.prepareStatement(sqlCode);
			{
				statement.setString(1, student.getFirstName());
				statement.setString(2, student.getLastName());
				statement.setInt(3, student.getGrade());
				statement.setInt(4, student.getStudentID());
				statement.setString(5, student.getContactNum());
				statement.setInt(6, student.getStudentID());
				statement.executeUpdate();
			}
			
			
		}catch(SQLException e) {
			
			System.out.println("Info update failed.");
			
		}
	}
	
	
	
	
	
	
	
	
	public String showInfo() {
		
		
		String returnString = "First Name:" + "\t" + "Last Name:" + "\t" + "Grade:" + "\t" + "Student ID:" + "\t" + "Contact Number:" + "\n";
		
		
		try {
			Connection con = this.DBConnect();
			
			String sqlCode = "SELECT *"
					+ "FROM Students;";
			
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sqlCode);
			
			
			while(rs.next()) {
				
				returnString = returnString + rs.getString("firstName") + "\t" + rs.getString("lastName") + "\t"
						+ rs.getInt("grade") + "\t" + rs.getInt("studentID") + "\t" + rs.getString("contactNum") + "\n";
				
				
			}
			
			return returnString;
			
			
		}catch(SQLException e) {
			
			System.out.println("Failed to obtain information.");
			
		}
		
		
		return returnString;
	}
	
	

}
