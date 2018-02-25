import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Component;

import javax.swing.SpringLayout;
import javax.swing.text.Caret;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Date;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class registrartion extends JFrame {
	private static JTextField txtFldName;    
	private static JTextField txtFldEmail;
	private static JTextField txtFldContact;
	private static JTextField txtFldGender;
	private static JTextField txtFldDept;
	private static JTextField txtFldSpecialization;
	private static JTextField txtFldAvailability;
	private JTextField txtFldUserName;
	private static JPasswordField txtFldPassword;
	private static JPasswordField txtFldConfirmPassword;
	
	public registrartion() {
		  SpringLayout springLayout = new SpringLayout();
	      getContentPane().setLayout(springLayout);
	      JLabel lblName = new JLabel("Name");
	      springLayout.putConstraint(SpringLayout.NORTH, lblName, 122, SpringLayout.NORTH, getContentPane());
	      lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
	      getContentPane().add(lblName);
	      
	      txtFldName = new JTextField();
	      springLayout.putConstraint(SpringLayout.NORTH, txtFldName, 0, SpringLayout.NORTH, lblName);
	      springLayout.putConstraint(SpringLayout.WEST, txtFldName, 76, SpringLayout.EAST, lblName);
	      springLayout.putConstraint(SpringLayout.EAST, txtFldName, 234, SpringLayout.EAST, lblName);
	      txtFldName.setColumns(10);
	      getContentPane().add(txtFldName);
	      
	      JLabel lblEmail = new JLabel("E-mail");
	      springLayout.putConstraint(SpringLayout.NORTH, lblEmail, 33, SpringLayout.SOUTH, lblName);
	      springLayout.putConstraint(SpringLayout.WEST, lblName, 0, SpringLayout.WEST, lblEmail);
	      springLayout.putConstraint(SpringLayout.EAST, lblEmail, -406, SpringLayout.EAST, getContentPane());
	      lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
	      getContentPane().add(lblEmail);
	      
	      txtFldEmail = new JTextField();
	      springLayout.putConstraint(SpringLayout.NORTH, txtFldEmail, 0, SpringLayout.NORTH, lblEmail);
	      springLayout.putConstraint(SpringLayout.WEST, txtFldEmail, 0, SpringLayout.WEST, txtFldName);
	      springLayout.putConstraint(SpringLayout.EAST, txtFldEmail, -176, SpringLayout.EAST, getContentPane());
	      txtFldEmail.setColumns(10);
	      getContentPane().add(txtFldEmail);
	      
	      JLabel lblContact = new JLabel("Contact No.");
	      springLayout.putConstraint(SpringLayout.NORTH, lblContact, 26, SpringLayout.SOUTH, lblEmail);
	      springLayout.putConstraint(SpringLayout.EAST, lblContact, -368, SpringLayout.EAST, getContentPane());
	      lblContact.setFont(new Font("Tahoma", Font.BOLD, 14));
	      getContentPane().add(lblContact);
	      
	      txtFldContact = new JTextField();
	      springLayout.putConstraint(SpringLayout.NORTH, txtFldContact, 0, SpringLayout.NORTH, lblContact);
	      springLayout.putConstraint(SpringLayout.WEST, txtFldContact, 0, SpringLayout.WEST, txtFldName);
	      springLayout.putConstraint(SpringLayout.EAST, txtFldContact, -176, SpringLayout.EAST, getContentPane());
	      txtFldContact.setColumns(10);
	      getContentPane().add(txtFldContact);
	      
	      JLabel lblGender = new JLabel("Gender");
	      springLayout.putConstraint(SpringLayout.WEST, lblGender, 0, SpringLayout.WEST, lblName);
	      lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
	      getContentPane().add(lblGender);
	      
	      JLabel lblDob = new JLabel("DOB");
	      springLayout.putConstraint(SpringLayout.NORTH, lblGender, 22, SpringLayout.SOUTH, lblDob);
	      springLayout.putConstraint(SpringLayout.NORTH, lblDob, 30, SpringLayout.SOUTH, lblContact);
	      springLayout.putConstraint(SpringLayout.WEST, lblDob, 0, SpringLayout.WEST, lblName);
	      lblDob.setFont(new Font("Tahoma", Font.BOLD, 14));
	      getContentPane().add(lblDob);
	      
	      txtFldGender = new JTextField();
	      springLayout.putConstraint(SpringLayout.NORTH, txtFldGender, 0, SpringLayout.NORTH, lblGender);
	      springLayout.putConstraint(SpringLayout.WEST, txtFldGender, 86, SpringLayout.EAST, lblDob);
	      springLayout.putConstraint(SpringLayout.EAST, txtFldGender, 0, SpringLayout.EAST, txtFldName);
	      txtFldGender.setColumns(10);
	      getContentPane().add(txtFldGender);
	      
	      JLabel lblDept = new JLabel("Department");
	      springLayout.putConstraint(SpringLayout.NORTH, lblDept, 26, SpringLayout.SOUTH, lblGender);
	      springLayout.putConstraint(SpringLayout.WEST, lblDept, 0, SpringLayout.WEST, lblName);
	      lblDept.setFont(new Font("Tahoma", Font.BOLD, 14));
	      getContentPane().add(lblDept);
	      
	      txtFldDept = new JTextField();
	      springLayout.putConstraint(SpringLayout.NORTH, txtFldDept, 0, SpringLayout.NORTH, lblDept);
	      springLayout.putConstraint(SpringLayout.WEST, txtFldDept, 0, SpringLayout.WEST, txtFldName);
	      springLayout.putConstraint(SpringLayout.EAST, txtFldDept, 0, SpringLayout.EAST, txtFldName);
	      txtFldDept.setColumns(10);
	      getContentPane().add(txtFldDept);
	      
	      JLabel lblSpecialization = new JLabel("Specialization");
	      springLayout.putConstraint(SpringLayout.WEST, lblSpecialization, 0, SpringLayout.WEST, lblName);
	      springLayout.putConstraint(SpringLayout.SOUTH, lblSpecialization, 42, SpringLayout.SOUTH, lblDept);
	      lblSpecialization.setFont(new Font("Tahoma", Font.BOLD, 14));
	      getContentPane().add(lblSpecialization);
	      
	      txtFldSpecialization = new JTextField();
	      springLayout.putConstraint(SpringLayout.NORTH, lblSpecialization, -2, SpringLayout.NORTH, txtFldSpecialization);
	      springLayout.putConstraint(SpringLayout.EAST, lblSpecialization, -9, SpringLayout.WEST, txtFldSpecialization);
	      springLayout.putConstraint(SpringLayout.NORTH, txtFldSpecialization, 21, SpringLayout.SOUTH, txtFldDept);
	      springLayout.putConstraint(SpringLayout.WEST, txtFldSpecialization, 0, SpringLayout.WEST, txtFldName);
	      springLayout.putConstraint(SpringLayout.EAST, txtFldSpecialization, 0, SpringLayout.EAST, txtFldName);
	      txtFldSpecialization.setColumns(10);
	      getContentPane().add(txtFldSpecialization);
	      
	      JLabel lblAvailability = new JLabel("Availability");
	      springLayout.putConstraint(SpringLayout.NORTH, lblAvailability, 25, SpringLayout.SOUTH, lblSpecialization);
	      springLayout.putConstraint(SpringLayout.WEST, lblAvailability, 0, SpringLayout.WEST, lblName);
	      lblAvailability.setFont(new Font("Tahoma", Font.BOLD, 14));
	      getContentPane().add(lblAvailability);
	      
	      txtFldAvailability = new JTextField();
	      springLayout.putConstraint(SpringLayout.WEST, txtFldAvailability, 0, SpringLayout.WEST, txtFldName);
	      springLayout.putConstraint(SpringLayout.NORTH, txtFldAvailability, 23, SpringLayout.SOUTH, txtFldSpecialization);
	      springLayout.putConstraint(SpringLayout.EAST, txtFldAvailability, 0, SpringLayout.EAST, txtFldName);
	      txtFldAvailability.setColumns(10);
	      getContentPane().add(txtFldAvailability);
	      
	      JButton btnRegister = new JButton("Register");
	      springLayout.putConstraint(SpringLayout.WEST, btnRegister, 126, SpringLayout.WEST, getContentPane());
	      springLayout.putConstraint(SpringLayout.SOUTH, btnRegister, -56, SpringLayout.SOUTH, getContentPane());
	      
	      getContentPane().add(btnRegister);
	      
	      JButton btnReset = new JButton("Reset");
	      springLayout.putConstraint(SpringLayout.EAST, btnRegister, -26, SpringLayout.WEST, btnReset);
	      springLayout.putConstraint(SpringLayout.SOUTH, btnReset, 0, SpringLayout.SOUTH, btnRegister);
	      springLayout.putConstraint(SpringLayout.EAST, btnReset, 21, SpringLayout.EAST, lblSpecialization);
	      springLayout.putConstraint(SpringLayout.NORTH, btnReset, 32, SpringLayout.SOUTH, lblAvailability);
	      springLayout.putConstraint(SpringLayout.WEST, btnReset, 303, SpringLayout.WEST, getContentPane());
	      
	      
	      getContentPane().add(btnReset);	      
	      JButton btnExit = new JButton("Exit");
	      btnExit.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent arg0) {
	      		int dialogButton = 0;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to exit?","Warning",dialogButton);
        		if(dialogResult == JOptionPane.YES_OPTION){
        			System.exit(0);
        		}
	      	}
	      });
	      
	      springLayout.putConstraint(SpringLayout.NORTH, btnExit, 0, SpringLayout.NORTH, btnRegister);
	      springLayout.putConstraint(SpringLayout.WEST, btnExit, 26, SpringLayout.EAST, btnReset);
	      springLayout.putConstraint(SpringLayout.SOUTH, btnExit, -56, SpringLayout.SOUTH, getContentPane());
	      springLayout.putConstraint(SpringLayout.EAST, btnExit, -122, SpringLayout.EAST, getContentPane());
	      getContentPane().add(btnExit);
	      
	      JLabel lblDoctorRegistration = new JLabel("Doctor Registration");
	      springLayout.putConstraint(SpringLayout.NORTH, btnRegister, 392, SpringLayout.SOUTH, lblDoctorRegistration);
	      springLayout.putConstraint(SpringLayout.NORTH, lblDoctorRegistration, -71, SpringLayout.NORTH, lblName);
	      springLayout.putConstraint(SpringLayout.WEST, lblDoctorRegistration, 221, SpringLayout.WEST, getContentPane());
	      springLayout.putConstraint(SpringLayout.SOUTH, lblDoctorRegistration, -37, SpringLayout.NORTH, lblName);
	      springLayout.putConstraint(SpringLayout.EAST, lblDoctorRegistration, 0, SpringLayout.EAST, txtFldName);
	      lblDoctorRegistration.setFont(new Font("Tahoma", Font.BOLD, 21));
	      getContentPane().add(lblDoctorRegistration);
	      
	      txtFldUserName = new JTextField();
	      springLayout.putConstraint(SpringLayout.NORTH, txtFldUserName, 0, SpringLayout.NORTH, lblEmail);
	      springLayout.putConstraint(SpringLayout.WEST, txtFldUserName, 0, SpringLayout.WEST, btnRegister);
	      getContentPane().add(txtFldUserName);
	      txtFldUserName.setColumns(10);
	      
	      JLabel lblUserame = new JLabel("Userame");
	      springLayout.putConstraint(SpringLayout.SOUTH, lblUserame, 0, SpringLayout.SOUTH, lblEmail);
	      springLayout.putConstraint(SpringLayout.EAST, lblUserame, -30, SpringLayout.WEST, txtFldUserName);
	      getContentPane().add(lblUserame);
	      
	      txtFldPassword = new JPasswordField();
	      springLayout.putConstraint(SpringLayout.NORTH, txtFldPassword, 34, SpringLayout.SOUTH, txtFldUserName);
	      springLayout.putConstraint(SpringLayout.WEST, txtFldPassword, 0, SpringLayout.WEST, btnRegister);
	      springLayout.putConstraint(SpringLayout.EAST, txtFldPassword, 0, SpringLayout.EAST, txtFldUserName);	     
	      getContentPane().add(txtFldPassword);	     
	      
	      JLabel lblPassword = new JLabel("Password");
	      springLayout.putConstraint(SpringLayout.WEST, lblPassword, 0, SpringLayout.WEST, lblUserame);
	      getContentPane().add(lblPassword);
	      
	      txtFldConfirmPassword = new JPasswordField();
	      springLayout.putConstraint(SpringLayout.NORTH, txtFldConfirmPassword, 26, SpringLayout.SOUTH, txtFldPassword);
	      springLayout.putConstraint(SpringLayout.WEST, txtFldConfirmPassword, 0, SpringLayout.WEST, btnRegister);
	      springLayout.putConstraint(SpringLayout.EAST, txtFldConfirmPassword, 0, SpringLayout.EAST, txtFldUserName);
	      getContentPane().add(txtFldConfirmPassword);
	       
	      JLabel lblConfirmPassword = new JLabel("Confirm password");
	      springLayout.putConstraint(SpringLayout.NORTH, lblConfirmPassword, 275, SpringLayout.NORTH, getContentPane());
	      springLayout.putConstraint(SpringLayout.EAST, lblConfirmPassword, -6, SpringLayout.WEST, txtFldConfirmPassword);
	      springLayout.putConstraint(SpringLayout.SOUTH, lblPassword, -29, SpringLayout.NORTH, lblConfirmPassword);
	      getContentPane().add(lblConfirmPassword);
	      
	      JDateChooser dateChooserDob = new JDateChooser();
	      springLayout.putConstraint(SpringLayout.NORTH, dateChooserDob, 0, SpringLayout.NORTH, lblDob);
	      springLayout.putConstraint(SpringLayout.WEST, dateChooserDob, -158, SpringLayout.EAST, txtFldContact);
	      springLayout.putConstraint(SpringLayout.SOUTH, dateChooserDob, 47, SpringLayout.SOUTH, lblContact);
	      springLayout.putConstraint(SpringLayout.EAST, dateChooserDob, 0, SpringLayout.EAST, txtFldName);
	      getContentPane().add(dateChooserDob);
	      dateChooserDob.setDateFormatString("yyyy-MM-dd");
	      
	      btnReset.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent arg0) {
		      		txtFldName.setText(null);
		      		txtFldEmail.setText(null);
		      		txtFldContact.setText(null);
		      		dateChooserDob.setDate(null);
		      		txtFldGender.setText(null);
		      		txtFldDept.setText(null);
		      		txtFldSpecialization.setText(null);
		      		txtFldAvailability.setText(null);
		      		txtFldUserName.setText(null);
		      		txtFldPassword.setText(null);
		      		txtFldConfirmPassword.setText(null);
		      	}
		      });
	      
	      btnRegister.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent arg0) {
		      		java.sql.Connection conn = null;
		      		java.sql.PreparedStatement pst=null;
		      		java.sql.PreparedStatement loginPst=null;
		      		
		      		int userid=0;
					try {
						conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/hms_db", "root", "" );
						conn.setAutoCommit(false); //for Transaction
						char[] pwd = txtFldPassword.getPassword();
						String text = String.copyValueOf(pwd);
						char[] cnfpwd = txtFldConfirmPassword.getPassword();
						String textcpwd = String.copyValueOf(cnfpwd);
						if(!text.equals(textcpwd)) {
							JFrame frame = new JFrame();
			        		 JOptionPane.showMessageDialog(frame, "Password and Confirm Password fields do not match");
						}
						else {
						loginPst = conn.prepareStatement(
							      "insert into login (username, password, usertype)"
							    		  +"values (?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
						loginPst.setString(1, txtFldUserName.getText());
						loginPst.setString(2, text);
						loginPst.setString(3, "doctor");
						loginPst.executeUpdate();

						ResultSet rs = loginPst.getGeneratedKeys();
						if (rs.next()){
						    userid=rs.getInt(1);
						}
					    loginPst.close();
					    String dob = ((JTextField)dateChooserDob.getDateEditor().getUiComponent()).getText();	
						 pst = conn.prepareStatement(
							      "insert into doctor (doctorname, email, contact, dob, gender, department, specialization, availability, userid)"
							    		  +"values (?, ?, ?, ?, ?, ?, ?, ?, ?)");

							    // set the preparedstatement parameters
									pst.setString(1, txtFldName.getText());
				                    pst.setString(2, txtFldEmail.getText());
				                    pst.setString(3, txtFldContact.getText());			                    
				                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				                    java.util.Date utilDate = null;
									try {
										utilDate = df.parse(dob);
									} 
									
									catch (ParseException e) {
										e.printStackTrace();
									}
									
				                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());			                    
				        	        pst.setDate(4, sqlDate);
				                    pst.setString(5, txtFldGender.getText());
				                    pst.setString(6, txtFldDept.getText());
				                    pst.setString(7, txtFldSpecialization.getText());
				                    pst.setString(8, txtFldAvailability.getText());
				                    pst.setInt(9, userid);							   
				                    // call executeUpdate to execute sql update statement
				                    pst.execute();
				                    pst.close();
				                    //Committing the transaction
				                    conn.commit();
				                    JFrame frame = new JFrame();
				                    JOptionPane.showMessageDialog(frame, "User registration successful");
						}
					} 					
					catch (SQLException e) {
								
						try {
							conn.rollback();
						} 
						
						catch (SQLException e1) {						
							e1.printStackTrace();
						}
						e.printStackTrace();
					}
					
					finally {
						if(loginPst!=null) {
							try {
								loginPst.close();
							} catch (SQLException e) {							
								e.printStackTrace();
							}
						}
						if(pst!=null) {
							try {
								pst.close();
							} catch (SQLException e) {							
								e.printStackTrace();
							}
						}
						
					}		      		
		      	}
		      });      
	}
	
   public static void main(String[] args) {
      
	   registrartion regt = new registrartion();
	   JFrame registrationFrame = new JFrame();
	   registrationFrame.setBounds(100, 100, 685, 522);
	   regt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   regt.setVisible(true);
      
    }
}