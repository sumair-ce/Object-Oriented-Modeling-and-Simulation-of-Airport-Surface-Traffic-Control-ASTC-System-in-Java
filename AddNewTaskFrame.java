package airportSimulation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AddNewTaskFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textprilbl;
	private JTextField textseclbl;
	private JTextField textprioritylbl;
	private JTextField textsupplbl;

	/**
	 * Launch the application.
	 */
	public static void displayAddNewTaskFrame(AddNewTaskFrame frame) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewTaskFrame frame = new AddNewTaskFrame();
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
	public AddNewTaskFrame() {
		setTitle("Add New Task");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 228);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Primary Label:");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 37, 171, 20);
		contentPane.add(lblNewLabel);
		
		textprilbl = new JTextField();
		textprilbl.setBounds(209, 39, 215, 20);
		contentPane.add(textprilbl);
		textprilbl.setColumns(10);
		
		JLabel lblEnterSecondaryLabel = new JLabel("Enter Secondary Label:");
		lblEnterSecondaryLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblEnterSecondaryLabel.setBounds(10, 64, 189, 20);
		contentPane.add(lblEnterSecondaryLabel);
		
		textseclbl = new JTextField();
		textseclbl.setColumns(10);
		textseclbl.setBounds(209, 66, 215, 20);
		contentPane.add(textseclbl);
		
		JLabel lblEnterPriorityhhmmss = new JLabel("Enter Priority (hhmmss):");
		lblEnterPriorityhhmmss.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblEnterPriorityhhmmss.setBounds(10, 90, 189, 20);
		contentPane.add(lblEnterPriorityhhmmss);
		
		textprioritylbl = new JTextField();
		textprioritylbl.setColumns(10);
		textprioritylbl.setBounds(209, 92, 215, 20);
		contentPane.add(textprioritylbl);
		
		JLabel lblsupplbl = new JLabel("Enter Supp Data:");
		lblsupplbl.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblsupplbl.setBounds(10, 118, 189, 20);
		contentPane.add(lblsupplbl);
		
		textsupplbl = new JTextField();
		textsupplbl.setColumns(10);
		textsupplbl.setBounds(209, 120, 215, 20);
		contentPane.add(textsupplbl);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pri_lbl=textprilbl.getText();
				String sec_lbl=textseclbl.getText();
				String priority_lbl=textprioritylbl.getText();
				String supp_lbl=textsupplbl.getText();
				TaskEngine.addNewTask(pri_lbl,sec_lbl,priority_lbl,supp_lbl);
			}
		});
		
		btnOk.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		btnOk.setBounds(209, 159, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textprilbl.setText("");
				textseclbl.setText("");
				textprioritylbl.setText("");
				textsupplbl.setText("");
				AirportFrame.closeframe();
				
			}
		});
		
		btnCancel.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		btnCancel.setBounds(110, 161, 89, 23);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel_1 = new JLabel("Add New Task");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBackground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblNewLabel_1.setBounds(162, 11, 120, 14);
		contentPane.add(lblNewLabel_1);
	}
}
