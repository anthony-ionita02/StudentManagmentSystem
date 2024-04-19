import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;





public class GUI implements ActionListener{
	
	private JFrame frame;
	private JPanel panelOne;
	private JPanel panelTwo;
	private JLabel labelOne;
	private JLabel labelTwo;
	private JButton buttonOne;
	private JButton buttonTwo;
	private JComboBox cb;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTextField tf5;
	private JLabel lb1;
	private JLabel lb2;
	private JLabel lb3;
	private JLabel lb4;
	private JLabel lb5;
	private JTextArea textArea;
	private static int userCommand = 0;
	private Color Cream = new Color(255,254,188);
	private Color Dusk = new Color(8,8,124);
	
	
	
	/*
	 * This HashSet is used to store all Student ID values within the database,
	 * which is used to see if a user is attempting to add a student that already
	 * exists, or update / remove a student that doesn't exist within the database. 
	 */
	
	static HashSet<Integer> studentList = new HashSet<>();
	
	
	
	
	
	
    public static void main(String[] args) {
		
    	
    	DataBaseFunction setBuilder = new DataBaseFunction();
    	studentList = setBuilder.buildHashSet();
		new GUI();
		
	}
	
	
	
	//Constructs most of the Swing components that are used for the GUI. 
	public GUI() {
		
		frame = new JFrame("Student Management System");
		panelOne = new JPanel();
		panelTwo = new JPanel();
		labelOne = new JLabel();
		labelTwo = new JLabel();
		buttonOne = new JButton();
		buttonTwo = new JButton();
		
		textArea = new JTextArea();
		textArea.setBackground(Dusk);
		textArea.setForeground(Cream);
		
		
		String[] menuList = {"Add Student", "Remove Student", "Update Student Info", "Display all Students"};
		cb = new JComboBox(menuList);
		cb.setBounds(200,200,150,50);
		
		
		
		
		labelOne.setHorizontalAlignment(JLabel.LEFT);
		labelOne.setSize(400, 100);
		labelOne.setText("Select the action you wish to perform from the drop-down menu: ");
		labelTwo.setHorizontalAlignment(JLabel.RIGHT);
		labelTwo.setSize(425, 100);
		labelTwo.setVisible(false);
		
		
		
		
		buttonOne.setText("OK");
		buttonOne.setBounds(400,200,100,50);
		buttonOne.addActionListener(this);
		buttonTwo.setBounds(400,200,100,50);
		buttonTwo.addActionListener(this);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLayout(new FlowLayout()); 
		panelOne.add(labelOne);
		panelOne.add(cb);
		panelOne.add(buttonOne);
		panelOne.add(labelTwo);
		frame.setVisible(true);
		
		
		
		lb1 = new JLabel("First Name:");
		tf1 = new JTextField();
		lb2 = new JLabel("Last Name:");
		tf2 = new JTextField();
		lb3 = new JLabel("Grade:");
		tf3 = new JTextField();
		lb4 = new JLabel("Student ID:");
		tf4 = new JTextField();
		lb5 = new JLabel("Contact Number:");
		tf5 = new JTextField();
		
		
		JLabel[] lbArray = {lb1,lb2,lb3,lb4,lb5};
		JTextField[] tfArray = {tf1,tf2,tf3,tf4,tf5};
		
		for(int i = 0; i < tfArray.length; i++) {
			tfArray[i].setPreferredSize(new Dimension(70,30));
			panelTwo.add(tfArray[i]);
		}
		
		
		
		panelTwo.add(lb1);
		panelTwo.add(tf1);
		panelTwo.add(lb2);
		panelTwo.add(tf2);
		panelTwo.add(lb3);
		panelTwo.add(tf3);
		panelTwo.add(lb4);
		panelTwo.add(tf4);
		panelTwo.add(lb5);
		panelTwo.add(tf5);
		panelTwo.add(buttonTwo);
		panelTwo.setVisible(false);
		
		
		frame.add(panelOne);
		frame.add(panelTwo);
		frame.add(textArea);
		
		
		frame.getContentPane().setBackground(Dusk);
		panelOne.setBackground(Dusk);
		labelOne.setForeground(Cream);
		panelTwo.setBackground(Dusk);
		labelTwo.setForeground(Cream);
		
		
		for(int i = 0; i < lbArray.length; i++) {
			lbArray[i].setForeground(Cream);
			lbArray[i].setSize(70,30);
		}
		
	}
	
	
	
	
	
	/*
	 * The below method determines what option is selected from the GUI drop-down menu, and the respective
	 * course of action depending on what button is pressed and what database function the user wishes to perform. 
	 */
	
