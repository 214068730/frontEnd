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

public class LecturerMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LecturerMenu frame = new LecturerMenu();
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
	public LecturerMenu() {
		setTitle("Lecturer Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLecturerMenu = new JLabel("Lecturer Menu");
		lblLecturerMenu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblLecturerMenu.setBounds(211, 11, 236, 51);
		contentPane.add(lblLecturerMenu);
		
		JButton btnAddLecturer = new JButton("Add Lecturer");
		btnAddLecturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.hide();
				AddOrUpdateLecturer addLecturer = new AddOrUpdateLecturer();
				addLecturer.setVisible(true);
			}
		});
		btnAddLecturer.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddLecturer.setBounds(192, 73, 236, 63);
		contentPane.add(btnAddLecturer);
		
		JButton btnUpdateLecturer = new JButton("Update Lecturer");
		btnUpdateLecturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.hide();
				AddOrUpdateLecturer updateLecturer = new AddOrUpdateLecturer();
				updateLecturer.setVisible(true);
			}
		});
		btnUpdateLecturer.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdateLecturer.setBounds(192, 158, 236, 63);
		contentPane.add(btnUpdateLecturer);
		
		JButton btnViewLecturer = new JButton("View Lecturer");
		btnViewLecturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.hide();
				ViewLecturer viewLecturer = new ViewLecturer();
				viewLecturer.setVisible(true);
			}
		});
		btnViewLecturer.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnViewLecturer.setBounds(192, 242, 236, 63);
		contentPane.add(btnViewLecturer);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//contentPane.hide();
				//MainMenu mainMenu = new MainMenu();
				
			}
		});
		btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnMainMenu.setBounds(192, 327, 236, 63);
		contentPane.add(btnMainMenu);
	}

}
