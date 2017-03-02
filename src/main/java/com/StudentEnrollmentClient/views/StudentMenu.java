package com.StudentEnrollmentClient.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentMenu frame = new StudentMenu();
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
	public StudentMenu() {
		setTitle("Student Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentMenu = new JLabel("Student Menu");
		lblStudentMenu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblStudentMenu.setBounds(176, 22, 178, 40);
		contentPane.add(lblStudentMenu);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.hide();
				AddOrUpdateStudent addStudent = new AddOrUpdateStudent();
				addStudent.setVisible(true);
			}
		});
		btnAddStudent.setBounds(152, 84, 236, 63);
		contentPane.add(btnAddStudent);
		
		JButton btnUpdateStudent = new JButton("Update Student");
		btnUpdateStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.hide();
				AddOrUpdateStudent updateStudent = new AddOrUpdateStudent();
				updateStudent.setVisible(true);
			}
		});
		btnUpdateStudent.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdateStudent.setBounds(152, 172, 236, 63);
		contentPane.add(btnUpdateStudent);
		
		JButton btnViewStudent = new JButton("View Student");
		btnViewStudent.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnViewStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.hide();
				ViewStudent viewStudent = new ViewStudent();
				viewStudent.setVisible(true);
			}
		});
		btnViewStudent.setBounds(152, 259, 236, 64);
		contentPane.add(btnViewStudent);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnMainMenu.setBounds(152, 346, 236, 63);
		contentPane.add(btnMainMenu);
	}

}
