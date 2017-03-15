package com.StudentEnrollmentClient.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import com.StudentEnrollmentClient.domain.Lecturer;
import com.StudentEnrollmentClient.domain.Student;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;
	private  Student student;
	private StudentMenu studentMenu;
	private DepartmentMenu deptMenu;
	private LecturerMenu lecturerMenu;
	private JButton button = new JButton("Student Menu");
	private JButton btnDeptMenu = new JButton("Department Menu");
	private JButton button_2 = new JButton("Subject Menu");
	private JButton button_3 = new JButton("Lecturer Menu");
	private JButton button_4 = new JButton("Course Menu");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setResizable(false);
		intialize();
	}
	
	public Menu(Student student) {
		this.student = student;
		intialize();
		accessRights();
		
	
	}
	
	public void accessRights() {
		// Access Rights
		String role = student.getRole().getRole();
		switch (role) {
		case "B":
			btnDeptMenu.setEnabled(false);
			button_2.setEnabled(false);
			button_3.setEnabled(false);
			button_4.setEnabled(false);
			
		}
	}
	
	public void intialize(){
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(64, 11, 328, 650);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Main Menu");
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		label.setBounds(97, 11, 154, 32);
		panel.add(label);
		
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentMenu = new StudentMenu(student);
				studentMenu.setVisible(true);
				dispose();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBounds(62, 49, 226, 70);
		panel.add(button);
		
		
		btnDeptMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deptMenu = new DepartmentMenu(student);
				deptMenu.setVisible(true);
				dispose();
			}
		});
		btnDeptMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDeptMenu.setBounds(62, 130, 226, 80);
		panel.add(btnDeptMenu);
		
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubjectMenu subjectMenu = new SubjectMenu(student);
				subjectMenu.setVisible(true);
				dispose();
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_2.setBounds(62, 221, 226, 80);
		panel.add(button_2);
		
		
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lecturerMenu = new LecturerMenu(student);
				lecturerMenu.setVisible(true);
				dispose();
			}
		});
		button_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_3.setBounds(62, 312, 226, 70);
		panel.add(button_3);
		
		
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CourseMenu view = new CourseMenu(student);
				view.setVisible(true);
				dispose();
			}
		});
		button_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_4.setBounds(62, 393, 226, 70);
		panel.add(button_4);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogOut.setBounds(62, 569, 226, 70);
		panel.add(btnLogOut);
		
		JButton btnEnrollment = new JButton("Enrollment");
		btnEnrollment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnrollementMenu view = new EnrollementMenu(student);
				view.setVisible(true);
				dispose();
				
			}
		});
		btnEnrollment.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEnrollment.setBounds(62, 484, 226, 70);
		panel.add(btnEnrollment);
	}

}
