package version01;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Set_Schedule extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Set_Schedule frame = new Set_Schedule();
					frame.setVisible(true);
					frame.setTitle("Aladdin V3.0");
					
					ImageIcon img = new ImageIcon("E:\\8th semester\\SDP 3\\aladdin-logo.jpg");
					frame.setIconImage(img.getImage());
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Set_Schedule() {
		setBackground(new Color(0, 206, 209));
		setResizable(false);
		setTitle("Aladdin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		getContentPane().setLayout(null);
		panel.setForeground(new Color(0, 204, 255));
		panel.setBackground(new Color(0, 206, 209));
		panel.setBounds(0, 0, 394, 471);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Aladdin");
		lblNewLabel.setBounds(10, 5, 374, 50);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Castellar", Font.BOLD, 35));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Set Date");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Castellar", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 65, 100, 30);
		panel.add(lblNewLabel_1);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home_page frame = new Home_page();
				frame.setVisible(true);
				frame.setTitle("Aladdin V3.0");
				ImageIcon img = new ImageIcon("E:\\8th semester\\SDP 3\\aladdin-logo.jpg");
				frame.setIconImage(img.getImage());
				dispose();
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBorder(null);
		btnCancel.setFont(new Font("Castellar", Font.BOLD, 15));
		btnCancel.setBackground(Color.RED);
		btnCancel.setBounds(135, 410, 108, 30);
		panel.add(btnCancel);
		
		JButton btnSet = new JButton("Set");
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Not Developed yet !");
			}
		});
		btnSet.setForeground(Color.WHITE);
		btnSet.setFont(new Font("Castellar", Font.BOLD, 15));
		btnSet.setBorder(null);
		btnSet.setBackground(new Color(51, 102, 255));
		btnSet.setBounds(262, 410, 108, 30);
		panel.add(btnSet);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Castellar", Font.BOLD, 15));
		btnReset.setBorder(null);
		btnReset.setBackground(new Color(51, 102, 255));
		btnReset.setBounds(10, 410, 108, 30);
		panel.add(btnReset);
		
		JLabel lblNewLabel_2 = new JLabel("Not developed yet !");
		lblNewLabel_2.setFont(new Font("Castellar", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 134, 360, 64);
		panel.add(lblNewLabel_2);
	}
}
