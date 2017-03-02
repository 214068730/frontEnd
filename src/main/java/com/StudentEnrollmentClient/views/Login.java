package com.StudentEnrollmentClient.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtStudIDLogin;
	private JTextField txtStudNameLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblLogin.setBounds(168, 30, 102, 26);
		contentPane.add(lblLogin);
		
		JLabel lblStudentid = new JLabel("StudentID:");
		lblStudentid.setBounds(35, 103, 90, 14);
		contentPane.add(lblStudentid);
		
		JLabel lblStudentName = new JLabel("Student Name:");
		lblStudentName.setBounds(33, 148, 92, 14);
		contentPane.add(lblStudentName);
		
		txtStudIDLogin = new JTextField();
		txtStudIDLogin.setBounds(121, 97, 164, 26);
		contentPane.add(txtStudIDLogin);
		txtStudIDLogin.setColumns(10);
		
		txtStudNameLogin = new JTextField();
		txtStudNameLogin.setBounds(121, 142, 164, 26);
		contentPane.add(txtStudNameLogin);
		txtStudNameLogin.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//contentPane.hide();
				//MainMenu mainMenu = new MainMenu();
			}
		});
		btnLogin.setBounds(39, 183, 102, 35);
		contentPane.add(btnLogin);
		
		JButton btnCancelLogin = new JButton("Cancel");
		btnCancelLogin.setBounds(212, 183, 105, 35);
		contentPane.add(btnCancelLogin);
	}
}
