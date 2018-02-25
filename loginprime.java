import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;


public class loginprime {
	private static JTextField txtFldUsername;  	
	private static JPasswordField txtFldPassword;

   public static void main(String[] args) {
      
      JFrame loginFrame = new JFrame("Login");
      loginFrame.setSize(715, 503);
      loginFrame.setLocation(300,200);
      SpringLayout springLayout = new SpringLayout();
      loginFrame.getContentPane().setLayout(springLayout);
      
      txtFldUsername = new JTextField();
      springLayout.putConstraint(SpringLayout.NORTH, txtFldUsername, 169, SpringLayout.NORTH, loginFrame.getContentPane());
      springLayout.putConstraint(SpringLayout.WEST, txtFldUsername, -363, SpringLayout.EAST, loginFrame.getContentPane());
      springLayout.putConstraint(SpringLayout.SOUTH, txtFldUsername, 208, SpringLayout.NORTH, loginFrame.getContentPane());
      springLayout.putConstraint(SpringLayout.EAST, txtFldUsername, -189, SpringLayout.EAST, loginFrame.getContentPane());
      loginFrame.getContentPane().add(txtFldUsername);
      txtFldUsername.setColumns(10);
      
      txtFldPassword = new JPasswordField();      
      springLayout.putConstraint(SpringLayout.NORTH, txtFldPassword, 22, SpringLayout.SOUTH, txtFldUsername);
      springLayout.putConstraint(SpringLayout.WEST, txtFldPassword, -363, SpringLayout.EAST, loginFrame.getContentPane());
      springLayout.putConstraint(SpringLayout.SOUTH, txtFldPassword, 61, SpringLayout.SOUTH, txtFldUsername);
      springLayout.putConstraint(SpringLayout.EAST, txtFldPassword, 0, SpringLayout.EAST, txtFldUsername);
      loginFrame.getContentPane().add(txtFldPassword);
      
      JLabel lblUsername = new JLabel("Username");
      springLayout.putConstraint(SpringLayout.NORTH, lblUsername, 5, SpringLayout.NORTH, txtFldUsername);
      springLayout.putConstraint(SpringLayout.EAST, lblUsername, -31, SpringLayout.WEST, txtFldUsername);
      lblUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
      loginFrame.getContentPane().add(lblUsername);
      
      JLabel lblPassword = new JLabel("Password");
      springLayout.putConstraint(SpringLayout.NORTH, lblPassword, 38, SpringLayout.SOUTH, lblUsername);
      springLayout.putConstraint(SpringLayout.WEST, lblPassword, 0, SpringLayout.WEST, lblUsername);
      lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
      loginFrame.getContentPane().add(lblPassword);
      
      JButton btnLogin = new JButton("Login");
      btnLogin.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent arg0) {
      		java.sql.Connection conn = null;
			try {
				conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/hms_db", "root", "" );
			} 
			catch (SQLException e) {				
				e.printStackTrace();
			}
		   
			// create preparedstatement using a sql update query
			
				 String user = txtFldUsername.getText();
				 char[] pwd = txtFldPassword.getPassword();
				 String pwdString = String.valueOf(pwd);				 
				 String sql = "SELECT * FROM login where username=? and password=?";
				try {					 
					PreparedStatement ps = conn.prepareStatement(sql);
				     ps.setString(1, user);
				    ps.setString(2, pwdString);				     
				     ResultSet rs = ps.executeQuery();
				   				     
				     if (rs.next() == false) { 
		    	        	JFrame frame = new JFrame();
			        		 JOptionPane.showMessageDialog(frame, "Incorrect Login Details");
		    	        	} else { 
		    	        		do { 
		    	        			String databaseUsername = rs.getString("username");
		   				         String databasePassword = rs.getString("password");		   				         
		   				         String type = rs.getString("usertype");		   				       
		   				         if(user.equals(databaseUsername) && pwdString.equals(databasePassword)) {
		   				        	 //to do : check for other user roles
		   				        	 if(type.equals("doctor")) {
		   				        		 String userid = rs.getString("userid");
		   				        		 JFrame frame = new JFrame();
		   				        		 JOptionPane.showMessageDialog(frame, "User Logged in successfully");
		   				        		 loginFrame.dispose();
		   				        		 update_doctor_info updtinfo = new update_doctor_info(Integer.parseInt(userid));
		   				        		 updtinfo.setVisible(true);
		   				        		 updtinfo.setExtendedState(Frame.MAXIMIZED_BOTH);
		   				        	}
		   				        	 else if (type.equals("bookappoint"))
		   				        	 {
		   				        		 loginFrame.dispose();
		   				        		patientnbookappointmentlanding frame = new patientnbookappointmentlanding();
		   								frame.setVisible(true);
		   				        		 frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		   				        	 }
		   				        	 else
		   				        	 {
		   				        		 loginFrame.dispose();
		   				        	 inma in = new inma();
		   				        	 in.setVisible(true);
		   				        	 }
		   				         }
		    	        		} 
		    	        		while (rs.next()); 
		    	        		}
				     
			} 
				catch (SQLException e) {				
				e.printStackTrace();
			}

			 }

		
      });
      btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
      springLayout.putConstraint(SpringLayout.NORTH, btnLogin, 26, SpringLayout.SOUTH, txtFldPassword);
      springLayout.putConstraint(SpringLayout.WEST, btnLogin, 266, SpringLayout.WEST, loginFrame.getContentPane());
      springLayout.putConstraint(SpringLayout.SOUTH, btnLogin, 65, SpringLayout.SOUTH, txtFldPassword);
      springLayout.putConstraint(SpringLayout.EAST, btnLogin, 373, SpringLayout.WEST, loginFrame.getContentPane());
      loginFrame.getContentPane().add(btnLogin);
      
      JButton btnReset = new JButton("Reset");
      btnReset.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent arg0) {
      		txtFldUsername.setText(null);
      		txtFldPassword.setText(null);
      	}
      });
      btnReset.setFont(new Font("Tahoma", Font.PLAIN, 16));
      springLayout.putConstraint(SpringLayout.NORTH, btnReset, 0, SpringLayout.NORTH, btnLogin);
      springLayout.putConstraint(SpringLayout.WEST, btnReset, 34, SpringLayout.EAST, btnLogin);
      springLayout.putConstraint(SpringLayout.SOUTH, btnReset, 0, SpringLayout.SOUTH, btnLogin);
      springLayout.putConstraint(SpringLayout.EAST, btnReset, 248, SpringLayout.WEST, btnLogin);
      loginFrame.getContentPane().add(btnReset);
      loginFrame.setVisible(true);
      
    }
}
