package eggheadeducator;
/**
 * Project: 1
 * @author Michael Crivello
 * Student ID: 1205570856
 * Team: 7
 * Recitation: 6
 * Description: Login class logs user in
 */


import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import java.awt.Image;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Login {

	private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JLabel lbPicture;
	private JLabel lblNewLabel_2;
	
	
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		connection = SqliteConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.setBounds(100, 100, 779, 499);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(319, 237, 108, 55);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(319, 303, 108, 42);
		frame.getContentPane().add(lblNewLabel_1);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		usernameField.setBounds(437, 246, 173, 42);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query = "select * from studentInfo where userName=? and password=? ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, usernameField.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rst = pst.executeQuery();
					int count = 0;
					while (rst.next()) {
						count++;
					}
					if (count == 1) {
						JOptionPane.showMessageDialog(null, "Username and Password is correct.");
						frame.dispose();
						Universe uniVerse = new Universe();
						uniVerse.setVisible(true);
					}  else {
						JOptionPane.showMessageDialog(null, "Username and Password is not correct. Try Again.");
					}
					
					rst.close();
					pst.close();
					
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, e);
					
				}
				
			}
		});
		btnLogin.setBounds(437, 367, 173, 55);
		frame.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setBounds(437, 311, 173, 32);
		frame.getContentPane().add(passwordField);
		
		lbPicture = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/eggHeadIcon.png")).getImage();
		lbPicture.setIcon(new ImageIcon(img));
		lbPicture.setBounds(33, 57, 254, 355);
		frame.getContentPane().add(lbPicture);
		
		lblNewLabel_2 = new JLabel("Egghead Educator");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel_2.setBounds(319, 57, 339, 132);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
