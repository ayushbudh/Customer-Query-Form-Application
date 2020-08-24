package com.CustomerCare;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import java.util.Date;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class QueryForm extends LoginPage{

	private JFrame frame;
	private JTextField emailBox;
	private JTextField SubjecttxtBox;
	private JTextField FirstNametxt;
	private JTextField LastNametxt;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryForm window = new QueryForm();
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
	public QueryForm() 
	{
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
		panel.setBounds(0, 0, 600, 68);
		panel.setBackground(new Color(220, 20, 60));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Query Form");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(126, 0, 357, 69);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(getClass().getResource("/resources/icons8-helping-hand-50.png")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(81, 0, 103, 69);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.window);
		panel_1.setBounds(0, 68, 600, 610);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(127, 170, 49, 23);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Subject:");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(111, 211, 65, 23);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Message:");
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel_1_1_1.setBounds(100, 256, 76, 23);
		panel_1.add(lblNewLabel_1_1_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBounds(188, 261, 234, 230);
		panel_1.add(textArea);
		
		emailBox = new JTextField();
		emailBox.setBounds(183, 170, 239, 26);
		panel_1.add(emailBox);
		emailBox.setColumns(10);
		
		SubjecttxtBox = new JTextField();
		SubjecttxtBox.setColumns(10);
		SubjecttxtBox.setBounds(183, 208, 239, 26);
		panel_1.add(SubjecttxtBox);
		
		FirstNametxt = new JTextField();
		FirstNametxt.setColumns(10);
		FirstNametxt.setBounds(183, 100, 239, 26);
		panel_1.add(FirstNametxt);
		
		LastNametxt = new JTextField();
		LastNametxt.setColumns(10);
		LastNametxt.setBounds(183, 135, 239, 26);
		panel_1.add(LastNametxt);
		
		JLabel sentMessage = new JLabel("");
		sentMessage.setForeground(Color.BLACK);
		sentMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		sentMessage.setBounds(220, 75, 193, 23);
		panel_1.add(sentMessage);
		
		JLabel ImageLabel = new JLabel("");
		ImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ImageLabel.setBounds(194, 75, 28, 23);
		panel_1.add(ImageLabel);
		
		JButton SubmitButton = new JButton("Submit");
		SubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String Checkdomain = emailBox.getText();
				
				if(FirstNametxt.getText().equals("") || LastNametxt.getText().equals("")||SubjecttxtBox.getText().equals("")||emailBox.getText().equals("")||textArea.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "One or more fields are empty. Please fill the entire form to submit a query. "," Empty input!",JOptionPane.ERROR_MESSAGE);
					sentMessage.setForeground(Color.RED);
					ImageLabel.setIcon(new ImageIcon(getClass().getResource("/resources/close.png")));
					sentMessage.setText("Query failed to submit!");
					
				}	
				else if( Checkdomain.length()>10 && Checkdomain.substring(Checkdomain.length()-10,Checkdomain.length()).equalsIgnoreCase("@gmail.com"))
				{
				
					
					System.out.println("Preparing to send message..........");
					final String Email =""/* Please write the email address inside the "" of the account from which you want to send the e-mail */;
					final String password = "" /* Please write the password inside the "" of the account from which you want to send the e-mail */;
					
					Properties pro = new Properties();
					pro.put("mail.smtp.auth", "true");
					pro.put("mail.smtp.starttls.enable", "true");
					pro.put("mail.smtp.host","smtp.gmail.com");
					pro.put("mail.smtp.port", "587");
					
					Session session = Session.getInstance(pro,
							new javax.mail.Authenticator()
							{
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(Email,password);
							}
							});
					
					try
					{
						DateFormat df = new SimpleDateFormat("MM/dd/yy ");
					    Date dateobj = new Date();
					       
					    DateFormat df1 = new SimpleDateFormat("HH:mm:ss ");
					    Date dateobj1 = new Date();
					   
						Message message = new MimeMessage(session);
						message.setFrom(new InternetAddress(""/* Please write the email address inside the "" of the account from which you want to send the e-mail */));
				
						message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailBox.getText()));
						message.setSubject("AutoReply: "+SubjecttxtBox.getText());
						message.setContent("<!DOCTYPE html>\n" + 
								"<html>\n" + 
								"<head>\n" + 
								"<title>  </title>\n" + 
								"\n" + 
								"<p> Thank you for your patience, one of our customer care specialist will soon contact you about your query.</p>\n" + 
								"<h4>Query Deatils:</h4>\n" + 
								"<h4 style =\"background-color:linen;\"> First Name </h4>\n" + 
								"\n" + 
								"</head>\n" + 
								"<body>\n" + 
								"<ul>\n" + 
								"<li>"+	FirstNametxt.getText()+"</li>\n" + 
								"</ul>\n" + 
								"</body>\n" + 
								"\n" + 
								"<h4 style =\"background-color:linen;\"> Last Name </h4>\n" + 
								"\n" + 
								"</head>\n" + 
								"<body>\n" + 
								"<ul>\n" + 
								"<li>"+	LastNametxt.getText()+"</li>\n" + 
								"</ul>\n" + 
								"</body>\n" + 
								"\n" + 
								"<h4 style =\"background-color:linen;\"> Date </h4>\n" + 
								"\n" + 
								"</head>\n" + 
								"<body>\n" + 
								"<ul>\n" + 
								"<li>"+	df.format(dateobj) +"</li>\n" + 
								"</ul>\n" + 
								"</body>\n" + 
								"\n" + 
								"<h4 style =\"background-color:linen;\"> Time </h4>\n" + 
								"\n" + 
								"</head>\n" + 
								"<body>\n" + 
								"<ul>\n" + 
								"<li>"+	df1.format(dateobj1) +"</li>\n" + 
								"</ul>\n" + 
								"</body>\n" + 
								"\n" + 
								"<h4 style =\"background-color:linen;\"> Subject </h4>\n" + 
								"\n" + 
								"</head>\n" + 
								"<body>\n" + 
								"<ul>\n" + 
								"<li>"+	SubjecttxtBox.getText()+"</li>\n" + 
								"</ul>\n" + 
								"</body>\n" + 
								"\n" + 
								"<h4 style =\"background-color:linen;\"> Query </h4>\n" + 
								"\n" + 
								"</head>\n" + 
								"<body>	\n" + 
								"	<p>"+ textArea.getText()+"</p>\n" + 
								"	<p><br><br><B>Thanks & Regards,</B><br> Customer Care Team<br>Any Health Insurance Company<br>Phone number:0000000000<br>Take care and stay fit.</p>\n" + 
								"\n" + 
								"<img src = \"https://www.nugenthouse.co.uk/app/uploads/2020/03/healthy_lifestyle_blog.jpg\" width = \"1020\" height=\"350\" alt=\"Stay fit and stay safe!\">\n" + 
								"</body>\n" + 
								"</html>", "text/html; character=utf-8");
						
				
						Transport.send(message);
						System.out.println("Message Sent!");
						ImageLabel.setIcon(new ImageIcon(getClass().getResource("/resources/icons8-checked-16.png")));
						sentMessage.setForeground(Color.green);
						sentMessage.setText("Query submitted successfully!");
					}	
		
					catch(MessagingException e8)
					{
						throw new RuntimeException(e8);
					}
					
				}
				else if(Checkdomain.length()<=10||Checkdomain.substring(Checkdomain.length()-10,Checkdomain.length())!="@gmail.com")
				{
					ImageLabel.setIcon(new ImageIcon(getClass().getResource("/resources/close.png")));
					sentMessage.setForeground(Color.RED);
					sentMessage.setText("Query failed to submit!");
					JOptionPane.showMessageDialog(null, "Incorrect extension inputted. Please re-enter email with @gmail.com extension. "," Extension error!",JOptionPane.ERROR_MESSAGE);
					emailBox.setText(null);
				}
			}
		});
		SubmitButton.setBounds(307, 522, 76, 29);
		panel_1.add(SubmitButton);
		
		JButton CancelButton = new JButton("Cancel");
		CancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.setVisible(false);
				frame.dispose();
			}
		});
		CancelButton.setBounds(230, 522, 76, 29);
		panel_1.add(CancelButton);
		
		JLabel lblNewLabel_1_2 = new JLabel("First Name:");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(83, 100, 93, 23);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Last Name:");
		lblNewLabel_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel_1_2_1.setBounds(83, 135, 93, 23);
		panel_1.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Any Health Insurance.      All rights reserved.");
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblNewLabel_2_1.setBounds(389, 588, 205, 16);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(getClass().getResource("/resources/icons8-registered-trademark-16.png")));
		lblNewLabel_3.setBounds(490, 588, 16, 16);
		panel_1.add(lblNewLabel_3);
	}
}
