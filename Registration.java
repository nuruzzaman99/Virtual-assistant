package version01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DropMode;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Registration extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtDateOfBirth;
	private JTextField txtEmailAddress;
	private JTextField txtPassword;
	private JTextField txtConfirmPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 807);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Aladdin");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Castellar", Font.BOLD, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel.setBackground(new Color(0, 206, 209));
		
		JLabel label_1 = new JLabel("All Right Reserved 2020 (BUBT Project CSE 300)");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(0, 0, 0));
		label_1.setFont(new Font("Castellar", Font.BOLD, 10));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(138)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
					.addGap(138))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel_1 = new JLabel("Registration");
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtFirstName = new JTextField();
		txtFirstName.setForeground(Color.BLACK);
		txtFirstName.setFont(new Font("Arial", Font.PLAIN, 15));
		txtFirstName.setBorder(null);
		txtFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		txtFirstName.setText("First Name");
		txtFirstName.setBackground(Color.WHITE);
		txtFirstName.setDropMode(DropMode.INSERT);
		txtFirstName.setToolTipText("");
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setForeground(Color.BLACK);
		txtLastName.setToolTipText("");
		txtLastName.setText("Last Name");
		txtLastName.setHorizontalAlignment(SwingConstants.CENTER);
		txtLastName.setFont(new Font("Arial", Font.PLAIN, 15));
		txtLastName.setDropMode(DropMode.INSERT);
		txtLastName.setColumns(10);
		txtLastName.setBorder(null);
		txtLastName.setBackground(Color.WHITE);
		
		txtDateOfBirth = new JTextField();
		txtDateOfBirth.setForeground(Color.BLACK);
		txtDateOfBirth.setToolTipText("");
		txtDateOfBirth.setText("Date Of Birth(DD/MM/YYYY)");
		txtDateOfBirth.setHorizontalAlignment(SwingConstants.CENTER);
		txtDateOfBirth.setFont(new Font("Arial", Font.PLAIN, 15));
		txtDateOfBirth.setDropMode(DropMode.INSERT);
		txtDateOfBirth.setColumns(10);
		txtDateOfBirth.setBorder(null);
		txtDateOfBirth.setBackground(Color.WHITE);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Calisto MT", Font.PLAIN, 15));
		comboBox.setBorder(null);
		comboBox.setBackground(Color.WHITE);
		comboBox.setForeground(Color.BLACK);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Country", "Afghanistan", "Algeria", "Argentina", "Australia", "Bangladesh", "Belgium", "Brazil", "Cambodia", "Canada", 
				"China", "Denmark", "Dominica", "Egypt", "Fiji", "Finland", "Germany", "Honduras", "Iceland", "India", "Indonesia", "Iran", "Italy", "Japan", "Malaysia", "New Zealand", "Oman", 
				"Pakistan", "Romania", "Russia", "South Africa", "Sri Lanka", "United Kingdom", "United States of America", "Yemen", "Zimbabwe"}));
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
			}
		});
		rdbtnMale.setForeground(Color.WHITE);
		rdbtnMale.setBackground(new Color(0, 206, 209));
		rdbtnMale.setBorder(null);
		rdbtnMale.setFont(new Font("Arial", Font.BOLD, 15));
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rdbtnFemale.setForeground(Color.WHITE);
		rdbtnFemale.setFont(new Font("Arial", Font.BOLD, 15));
		rdbtnFemale.setBorder(null);
		rdbtnFemale.setBackground(new Color(0, 206, 209));
		
		JRadioButton rdbtnOther = new JRadioButton("Other");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnMale);
		bg.add(rdbtnFemale);
		bg.add(rdbtnOther);
		
		txtEmailAddress = new JTextField();
		txtEmailAddress.setToolTipText("");
		txtEmailAddress.setText("Email Address");
		txtEmailAddress.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmailAddress.setForeground(Color.BLACK);
		txtEmailAddress.setFont(new Font("Cambria", Font.PLAIN, 15));
		txtEmailAddress.setDropMode(DropMode.INSERT);
		txtEmailAddress.setColumns(10);
		txtEmailAddress.setBorder(null);
		txtEmailAddress.setBackground(Color.WHITE);
		
		txtPassword = new JTextField();
		txtPassword.setToolTipText("");
		txtPassword.setText("Password");
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setForeground(Color.BLACK);
		txtPassword.setFont(new Font("Cambria", Font.PLAIN, 15));
		txtPassword.setDropMode(DropMode.INSERT);
		txtPassword.setColumns(10);
		txtPassword.setBorder(null);
		txtPassword.setBackground(Color.WHITE);
		
		txtConfirmPassword = new JTextField();
		txtConfirmPassword.setToolTipText("");
		txtConfirmPassword.setText("Confirm Password");
		txtConfirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtConfirmPassword.setForeground(Color.BLACK);
		txtConfirmPassword.setFont(new Font("Candara", Font.PLAIN, 15));
		txtConfirmPassword.setDropMode(DropMode.INSERT);
		txtConfirmPassword.setColumns(10);
		txtConfirmPassword.setBorder(null);
		txtConfirmPassword.setBackground(Color.WHITE);
		
		JButton btnNewButton = new JButton("Create Account");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(new Color(21, 158, 23));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new Color(0, 204, 255));
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String firstname = txtFirstName.getText();
				String lastname = txtLastName.getText();
				String date =txtDateOfBirth.getText();
				String email = txtEmailAddress.getText();
				String password = txtPassword.getText();
				String confirmpassword = txtConfirmPassword.getText();
				String nation = (String) comboBox.getSelectedItem();
				String gender = " "; 
                if (rdbtnFemale.isSelected()) { 
  
                    gender = "female"; 
                } 
  
                else if (rdbtnMale.isSelected()) { 
  
                	gender = "male"; 
                } 

				if(password.equals(confirmpassword)) {
					try {
						Class.forName("com.mysql.jdbc.Driver");  
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_assistant","root","");
						
						PreparedStatement ps = con.prepareStatement("INSERT INTO `registration`(`first_name`, `last_name`, `dateOfbirth`, `nation`, `gender`, `email`, `password`) values(?,?,?,?,?,?,?)");  
						PreparedStatement ps2 = con.prepareStatement("INSERT INTO `login`(`email`, `password`) VALUES(?, ?)"); 
							ps.setString(1, firstname);
							ps.setString(2, lastname);
							ps.setString(3, date);
							ps.setString(4, nation);
							ps.setString(5, gender);
							ps.setString(6, email);
							ps.setString(7, password);
							
							ps2.setString(1, email);
							ps2.setString(2, password);
							
						ps.executeUpdate();
						ps2.executeUpdate();
						con.close();
						JOptionPane.showMessageDialog(null, "Registration Successfull. Login with your email and password.");
						Login_page ob = new Login_page();
						ob.setVisible(true);
						dispose();
					}
					catch(Exception e1){ 
						System.out.println(e1);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Password not matched.");
				}
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 204, 255));
		btnNewButton.setFont(new Font("Cambria", Font.BOLD, 20));
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("I agree to all terms & conditions");
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setBorder(null);
		chckbxNewCheckBox.setForeground(new Color(0, 0, 0));
		chckbxNewCheckBox.setFont(new Font("Arial", Font.PLAIN, 15));
		chckbxNewCheckBox.setBackground(new Color(0, 206, 209));
		
		JButton btnLogin = new JButton("Allready have an account ?");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new Color(0, 100, 33));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setBackground(new Color(0, 204, 204));
			}
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login_page frame = new Login_page();
				frame.setVisible(true);
				frame.setTitle("Aladdin V3.0");
				ImageIcon img = new ImageIcon("E:\\8th semester\\SDP 3\\aladdin-logo.jpg");
				frame.setIconImage(img.getImage());
				
				dispose();
				}
		});
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setFont(new Font("Cambria", Font.PLAIN, 17));
		btnLogin.setBorder(null);
		btnLogin.setBackground(new Color(0, 204, 204));
		
		
		rdbtnOther.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rdbtnOther.setForeground(Color.WHITE);
		rdbtnOther.setFont(new Font("Arial", Font.BOLD, 15));
		rdbtnOther.setBorder(null);
		rdbtnOther.setBackground(new Color(0, 206, 209));
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFirstName.setText(null);
				txtLastName.setText(null);
				txtDateOfBirth.setText(null);
				txtEmailAddress.setText(null);
				txtPassword.setText(null);
				txtConfirmPassword.setText(null);
				comboBox.setSelectedIndex(0);
			}
		});
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnReset.setBackground(new Color(0, 100, 33));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnReset.setBackground(new Color(165, 42, 42));
			}
		});
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Cambria", Font.BOLD, 20));
		btnReset.setBorder(null);
		btnReset.setBackground(new Color(165, 42, 42));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(68)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtConfirmPassword, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
						.addComponent(txtEmailAddress, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(txtFirstName, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtLastName, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
						.addComponent(txtDateOfBirth, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
						.addComponent(comboBox, Alignment.TRAILING, 0, 310, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(rdbtnMale, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(rdbtnFemale, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnOther, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addGap(0, 0, Short.MAX_VALUE))
						.addComponent(txtPassword, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
						.addComponent(chckbxNewCheckBox, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
						.addComponent(btnNewButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
						.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
						.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
					.addGap(72))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(7)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
					.addGap(7))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtLastName, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
						.addComponent(txtFirstName, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtDateOfBirth, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(rdbtnMale, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addComponent(rdbtnFemale, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addComponent(rdbtnOther, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtEmailAddress, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtConfirmPassword, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxNewCheckBox, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(19))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
