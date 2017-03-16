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

public class StudentSubMenu extends JFrame {

	private JPanel contentPane;
	private Student student;
	private StudentMainMenu studMainMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentSubMenu frame = new StudentSubMenu();
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
	public StudentSubMenu() {
		intialize();
	}

	public StudentSubMenu(Student student) {
		
		this.student = student;
		intialize();

	}
	
	public void intialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(93, 40, 328, 255);
		contentPane.add(panel);
		
		JLabel lblStudentSubmenu = new JLabel("Student Menu");
		lblStudentSubmenu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblStudentSubmenu.setBounds(77, 0, 193, 32);
		panel.add(lblStudentSubmenu);
		
		JButton button = new JButton("Update Student");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddOrUpdateStudent updateStudent = new AddOrUpdateStudent(
						student, "UPDATE");
				updateStudent.setVisible(true);
				dispose();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBounds(52, 70, 236, 63);
		panel.add(button);
		
		JButton btnStudentMainMenu = new JButton("Main Menu");
		btnStudentMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studMainMenu = new StudentMainMenu(student);
				studMainMenu.setVisible(true);
				dispose();
			}
		});
		btnStudentMainMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnStudentMainMenu.setBounds(52, 163, 236, 63);
		panel.add(btnStudentMainMenu);
	}
}
