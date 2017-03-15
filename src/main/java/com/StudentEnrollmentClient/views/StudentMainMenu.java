package com.StudentEnrollmentClient.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import com.StudentEnrollmentClient.domain.Student;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentMainMenu extends JFrame {

	private JPanel contentPane;
	private StudentSubMenu studSubMenu;
	private Student student;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentMainMenu frame = new StudentMainMenu();
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
	public StudentMainMenu() {
		intialize();
	}

	public StudentMainMenu(Student student) {
		
		this.student = student;
		intialize();

	}
	
	public void intialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(91, 11, 328, 353);
		contentPane.add(panel);
		
		JLabel lblStudentMainMenu = new JLabel("Student Main Menu");
		lblStudentMainMenu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblStudentMainMenu.setBounds(28, 6, 290, 32);
		panel.add(lblStudentMainMenu);
		
		JButton btnStudentSubMenu = new JButton("Student Sub Menu");
		btnStudentSubMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studSubMenu = new StudentSubMenu(student);
				studSubMenu.setVisible(true);
				dispose();
			}
		});
		btnStudentSubMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnStudentSubMenu.setBounds(62, 70, 226, 70);
		panel.add(btnStudentSubMenu);
		
		JButton button_6 = new JButton("Enrollment");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String role = student.getRole().getRole();
				
				switch (role)
				{
				case "A":
					EnrollementMenu view = new EnrollementMenu(student);
					view.setVisible(true);
					dispose();
					break;
				case "B":
					StudEnrollmentMenu studEnrolView = new StudEnrollmentMenu(student);
					studEnrolView.setVisible(true);
					dispose();
					break;
				}				
			}
		});
		button_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_6.setBounds(62, 162, 226, 70);
		panel.add(button_6);
		
		JButton button_5 = new JButton("Log Out");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		button_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_5.setBounds(62, 255, 226, 70);
		panel.add(button_5);
	}
}