	public void actionPerformed(ActionEvent e) {
		
		
		String userChoice = (String) cb.getItemAt(cb.getSelectedIndex());
		DataBaseFunction editor = new DataBaseFunction();
		labelTwo.setVisible(false);
		textArea.setVisible(false);
		panelTwo.setVisible(false);
		labelTwo.setForeground(Cream);
		Student student = new Student();
		
		
		
		if(e.getSource() == buttonOne) {
		    
			
			switch(userChoice) {
			
			case "Add Student":
			    	
			    buttonTwo.setText("ADD");
			    panelTwo.setVisible(true);
		        userCommand = 1;
			    break;
			    	
			    	
		    
		    
	        case "Remove Student":
	        	
	        	buttonTwo.setText("REMOVE");
	        	panelTwo.setVisible(true);
	        	userCommand = 2;
		    	break;
		    	
		    	
		    	
		    case "Update Student Info":
		    	
		    	buttonTwo.setText("UPDATE");
	        	panelTwo.setVisible(true);
	        	userCommand = 3;

		    	break;
		    	
		    	
		    	
		    case "Display all Students":
		    
		    	String s = editor.showInfo();
		    	textArea.setText(s);
		    	labelTwo.setText("");
		    	textArea.setVisible(true);
		    	break;
		    	
		    	
		    
		    	
		    	
		    default:
		    	System.out.println("Action could not be performed.");
		    	break;
		        }
			    
		
		}
		
		if(e.getSource() == buttonTwo) {
			
			if(userCommand == 2) {
				
				 labelTwo.setForeground(Color.RED);
				 
				try {
		        	student = new Student(Integer.parseInt(tf4.getText()));
		        	
		        	    if(studentList.contains(student.getStudentID())) {
		        		    studentList.remove(student.getStudentID());
		    		        editor.removeStudent(student);
			    	        labelTwo.setText("Student removed                          ");
			    	        labelTwo.setForeground(Color.GREEN);
		        	    }
		        	    else {
		        		     labelTwo.setText("A student with that ID does not exist in the database.");
		        	    }
		        	}
		        	catch(Exception e2) {
		        		
		        		labelTwo.setText("An error occured. Please make sure you entered the Student ID correctly");
		        		
		        	}
				labelTwo.setVisible(true);
			}
			
			if(userCommand == 1) {
				
				labelTwo.setForeground(Color.RED);
				
                 try {
		    		
		    		String firstName = tf1.getText();
		    		String lastName = tf2.getText();
		    		int grade = Integer.parseInt(tf3.getText());
		    	    int studentID = Integer.parseInt(tf4.getText());
		    		String contactNum = tf5.getText();
		    		
		    		student = new Student(firstName, lastName, grade, studentID, contactNum);
		    		
		    		if(!studentList.contains(student.getStudentID())) {
		    			editor.addStudent(student);
				    	labelTwo.setText("Student added                      ");
				    	labelTwo.setForeground(Color.GREEN);
				    	studentList.add(student.getStudentID());
				    	
		    		}
		    		else {
		    			labelTwo.setText("A student with that ID already exists in the database.");
		    		}
		    		
		    		}catch(Exception ex) { 
		    			
		    			labelTwo.setText("An error occured. Please make sure you entered the information correctly"
		    					+ " and filled in all feilds.");
		    			
		    		}
                 labelTwo.setVisible(true);
		    	
		    	
			}
			
			if(userCommand == 3) {
				
				 labelTwo.setForeground(Color.RED);
				 
		    	try {
			    	String firstName = tf1.getText();
		    		String lastName = tf2.getText();
		    		int grade = Integer.parseInt(tf3.getText());
		    		int studentID = Integer.parseInt(tf4.getText());
		    		String contactNum = tf5.getText();
			    	student = new Student(firstName, lastName, grade, studentID, contactNum);
			    	
			    	
			    	if(studentList.contains(student.getStudentID())) {
			    		
			    		editor.updateInfo(student);
				    	labelTwo.setText("Update complete");
				    	 labelTwo.setForeground(Color.GREEN);
				    	
			    	    }
			    	else {
			    		labelTwo.setText("A student with that ID does not exist in the database.");
			    	}
			    	
			    	
			    	}
			    	catch(Exception ex) {
			    		
			    		labelTwo.setText("An error occured. Please make sure you entered the information correctly and filled in all fields.");
			    	}
		    	
		    	labelTwo.setVisible(true);
			}
			
		}
	}
	
	

}
