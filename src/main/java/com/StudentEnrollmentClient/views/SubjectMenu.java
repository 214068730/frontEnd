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

public class SubjectMenu extends JFrame {

	private JPanel contentPane;
	private Student student;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SubjectMenu frame = new SubjectMenu();
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
	public SubjectMenu() {
		setResizable(false);
		intialize();
	}
	
	public SubjectMenu(Student student){
		intialize();
		this.student = student;
	}
	
	private void intialize(){
		setTitle("Subject Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 353, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Subject Menu");
		lblNewLabel.setBounds(93, 22, 161, 49);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		
		JButton btnAddSubject = new JButton("Add Subject");
		btnAddSubject.setBounds(50, 78, 236, 63);
		contentPane.add(btnAddSubject);
		btnAddSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddOrUpdateSubject addSubject = new AddOrUpdateSubject(student);
				addSubject.setVisible(true);
				dispose();
			}
		});
		btnAddSubject.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnViewSubjects = new JButton("View Subject(s)");
		btnViewSubjects.setBounds(50, 167, 236, 63);
		contentPane.add(btnViewSubjects);
		btnViewSubjects.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewSubject viewSubject = new ViewSubject();
				viewSubject.setVisible(true);
				dispose();
			}
		});
		btnViewSubjects.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(50, 253, 236, 63);
		contentPane.add(btnMainMenu);
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				dispose();
			}
		});
		btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
	}

}
