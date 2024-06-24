package airportSimulation;
import javax.swing.Timer;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class AirportFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textclock;
	private JTextField textCategory;
	private JTextField texttask;
	private JTextField texttime;
	private JLabel lblNewLabel_1;
	static ShortestPathFrame pathframe = new ShortestPathFrame();
	static AddNewTaskFrame newtaskframe = new AddNewTaskFrame();

	/**
	 * Launch the application.
	 */
	
	public static void displayframe(AirportFrame frame) {
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

	/**
	 * Create the frame.
	 */
	public AirportFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textclock = new JTextField();
		textclock.setForeground(SystemColor.text);
		textclock.setBackground(SystemColor.textText);
		textclock.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textclock.setHorizontalAlignment(SwingConstants.CENTER);
		textclock.setBounds(273, 36, 78, 20);
		contentPane.add(textclock);
		textclock.setColumns(10);
		
		JButton btndisplaytasks = new JButton("Yes");
		btndisplaytasks.setForeground(Color.BLACK);
		btndisplaytasks.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btndisplaytasks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteAnyTask frame = new deleteAnyTask();
				frame.setVisible(true);
			}
		});
		btndisplaytasks.setBounds(465, 221, 63, 23);
		contentPane.add(btndisplaytasks);
		
		textCategory = new JTextField();
		textCategory.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		textCategory.setBounds(142, 90, 386, 20);
		contentPane.add(textCategory);
		textCategory.setColumns(10);
		
		texttask = new JTextField();
		texttask.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		texttask.setColumns(10);
		texttask.setBounds(142, 121, 386, 20);
		contentPane.add(texttask);
		
		texttime = new JTextField();
		texttime.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		texttime.setColumns(10);
		texttime.setBounds(142, 152, 386, 20);
		contentPane.add(texttime);
		
		JLabel lblNewLabel = new JLabel("Category:");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 92, 78, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblTask = new JLabel("Task:");
		lblTask.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblTask.setBounds(10, 117, 53, 24);
		contentPane.add(lblTask);
		
		JLabel lblTime = new JLabel("Dispatch Time:");
		lblTime.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblTime.setBounds(10, 143, 120, 35);
		contentPane.add(lblTime);
		
		lblNewLabel_1 = new JLabel("Task to be done:");
		lblNewLabel_1.setForeground(Color.MAGENTA);
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(10, 60, 138, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Previous Task Info:");
		lblNewLabel_3.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblNewLabel_3.setBounds(10, 289, 172, 20);
		contentPane.add(lblNewLabel_3);
		
		lblPressToDisplay = new JLabel("Do you want to delete any tasks?");
		lblPressToDisplay.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblPressToDisplay.setBounds(10, 222, 282, 19);
		contentPane.add(lblPressToDisplay);
		
		JLabel lblDoYouWant = new JLabel("Do you want to add new task?");
		lblDoYouWant.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblDoYouWant.setBounds(10, 189, 341, 19);
		contentPane.add(lblDoYouWant);
		
		
		JButton btndisplaytasks_1 = new JButton("Yes");
		btndisplaytasks_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        newtaskframe.displayAddNewTaskFrame(newtaskframe);
		    }
		});
		
		btndisplaytasks_1.setForeground(Color.BLACK);
		btndisplaytasks_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btndisplaytasks_1.setBounds(465, 186, 63, 23);
		contentPane.add(btndisplaytasks_1);
		
		textinfo = new JTextField();
		textinfo.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		textinfo.setBounds(10, 317, 518, 20);
		contentPane.add(textinfo);
		textinfo.setColumns(10);
		
		JLabel lblpath = new JLabel("Do you want to find Shortest Path?");
		lblpath.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblpath.setBounds(10, 258, 282, 20);
		contentPane.add(lblpath);
		
		
		JButton btnpath = new JButton("Yes");
		btnpath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pathframe.displaypathframe(pathframe);
			}
		});
		
		btnpath.setForeground(Color.BLACK);
		btnpath.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnpath.setBounds(465, 255, 63, 23);
		contentPane.add(btnpath);
		
		JLabel lblNewLabel_2 = new JLabel("Main Task Menu");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblNewLabel_2.setBounds(189, 11, 137, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblclockk = new JLabel("Global Clock:");
		lblclockk.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblclockk.setBounds(160, 39, 120, 14);
		contentPane.add(lblclockk);
		
		globalclock clock=new globalclock();
		
		
		Timer timer = new Timer(1000, new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		            textclock.setText(clock.showtime());
		        }
		    });
		    timer.start();  // Start the timer
		
		
	}
	int p=0;
	private JLabel lblPressToDisplay;
	private JTextField textinfo;
	public void nexttask(String a, String b, int c)
	{
		
		textCategory.setText(a);
		texttask.setText(b);
		texttime.setText(Integer.toString(c));
	}
//	public void updatestatus()
//	{
//		lblstatus.setText(p+1 + " task Completed");
//		p++;
//	}
	public void additionalInfo(String z)
	{
		textinfo.setText(z);
	}

	public static void closePathFinderFrame() {
		pathframe.setVisible(false);
		
	}
	public static void closeframe()
	{
		newtaskframe.setVisible(false);
	}
}
