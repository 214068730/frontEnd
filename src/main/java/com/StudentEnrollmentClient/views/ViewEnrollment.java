package com.StudentEnrollmentClient.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JScrollPane;

import java.awt.Component;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewEnrollment extends JFrame {

	private JPanel contentPane;
	private Enrol enroll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEnrollment frame = new ViewEnrollment();
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
	public ViewEnrollment(){
		initialize();
	}
	
	public ViewEnrollment(Enrol enroll){
		initialize();
		this.enroll = enroll;
	}
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1104, 616);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnrollments = new JLabel("Enrollments");
		lblEnrollments.setBounds(400, 11, 217, 32);
		lblEnrollments.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		contentPane.add(lblEnrollments);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(10, 54, 1047, 428);
		contentPane.add(scrollPane);
		
		JButton button = new JButton("Update");
		button.setBounds(770, 510, 130, 42);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Menu");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu mainMenu = new Menu();
				mainMenu.setVisible(true);
				dispose();
			}
		});
		button_1.setBounds(927, 510, 130, 42);
		contentPane.add(button_1);
	}
}
