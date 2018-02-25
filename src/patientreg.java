import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class patientreg extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnRetrieve;
	private JButton btnBookAppointment;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					patientreg frame = new patientreg();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

		
	public patientreg() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1126, 719);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(29, 46, 62, 28);
		contentPane.add(lblName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(29, 83, 62, 28);
		contentPane.add(lblAge);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(29, 132, 62, 28);
		contentPane.add(lblGender);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(29, 181, 62, 28);
		contentPane.add(lblAddress);
		
		JLabel lblPhoneno = new JLabel("Phoneno");
		lblPhoneno.setBounds(29, 220, 62, 28);
		contentPane.add(lblPhoneno);
		
		JLabel lblAilment = new JLabel("Ailment");
		lblAilment.setBounds(29, 259, 62, 28);
		contentPane.add(lblAilment);
		
		JLabel lblDoctorid = new JLabel("Doctorid");
		lblDoctorid.setBounds(29, 298, 62, 28);
		contentPane.add(lblDoctorid);
		
		JLabel lblBloodgroup = new JLabel("Bloodgroup");
		lblBloodgroup.setBounds(29, 344, 62, 28);
		contentPane.add(lblBloodgroup);
		
		JLabel lblEmergencyContact = new JLabel("Emergency Contact");
		lblEmergencyContact.setBounds(0, 396, 96, 28);
		contentPane.add(lblEmergencyContact);
		
		textField = new JTextField();
		textField.setBounds(101, 50, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(101, 87, 96, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(101, 136, 96, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(101, 185, 96, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(101, 224, 96, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(101, 263, 96, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(101, 306, 96, 20);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(101, 348, 96, 20);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(101, 400, 96, 20);
		contentPane.add(textField_8);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
                {                    
                    String query="insert into patient(name,age,gender,address,phoneno,ailment,doctorid,bloodgroup,emergencycontact)" + "values(?,?,?,?,?,?,?,?,?)";
        			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/hms_db", "root", "");
                    java.sql.PreparedStatement pst = connection.prepareStatement(query); 
                    pst.setString(1, textField.getText());
                    pst.setString(2, textField_1.getText());
                    pst.setString(3, textField_2.getText());
                    pst.setString(4, textField_3.getText());
				    pst.setString(5, textField_4.getText());
				    pst.setString(6, textField_5.getText());
				    pst.setString(7, textField_6.getText());
				    pst.setString(8, textField_7.getText());
				    pst.setString(9, textField_8.getText());
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data Saved successfully");
   
                    pst.close();                 
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
			}
		});
		btnInsert.setBounds(29, 477, 89, 23);
		contentPane.add(btnInsert);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					 String query = "delete from patient where phoneno='"+textField_4.getText()+"'";
	        			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/hms_db", "root", "");
					java.sql.PreparedStatement pst = connection.prepareStatement(query );
                    pst.execute();                    
                   JOptionPane.showMessageDialog(null, "Data deleted successfully");
                   
                   pst.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(144, 477, 89, 23);
		contentPane.add(btnDelete);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try
				  {
	        			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/hms_db", "root", "");

				    // create our java preparedstatement using a sql update query
					 java.sql.PreparedStatement pst = connection.prepareStatement(
				      "UPDATE Patient SET name = ?, age = ?, gender = ?, address = ?, phoneno = ?, ailment = ?, doctorid = ?, bloodgroup = ?, emergencycontact = ?  WHERE phoneno = ?");

				    // set the preparedstatement parameters
					    pst.setString(1, textField.getText());
	                    pst.setString(2, textField_1.getText());
	                    pst.setString(3, textField_2.getText());
	                    pst.setString(4, textField_3.getText());
					    pst.setString(5, textField_4.getText());
					    pst.setString(6, textField_5.getText());
					    pst.setString(7, textField_6.getText());
					    pst.setString(8, textField_7.getText());
					    pst.setString(9, textField_8.getText());
					    pst.setString(10, textField_4.getText());
					    
				    // call executeUpdate to execute our sql update statement
				    pst.executeUpdate();
				    pst.close();
				  }
				 catch(Exception e)
	                {
	                    e.printStackTrace();
	                }			
			}
		});
		btnUpdate.setBounds(259, 477, 89, 23);
		contentPane.add(btnUpdate);
		
		btnRetrieve = new JButton("Retrieve");
		btnRetrieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
        			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/hms_db?autoReconnect=true&useSSL=false", "root", "");

					String query = "select * from Patient";
					java.sql.PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					//table.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnRetrieve.setBounds(384, 477, 89, 23);
		contentPane.add(btnRetrieve);
		
		btnBookAppointment = new JButton("Book Appointment");
		btnBookAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				landingbook lb = new landingbook();
				lb.setVisible(true);	
			}
		});
		btnBookAppointment.setBounds(502, 477, 150, 23);
		contentPane.add(btnBookAppointment);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(234, 52, 416, 372);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);	
	}
}
