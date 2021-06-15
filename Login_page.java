package version01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

import javax.swing.DropMode;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class Login_page extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_page frame = new Login_page();
					frame.setVisible(true);
					frame.setTitle("Aladdin V3.0");
					ImageIcon img = new ImageIcon("E:\\8th semester\\SDP 3\\aladdin-logo.jpg");
					frame.setIconImage(img.getImage());
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public Login_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setContentPane(contentPane);
		
		JLabel lblAllRightReserved = new JLabel("All Right Reserved 2020 ( BUBT Project CSE 300 )");
		lblAllRightReserved.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllRightReserved.setForeground(new Color(0, 0, 0));
		lblAllRightReserved.setFont(new Font("Castellar", Font.BOLD, 10));
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(0, 206, 209));
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Castellar", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		username = new JTextField();
		username.setHorizontalAlignment(SwingConstants.LEFT);
		username.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				username.setBackground(new Color(0, 191, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				username.setBackground(new Color(255, 255, 255));
			}
		});
		username.setBorder(null);
		username.setDropMode(DropMode.INSERT);
		username.setFont(new Font("Calisto MT", Font.PLAIN, 20));
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setHorizontalAlignment(SwingConstants.LEFT);
		password.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				password.setBackground(new Color(0, 191, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				password.setBackground(new Color(255, 255, 255));
			}
		});
		password.setEchoChar('*');
		password.setDropMode(DropMode.INSERT);
		password.setBorder(null);
		password.setFont(new Font("Calisto MT", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBorder(null);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new Color(0, 191, 255));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(new Color(21, 158, 23 ));
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				int i=0;
				try {
					if(username.getText().isEmpty() || password.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "can not be empty.");
					}
					String email = username.getText();
					String pass = password.getText();
					
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_assistant","root","");  
					
					Statement stmt=con.createStatement();  
					ResultSet rs=stmt.executeQuery("SELECT * FROM `login` WHERE 1");  
					while(rs.next())
						if(email.equals(rs.getString(1)) && pass.equals(rs.getString(2))) {
							JOptionPane.showMessageDialog(null, "Login Successfull");
							
							Home_page frame = new Home_page();
							frame.setVisible(true);
							frame.setTitle("Aladdin V3.0");
							
							ImageIcon img = new ImageIcon("E:\\8th semester\\SDP 3\\aladdin-logo.jpg");
							frame.setIconImage(img.getImage());
							i+=1;
							dispose();
						}
					con.close();
					if(i==0) {
						JOptionPane.showMessageDialog(null, "Email or Password Error.");
					}
				}
				catch(Exception e3){
					JOptionPane.showMessageDialog(null, "Email or Password Error."+e3);
				}  
			}
		});
		btnNewButton.setForeground(new Color(240, 255, 240));
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setFont(new Font("Castellar", Font.BOLD, 20));
		
		JLabel lblNewLabel_2 = new JLabel("Create Account");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Registration frame = new Registration();
				frame.setVisible(true);
				frame.setTitle("Aladdin V3.0");
				ImageIcon img = new ImageIcon("E:\\8th semester\\SDP 3\\aladdin-logo.jpg");
				frame.setIconImage(img.getImage());
				dispose();
			}
		});
		lblNewLabel_2.setBackground(new Color(64, 224, 208));
		lblNewLabel_2.setFont(new Font("Castellar", Font.PLAIN, 17));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Castellar", Font.BOLD, 15));
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Castellar", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGap(93)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(username, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
								.addComponent(password, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
								.addComponent(lblPassword, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
							.addGap(108))
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(username, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
					.addGap(38)
					.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(password, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
					.addGap(39)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
					.addGap(57)
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JLabel lblAladdin = new JLabel("Aladdin");
		lblAladdin.setBackground(new Color(153, 255, 255));
		lblAladdin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAladdin.setForeground(Color.WHITE);
		lblAladdin.setFont(new Font("Castellar", Font.BOLD, 35));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(122)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
					.addGap(122))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAladdin, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
						.addComponent(lblAllRightReserved, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAladdin, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
					.addGap(52)
					.addComponent(lblAllRightReserved, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
