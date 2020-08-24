package com.CustomerCare;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class LoginPage {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public LoginPage() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 20, 60));
		panel.setBounds(0, 0, 600, 69);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblWelcomeToAny = new JLabel("Welcome to Any Health Insurance!");
		lblWelcomeToAny.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToAny.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		lblWelcomeToAny.setBounds(109, 6, 405, 56);
		panel.add(lblWelcomeToAny);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(26, 0, 103, 69);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/resources/icons8-helping-hand-50.png")));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 69, 600, 609);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Username:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(124, 200, 93, 23);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("/resources/icons8-plus-64.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(169, 0, 252, 130);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Password:");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel_1_2_1.setBounds(124, 244, 93, 23);
		panel_1.add(lblNewLabel_1_2_1);
		
		textField = new JTextField();
		textField.setBounds(231, 200, 146, 26);
		panel_1.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(231, 244, 146, 26);
		panel_1.add(passwordField);
		
		JLabel sentMessage = new JLabel("");
		sentMessage.setForeground(Color.BLACK);
		sentMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		sentMessage.setBounds(241, 271, 180, 23);
		panel_1.add(sentMessage);
		
		JLabel ImageLabel = new JLabel("");
		ImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ImageLabel.setBounds(212, 271, 28, 23);
		panel_1.add(ImageLabel);
	
		JButton LoginButton = new JButton("Login");
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String UserName ="orange";
				char correctPassword[] = {'a','p','p','l','e'};
				char inputPassword[] = passwordField.getPassword();
				if(textField.getText().equals(UserName) && Arrays.equals(inputPassword, correctPassword))
				{
					sentMessage.setForeground(Color.GREEN);
					sentMessage.setText("Login successful!");
					frame.setVisible(false);
					QueryForm.main(null);
				}
				else
				{
					ImageLabel.setIcon(new ImageIcon(getClass().getResource("/resources/close.png")));
					sentMessage.setForeground(Color.RED);
					sentMessage.setText("Login unsuccessful!");
					JOptionPane.showMessageDialog(null, "Incorrect Username or password. Please try again!","Access Denied!",JOptionPane.ERROR_MESSAGE);
					textField.setText(null);
					passwordField.setText(null);
				}
			}
		});
		LoginButton.setBounds(302, 306, 64, 29);
		panel_1.add(LoginButton);
		
		JButton ClearButton = new JButton("Clear");
		ClearButton.setBounds(237, 306, 64, 29);
		panel_1.add(ClearButton);
		
		JLabel lblNewLabel_2 = new JLabel("Any Health Insurance.      All rights reserved.");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBounds(389, 587, 205, 16);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(getClass().getResource("/resources/icons8-registered-trademark-16.png")));
		lblNewLabel_3.setBounds(489, 587, 16, 16);
		panel_1.add(lblNewLabel_3);	
	}
}
