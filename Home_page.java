package version01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Desktop;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Home_page extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAskAssistant;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_page frame = new Home_page();
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
	public Home_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setFont(new Font("Cambria", Font.PLAIN, 12));
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBackground(new Color(0, 0, 0));
		
		JLabel lblAladdinVirtualAssistant = new JLabel("Aladdin");
		lblAladdinVirtualAssistant.setBackground(Color.WHITE);
		lblAladdinVirtualAssistant.setHorizontalAlignment(SwingConstants.CENTER);
		lblAladdinVirtualAssistant.setForeground(Color.WHITE);
		lblAladdinVirtualAssistant.setFont(new Font("Castellar", Font.BOLD, 35));
		
		JLabel label_2 = new JLabel("All Right Reserved 2020 (BUBT Project CSE 300)");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(0, 0, 0));
		label_2.setFont(new Font("Castellar", Font.BOLD, 10));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(89)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
							.addGap(86))))
				.addComponent(lblAladdinVirtualAssistant, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblAladdinVirtualAssistant, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
					.addGap(30)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		);
		
		txtAskAssistant = new JTextField();
		txtAskAssistant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//txtAskAssistant.setText(null);
			}
		});
		txtAskAssistant.setForeground(Color.BLACK);
		txtAskAssistant.setText(" Ask...!");
		txtAskAssistant.setFont(new Font("Calisto MT", Font.PLAIN, 15));
		txtAskAssistant.setHorizontalAlignment(SwingConstants.LEFT);
		txtAskAssistant.setBackground(new Color(255, 255, 255));
		txtAskAssistant.setBorder(null);
		txtAskAssistant.setColumns(10);
		
		JComboBox<Object> searchbox = new JComboBox<Object>();
		searchbox.setForeground(Color.BLACK);
		searchbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAskAssistant.setText((String) searchbox.getSelectedItem());
				
			}
		});
		
		JTextArea textarea = new JTextArea();
		textarea.setColumns(10);
		textarea.setForeground(new Color(0, 0, 0));
		textarea.append("Aladdin : Welcome My Master !\n");
		JButton send = new JButton("Send");
		send.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				send.setBackground(new Color(0,191,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				send.setBackground(new Color(51,102,255));
			}
		});
		//<<<<<<<<<<<<<<<<<<<<<<<<<<<<String found>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = txtAskAssistant.getText();
				
				if(user.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Empty.");
				}
				else {
					textarea.append("Me : "+ user+ "\n");
					txtAskAssistant.setText(null);
					int i=0;
					
					try {
						Class.forName("com.mysql.jdbc.Driver");  
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_assistant","root","");

						Statement stmt=con.createStatement();
						
						String ne = "Set My Schedule.";
						if(user.equals(ne)) {
							//textarea.append("Aladdin : "+ user + " ! Master?\n");
							Set_Schedule obj = new Set_Schedule();
							obj.setVisible(true);
							obj.setTitle("Aladdin V3.0");
							ImageIcon img = new ImageIcon("E:\\8th semester\\SDP 3\\aladdin-logo.jpg");
							obj.setIconImage(img.getImage());
							
							dispose();
							i+=1;
						}
						ResultSet rs=stmt.executeQuery("SELECT * FROM `greetings` WHERE formal='"+user.toLowerCase()+"' OR informal='"+user.toLowerCase()+"'");
						while(rs.next()) {
							if(user.toLowerCase().equals(rs.getString(1))) {
								textarea.append("Aladdin : "+ rs.getString(2) + " ! Master?\n");
								i+=1;
								break;
							}
							else if(user.toLowerCase().equals(rs.getString(2))) {
								textarea.append("Aladdin : "+ rs.getString(1) + " ! Master?\n");
								i+=1;
								break;
							}
						}
						ResultSet rs2=stmt.executeQuery("SELECT * FROM `learn_new` WHERE comand='"+user.toLowerCase()+"'");
						while(rs2.next()) {
							if(user.toLowerCase().equals(rs2.getString(1))) {
								
								String url = rs2.getString(2);
						        if(Desktop.isDesktopSupported()){
						            Desktop desktop = Desktop.getDesktop();
						            try {
						                desktop.browse(new URI(url));
						            }
						            catch (IOException | URISyntaxException e4) {
						                
						                e4.printStackTrace();
						            }
						            textarea.append("Aladdin : Result showen in your Web browser.\n");
						        }
						        else{
						            Runtime runtime = Runtime.getRuntime();
						            try {
						                runtime.exec("xdg-open " + url); 
						            }
						            catch (IOException e2) {
						                
						                e2.printStackTrace();
						            }
						        }
								i+=1;
								break;
							}
						}
						ResultSet rs3=stmt.executeQuery("SELECT * FROM `web_command` WHERE command='"+user.toLowerCase()+"'");
						while(rs3.next()) {
							if(user.toLowerCase().equals(rs3.getString(2))) {
								
								String url = rs3.getString(1);
						        if(Desktop.isDesktopSupported()){
						            Desktop desktop = Desktop.getDesktop();
						            try {
						                desktop.browse(new URI(url));
						            }
						            catch (IOException | URISyntaxException e4) {
						                
						                e4.printStackTrace();
						            }
						            textarea.append("Aladdin : Result showen in your Web browser.\n");
						        }
						        else{
						            Runtime runtime = Runtime.getRuntime();
						            try {
						                runtime.exec("xdg-open " + url); 
						            }
						            catch (IOException e3) {
						                
						                e3.printStackTrace();
						            }
						        }
						        i+=1;
						        break;
							}
						}
						ResultSet rs4=stmt.executeQuery("SELECT * FROM `user_query` WHERE query='"+user.toLowerCase()+"'");
						while(rs4.next()) {
							if(user.toLowerCase().equals(rs4.getString(1))) {
								textarea.append("Aladdin : "+ rs4.getString(2) + "\n");
								i+=1;
								break;
							}
						}
						
						//<<<<<<<<<<<<<<<<<<<<<<<<<<<<Access the desktop application to launch>>>>>>>>>>>>>>>>>>>>>>>>>>>
						
						ResultSet rs5=stmt.executeQuery("SELECT * FROM `launch_app` WHERE app_name='"+user.toLowerCase()+"'");
						while(rs5.next()) {
							if(user.toLowerCase().equals(rs5.getString(1))) {
								String appname = rs5.getString(2);
								
								JDialog.setDefaultLookAndFeelDecorated(true);
						        int response5 = JOptionPane.showConfirmDialog(null, "Do you want me to open "+user+" for you?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						        
						        if(response5 == JOptionPane.NO_OPTION) {
						        	/*
						        	 * 
						        	 * 
						        	 * 
						        	 * 
						        	 * */
						        }
						        else if(response5 == JOptionPane.YES_OPTION) {
						        	
						        	textarea.append("Aladdin : Opening "+ rs5.getString(1) + "\n");
									Runtime runtime = Runtime.getRuntime();
									try
									{
										runtime.exec(appname);        //opens new app instance
										
									}
									catch (IOException e5) {
						                
						                e5.printStackTrace();
						            }
						        }	
								i+=1;
								break;
							}
						}
						//<<<<<<<<<<<<<<<<<<<<<<<<<<<<Data not found / Add to data table>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
						if(i==0) {
							textarea.append("Aladdin : I am a Prototype. I am learning. Help me learn.\n");

						    JDialog.setDefaultLookAndFeelDecorated(true);
						    int response = JOptionPane.showConfirmDialog(null, "Is `"+user+"` an Order?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						    
						    if (response == JOptionPane.NO_OPTION) {
						    	String url_g = user.replaceAll("\\s", "+");
						    	PreparedStatement ps = con.prepareStatement("INSERT INTO `learn_new`(`comand`, `google_url`) VALUES (?, ?)");//add data with google search
								ps.setString(1, user.toLowerCase());
								ps.setString(2, "https://www.google.com/search?q="+url_g.toLowerCase()+"&oq="+url_g.toLowerCase()+"&aqs=chrome");
								ps.executeUpdate();
								
								String url = "https://www.google.com/search?q="+url_g.toLowerCase()+"&oq="+url_g.toLowerCase()+"&aqs=chrome";
						        if(Desktop.isDesktopSupported()){
						            Desktop desktop = Desktop.getDesktop();
						            try {
						                desktop.browse(new URI(url));
						            }
						            catch (IOException | URISyntaxException e4) {
						                
						                e4.printStackTrace();
						            }
						            textarea.append("Aladdin : I pulled up what i found on google by "+user+".\n");
						        }
						        else{
						            Runtime runtime = Runtime.getRuntime();
						            try {
						                runtime.exec("xdg-open " + url); 
						            }
						            catch (IOException e5) {
						                
						                e5.printStackTrace();
						            }
						        }
						        JOptionPane.showMessageDialog(null, "Added To Memory.");
						        
						    }
						    else if (response == JOptionPane.YES_OPTION) {
						    	
						    	JDialog.setDefaultLookAndFeelDecorated(true);
						        int response2 = JOptionPane.showConfirmDialog(null, "Is `"+user+"` a URL or WEB address?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						        
						        if (response2 == JOptionPane.NO_OPTION) {
						        	
						        	JDialog.setDefaultLookAndFeelDecorated(true);
							        int response3 = JOptionPane.showConfirmDialog(null, "Do you want me to google for you?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							        
							        if(response3 == JOptionPane.NO_OPTION) {
							            String answer = JOptionPane.showInputDialog(null,user+". What's your reply would be?");
							        	
							        	PreparedStatement ps3 = con.prepareStatement("INSERT INTO `user_query`(`query`, `answer`) VALUES (?,?)");
										ps3.setString(1, user.toLowerCase());
										ps3.setString(2, answer);
										ps3.executeUpdate();
										JOptionPane.showMessageDialog(null, "Added To Memory.");
							        	JOptionPane.showMessageDialog(null, "I have learn something new from you.");
							        	txtAskAssistant.setText("  Ask Aladdin");
							        }
							        else if(response3 == JOptionPane.YES_OPTION) {
							        	PreparedStatement ps2 = con.prepareStatement("INSERT INTO `learn_new`(`comand`, `google_url`) VALUES (?,?)");
							        	
							        	String url_g = user.replaceAll("\\s", "+");
							        	
										ps2.setString(1, user.toLowerCase());
										ps2.setString(2, "https://www.google.com/search?q="+url_g.toLowerCase()+"&oq="+url_g.toLowerCase()+"&aqs=chrome");
										ps2.executeUpdate();
							        	JOptionPane.showMessageDialog(null, "I have learn something new from you.");
							        	txtAskAssistant.setText("  Ask Aladdin");
							        	
							        	String url = "https://www.google.com/search?q="+url_g.toLowerCase()+"&oq="+url_g.toLowerCase()+"&aqs=chrome";
							        	if(Desktop.isDesktopSupported()){
								            Desktop desktop = Desktop.getDesktop();
								            try {
								                desktop.browse(new URI(url));
								            }
								            catch (IOException | URISyntaxException e4) {
								                
								                e4.printStackTrace();
								            }
								            textarea.append("Aladdin : Result showen in your Web browser.\n");
								        }
								        else{
								            Runtime runtime = Runtime.getRuntime();
								            try {
								                runtime.exec("xdg-open " + url); 
								            }
								            catch (IOException e5) {
								                
								                e5.printStackTrace();
								            }
								        }
							        }	
						        }
						        else if (response2 == JOptionPane.YES_OPTION) {
						        	PreparedStatement ps2 = con.prepareStatement("INSERT INTO `web_command`(`url`, `command`) VALUES (?,?)");
									ps2.setString(1, "https://"+user.toLowerCase());
									ps2.setString(2, user.toLowerCase());
									ps2.executeUpdate();
									JOptionPane.showMessageDialog(null, "I have learn something new from you.");
									
									String url = user.toLowerCase();
							        if(Desktop.isDesktopSupported()){
							            Desktop desktop = Desktop.getDesktop();
							            try {
							                desktop.browse(new URI(url));
							            } catch (IOException | URISyntaxException e4) {
							                
							                e4.printStackTrace();
							            }
							            textarea.append("Aladdin : Result showen in your Web browser.\n");
							        }
							        else{
							            Runtime runtime = Runtime.getRuntime();
							            try {
							                runtime.exec("xdg-open " + url);
							            } catch (IOException e5) {
							                
							                e5.printStackTrace();
							            }
							        }
						        }
						    } 
						}
						con.close();
					}
					catch(Exception e3){ 
						JOptionPane.showMessageDialog(null, "Error! "+e3);
					}
				}
			}
		});
		send.setFont(new Font("Cambria", Font.BOLD, 17));
		send.setForeground(new Color(255, 255, 255));
		send.setBackground(new Color(51, 102, 255));
		send.setBorder(null);
		
		textarea.setFont(new Font("Cambria", Font.PLAIN, 15));
		textarea.setBackground(Color.WHITE);
		textarea.setBorder(null);
		textarea.setEditable(false);
		
		
		searchbox.setBorder(null);
		searchbox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Aladdin", "BUBT", "BUBT Administration", "BUBT Campus", "BUBT All notice", "Teachers of BUBT", "Tuition fees of BUBT", "Set My Schedule.", "What can you do?", "What time is it?", "Who are you?"}));
		searchbox.setFont(new Font("Castellar", Font.PLAIN, 17));
		
		
		JScrollPane areaScrollPane = new JScrollPane();
		JScrollBar scrollBar = new JScrollBar();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(6)
					.addComponent(areaScrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtAskAssistant, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
							.addGap(2)
							.addComponent(send, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(textarea, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addComponent(searchbox, Alignment.TRAILING, 0, 404, Short.MAX_VALUE))
					.addGap(7))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(areaScrollPane, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textarea, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
						.addComponent(scrollBar, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(searchbox, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(send, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtAskAssistant, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(5))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
