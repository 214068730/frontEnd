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

public class AddOrUpdateDepartment extends JFrame {

	private JPanel contentPane;
	private JTextField txtDeptName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddOrUpdateDepartment frame = new AddOrUpdateDepartment();
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
	public AddOrUpdateDepartment() {
		setResizable(false);
		setTitle("Add Or Update Department");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddupdateDepartment = new JLabel("Add/Update Department");
		lblAddupdateDepartment.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblAddupdateDepartment.setBounds(143, 0, 244, 51);
		contentPane.add(lblAddupdateDepartment);
		
		JLabel lblDepartmentName = new JLabel("Department Name:");
		lblDepartmentName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDepartmentName.setBounds(59, 99, 134, 14);
		contentPane.add(lblDepartmentName);
		
		txtDeptName = new JTextField();
		txtDeptName.setBounds(203, 82, 196, 30);
		contentPane.add(txtDeptName);
		txtDeptName.setColumns(10);
		
		JButton btnSaveDept = new JButton("Save");
		btnSaveDept.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSaveDept.setBounds(59, 149, 120, 40);
		contentPane.add(btnSaveDept);
		
		JButton btnUpdateDept = new JButton("Update");
		btnUpdateDept.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdateDept.setBounds(215, 149, 120, 40);
		contentPane.add(btnUpdateDept);
		
		JButton btnCancelDept = new JButton("Cancel");
		btnCancelDept.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelDept.setBounds(370, 149, 120, 40);
		contentPane.add(btnCancelDept);
	}

}