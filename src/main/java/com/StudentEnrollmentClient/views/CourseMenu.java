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

public class CourseMenu extends JFrame {

	private JPanel contentPane;
	private Student student;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseMenu frame = new CourseMenu();
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
	public CourseMenu() {
		intialize();
	}
	
	public CourseMenu(Student student) {
		intialize();
		this.student = student;
	}
	
	public void intialize(){
		setTitle("Course Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCourseMenu = new JLabel("Course Menu");
		lblCourseMenu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblCourseMenu.setBounds(194, 0, 153, 51);
		contentPane.add(lblCourseMenu);
		
		JButton btnAddCourse = new JButton("Add Course");
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.hide();
				AddOrUpdateCourse addCourse = new AddOrUpdateCourse();
				addCourse.setVisible(true);
			}
		});
		btnAddCourse.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddCourse.setBounds(149, 62, 236, 63);
		contentPane.add(btnAddCourse);
		
		JButton btnUpdateCourse = new JButton("Assign Subjects");
		btnUpdateCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AssignSubject view = new AssignSubject(student);
				view.setVisible(true);
				dispose();
				
			}
		});
		btnUpdateCourse.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdateCourse.setBounds(149, 147, 236, 63);
		contentPane.add(btnUpdateCourse);
		
		JButton btnViewCourse = new JButton("View Course(s)");
		btnViewCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCourse viewCourse = new ViewCourse();
				viewCourse.setVisible(true);
				dispose();
			}
		});
		btnViewCourse.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnViewCourse.setBounds(149, 235, 236, 63);
		contentPane.add(btnViewCourse);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnMainMenu.setBounds(149, 320, 236, 63);
		contentPane.add(btnMainMenu);
	}

}
