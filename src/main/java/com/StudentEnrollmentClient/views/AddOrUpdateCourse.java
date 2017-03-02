package com.StudentEnrollmentClient.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class AddOrUpdateCourse extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddOrUpdateCourse frame = new AddOrUpdateCourse();
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
	public AddOrUpdateCourse() {
		setTitle("Add Or Update Course(s)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddupdateCourse = new JLabel("Add/Update Course");
		lblAddupdateCourse.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblAddupdateCourse.setBounds(193, 0, 266, 44);
		contentPane.add(lblAddupdateCourse);
	}

}
