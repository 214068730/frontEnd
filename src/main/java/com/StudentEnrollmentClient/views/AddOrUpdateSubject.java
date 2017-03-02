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
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JMenu;
import javax.swing.JComboBox;

public class AddOrUpdateSubject extends JFrame {

	private JPanel contentPane;
	private JTextField txtSubjectCode;
	private JTextField txtSubjectName;
	private JTextField txtPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddOrUpdateSubject frame = new AddOrUpdateSubject();
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
	public AddOrUpdateSubject() {
		setTitle("Add Or Update Subject");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 917, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add/Update Subject");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(306, 0, 305, 61);
		contentPane.add(lblNewLabel);
		
		JLabel lblSubjectCode = new JLabel("Subject Code:");
		lblSubjectCode.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSubjectCode.setBounds(85, 133, 162, 20);
		contentPane.add(lblSubjectCode);
		
		JLabel lblSubjectName = new JLabel("Subject Name:");
		lblSubjectName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSubjectName.setBounds(85, 164, 162, 26);
		contentPane.add(lblSubjectName);
		
		JLabel lblAcademicYear = new JLabel("Academic Year:");
		lblAcademicYear.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAcademicYear.setBounds(85, 201, 162, 26);
		contentPane.add(lblAcademicYear);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPrice.setBounds(85, 238, 162, 26);
		contentPane.add(lblPrice);
		
		txtSubjectCode = new JTextField();
		txtSubjectCode.setBounds(240, 128, 177, 25);
		contentPane.add(txtSubjectCode);
		txtSubjectCode.setColumns(10);
		
		txtSubjectName = new JTextField();
		txtSubjectName.setColumns(10);
		txtSubjectName.setBounds(240, 164, 177, 25);
		contentPane.add(txtSubjectName);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(240, 238, 177, 25);
		contentPane.add(txtPrice);
		
		JButton btnSaveSubject = new JButton("Save");
		btnSaveSubject.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSaveSubject.setBounds(85, 308, 177, 50);
		contentPane.add(btnSaveSubject);
		
		JLabel lblNewLabel_1 = new JLabel("Lecturer:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(581, 133, 123, 20);
		contentPane.add(lblNewLabel_1);
		
		JComboBox cmdLecturer = new JComboBox();
		cmdLecturer.setBounds(701, 132, 177, 26);
		contentPane.add(cmdLecturer);
		
		JButton btnUpdateSubject = new JButton("Update");
		btnUpdateSubject.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdateSubject.setBounds(352, 308, 177, 50);
		contentPane.add(btnUpdateSubject);
		
		JButton btnCancelSubject = new JButton("Cancel");
		btnCancelSubject.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCancelSubject.setBounds(612, 308, 177, 50);
		contentPane.add(btnCancelSubject);
		
		JComboBox cmdYear = new JComboBox();
		cmdYear.setBounds(240, 201, 177, 26);
		contentPane.add(cmdYear);
	}
}
