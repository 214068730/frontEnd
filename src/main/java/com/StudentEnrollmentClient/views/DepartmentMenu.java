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

public class DepartmentMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentMenu frame = new DepartmentMenu();
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
	public DepartmentMenu() {
		setTitle("Department Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 386);
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
				contentPane.hide();
				AddOrUpdateDepartment addDept = new AddOrUpdateDepartment();
				addDept.setVisible(true);
			}
		});
		btnAddDepartment.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddDepartment.setBounds(142, 80, 236, 63);
		contentPane.add(btnAddDepartment);
		
		JButton btnUpdateDepartment = new JButton("Update Department");
		btnUpdateDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.hide();
				AddOrUpdateDepartment updateDept = new AddOrUpdateDepartment();
				updateDept.setVisible(true);
			}
		});
		btnUpdateDepartment.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdateDepartment.setBounds(146, 169, 236, 63);
		contentPane.add(btnUpdateDepartment);
		
		JButton btnViewDepartment = new JButton("View Department(s)");
		btnViewDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.hide();
				ViewDepartment viewDept = new ViewDepartment();
				viewDept.setVisible(true);
			}
		});
		btnViewDepartment.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnViewDepartment.setBounds(146, 260, 236, 63);
		contentPane.add(btnViewDepartment);
	}

}
