package airportSimulation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ShortestPathFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textdisplaydistance;

	/**
	 * Launch the application.
	 */
	public static void displaypathframe(ShortestPathFrame frame) {
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
	public ShortestPathFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 231);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select the Starting City:");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 42, 179, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblSelectTheDestination = new JLabel("Select the Destination City:");
		lblSelectTheDestination.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblSelectTheDestination.setBounds(10, 72, 232, 23);
		contentPane.add(lblSelectTheDestination);
		
		JComboBox cityList = new JComboBox();
		cityList.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cityList.setBounds(282, 44, 142, 22);
		contentPane.add(cityList);
		
		cityList.addItem("Select");
		cityList.addItem("New York");
		cityList.addItem("Chicago");
		cityList.addItem("Houston");
		cityList.addItem("New Jersey");
		cityList.addItem("Los Angeles");
		cityList.addItem("Miami");
		cityList.addItem("San Francisco");
		cityList.addItem("Denver");
		cityList.setSelectedItem("Select");
		
		JComboBox cityList2 = new JComboBox();
		cityList2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cityList2.setBounds(282, 74, 142, 22);
		contentPane.add(cityList2);
		cityList2.addItem("Select");
		cityList2.addItem("New York");
		cityList2.addItem("Chicago");
		cityList2.addItem("Houston");
		cityList2.addItem("New Jersey");
		cityList2.addItem("Los Angeles");
		cityList2.addItem("Miami");
		cityList2.addItem("San Francisco");
		cityList2.addItem("Denver");
		
		cityList2.setSelectedItem("Select");
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String start=(String) cityList.getSelectedItem();
				String end=(String) cityList2.getSelectedItem();
				int shortest_path=shortestPathFinder.callDijkstra(start, end);
				textdisplaydistance.setText(Integer.toString(shortest_path));
			}
		});
		btnFind.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		btnFind.setBounds(228, 119, 89, 23);
		contentPane.add(btnFind);
		
		textdisplaydistance = new JTextField();
		textdisplaydistance.setBounds(323, 158, 101, 20);
		contentPane.add(textdisplaydistance);
		textdisplaydistance.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textdisplaydistance.setText("");
				AirportFrame.closePathFinderFrame();
			}
		});
		btnCancel.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		btnCancel.setBounds(129, 121, 89, 23);
		contentPane.add(btnCancel);
		
		JLabel lblShortestPathBetween = new JLabel("Shortest Path between these Cities is:");
		lblShortestPathBetween.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblShortestPathBetween.setBounds(10, 155, 337, 23);
		contentPane.add(lblShortestPathBetween);
		
		JLabel lblNewLabel_1 = new JLabel("Shortest Path Finder");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblNewLabel_1.setBounds(145, 11, 179, 14);
		contentPane.add(lblNewLabel_1);
		
	}
}
