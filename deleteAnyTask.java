package airportSimulation;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class deleteAnyTask extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textindex;
	JLabel lblmessage;

	/**
	 * Launch the application.
	 */
	
	public static void displyftn(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteAnyTask frame = new deleteAnyTask();
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
	public deleteAnyTask() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 213);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete Task Menu");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblNewLabel.setBounds(146, 11, 144, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Index number to delete task:");
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 61, 280, 14);
		contentPane.add(lblNewLabel_1);
		
		textindex = new JTextField();
		textindex.setBounds(290, 60, 134, 20);
		contentPane.add(textindex);
		textindex.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= Integer.parseInt(textindex.getText());
				System.out.println(index);
				if (index<=TaskEngine.mytasklist.size())
				{
					TaskEngine.mytasklist.remove(2);
					lblmessage.setText("Task has been Deleted Successfully");
					lblmessage.setForeground(Color.GREEN);
				}
				else
				{
					lblmessage.setText("Cannot Delete Task, Please Enter valid Index");
					lblmessage.setForeground(Color.RED);
				}
				
			}
		});
		btnEnter.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		btnEnter.setBounds(224, 95, 89, 23);
		contentPane.add(btnEnter);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		btnCancel.setBounds(121, 95, 89, 23);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Message:");
		lblNewLabel_1_1.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(10, 133, 89, 21);
		contentPane.add(lblNewLabel_1_1);
		
		lblmessage = new JLabel("Message Come here");
		lblmessage.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblmessage.setBounds(95, 133, 329, 21);
		contentPane.add(lblmessage);
	}
}
