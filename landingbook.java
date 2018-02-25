import static java.awt.BorderLayout.NORTH;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;
import javax.swing.border.EtchedBorder;
import java.util.Date.*;
import java.util.Calendar;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.lang.Throwable.*;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.DateModel;
import java.util.Properties;
import org.jdatepicker.impl.JDatePickerImpl;
import javax.swing.JFormattedTextField.AbstractFormatter;
import com.toedter.calendar.JDateChooser;

//import group8.appointmentbook.ui.ScheduleForm;

import com.toedter.calendar.JCalendar;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextPane;
//import net.proteanit.sql.DbUtils;

public class landingbook extends JFrame {
	 //changes
	private JPanel contentPane;
	private JTextField patidfield;
	private JTextField doctoridfield;
	private JTextField timefield;
	private JDateChooser dateChooser;
	//private JTable table;
	//JScrollPane showdocPane;
	//JTextArea showdocArea;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					landingbook frame = new landingbook();
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
	
	Connection connection =null; 
	
	
	public landingbook() {
		
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost/hms_db?autoReconnect=true&useSSL=false", "root", "");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea showappsArea = new JTextArea();
		showappsArea.setBackground(new Color(255, 255, 240));
		showappsArea.setBounds(5, 5, 403, 515);
		showappsArea.setEditable(false);
		contentPane.add(showappsArea);
		 //changes
		JLabel lblNewLabel = new JLabel("PatientID");
		lblNewLabel.setBounds(437, 27, 79, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Appointment");
		lblNewLabel_2.setBounds(437, 205, 107, 20);
		contentPane.add(lblNewLabel_2);
		 //changes
		JLabel lblNewLabel_3 = new JLabel("Doctor ID");
		lblNewLabel_3.setBounds(437, 241, 69, 20);
		contentPane.add(lblNewLabel_3);
		 //changes
		patidfield = new JTextField();
		patidfield.setBounds(559, 24, 146, 26);
		contentPane.add(patidfield);
		patidfield.setColumns(10);
		 //changes
		doctoridfield = new JTextField();
		doctoridfield.setBounds(559, 238, 146, 26);
		contentPane.add(doctoridfield);
		doctoridfield.setColumns(10);
		
		dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(559, 199, 99, 26);
		contentPane.add(dateChooser);
		
		JButton BookButton = new JButton("Book");
		BookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
                {   
					if(patidfield.getText().equals("")
							||doctoridfield.getText().equals("")
							||timefield.getText().equals("")
							){
                	
						java.awt.Toolkit.getDefaultToolkit().beep();
						JOptionPane.showMessageDialog(landingbook.this,
								"You must enter the Patient ID, date, time \n "
										+ "and doctor ID.",
								"Invalid Data", JOptionPane.ERROR_MESSAGE);
					} else {
                	
                    String query="insert into appointment(pid,doctorid,appdate,apptime)" + "values(?,?,?,?)";
                    
                    java.sql.PreparedStatement pst = connection.prepareStatement(query);
                    
                    pst.setString(1, patidfield.getText());
                    pst.setString(2, doctoridfield.getText());
                    pst.setString(3, ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
				    pst.setString(4, timefield.getText());
				   
				 
				    pst.executeUpdate();
                    
                    JOptionPane.showMessageDialog(null, "Data Saved successfully");
                    
                    patidfield.setText(null);
                    //dateChooser.setText(null);
					doctoridfield.setText(null);
					timefield.setText(null);
							
					
                    pst.close();
                  
                	}
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
				
 		}
		});
		BookButton.setBounds(437, 301, 115, 29);
		contentPane.add(BookButton);
		
		JButton ShowButton = new JButton("Show Appointments");
		ShowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		ShowButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					showappsArea.setText(showAppointments());
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
		
		ShowButton.setBounds(437, 344, 202, 29);
		contentPane.add(ShowButton);
		
		JButton CancelButton = new JButton("Cancel");
		CancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
                {       
					if(doctoridfield.getText().equals("")
							||timefield.getText().equals("")){
                	
						java.awt.Toolkit.getDefaultToolkit().beep();
						JOptionPane.showMessageDialog(landingbook.this,
								"You must enter the time \n "
										+ "and doctor ID.",
								"Invalid Data", JOptionPane.ERROR_MESSAGE);
					} else {
					String showdate = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
					String showtime = timefield.getText();
					String showdoc = doctoridfield.getText();
					
                    String query="delete from appointment where (appdate="+ "'"+showdate+"'"+
					" AND apptime="+ "'"+showtime + "'" + " AND doctorid="+ "'"+showdoc+"')" ;
                    
                    java.sql.PreparedStatement pst = connection.prepareStatement(query);
                    
                    pst.executeUpdate();
                    
                    JOptionPane.showMessageDialog(null, "Data Deleted successfully");
                    
                 	//dateField.setText(null);
					doctoridfield.setText(null);
					timefield.setText(null);
							
					
                    pst.close();
					}
                    
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
				
 		}
		});
		CancelButton.setBounds(590, 301, 115, 29);
		contentPane.add(CancelButton);
		
		timefield = new JTextField();
		timefield.setBounds(684, 199, 114, 26);
		contentPane.add(timefield);
		timefield.setColumns(10);
		
		
		
			
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(559, 175, 69, 20);
		contentPane.add(lblDate);
		
		JLabel lblTime = new JLabel("Time(HH:MM:SS)");
		lblTime.setBounds(674, 175, 124, 20);
		contentPane.add(lblTime);
		
		//table = new JTable();
		//showdocPane.setViewportView(table);
		JTextArea showdocArea = new JTextArea();
		showdocArea.setEditable(false);
		showdocArea.setBounds(437, 389, 361, 117);
		contentPane.add(showdocArea);
		
		JButton btnNewDoctor = new JButton("Show Doctors");
		btnNewDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewDoctor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					
					String sdoc="";
						
					 String query2 ="select doctorid, doctorname, availability from doctor";
	                    
	                    java.sql.PreparedStatement pst = connection.prepareStatement(query2);
	                    
	                    ResultSet rs = pst.executeQuery();
	                    
	                    while(rs.next()) {
	                    	
	                    	sdoc+= rs.getString("doctorid") + " ";
	                    	sdoc+= rs.getString("availability") + " ";
	                    	sdoc+= rs.getString("doctorname") + " \n\n";
	                    	
	                    }
										
	                    showdocArea.setText(sdoc);
	                   
	                   
					}
					catch(Exception e1){
						e1.printStackTrace();
					}
			
			
			}
		});
		
		btnNewDoctor.setBounds(659, 344, 139, 29);
		contentPane.add(btnNewDoctor);
		
	/*	JScrollPane showdocPane = new JScrollPane();
		showdocPane.setViewportView(table);
		showdocPane.setBounds(776, 501, -330, -93);
		contentPane.add(showdocPane);
		*/
		
		
		JTextArea showpatArea = new JTextArea();
		showpatArea.setEditable(false);
		showpatArea.setBounds(436, 63, 362, 71);
		contentPane.add(showpatArea);
		
		JButton btnShowPatient = new JButton("Show Patient");
		btnShowPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnShowPatient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				try {
					if(patidfield.getText().equals("")){
                	
						java.awt.Toolkit.getDefaultToolkit().beep();
						JOptionPane.showMessageDialog(landingbook.this,
								"You must enter the Patient ID",
								"Invalid Data", JOptionPane.ERROR_MESSAGE);
					} else {
		
				String spatient="";
					
				 String query2 ="select name, age, phoneno from patient where pid= "+ patidfield.getText();
                    
                    java.sql.PreparedStatement pst = connection.prepareStatement(query2);
                    
                    ResultSet rs = pst.executeQuery();
                    
                    while(rs.next()) {
                    	
                    	spatient+= rs.getString("name") + " ";
                    	spatient+= rs.getString("age") + " "; 
                    	spatient+= rs.getString("phoneno") + " \n\n";
                    	
                    }
                   
                    showpatArea.setText(spatient);	
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
		
		
			}
		});
		btnShowPatient.setBounds(437, 135, 146, 29);
		contentPane.add(btnShowPatient);
		
		
		
		
		
	}
	
	String showAppointments() throws Exception{
		
		String formattedApps;
		formattedApps = "SCHEDULED APPOINTMENTS FOR DAY: " + 
		((JTextField)dateChooser.getDateEditor().getUiComponent()).getText() + "\n\n\n";

			 	
						try {
							
							String showdate = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
							
						 String query2 ="select pid, doctorid, apptime from appointment where appdate=" + "'" + showdate+"'" ;
		                    
		                    java.sql.PreparedStatement pst = connection.prepareStatement(query2);
		                    
		                    ResultSet rs = pst.executeQuery();
		                    
		                    while(rs.next()) {
		                    	
		                    	formattedApps+= rs.getString("pid") + " ";
		                    	formattedApps+= rs.getString("doctorid") + " "; 
		                    	formattedApps+= rs.getString("apptime") + " \n\n";
		                    	
		                    }
		                    
						}
						catch(Exception e){
							e.printStackTrace();
						}
				
						
				return formattedApps;
	}// End Show appointments
}

