
public class Student {
	
	
	private String firstName;
	private String lastName;
	private int grade;
	private int studentID;
	private String contactNum;
	
	
	
	
	public Student() {
		
	}	
	
	
	
	
	public Student(int studentID) {
		
		this.studentID = studentID;
	}
	
	
	
	

	public Student(String firstName, String lastName, int grade, int studentID, String contactNum) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.grade = grade;
		this.studentID = studentID;
		this.contactNum = contactNum;
		
	}
	
	
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	
	
	public String getFirstName() {
		return this.firstName;
	}
	
	
	
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
	
	public String getLastName() {
		return this.lastName;
	}
	
	
	
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
	
	
	public int getGrade() {
		return this.grade;
	}
	
	
	
	
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	
	
	
	
	public int getStudentID() {
		return this.studentID;
	}
	
	
	
	
	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}
	
	
	
	
	public String getContactNum() {
		return this.contactNum;
	}
	

	
}
