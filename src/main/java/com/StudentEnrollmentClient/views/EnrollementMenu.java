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

public class EnrollementMenu extends JFrame {

	private JPanel contentPane;
	private Student student;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnrollementMenu frame = new EnrollementMenu();
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
	public EnrollementMenu() {
		intialize();
	}
	
	public EnrollementMenu(Student student) {
		this.student = student;
		intialize();
	}
	
	public void intialize(){
		setTitle("Enrollment Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 306, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 11, 250, 371);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblEnrollment = new JLabel("Enrollment");
		lblEnrollment.setBounds(50, 11, 152, 32);
		panel.add(lblEnrollment);
		lblEnrollment.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		
		JButton btnEnroll = new JButton("Enroll");
		btnEnroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Enrol view = new Enrol(student);
				view.setVisible(true);
				dispose();
			}
		});
		btnEnroll.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEnroll.setBounds(10, 64, 226, 70);
		panel.add(btnEnroll);
		
		JButton btnView = new JButton("View");
		btnView.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnView.setBounds(10, 163, 226, 70);
		panel.add(btnView);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu view = new Menu(student);
				view.setVisible(true);
				dispose();
			}
		});
		btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnMainMenu.setBounds(10, 261, 226, 70);
		panel.add(btnMainMenu);
	}
}