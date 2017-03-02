package com.StudentEnrollmentClient.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu {

	private JFrame frmMainMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frmMainMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainMenu = new JFrame();
		frmMainMenu.setTitle("Main Menu");
		frmMainMenu.setBounds(100, 100, 633, 528);
		frmMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainMenu.getContentPane().setLayout(null);
		
		JLabel lblMainMenu = new JLabel("Main Menu");
		lblMainMenu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblMainMenu.setBounds(185, 11, 259, 32);
		frmMainMenu.getContentPane().add(lblMainMenu);
		
		JButton btnStudentMenu = new JButton("Student Menu");
		btnStudentMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnStudentMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMainMenu.hide();
				StudentMenu studMenu = new StudentMenu();
				studMenu.setVisible(true);
			}
		});
		btnStudentMenu.setBounds(181, 65, 226, 70);
		frmMainMenu.getContentPane().add(btnStudentMenu);
		
		JButton btnDepartmentMenu = new JButton("Department Menu");
		btnDepartmentMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMainMenu.hide();
				DepartmentMenu deptMenu = new DepartmentMenu();
				deptMenu.setVisible(true);
			}
		});
		btnDepartmentMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDepartmentMenu.setBounds(181, 146, 226, 80);
		frmMainMenu.getContentPane().add(btnDepartmentMenu);
		
		JButton btnSubjectMenu = new JButton("Subject Menu");
		btnSubjectMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMainMenu.hide();
				SubjectMenu subjMenu = new SubjectMenu();
				subjMenu.setVisible(true);
			}
		});
		btnSubjectMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSubjectMenu.setBounds(181, 237, 226, 80);
		frmMainMenu.getContentPane().add(btnSubjectMenu);
		
		JButton btnLecturerMenu = new JButton("Lecturer Menu");
		btnLecturerMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLecturerMenu.setBounds(181, 328, 226, 70);
		frmMainMenu.getContentPane().add(btnLecturerMenu);
		
		JButton btnCourseMenu = new JButton("Course Menu");
		btnCourseMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMainMenu.hide();
				CourseMenu courseMenu = new CourseMenu();
				courseMenu.setVisible(true);
			}
		});
		btnCourseMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCourseMenu.setBounds(181, 409, 226, 70);
		frmMainMenu.getContentPane().add(btnCourseMenu);
	}
}
