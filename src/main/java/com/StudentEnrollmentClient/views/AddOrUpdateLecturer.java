package com.StudentEnrollmentClient.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import com.StudentEnrollmentClient.domain.Lecturer;
import com.StudentEnrollmentClient.domain.Student;
import com.StudentEnrollmentClient.rest.Impl.LecturerRestImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddOrUpdateLecturer extends JFrame {

	private JPanel contentPane;
	private JTextField txtLecturerName;
	private JTextField txtLecturerSurname;
	Lecturer lecturer;
	private Student student;
	private String message;
	private LecturerRestImpl lecturerService = new LecturerRestImpl();

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
		//initialize();
	}
	
	public AddOrUpdateLecturer(Student student, String message) {
		initialize();
		this.student = student;
		this.message = message;
		
		switch (message)
		{
		case "UPDATE":
			txtLecturerName.setText(lecturer.getName());
			txtLecturerSurname.setText(lecturer.getSurname());
			break;
		default:
			break;
		}
	}
	
	
	public void initialize() {
		setResizable(false);
		setTitle("Add Or Update Lecturer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 310);
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
		btnSaveLecturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switch(message)
				{
				case "UPDATE":
					if (!txtLecturerName.getText().equals("") && !txtLecturerSurname.getText().equals(""))
					{
						String name = txtLecturerName.getText();
						String surname = txtLecturerSurname.getText();
						
						//update lecturer
						lecturer.setName(name);
						lecturer.setSurname(surname);
						lecturerService.put(lecturer);
						
						Lecturer updatedLecturer = lecturerService.get(lecturer.getId());
						if (!updatedLecturer.equals( lecturer))
							JOptionPane.showMessageDialog(null,"LECTURER HAS BEEN UPDATED!!", "SUCCESS",JOptionPane.INFORMATION_MESSAGE);
					}
				case "ADD":
					if (!txtLecturerName.getText().equals("") && !txtLecturerSurname.getText().equals(""))
					{
						String name = txtLecturerName.getText();
						String surname = txtLecturerSurname.getText();
						
						//add lecturer
						Lecturer lecturer = lecturerService.post(new Lecturer(name, surname));
						
						if (lecturer != null) 
							JOptionPane.showMessageDialog(null,"LECTURER ADDED!!", "SUCCESS",JOptionPane.INFORMATION_MESSAGE);
					}
					else
						JOptionPane.showMessageDialog(null,
								"PLEASE ENSURE THAT ALL FIELDS ARE FILLED",
								"INFO", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnSaveLecturer.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSaveLecturer.setBounds(68, 207, 169, 39);
		contentPane.add(btnSaveLecturer);
		
		JLabel lblLecturerSurname = new JLabel("Lecturer Surname:");
		lblLecturerSurname.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLecturerSurname.setBounds(29, 140, 162, 20);
		contentPane.add(lblLecturerSurname);
		
		txtLecturerSurname = new JTextField();
		txtLecturerSurname.setColumns(10);
		txtLecturerSurname.setBounds(201, 140, 177, 25);
		contentPane.add(txtLecturerSurname);
		
		JButton btnCancelLecturer = new JButton("Cancel");
		btnCancelLecturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LecturerMenu lecturerMenu = new LecturerMenu(student);
				lecturerMenu.setVisible(true);
				dispose();
			}
		});
		btnCancelLecturer.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCancelLecturer.setBounds(306, 207, 169, 39);
		contentPane.add(btnCancelLecturer);
	}

}
