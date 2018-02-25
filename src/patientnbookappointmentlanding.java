import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class patientnbookappointmentlanding extends JFrame {
	private JFrame frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					patientnbookappointmentlanding frame = new patientnbookappointmentlanding();
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
	public patientnbookappointmentlanding() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPatientRegistration = new JButton("Patient Registration");
		btnPatientRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				patientreg hm = new patientreg();
				hm.setVisible(true);
				frame.dispose();
			
			}
		});
		btnPatientRegistration.setBounds(159, 75, 131, 23);
		contentPane.add(btnPatientRegistration);
		
		JButton btnBookAppointment = new JButton("Book Appointment");
		btnBookAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				landingbook lb = new landingbook();
				lb.setVisible(true);
				frame.dispose();

			}
		});
		btnBookAppointment.setBounds(159, 125, 131, 23);
		contentPane.add(btnBookAppointment);
	}

}
