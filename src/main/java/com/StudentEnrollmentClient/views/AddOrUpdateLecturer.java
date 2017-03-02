package com.StudentEnrollmentClient.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddOrUpdateLecturer extends JFrame {

	private JPanel contentPane;
	private JTextField txtLecturerName;
	private JTextField txtLecturerSurname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddOrUpdateLecturer frame = new AddOrUpdateLecturer();
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
	public AddOrUpdateLecturer() {
		setTitle("Add Or Update Lecturer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddupdateLecturer = new JLabel("Add/Update Lecturer");
		lblAddupdateLecturer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblAddupdateLecturer.setBounds(199, 0, 266, 44);
		contentPane.add(lblAddupdateLecturer);
		
		JLabel lblLecturerName = new JLabel("Lecturer Name:");
		lblLecturerName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLecturerName.setBounds(29, 98, 162, 20);
		contentPane.add(lblLecturerName);
		
		txtLecturerName = new JTextField();
		txtLecturerName.setColumns(10);
		txtLecturerName.setBounds(199, 93, 177, 25);
		contentPane.add(txtLecturerName);
		
		JButton btnSaveLecturer = new JButton("Save");
		btnSaveLecturer.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSaveLecturer.setBounds(22, 207, 169, 39);
		contentPane.add(btnSaveLecturer);
		
		JLabel lblLecturerSurname = new JLabel("Lecturer Surname:");
		lblLecturerSurname.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLecturerSurname.setBounds(29, 140, 162, 20);
		contentPane.add(lblLecturerSurname);
		
		txtLecturerSurname = new JTextField();
		txtLecturerSurname.setColumns(10);
		txtLecturerSurname.setBounds(201, 140, 177, 25);
		contentPane.add(txtLecturerSurname);
		
		JButton btnUpdateLecturer = new JButton("Update");
		btnUpdateLecturer.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdateLecturer.setBounds(218, 207, 169, 39);
		contentPane.add(btnUpdateLecturer);
		
		JButton btnCancelLecturer = new JButton("Cancel");
		btnCancelLecturer.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCancelLecturer.setBounds(417, 207, 169, 39);
		contentPane.add(btnCancelLecturer);
	}

}
