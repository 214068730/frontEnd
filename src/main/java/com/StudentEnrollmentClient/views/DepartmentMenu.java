package com.StudentEnrollmentClient.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import com.StudentEnrollmentClient.domain.Department;
import com.StudentEnrollmentClient.domain.Student;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DepartmentMenu extends JFrame {

	private JPanel contentPane;
	private static Department department;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentMenu frame = new DepartmentMenu(department);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public DepartmentMenu() {
		intialize();
	}

	public DepartmentMenu(Department department) {
		intialize();
	}

	/**
	 * Create the frame.
	 */
	public void intialize() {
		setTitle("Department Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDepartmentMenu = new JLabel("Department Menu");
		lblDepartmentMenu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblDepartmentMenu.setBounds(146, 11, 254, 48);
		contentPane.add(lblDepartmentMenu);
		
		JButton btnAddDepartment = new JButton("Add Department");
		btnAddDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddOrUpdateDepartment addDept = new AddOrUpdateDepartment(department);
				addDept.setVisible(true);
				dispose();
			}
		});
		btnAddDepartment.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddDepartment.setBounds(126, 80, 236, 63);
		contentPane.add(btnAddDepartment);
		
		JButton btnViewDepartment = new JButton("View Department(s)");
		btnViewDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewDepartment viewDept = new ViewDepartment();
				viewDept.setVisible(true);
				dispose();
			}
		});
		btnViewDepartment.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnViewDepartment.setBounds(126, 170, 236, 63);
		contentPane.add(btnViewDepartment);
		
		JButton button = new JButton("Main Menu");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu mainMenu = new Menu();
				mainMenu.setVisible(true);
				dispose();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBounds(126, 263, 236, 63);
		contentPane.add(button);
	}
}
