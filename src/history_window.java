import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class history_window extends JFrame {

	private JPanel contentPane;
	
	public history_window(String dateofvisit,String history) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblDateOfVisit = new JLabel("Date of Visit:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDateOfVisit, 65, SpringLayout.WEST, contentPane);
		contentPane.add(lblDateOfVisit);
		
		JLabel lblDovLabel = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblDovLabel, 32, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDovLabel, 161, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblDateOfVisit, 0, SpringLayout.SOUTH, lblDovLabel);
		contentPane.add(lblDovLabel);
		
		JTextArea textAreaHistory = new JTextArea();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textAreaHistory, 18, SpringLayout.SOUTH, lblDateOfVisit);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textAreaHistory, -36, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textAreaHistory, -65, SpringLayout.EAST, contentPane);
		textAreaHistory.setEditable(false);
		textAreaHistory.setLineWrap(true);
		sl_contentPane.putConstraint(SpringLayout.WEST, textAreaHistory, 65, SpringLayout.WEST, contentPane);
		contentPane.add(textAreaHistory);
		
		lblDovLabel.setText(dateofvisit);
		textAreaHistory.setText(history);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
}
