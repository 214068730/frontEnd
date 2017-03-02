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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.JRadioButton;
import java.awt.Canvas;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class AddOrUpdateStudent extends JFrame {

	private JPanel contentPane;
	private JTextField txtStudNumber;
	private JTextField txtStudName;
	private JTextField txtStudSurname;
	private JTextField txtStudIDNr;
	private JTextField txtAddrStreetNum;
	private JTextField txtAddrStreetName;
	private JTextField txtAddrSurbubName;
	private JTextField txtAddrAreaCode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddOrUpdateStudent frame = new AddOrUpdateStudent();
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
	public AddOrUpdateStudent() {
		setResizable(false);
		setTitle("Add Or Update Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 972, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panStudInfo = new Panel();
		panStudInfo.setBounds(20, 87, 458, 179);
		contentPane.add(panStudInfo);
		panStudInfo.setLayout(null);
		
		JLabel lblStudentIdnumber = new JLabel("Student Number:");
		lblStudentIdnumber.setBounds(20, 11, 139, 20);
		panStudInfo.add(lblStudentIdnumber);
		lblStudentIdnumber.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		txtStudNumber = new JTextField();
		txtStudNumber.setBounds(186, 9, 248, 29);
		panStudInfo.add(txtStudNumber);
		txtStudNumber.setColumns(10);
		
		JLabel lblStudentName = new JLabel("Student Name:");
		lblStudentName.setBounds(20, 55, 147, 14);
		panStudInfo.add(lblStudentName);
		lblStudentName.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		txtStudName = new JTextField();
		txtStudName.setBounds(186, 50, 248, 29);
		panStudInfo.add(txtStudName);
		txtStudName.setColumns(10);
		
		JLabel lblStudentSurname = new JLabel("Student Surname:");
		lblStudentSurname.setBounds(20, 101, 183, 14);
		panStudInfo.add(lblStudentSurname);
		lblStudentSurname.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		txtStudSurname = new JTextField();
		txtStudSurname.setBounds(186, 90, 248, 29);
		panStudInfo.add(txtStudSurname);
		txtStudSurname.setColumns(10);
		
		JLabel lblStudentIdnumber_1 = new JLabel("Student IDNumber:");
		lblStudentIdnumber_1.setBounds(20, 143, 171, 14);
		panStudInfo.add(lblStudentIdnumber_1);
		lblStudentIdnumber_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		txtStudIDNr = new JTextField();
		txtStudIDNr.setBounds(186, 130, 248, 29);
		panStudInfo.add(txtStudIDNr);
		txtStudIDNr.setColumns(10);
		
		JLabel lblAddupdateStudent = new JLabel("Add/Update Student");
		lblAddupdateStudent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblAddupdateStudent.setBounds(292, 11, 345, 59);
		contentPane.add(lblAddupdateStudent);
		
		JButton btnSaveStudent = new JButton("Save");
		btnSaveStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSaveStudent.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSaveStudent.setBounds(31, 320, 184, 59);
		contentPane.add(btnSaveStudent);
		
		JButton btnUpdateStudent = new JButton("Update");
		btnUpdateStudent.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdateStudent.setBounds(273, 320, 184, 59);
		contentPane.add(btnUpdateStudent);
		
		JButton btnCancelStudent = new JButton("Cancel");
		btnCancelStudent.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCancelStudent.setBounds(535, 320, 184, 59);
		contentPane.add(btnCancelStudent);
		
		Panel panStudAddress = new Panel();
		panStudAddress.setBounds(521, 87, 423, 179);
		contentPane.add(panStudAddress);
		panStudAddress.setLayout(null);
		
		txtAddrStreetNum = new JTextField();
		txtAddrStreetNum.setColumns(10);
		txtAddrStreetNum.setBounds(159, 11, 248, 29);
		panStudAddress.add(txtAddrStreetNum);
		
		txtAddrStreetName = new JTextField();
		txtAddrStreetName.setColumns(10);
		txtAddrStreetName.setBounds(159, 51, 248, 29);
		panStudAddress.add(txtAddrStreetName);
		
		txtAddrSurbubName = new JTextField();
		txtAddrSurbubName.setColumns(10);
		txtAddrSurbubName.setBounds(159, 99, 248, 29);
		panStudAddress.add(txtAddrSurbubName);
		
		txtAddrAreaCode = new JTextField();
		txtAddrAreaCode.setColumns(10);
		txtAddrAreaCode.setBounds(159, 139, 248, 29);
		panStudAddress.add(txtAddrAreaCode);
		
		JLabel lblStreetNumber = new JLabel("Street Number:");
		lblStreetNumber.setBounds(10, 20, 139, 20);
		panStudAddress.add(lblStreetNumber);
		lblStreetNumber.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblStreetName = new JLabel("Street Name:");
		lblStreetName.setBounds(10, 60, 139, 20);
		panStudAddress.add(lblStreetName);
		lblStreetName.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblSurbubName = new JLabel("Surbub Name:");
		lblSurbubName.setBounds(10, 108, 139, 20);
		panStudAddress.add(lblSurbubName);
		lblSurbubName.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblAreaCode = new JLabel("Area Code:");
		lblAreaCode.setBounds(10, 148, 139, 20);
		panStudAddress.add(lblAreaCode);
		lblAreaCode.setFont(new Font("Tahoma", Font.BOLD, 16));
	}
}
