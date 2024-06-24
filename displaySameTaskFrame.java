package airportSimulation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.Timer;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class displaySameTaskFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textcategory;
	private JTextField texttask;
	private JTextField texttime;
	private JTextField textinfo;
	private JTextField textclock;

	/**
	 * Launch the application.
	 */
	
	public static void sametaskframe(displaySameTaskFrame frame) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void nexttask(String a, String b, int c)
	{
		
		textcategory.setText(a);
		texttask.setText(b);
		texttime.setText(Integer.toString(c));
	}
	public void additionalInfo(String z)
	{
		textinfo.setText(z);
	}
	
	
	
	/**
	 * Create the frame.
	 */
	public displaySameTaskFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tasks with Same Priority");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblNewLabel.setBounds(122, 11, 199, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Category:");
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 97, 95, 21);
		contentPane.add(lblNewLabel_1);
		
		textcategory = new JTextField();
		textcategory.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		textcategory.setBounds(167, 99, 257, 20);
		contentPane.add(textcategory);
		textcategory.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Task:");
		lblNewLabel_1_1.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(10, 125, 95, 21);
		contentPane.add(lblNewLabel_1_1);
		
		texttask = new JTextField();
		texttask.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		texttask.setColumns(10);
		texttask.setBounds(167, 127, 257, 20);
		contentPane.add(texttask);
		
		JLabel lblNewLabel_1_2 = new JLabel("Dispatch Time:");
		lblNewLabel_1_2.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(10, 157, 132, 21);
		contentPane.add(lblNewLabel_1_2);
		
		texttime = new JTextField();
		texttime.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		texttime.setColumns(10);
		texttime.setBounds(167, 159, 257, 20);
		contentPane.add(texttime);
		
		JLabel lblTask = new JLabel("Task to be done:");
		lblTask.setForeground(Color.MAGENTA);
		lblTask.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblTask.setBounds(10, 71, 199, 21);
		contentPane.add(lblTask);
		
		JLabel lblNewLabel_2 = new JLabel("Previous Task Info:");
		lblNewLabel_2.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblNewLabel_2.setBounds(10, 189, 186, 14);
		contentPane.add(lblNewLabel_2);
		
		textinfo = new JTextField();
		textinfo.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		textinfo.setBounds(10, 214, 414, 20);
		contentPane.add(textinfo);
		textinfo.setColumns(10);
		
		JLabel lblclockk = new JLabel("Global Clock:");
		lblclockk.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblclockk.setBounds(122, 46, 120, 14);
		contentPane.add(lblclockk);
		
		textclock = new JTextField();
		textclock.setHorizontalAlignment(SwingConstants.CENTER);
		textclock.setForeground(SystemColor.text);
		textclock.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textclock.setColumns(10);
		textclock.setBackground(SystemColor.textText);
		textclock.setBounds(235, 43, 78, 20);
		contentPane.add(textclock);
		
		
		globalclock clock=new globalclock();
		
		
		Timer timer = new Timer(1000, new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		            textclock.setText(clock.showtime());
		        }
		    });
		    timer.start();  // Start the timer
		
	}
	
}
