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

public class EnrollementMenu extends JFrame {

	private JPanel contentPane;
	private JButton btnView = new JButton("View");
	private Student student;
	private ProgressStatusServiceImpl progressService = new ProgressStatusServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnrollementMenu frame = new EnrollementMenu();
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
	public EnrollementMenu() {

	}

	public EnrollementMenu(Student student) {
		this.student = student;
		intialize();
		try {
			ProgressStatus status = progressService.getActive(student.getStudentID(), 1);
			if (status == null)
				btnView.setEnabled(false);
			else
				btnView.setEnabled(true);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void intialize() {
		setResizable(false);
		setTitle("Enrollment Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 306, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(20, 11, 250, 371);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblEnrollment = new JLabel("Enrollment");
		lblEnrollment.setBounds(50, 11, 152, 32);
		panel.add(lblEnrollment);
		lblEnrollment.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));

		JButton btnEnroll = new JButton("Enroll");
		btnEnroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Enrol view = new Enrol(student);
				view.setVisible(true);
				dispose();
			}
		});
		btnEnroll.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEnroll.setBounds(10, 64, 226, 70);
		panel.add(btnEnroll);
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewEnrollment view = new ViewEnrollment(student);
				view.setVisible(true);
				dispose();
			}
		});
		btnView.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnView.setBounds(10, 163, 226, 70);
		panel.add(btnView);

		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu view = new Menu(student);
				view.setVisible(true);
				dispose();
			}
		});
		btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnMainMenu.setBounds(10, 261, 226, 70);
		panel.add(btnMainMenu);
	}
}
