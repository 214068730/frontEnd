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

public class SubjectMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SubjectMenu frame = new SubjectMenu();
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
	public SubjectMenu() {
		setTitle("Subject Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Subject Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(219, 0, 216, 49);
		contentPane.add(lblNewLabel);
		
		JButton btnAddSubject = new JButton("Add Subject");
		btnAddSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.hide();
				AddOrUpdateSubject addSubject = new AddOrUpdateSubject();
				addSubject.setVisible(true);
			}
		});
		btnAddSubject.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddSubject.setBounds(204, 82, 236, 63);
		contentPane.add(btnAddSubject);
		
		JButton btnUpdateSubject = new JButton("Update Subject");
		btnUpdateSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.hide();
				AddOrUpdateSubject updateSubject = new AddOrUpdateSubject();
				updateSubject.setVisible(true);
			}
		});
		btnUpdateSubject.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdateSubject.setBounds(204, 175, 236, 63);
		contentPane.add(btnUpdateSubject);
		
		JButton btnViewSubjects = new JButton("View Subject(s)");
		btnViewSubjects.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.hide();
				ViewSubject viewSubject = new ViewSubject();
				viewSubject.setVisible(true);
			}
		});
		btnViewSubjects.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnViewSubjects.setBounds(204, 270, 236, 63);
		contentPane.add(btnViewSubjects);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//contentPane.hide();
				//MainMenu mainMenu = new MainMenu();
				//mainMenu.
			}
		});
		btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnMainMenu.setBounds(204, 357, 236, 63);
		contentPane.add(btnMainMenu);
	}

}
