import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Updating_Prescription extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table_up;
	private JTextArea textArea;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Updating_Prescription frame = new Updating_Prescription();
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
	public Updating_Prescription() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("name ");
		lblName.setBounds(10, 50, 49, 14);
		contentPane.add(lblName);
		
		JLabel lblQuantity = new JLabel("sold_quantity");
		lblQuantity.setBounds(10, 75, 73, 14);
		contentPane.add(lblQuantity);
		
		textField = new JTextField();
		textField.setBounds(116, 47, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(116, 72, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int a = 0;
					 Connection connection = null;
					connection = DriverManager.getConnection("jdbc:mysql://localhost/hms_db", "root", "");
					java.sql.PreparedStatement pstt = connection.prepareStatement("SELECT rquantity FROM inventory WHERE rname = ?");
					 pstt.setString(1, textField.getText());
					 ResultSet result = pstt.executeQuery();
					 if(result.next())
					 {
					 a = result.getInt("rquantity");
					 System.out.println(a);
					 }
					 pstt.close();
					 int soldquantity = Integer.parseInt(textField_1.getText());
					 int updatedquantity = a - soldquantity;
					java.sql.PreparedStatement pst = connection.prepareStatement("UPDATE inventory SET rquantity = ?   WHERE rname = ?");

						    // set the preparedstatement parameters
							    pst.setInt(1, updatedquantity);
			                    pst.setString(2, textField.getText());
			                   
						    // call executeUpdate to execute our sql update statement
						    pst.executeUpdate();
						    pst.close();
						    
						    JOptionPane.showMessageDialog(null, "Data Updated successfully");

				} 
				catch (SQLException e) {
					
					
					e.printStackTrace();
				}

			}
		});
		btnUpdate.setBounds(58, 125, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				inma inventorymgt = new inma();
				inventorymgt.setVisible(true);
				JFrame frame = new JFrame();
				  frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);	
			}
		});
		btnBack.setBounds(258, 361, 89, 23);
		contentPane.add(btnBack);
		
		JLabel Patient_Id = new JLabel("Patient ID ");
		Patient_Id.setBounds(342, 50, 58, 14);
		contentPane.add(Patient_Id);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(404, 47, 96, 20);
		contentPane.add(textField_2);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(516, 46, 89, 23);
		contentPane.add(btnOk);
		
		JLabel label = new JLabel("name ");
		label.setBounds(10, 175, 49, 14);
		contentPane.add(label);
		
		JLabel lblAddquantity = new JLabel("add_quantity");
		lblAddquantity.setBounds(10, 200, 73, 14);
		contentPane.add(lblAddquantity);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(116, 172, 96, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(116, 197, 96, 20);
		contentPane.add(textField_4);
		
		JButton button = new JButton("Update");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int a = 0;
					 Connection connection = null;
					connection = DriverManager.getConnection("jdbc:mysql://localhost/hms_db", "root", "");
					java.sql.PreparedStatement pstt = connection.prepareStatement("SELECT rquantity FROM inventory WHERE rname = ?");
					 pstt.setString(1, textField_3.getText());
					 ResultSet result = pstt.executeQuery();
					 if(result.next())
					 {
					 a = result.getInt("rquantity");
					 System.out.println(a);
					 }
					 pstt.close();
					 int soldquantity = Integer.parseInt(textField_4.getText());
					 int updatedquantity = a + soldquantity;
					java.sql.PreparedStatement pst = connection.prepareStatement("UPDATE inventory SET rquantity = ?   WHERE rname = ?");

						    // set the preparedstatement parameters
							    pst.setInt(1, updatedquantity);
			                    pst.setString(2, textField_3.getText());
			                   
						    // call executeUpdate to execute our sql update statement
						    pst.executeUpdate();
						    pst.close();
						    
						    JOptionPane.showMessageDialog(null, "Data Updated successfully");

				} 
				catch (SQLException e) {
					
					
					e.printStackTrace();
				}

				
			}
		});
		button.setBounds(58, 243, 89, 23);
		contentPane.add(button);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(342, 112, 268, 214);
		contentPane.add(textArea);
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
	    			String ptid=textField_2.getText();
	    			if(ptid.equals("")||ptid.equals(null)) {
	    				JFrame frame = new JFrame();
		        		 JOptionPane.showMessageDialog(frame, "Enter Patient ID!");
	        		}
	    			else {
//	    			String[] tableColumnsName = {"Date of Visit","Diagnosis"}; 
//					DefaultTableModel aModel = (DefaultTableModel) tablePtHistory.getModel();
//					aModel.setColumnIdentifiers(tableColumnsName);
	    			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/hms_db", "root", "" );
	    			java.sql.Statement ptCreateStmt=conn.createStatement();
	    	        ResultSet ptResultSet=ptCreateStmt.executeQuery("select * from patientprescription where pid="+ptid);    	        
	    	        if (ptResultSet.next() == false) { 
	    	        	JFrame frame = new JFrame();
		        		 JOptionPane.showMessageDialog(frame,"Patient ID Does Not Exist");
	    	        	} else { 
	    	        		do { 
	    	        			
	    	        			textArea.setText(ptResultSet.getString("prescription"));
	    	        		} 
	    	        		while (ptResultSet.next()); 
	    	        		}
	    			}
				}
	    	    catch (SQLException e) {				
					e.printStackTrace();
				}
			}
		});
	
	}
}