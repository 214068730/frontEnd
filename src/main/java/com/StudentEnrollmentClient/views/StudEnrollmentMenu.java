package com.StudentEnrollmentClient.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import com.StudentEnrollmentClient.domain.ProgressStatus;
import com.StudentEnrollmentClient.domain.Student;
import com.StudentEnrollmentClient.services.Impl.ProgressStatusServiceImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudEnrollmentMenu extends JFrame {

	private JPanel contentPane;
	private StudentMainMenu studMainMenu;
	private Student student;
	private JButton btnViewStudEnrollment = new JButton("View");
	private ProgressStatusServiceImpl progressService = new ProgressStatusServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudEnrollmentMenu frame = new StudEnrollmentMenu();
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
	public StudEnrollmentMenu() {
		getContentPane().setLayout(null);

	}

	public StudEnrollmentMenu(Student student) {
		this.student = student;
		intialize();
		try {
			ProgressStatus status = progressService.getActive(student.getStudentID(), 1);
			if (status == null)
				btnViewStudEnrollment.setEnabled(false);
			else
				btnViewStudEnrollment.setEnabled(true);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	
	public void intialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentEnrollmentMenu = new JLabel("Student Enrollment Menu");
		lblStudentEnrollmentMenu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblStudentEnrollmentMenu.setBounds(60, 0, 308, 51);
		contentPane.add(lblStudentEnrollmentMenu);
		
		JButton btnNewButton = new JButton("Enroll");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Enrol enrol = new Enrol(student);
				enrol.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(110, 72, 236, 63);
		contentPane.add(btnNewButton);
		
		JButton btnStudentMainMenu = new JButton("Student Main Menu");
		btnStudentMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studMainMenu = new StudentMainMenu(student);
				studMainMenu.setVisible(true);
				dispose();
			}
		});
		btnStudentMainMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnStudentMainMenu.setBounds(110, 247, 236, 63);
		contentPane.add(btnStudentMainMenu);
		
		btnViewStudEnrollment.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnViewStudEnrollment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewEnrollment viewEnrollment = new ViewEnrollment(student);
				viewEnrollment.setVisible(true);
				dispose();
			}
		});
		btnViewStudEnrollment.setBounds(108, 159, 238, 63);
		contentPane.add(btnViewStudEnrollment);
	}
}
