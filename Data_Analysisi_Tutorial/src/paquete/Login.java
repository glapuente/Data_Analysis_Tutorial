package paquete;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {
	
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement pst = null;

	private JPanel contentPane;
	private JTextField txt_username;
	private JPasswordField txt_pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.setTitle("Data Analysis Login");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		// DB connection
		Db_connector.main(null);
		con = Db_connector.ConnectDb();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblUsername = new JLabel("Username");
		
		JLabel lblPassword = new JLabel("Password");
		
		txt_username = new JTextField();
		txt_username.setColumns(10);
		
		txt_pass = new JPasswordField();
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// what does the button do
				String sql = "select * from Users where username=? and pass=?";
				try{
					pst = con.prepareStatement(sql);
					pst.setString(1, txt_username.getText());
					pst.setString(2, txt_pass.getText());
					
					rs = pst.executeQuery();
					if(rs.next()){
						JOptionPane.showMessageDialog(null, "Username and Password is correct");
						Selection s = new Selection();
						s.setVisible(true);
						dispose();
					}
					else{
						JOptionPane.showMessageDialog(null, "Username and Password is incorrect!");	
					}
					
				} catch(Exception e){
					JOptionPane.showMessageDialog(null, e);

				}
			}
		});
		
		JLabel lblDataAnalysisTutorial = new JLabel("Data Analysis Tutorial Tool");
		lblDataAnalysisTutorial.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDataAnalysisTutorial.setForeground(Color.BLUE);
		
		JLabel lblCreateNewAccount = new JLabel("Create new account");
		lblCreateNewAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Crear una cuenta nueva
				New_account new_acc = new New_account();
				new_acc.setVisible(true);
				
			}
		});
		lblCreateNewAccount.setForeground(Color.BLUE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(102)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDataAnalysisTutorial)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblUsername)
									.addGap(18)
									.addComponent(txt_username))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblPassword)
									.addGap(18)
									.addComponent(txt_pass, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)))
							.addGap(37))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(141)
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)))
					.addGap(115))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCreateNewAccount)
					.addContainerGap(354, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDataAnalysisTutorial)
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(txt_username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(txt_pass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(btnLogin)
					.addGap(18)
					.addComponent(lblCreateNewAccount)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
