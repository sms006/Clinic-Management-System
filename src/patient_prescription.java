import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;


public class patient_prescription extends JFrame {    
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public patient_prescription(int patientid) {
		  JFrame prescriptionFrame = new JFrame("Prescription");
		  prescriptionFrame.setSize(495, 391);
		  prescriptionFrame.setLocation(300,200);
	      SpringLayout springLayout = new SpringLayout();
	      prescriptionFrame.getContentPane().setLayout(springLayout);
	      
	      JLabel lblPrescription = new JLabel("Prescription");
	      springLayout.putConstraint(SpringLayout.NORTH, lblPrescription, 10, SpringLayout.NORTH, prescriptionFrame.getContentPane());
	      springLayout.putConstraint(SpringLayout.WEST, lblPrescription, 167, SpringLayout.WEST, prescriptionFrame.getContentPane());
	      lblPrescription.setFont(new Font("Tahoma", Font.BOLD, 21));
	      prescriptionFrame.getContentPane().add(lblPrescription);
	      
	      JTextArea txtAreaPrescription = new JTextArea();
	      txtAreaPrescription.setEditable(false);
	      txtAreaPrescription.setEnabled(false);
	      springLayout.putConstraint(SpringLayout.NORTH, txtAreaPrescription, 21, SpringLayout.SOUTH, lblPrescription);
	      springLayout.putConstraint(SpringLayout.WEST, txtAreaPrescription, 63, SpringLayout.WEST, prescriptionFrame.getContentPane());
	      springLayout.putConstraint(SpringLayout.SOUTH, txtAreaPrescription, 220, SpringLayout.SOUTH, lblPrescription);
	      springLayout.putConstraint(SpringLayout.EAST, txtAreaPrescription, 416, SpringLayout.WEST, prescriptionFrame.getContentPane());
	      prescriptionFrame.getContentPane().add(txtAreaPrescription);
	      txtAreaPrescription.setLineWrap(true);
	      
	      JButton btnUpdate = new JButton("Add/Update");
	      springLayout.putConstraint(SpringLayout.WEST, btnUpdate, 124, SpringLayout.WEST, prescriptionFrame.getContentPane());
	      springLayout.putConstraint(SpringLayout.SOUTH, btnUpdate, -28, SpringLayout.SOUTH, prescriptionFrame.getContentPane());
	      prescriptionFrame.getContentPane().add(btnUpdate);
	      
	      JButton btnSave = new JButton("Save");
	      springLayout.putConstraint(SpringLayout.WEST, btnSave, 258, SpringLayout.WEST, prescriptionFrame.getContentPane());
	      springLayout.putConstraint(SpringLayout.EAST, btnSave, -151, SpringLayout.EAST, prescriptionFrame.getContentPane());
	      springLayout.putConstraint(SpringLayout.NORTH, btnUpdate, -2, SpringLayout.NORTH, btnSave);
	      springLayout.putConstraint(SpringLayout.EAST, btnUpdate, -28, SpringLayout.WEST, btnSave);
	      btnSave.setEnabled(false);
	      
	      prescriptionFrame.getContentPane().add(btnSave);
	      
	      JLabel lblPatientAdmitted = new JLabel("Patient Admitted?");
	      springLayout.putConstraint(SpringLayout.NORTH, lblPatientAdmitted, 6, SpringLayout.SOUTH, txtAreaPrescription);
	      lblPatientAdmitted.setFont(new Font("Tahoma", Font.PLAIN, 14));
	      prescriptionFrame.getContentPane().add(lblPatientAdmitted);
	      
	      JRadioButton rdbtnYes = new JRadioButton("Yes");
	      rdbtnYes.setActionCommand("Yes");
	      rdbtnYes.setSelected(true);
	      springLayout.putConstraint(SpringLayout.EAST, lblPatientAdmitted, 0, SpringLayout.WEST, rdbtnYes);
	      springLayout.putConstraint(SpringLayout.NORTH, rdbtnYes, 6, SpringLayout.SOUTH, txtAreaPrescription);
	      prescriptionFrame.getContentPane().add(rdbtnYes);
	      
	      JRadioButton rdbtnNo = new JRadioButton("No");
	      springLayout.putConstraint(SpringLayout.NORTH, btnSave, 17, SpringLayout.SOUTH, rdbtnNo);
	      rdbtnNo.setActionCommand("No");
	      springLayout.putConstraint(SpringLayout.EAST, rdbtnYes, -6, SpringLayout.WEST, rdbtnNo);
	      springLayout.putConstraint(SpringLayout.NORTH, rdbtnNo, 6, SpringLayout.SOUTH, txtAreaPrescription);
	      springLayout.putConstraint(SpringLayout.WEST, rdbtnNo, 0, SpringLayout.WEST, btnSave);
	      prescriptionFrame.getContentPane().add(rdbtnNo);
	   
	      ButtonGroup group = new ButtonGroup();
	      group.add(rdbtnYes);
	      group.add(rdbtnNo);
	      
	      btnSave.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent arg0) {
		      		java.sql.Connection conn;
		      		java.sql.PreparedStatement updatePrescriptionPst=null;
		      		String selection = group.getSelection().getActionCommand();
					try {
						boolean admissionstatus = false;
						if(selection.equals("Yes")) {
							admissionstatus = true;
						}
						else {
							admissionstatus = false;
						}
						conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/hms_db", "root", "" );
						java.sql.Statement st2=conn.createStatement();
	        	        ResultSet rs2=st2.executeQuery("select prescription from patientprescription where pid="+patientid);
	        	        if(!rs2.next()) {
	        	        	
		    				Date d = new Date(System.currentTimeMillis());
							 updatePrescriptionPst = conn.prepareStatement(
								      "insert into patientprescription (recentprescriptiondate, prescription, pid,admissionstatus)"
								    		  +"values (?, ?, ?,?)");
							 updatePrescriptionPst.setDate(1,d);
							 updatePrescriptionPst.setString(2, txtAreaPrescription.getText());
							 updatePrescriptionPst.setInt(3,patientid);
							 updatePrescriptionPst.setBoolean(4, admissionstatus);
							 updatePrescriptionPst.executeUpdate();
							 updatePrescriptionPst.close();
							 JFrame frame = new JFrame();
			        		 JOptionPane.showMessageDialog(frame, "Prescription successfully saved");			        		 
			        		 prescriptionFrame.dispose();
	        	        }
	        	        else {
	        	        	java.sql.Statement st=conn.createStatement();	       //en madtidya illi 	        	
		    				Date d = new Date(System.currentTimeMillis());
							 updatePrescriptionPst = conn.prepareStatement(
								      "update patientprescription set recentprescriptiondate=?, prescription=?, admissionstatus = ? where pid=?"
								    		  );
							 updatePrescriptionPst.setDate(1,d);
							 updatePrescriptionPst.setString(2, txtAreaPrescription.getText());
							 updatePrescriptionPst.setBoolean(3, admissionstatus);
							 updatePrescriptionPst.setInt(4,patientid);
							 updatePrescriptionPst.executeUpdate();
							 updatePrescriptionPst.close();
							 JFrame frame = new JFrame();
			        		 JOptionPane.showMessageDialog(frame, "Prescription successfully saved");			        		 
			        		 prescriptionFrame.dispose();
	        	        }
		    				
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		      	}
		      });
	      
	      btnUpdate.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent arg0) {
		      		
		      		txtAreaPrescription.setEditable(true);
		      		txtAreaPrescription.setEnabled(true);
		      		btnSave.setEnabled(true);
		      		btnUpdate.setEnabled(false);
		      		
		      	}
		      });
	      
	      prescriptionFrame.setVisible(true);
	      java.sql.Connection conn = null;
			try {
				conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/hms_db", "root", "" );
				java.sql.Statement st=conn.createStatement();
  	        ResultSet rs=st.executeQuery("select * from patientprescription where pid="+patientid);
  	        while(rs.next()) {
  	        	txtAreaPrescription.setText(rs.getString("prescription"));
  	        }
  	        
			} catch (SQLException e) {				
				e.printStackTrace();
			}
	   }
}
