import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class inma extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JFrame frame_inventory;
	private JButton btnInsert;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnRetrieve;
	private JButton btnCheck;
	private JButton btnExit;
	private JButton btnReset;
	private JTable table;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inma frame = new inma();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection =null;
	private JScrollPane scrollPane;
	/**
	 * Create the frame.
	 * 
	 */
	public inma() {
		try {
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost/hms_db", "root", "");
				} catch (SQLException e) {
			
			e.printStackTrace();
		}
		initialize();
	}
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 856, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblResourcename = new JLabel("Name");
		lblResourcename.setBounds(10, 11, 63, 14);
		contentPane.add(lblResourcename);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(10, 36, 63, 14);
		contentPane.add(lblQuantity);
		
		JLabel lblThreshold = new JLabel("Threshold");
		lblThreshold.setBounds(10, 61, 63, 14);
		contentPane.add(lblThreshold);
		
		textField = new JTextField();
		textField.setBounds(65, 8, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(65, 33, 96, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(65, 58, 96, 20);
		contentPane.add(textField_2);
		
		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					String query="insert into inventory(rname,rquantity,threshold)" + "values(?,?,?)";
				
                
                java.sql.PreparedStatement pst = connection.prepareStatement(query);
                
                pst.setString(1, textField.getText());
                pst.setString(2, textField_1.getText());
                pst.setString(3, textField_2.getText());
          
			
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
		btnInsert.setBounds(43, 459, 89, 23);
		contentPane.add(btnInsert);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					 String query = "delete from inventory where rname='"+textField.getText()+"'";
					java.sql.PreparedStatement pst = connection.prepareStatement(query );
                    pst.execute();                    
                   JOptionPane.showMessageDialog(null, "Data deleted successfully");
                   
                   pst.close();

				} 
				catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(207, 459, 89, 23);
		contentPane.add(btnDelete);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
					Updating_Prescription uppr = new Updating_Prescription();
					uppr.setVisible(true);
			}
		});
		btnUpdate.setBounds(371, 459, 89, 23);
		contentPane.add(btnUpdate);
		
		btnRetrieve = new JButton("Retrieve");
		btnRetrieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "select * from inventory";
					java.sql.PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					//table.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			}
		});
		btnRetrieve.setBounds(549, 459, 89, 23);
		contentPane.add(btnRetrieve);
		
		btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					 String query = "select * from inventory where rquantity <= threshold";
					java.sql.PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery(query);
					//table.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();

				} 
				catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		});
		btnCheck.setBounds(697, 459, 89, 23);
		contentPane.add(btnCheck);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(286, 501, 89, 23);
		contentPane.add(btnExit);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
			}
		});
		btnReset.setBounds(462, 501, 89, 23);
		contentPane.add(btnReset);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(207, 11, 583, 433);
		contentPane.add(scrollPane);
		
			
		table = new JTable();
		scrollPane.setViewportView(table);		
	
	}
}
