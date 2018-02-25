import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.Component;
import javax.swing.SpringLayout;
import com.mysql.jdbc.Statement;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.util.Date;
import javax.swing.ListSelectionModel;
import com.toedter.calendar.JDateChooser;


public class update_doctor_info extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtFldName;
	private JTextField txtFldEmail;
	private JTextField txtFldContact;
	private JTextField txtFldGender;
	private JTextField txtFldDob;
	private JTextField txtFldDept;
	private JTextField txtFldSpecialization;
	private JTextField txtFldAvailability;
	private JTextField txtFldPtId;
	private JTable tablePtHistory;
	static JFrame frame = new JFrame();
	private JTable tableAppt;
	
	
    public update_doctor_info(int userid) {
         
    	java.sql.Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/hms_db", "root", "" );
		} catch (SQLException e1) {			
			e1.printStackTrace();
		}
        setTitle("Doctor");
        SpringLayout springLayout = new SpringLayout();
        
        getContentPane().setLayout(springLayout);
        JTabbedPane jtp = new JTabbedPane();
        springLayout.putConstraint(SpringLayout.NORTH, jtp, 0, SpringLayout.NORTH, getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, jtp, 0, SpringLayout.WEST, getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, jtp, 512, SpringLayout.NORTH, getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, jtp, 686, SpringLayout.WEST, getContentPane());
        getContentPane().add(jtp);
        JPanel jp1 = new JPanel();
        jp1.setBounds(100, 100, 685, 522);
        JPanel jp2 = new JPanel();
        jp2.setBounds(100, 100, 685, 522);
        SpringLayout sl_jp1 = new SpringLayout();
        jp1.setLayout(sl_jp1);
        jtp.addTab("My Profile", jp1);
        
        JLabel lblUpdateMyInfo = new JLabel("UPDATE MY INFO");
        sl_jp1.putConstraint(SpringLayout.NORTH, lblUpdateMyInfo, 10, SpringLayout.NORTH, jp1);
        sl_jp1.putConstraint(SpringLayout.WEST, lblUpdateMyInfo, 242, SpringLayout.WEST, jp1);
        lblUpdateMyInfo.setFont(new Font("Tahoma", Font.BOLD, 18));
        jp1.add(lblUpdateMyInfo);
        
        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        sl_jp1.putConstraint(SpringLayout.NORTH, lblName, 79, SpringLayout.NORTH, jp1);
        sl_jp1.putConstraint(SpringLayout.WEST, lblName, 140, SpringLayout.WEST, jp1);
        jp1.add(lblName);
        
        JLabel lblEmail = new JLabel("E-mail");
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
        sl_jp1.putConstraint(SpringLayout.NORTH, lblEmail, 27, SpringLayout.SOUTH, lblName);
        sl_jp1.putConstraint(SpringLayout.WEST, lblEmail, 0, SpringLayout.WEST, lblName);
        jp1.add(lblEmail);
        
        JLabel lblContactNo = new JLabel("Contact No.");
        lblContactNo.setFont(new Font("Tahoma", Font.BOLD, 14));
        sl_jp1.putConstraint(SpringLayout.NORTH, lblContactNo, 26, SpringLayout.SOUTH, lblEmail);
        sl_jp1.putConstraint(SpringLayout.WEST, lblContactNo, 0, SpringLayout.WEST, lblName);
        jp1.add(lblContactNo);
        
        JLabel lblGender = new JLabel("Gender");
        lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
        sl_jp1.putConstraint(SpringLayout.NORTH, lblGender, 25, SpringLayout.SOUTH, lblContactNo);
        sl_jp1.putConstraint(SpringLayout.WEST, lblGender, 0, SpringLayout.WEST, lblName);
        jp1.add(lblGender);
        
        JLabel lblDob = new JLabel("DOB");
        lblDob.setFont(new Font("Tahoma", Font.BOLD, 14));
        sl_jp1.putConstraint(SpringLayout.NORTH, lblDob, 25, SpringLayout.SOUTH, lblGender);
        sl_jp1.putConstraint(SpringLayout.WEST, lblDob, 0, SpringLayout.WEST, lblName);
        jp1.add(lblDob);
        
        JLabel lblDepartment = new JLabel("Department");
        lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 14));
        sl_jp1.putConstraint(SpringLayout.NORTH, lblDepartment, 25, SpringLayout.SOUTH, lblDob);
        sl_jp1.putConstraint(SpringLayout.WEST, lblDepartment, 136, SpringLayout.WEST, jp1);
        jp1.add(lblDepartment);
        
        JLabel lblSpecialization = new JLabel("Specialization");
        lblSpecialization.setFont(new Font("Tahoma", Font.BOLD, 14));
        sl_jp1.putConstraint(SpringLayout.NORTH, lblSpecialization, 30, SpringLayout.SOUTH, lblDepartment);
        sl_jp1.putConstraint(SpringLayout.WEST, lblSpecialization, 0, SpringLayout.WEST, lblName);
        jp1.add(lblSpecialization);
        
        JLabel lblAvailability = new JLabel("Availability");
        lblAvailability.setFont(new Font("Tahoma", Font.BOLD, 14));
        sl_jp1.putConstraint(SpringLayout.NORTH, lblAvailability, 27, SpringLayout.SOUTH, lblSpecialization);
        sl_jp1.putConstraint(SpringLayout.WEST, lblAvailability, 0, SpringLayout.WEST, lblName);
        jp1.add(lblAvailability);
        
        txtFldName = new JTextField();
        txtFldName.setEditable(false);
        sl_jp1.putConstraint(SpringLayout.NORTH, txtFldName, -20, SpringLayout.SOUTH, lblName);
        sl_jp1.putConstraint(SpringLayout.WEST, txtFldName, 84, SpringLayout.EAST, lblName);
        sl_jp1.putConstraint(SpringLayout.SOUTH, txtFldName, 0, SpringLayout.SOUTH, lblName);
        sl_jp1.putConstraint(SpringLayout.EAST, txtFldName, 243, SpringLayout.EAST, lblName);
        jp1.add(txtFldName);
        txtFldName.setColumns(10);
        
        txtFldEmail = new JTextField();
        sl_jp1.putConstraint(SpringLayout.NORTH, txtFldEmail, 27, SpringLayout.SOUTH, txtFldName);
        sl_jp1.putConstraint(SpringLayout.WEST, txtFldEmail, 80, SpringLayout.EAST, lblEmail);
        sl_jp1.putConstraint(SpringLayout.SOUTH, txtFldEmail, 49, SpringLayout.SOUTH, txtFldName);
        sl_jp1.putConstraint(SpringLayout.EAST, txtFldEmail, 0, SpringLayout.EAST, txtFldName);
        txtFldEmail.setColumns(10);
        jp1.add(txtFldEmail);
        
        txtFldContact = new JTextField();
        sl_jp1.putConstraint(SpringLayout.NORTH, txtFldContact, 0, SpringLayout.NORTH, lblContactNo);
        sl_jp1.putConstraint(SpringLayout.WEST, txtFldContact, 0, SpringLayout.WEST, txtFldName);
        sl_jp1.putConstraint(SpringLayout.EAST, txtFldContact, 0, SpringLayout.EAST, txtFldName);
        txtFldContact.setColumns(10);
        jp1.add(txtFldContact);
        
        txtFldGender = new JTextField();
        txtFldGender.setEditable(false);
        sl_jp1.putConstraint(SpringLayout.WEST, txtFldGender, 0, SpringLayout.WEST, txtFldName);
        sl_jp1.putConstraint(SpringLayout.SOUTH, txtFldGender, 0, SpringLayout.SOUTH, lblGender);
        sl_jp1.putConstraint(SpringLayout.EAST, txtFldGender, 0, SpringLayout.EAST, txtFldName);
        txtFldGender.setColumns(10);
        jp1.add(txtFldGender);
        
        txtFldDob = new JTextField();
        txtFldDob.setEditable(false);
        sl_jp1.putConstraint(SpringLayout.WEST, txtFldDob, 0, SpringLayout.WEST, txtFldName);
        sl_jp1.putConstraint(SpringLayout.SOUTH, txtFldDob, 0, SpringLayout.SOUTH, lblDob);
        sl_jp1.putConstraint(SpringLayout.EAST, txtFldDob, 0, SpringLayout.EAST, txtFldName);
        txtFldDob.setColumns(10);
        jp1.add(txtFldDob);
        
        txtFldDept = new JTextField();
        txtFldDept.setEditable(false);
        sl_jp1.putConstraint(SpringLayout.WEST, txtFldDept, 0, SpringLayout.WEST, txtFldName);
        sl_jp1.putConstraint(SpringLayout.SOUTH, txtFldDept, 0, SpringLayout.SOUTH, lblDepartment);
        sl_jp1.putConstraint(SpringLayout.EAST, txtFldDept, 0, SpringLayout.EAST, txtFldName);
        txtFldDept.setColumns(10);
        jp1.add(txtFldDept);
        
        txtFldSpecialization = new JTextField();
        txtFldSpecialization.setEditable(false);
        sl_jp1.putConstraint(SpringLayout.NORTH, txtFldSpecialization, 0, SpringLayout.NORTH, lblSpecialization);
        sl_jp1.putConstraint(SpringLayout.WEST, txtFldSpecialization, 0, SpringLayout.WEST, txtFldName);
        sl_jp1.putConstraint(SpringLayout.EAST, txtFldSpecialization, 0, SpringLayout.EAST, txtFldName);
        txtFldSpecialization.setColumns(10);
        jp1.add(txtFldSpecialization);
        
        txtFldAvailability = new JTextField();
        sl_jp1.putConstraint(SpringLayout.NORTH, txtFldAvailability, 0, SpringLayout.NORTH, lblAvailability);
        sl_jp1.putConstraint(SpringLayout.WEST, txtFldAvailability, 0, SpringLayout.WEST, txtFldName);
        sl_jp1.putConstraint(SpringLayout.EAST, txtFldAvailability, 0, SpringLayout.EAST, txtFldName);
        txtFldAvailability.setColumns(10);
        jp1.add(txtFldAvailability);
        
        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		try
				  {
        			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/hms_db", "root", "" );
				    // create preparedstatement using a sql update query
					 	java.sql.PreparedStatement pst = conn.prepareStatement(
					 			"UPDATE Doctor SET Email = ?, Contact = ?, Availability = ?  WHERE userid = ?");
				    // set the preparedstatement parameters
					    pst.setString(1, txtFldEmail.getText());
	                    pst.setString(2, txtFldContact.getText());
	                    pst.setString(3, txtFldAvailability.getText());
	                    pst.setInt(4, userid);					    
				    // call executeUpdate to execute our sql update statement
	                    pst.executeUpdate();
	                    pst.close();
	                    Component frame = null;
	                    JOptionPane.showMessageDialog(frame, "User details have been updated successfully");
				  }
				 catch(Exception e)
	                {
	                    e.printStackTrace();
	                    Component frame = null;
						JOptionPane.showMessageDialog(frame, "Error occurred while updating details");
	                }								
			}
        	
        });
        
        sl_jp1.putConstraint(SpringLayout.NORTH, btnUpdate, 28, SpringLayout.SOUTH, lblAvailability);
        sl_jp1.putConstraint(SpringLayout.WEST, btnUpdate, 150, SpringLayout.WEST, jp1);
        jp1.add(btnUpdate);        
        
		try {
			
			java.sql.Statement st=conn.createStatement();
	        ResultSet rs=st.executeQuery("select * from doctor where userid="+userid);
	        while(rs.next()){
	        txtFldName.setText(rs.getString("doctorname"));
	        txtFldEmail.setText(rs.getString("email"));
	        txtFldContact.setText(rs.getString("contact"));
	        txtFldGender.setText(rs.getString("gender"));
	        Date dateOfBirth=rs.getDate("dob");
	        String valueToInsert = dateOfBirth.toString();	        
	        txtFldDob.setText(valueToInsert);
	        txtFldDept.setText(rs.getString("department"));
	        txtFldSpecialization.setText(rs.getString("specialization"));
	        txtFldAvailability.setText(rs.getString("availability"));	        	
	        }
		} 
		catch (SQLException e) {			
			e.printStackTrace();
		}
        
        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {        		
				txtFldEmail.setText(null);
				txtFldContact.setText(null);				
				txtFldAvailability.setText(null);
        	}
        });
        sl_jp1.putConstraint(SpringLayout.WEST, btnReset, 299, SpringLayout.WEST, jp1);
        sl_jp1.putConstraint(SpringLayout.EAST, btnReset, -280, SpringLayout.EAST, jp1);
        sl_jp1.putConstraint(SpringLayout.SOUTH, btnUpdate, 0, SpringLayout.SOUTH, btnReset);
        sl_jp1.putConstraint(SpringLayout.EAST, btnUpdate, -47, SpringLayout.WEST, btnReset);
        sl_jp1.putConstraint(SpringLayout.NORTH, btnReset, 25, SpringLayout.SOUTH, txtFldAvailability);
        jp1.add(btnReset);
        
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
        
        sl_jp1.putConstraint(SpringLayout.NORTH, btnExit, -23, SpringLayout.SOUTH, btnUpdate);
        sl_jp1.putConstraint(SpringLayout.WEST, btnExit, 46, SpringLayout.EAST, btnReset);
        sl_jp1.putConstraint(SpringLayout.SOUTH, btnExit, 0, SpringLayout.SOUTH, btnUpdate);
        sl_jp1.putConstraint(SpringLayout.EAST, btnExit, 137, SpringLayout.EAST, btnReset);
        jp1.add(btnExit);
        jtp.addTab("Patient Information", jp2);
        jp2.setLayout(null);
        
        txtFldPtId = new JTextField();
        txtFldPtId.setBounds(239, 11, 96, 20);
        jp2.add(txtFldPtId);
        txtFldPtId.setColumns(10);
        
        JLabel lblPtId = new JLabel("Patient ID");
        lblPtId.setBounds(170, 14, 59, 14);
        jp2.add(lblPtId);
        
        JButton btnSearch = new JButton("Search");
        
        btnSearch.setBounds(360, 10, 96, 23);
        jp2.add(btnSearch);
        
        JScrollPane scrollPanePtHistory = new JScrollPane();
        scrollPanePtHistory.setBounds(57, 145, 544, 204);
        jp2.add(scrollPanePtHistory);
        
       
        tablePtHistory = new JTable();      
        tablePtHistory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        scrollPanePtHistory.setViewportView(tablePtHistory);
         
        
        JLabel lblPateintName = new JLabel("Patient Name:");
        lblPateintName.setBounds(81, 64, 96, 14);
        jp2.add(lblPateintName);
        
        JLabel lblAge = new JLabel("Age:");
        lblAge.setBounds(81, 92, 59, 17);
        jp2.add(lblAge);
        
        JLabel lblGender_1 = new JLabel("Gender:");
        lblGender_1.setBounds(81, 120, 49, 14);
        jp2.add(lblGender_1);
        
        JLabel lblBloodGroup = new JLabel("Blood Group:");
        lblBloodGroup.setBounds(343, 61, 86, 14);
        jp2.add(lblBloodGroup);
        
        JLabel lblAilment = new JLabel("Ailment:");
        lblAilment.setBounds(343, 92, 70, 14);
        jp2.add(lblAilment);
        
        JLabel label = new JLabel("");
        label.setBounds(173, 64, 162, 14);
        jp2.add(label);
        
        JLabel label_1 = new JLabel("");
        label_1.setBounds(160, 95, 162, 14);
        jp2.add(label_1);
        
        JLabel label_2 = new JLabel("");
        label_2.setBounds(160, 120, 162, 14);
        jp2.add(label_2);
        
        JLabel label_3 = new JLabel("");
        label_3.setBounds(428, 61, 162, 14);
        jp2.add(label_3);
        
        JLabel label_4 = new JLabel("");
        label_4.setBounds(399, 92, 173, 14);
        jp2.add(label_4);
        
        JLabel lblNewDiagnosis = new JLabel("Diagnosis");
        lblNewDiagnosis.setBounds(41, 396, 59, 43);
        jp2.add(lblNewDiagnosis);
        
        JTextArea txtAreaDiagnosis = new JTextArea();
        txtAreaDiagnosis.setLineWrap(true);
        txtAreaDiagnosis.setBounds(103, 384, 326, 62);
        jp2.add(txtAreaDiagnosis);
        
        
        JButton btnAddDiagnosis = new JButton("Add Diagnosis");
        btnAddDiagnosis.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		java.sql.Connection conn = null;
        		java.sql.PreparedStatement patientHistoryPst=null;
    			try {
    				String newdiagnosis = txtAreaDiagnosis.getText();
    				if(newdiagnosis.equals("")||newdiagnosis.equals(null)) {
            			JFrame frame = new JFrame();
    	        		 JOptionPane.showMessageDialog(frame, "Diagnosis is empty");
            		}
    				else {
    				String ptid=txtFldPtId.getText();
    				if(ptid.equals("")||ptid.equals(null)) {
            			JFrame frame = new JFrame();
    	        		 JOptionPane.showMessageDialog(frame, "Enter Patient ID to add Diagnosis");
            		}
    				else {
    				
    				java.sql.Date sq = new java.sql.Date(System.currentTimeMillis());

    				String[] tableColumnsName = {"Date of Visit","Diagnosis"}; 
    				DefaultTableModel aModel = (DefaultTableModel) tablePtHistory.getModel();
    				aModel.setColumnIdentifiers(tableColumnsName);
    				conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/hms_db", "root", "" );
    				patientHistoryPst = conn.prepareStatement(
  					      "insert into patientHistory (dateofvisit, history, pid)"
  					    		  +"values (?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
    				
    				patientHistoryPst.setDate(1,  sq);
    				patientHistoryPst.setString(2, txtAreaDiagnosis.getText());
    				patientHistoryPst.setString(3, ptid);
    				patientHistoryPst.executeUpdate();
    				patientHistoryPst.close();
    				java.sql.Statement st1=conn.createStatement();
        	        ResultSet rs1=st1.executeQuery("select dateofvisit as 'Date of Visit',history from patienthistory where pid="+ptid+" ORDER BY phistoryid DESC");
        	        java.sql.ResultSetMetaData rsmd = rs1.getMetaData();
        	        int colNo = rsmd.getColumnCount();
        	        if (aModel.getRowCount() > 0) {
        	            for (int i = aModel.getRowCount() - 1; i > -1; i--) {
        	            	aModel.removeRow(i);
        	            }
        	        }
        	        while(rs1.next()){
        	         Object[] objects = new Object[colNo];
        	         
        	         for(int i=0;i<colNo;i++){
        	          objects[i]=rs1.getObject(i+1);
        	          }
        	         aModel.addRow(objects);
        	        }
        	        tablePtHistory.setModel(aModel);
        	       
    				}
    				}
    				
    			} 
    			
    			catch (SQLException e) {
    				
    				e.printStackTrace();
    			}
    			
        	}
        });
        btnAddDiagnosis.setBounds(461, 381, 198, 31);
        jp2.add(btnAddDiagnosis);
        
        JButton btnAddupdatePrescription = new JButton("Add/Update Prescription");
        btnAddupdatePrescription.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		JFrame frame = new JFrame();
        		String ptid = txtFldPtId.getText(); 
        		if(ptid.equals("")||ptid.equals(null)) {
        			
	        		 JOptionPane.showMessageDialog(frame, "Enter Patient ID!");
        		}
        		else {
        		int number = Integer.parseInt(ptid);        		
        		patient_prescription prescription = new patient_prescription(number);
        		prescription.setVisible(true);        		
        		frame.dispose();
        		}
        		
        	}
        });
        
        btnAddupdatePrescription.setBounds(461, 423, 198, 31);
        jp2.add(btnAddupdatePrescription);
        
        JPanel panel = new JPanel();
        jtp.addTab("Appointments", null, panel, null);
        SpringLayout sl_panel = new SpringLayout();
        panel.setLayout(sl_panel);
        
        JLabel lblSelectDate = new JLabel("Select Date:");
        sl_panel.putConstraint(SpringLayout.WEST, lblSelectDate, 144, SpringLayout.WEST, panel);
        sl_panel.putConstraint(SpringLayout.SOUTH, lblSelectDate, -412, SpringLayout.SOUTH, panel);
        panel.add(lblSelectDate);
        
        JButton btnGetAppointments = new JButton("Get Appointments");
        
        sl_panel.putConstraint(SpringLayout.NORTH, btnGetAppointments, -4, SpringLayout.NORTH, lblSelectDate);
        sl_panel.putConstraint(SpringLayout.EAST, btnGetAppointments, -154, SpringLayout.EAST, panel);
        panel.add(btnGetAppointments);
        
        JDateChooser dateChooser = new JDateChooser();
        sl_panel.putConstraint(SpringLayout.WEST, dateChooser, 25, SpringLayout.EAST, lblSelectDate);
        sl_panel.putConstraint(SpringLayout.SOUTH, dateChooser, -406, SpringLayout.SOUTH, panel);
        sl_panel.putConstraint(SpringLayout.EAST, dateChooser, 168, SpringLayout.EAST, lblSelectDate);
        panel.add(dateChooser);
        dateChooser.setDateFormatString("yyyy-MM-dd");
        
        JScrollPane scrollPaneAppt = new JScrollPane();
        sl_panel.putConstraint(SpringLayout.NORTH, scrollPaneAppt, 56, SpringLayout.SOUTH, dateChooser);
        sl_panel.putConstraint(SpringLayout.WEST, scrollPaneAppt, 79, SpringLayout.WEST, panel);
        sl_panel.putConstraint(SpringLayout.SOUTH, scrollPaneAppt, 318, SpringLayout.SOUTH, dateChooser);
        sl_panel.putConstraint(SpringLayout.EAST, scrollPaneAppt, 583, SpringLayout.WEST, panel);
        panel.add(scrollPaneAppt);
        
        tableAppt = new JTable();
        scrollPaneAppt.setColumnHeaderView(tableAppt);
        scrollPaneAppt.setViewportView(tableAppt);
       
        
        btnGetAppointments.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent arg0) {
        		
        		try {					
        			
    				String[] ApptColumnsName = {"Patient Name","Appointment Date","Appointment Time"}; 
    				DefaultTableModel apptModel = (DefaultTableModel) tableAppt.getModel();    				
    				String showdate = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();					
					apptModel.setColumnIdentifiers(ApptColumnsName);
    				java.sql.Connection conn = null;
    				conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/hms_db", "root", "" );
    				java.sql.Statement apptCreateStmt=conn.createStatement();        	        
        	        ResultSet apptResultSet=apptCreateStmt.executeQuery("select p.name,pa.appdate,pa.apptime from appointment pa "
        	        		+ "join patient p on pa.pid = p.pid join doctor d on d.doctorid = pa.doctorid "
        	        		+ "join login l on l.userid = d.userid "
        	        		+ "where d.doctorid IN (select d.doctorid from doctor where d.userid ="+userid+") "
        	        				+ "AND pa.appdate ="+ "'"+showdate+"'");  
        	        java.sql.ResultSetMetaData rsmd = apptResultSet.getMetaData();
        	        int colNo = rsmd.getColumnCount();
        	        if (apptModel.getRowCount() > 0) {
        	            for (int i = apptModel.getRowCount() - 1; i > -1; i--) {
        	            	apptModel.removeRow(i);
        	            }
        	        }
        	        while(apptResultSet.next()){
        	         Object[] objects = new Object[colNo];
        	         
        	         for(int i=0;i<colNo;i++){
        	          objects[i]=apptResultSet.getObject(i+1);
        	          }
        	         apptModel.addRow(objects);
        	        }
        	        tableAppt.setModel(apptModel);
        		}
        		catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			} 
        			
        		 }
        });
        
        btnSearch.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			
    		try {
    			String ptid=txtFldPtId.getText();
    			if(ptid.equals("")||ptid.equals(null)) {
    				JFrame frame = new JFrame();
	        		 JOptionPane.showMessageDialog(frame, "Enter Patient ID!");
        		}
    			else {
    			String[] tableColumnsName = {"Date of Visit","Diagnosis"}; 
				DefaultTableModel aModel = (DefaultTableModel) tablePtHistory.getModel();
				aModel.setColumnIdentifiers(tableColumnsName);
    			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/hms_db", "root", "" );
    			java.sql.Statement ptCreateStmt=conn.createStatement();
    	        ResultSet ptResultSet=ptCreateStmt.executeQuery("select * from patient where pid="+ptid);    	        
    	        if (ptResultSet.next() == false) { 
    	        	JFrame frame = new JFrame();
	        		 JOptionPane.showMessageDialog(frame, "Patient ID Does Not Exist");
    	        	} else { 
    	        		do { 
    	        			label.setText(ptResultSet.getString("name"));
    	    	        	label_1.setText(ptResultSet.getString("age"));
    	    	        	label_2.setText(ptResultSet.getString("gender"));
    	    	        	label_3.setText(ptResultSet.getString("bloodgroup"));
    	    	        	label_4.setText(ptResultSet.getString("ailment"));
    	        		} 
    	        		while (ptResultSet.next()); 
    	        		}
    	   
    			java.sql.Statement ptHistoryCreateStmt=conn.createStatement();
    	        ResultSet ptHistoryResultSet=ptHistoryCreateStmt.executeQuery("select dateofvisit,history from patienthistory where pid="+ptid+" ORDER BY phistoryid DESC");
    	        java.sql.ResultSetMetaData rsmd = ptHistoryResultSet.getMetaData();
    	        int colNo = rsmd.getColumnCount();
    	        if (aModel.getRowCount() > 0) {
    	            for (int i = aModel.getRowCount() - 1; i > -1; i--) {
    	            	aModel.removeRow(i);
    	            }
    	        }
    	        while(ptHistoryResultSet.next()){
    	         Object[] objects = new Object[colNo];    	         
    	         for(int i=0;i<colNo;i++){
    	          objects[i]=ptHistoryResultSet.getObject(i+1);
    	          }
    	         aModel.addRow(objects);
    	        }
    	        tablePtHistory.setModel(aModel);
    			}
    	        frame.dispose();
    		} 
    		catch (SQLException e) {
    			
    			e.printStackTrace();
    		}
    	}
    });
        
        tablePtHistory.addMouseListener(new MouseAdapter() {
        	
        	public void mouseClicked(MouseEvent e) {
        		try {
        		if(e.getClickCount()==1) {        		
        		    DefaultTableModel model = (DefaultTableModel)tablePtHistory.getModel();
        		   	JTable target = (JTable) e.getSource();
        			int row = target.getSelectedRow();
        			String dov = model.getValueAt(row, 0).toString();
        			String history = model.getValueAt(row, 1).toString();
        			history_window hw = new history_window(dov,history);
        			hw.setSize(500, 400);
        			hw.setVisible(true);
        			hw.setLocationRelativeTo(null);
        		    			
        		}
        		}
        		catch(Exception ex) {
        			ex.printStackTrace();
        		}
        		}
        }); 
    }
    
    public static void main(String[] args) {
         int userid=0;
         update_doctor_info doctorMod = new update_doctor_info(userid);        
         frame.setBounds(100, 100, 685, 522);
         doctorMod.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         doctorMod.setVisible(true);
         
    }
}

