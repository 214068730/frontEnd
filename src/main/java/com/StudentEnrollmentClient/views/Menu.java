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

public class Menu extends JFrame {

	private JPanel contentPane;
	private static Student student;
	private StudentMenu studentMenu;
	private DepartmentMenu deptMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu(student);
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
	public Menu() {
		intialize();
	}
	
	public Menu(Student student) {
		intialize();
		this.student = student;
	
	}
	
	public void intialize(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(57, 11, 328, 489);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Main Menu");
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		label.setBounds(97, 11, 154, 32);
		panel.add(label);
		
		JButton button = new JButton("Student Menu");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentMenu = new StudentMenu(student);
				studentMenu.setVisible(true);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBounds(62, 49, 226, 70);
		panel.add(button);
		
		JButton btnDeptMenu = new JButton("Department Menu");
		btnDeptMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deptMenu = new DepartmentMenu();
				deptMenu.setVisible(true);
			}
		});
		btnDeptMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDeptMenu.setBounds(62, 130, 226, 80);
		panel.add(btnDeptMenu);
		
		JButton button_2 = new JButton("Subject Menu");
		button_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_2.setBounds(62, 221, 226, 80);
		panel.add(button_2);
		
		JButton button_3 = new JButton("Lecturer Menu");
		button_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_3.setBounds(62, 312, 226, 70);
		panel.add(button_3);
		
		JButton button_4 = new JButton("Course Menu");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_4.setBounds(62, 393, 226, 70);
		panel.add(button_4);
	}

}
