package com.StudentEnrollmentClient.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import com.StudentEnrollmentClient.domain.Student;
import com.StudentEnrollmentClient.rest.Impl.StudentRestImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtStudentNumber;
	private JTextField txtPassword;
	private Student student;
	private final StudentRestImpl service = new StudentRestImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login login = new Login();
					login.setVisible(true);
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
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 381, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblLogin.setBounds(159, 11, 102, 26);
		contentPane.add(lblLogin);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = txtStudentNumber.getText();
				String password = txtPassword.getText();
				if (!username.equals("") && !password.equals("")) {
					try {
						Student student = service.getStudentLogin(username,
								password);
						if (student != null) {
							Menu menu = new Menu(student);
							menu.setVisible(true);
							dispose();
							
						} else
							JOptionPane.showMessageDialog(null,
									"STUDENT DETAILS NOT FOUND", "ERROR",
									JOptionPane.ERROR_MESSAGE);

					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage(),
								"ERROR", JOptionPane.ERROR_MESSAGE);
					}
				} else
					JOptionPane.showMessageDialog(null,
							"Please fill in all fields", "INFO",
							JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnLogin.setBounds(161, 184, 86, 35);
		contentPane.add(btnLogin);

		JButton btnCancelLogin = new JButton("Cancel");
		btnCancelLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancelLogin.setBounds(254, 184, 86, 35);
		contentPane.add(btnCancelLogin);

		JPanel panel = new JPanel();
		panel.setBounds(31, 48, 309, 125);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblStudentid = new JLabel("StudentID:");
		lblStudentid.setBounds(25, 41, 53, 14);
		panel.add(lblStudentid);

		txtStudentNumber = new JTextField();
		txtStudentNumber.setBounds(124, 29, 164, 26);
		panel.add(txtStudentNumber);
		txtStudentNumber.setColumns(10);

		txtPassword = new JTextField();
		txtPassword.setBounds(124, 65, 164, 26);
		panel.add(txtPassword);
		txtPassword.setColumns(10);

		JLabel lblStudentName = new JLabel("Student Name:");
		lblStudentName.setBounds(25, 77, 92, 14);
		panel.add(lblStudentName);
	}
}
