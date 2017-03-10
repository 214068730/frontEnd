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

import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import com.StudentEnrollmentClient.domain.Address;
import com.StudentEnrollmentClient.domain.Roles;
import com.StudentEnrollmentClient.domain.Student;
import com.StudentEnrollmentClient.rest.Impl.AddressRestImpl;
import com.StudentEnrollmentClient.rest.Impl.RolesRestImpl;
import com.StudentEnrollmentClient.rest.Impl.StudentRestImpl;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddOrUpdateStudent extends JFrame {

	private JPanel contentPane;
	private String message;
	Student student;
	private JTextField txtStudentName;
	private JTextField txtStudentSurname;
	private JTextField txtStudentIdNumber;
	private JTextField txtStreetName;
	private JTextField txtSuburb;
	private JTextField txtAreaCode;
	private JTextField txtStreetNumber;
	final JComboBox ddlRights = new JComboBox();
	private AddressRestImpl addressService = new AddressRestImpl();
	private StudentRestImpl studentService = new StudentRestImpl();
	private RolesRestImpl rolesService = new RolesRestImpl();

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
		intialize();
	}

	public AddOrUpdateStudent(Student student, String message) {
		intialize();
		this.student = student;
		this.message = message;
		switch (message) {
		case "UPDATE":
			txtStudentName.setText(student.getStudentName());
			txtStudentSurname.setText(student.getStudentSurname());
			txtStudentIdNumber.setText(student.getStudentIdNumber());
			txtStreetName.setText(student.getStudentAddress().getStreetName());
			txtSuburb.setText(student.getStudentAddress().getSurbubName());
			txtAreaCode.setText(student.getStudentAddress().getAreaCode());
			String index = student.getRole().getId().toString();
			ddlRights.setSelectedIndex(Integer.parseInt(index)-1);//minus one because db index start from 1
			txtStreetNumber.setText(student.getStudentAddress().getStreetNumber());
			
			break;
		default:
			break;
		}
	}

	public void intialize() {
		setResizable(false);
		setTitle("Add Or Update Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 972, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Panel panStudInfo = new Panel();
		panStudInfo.setBounds(20, 87, 458, 170);
		contentPane.add(panStudInfo);
		panStudInfo.setLayout(null);

		JLabel lblStudentName = new JLabel("Student Name:");
		lblStudentName.setBounds(21, 16, 147, 14);
		panStudInfo.add(lblStudentName);
		lblStudentName.setFont(new Font("Tahoma", Font.BOLD, 16));

		txtStudentName = new JTextField();
		txtStudentName.setBounds(187, 11, 248, 29);
		panStudInfo.add(txtStudentName);
		txtStudentName.setColumns(10);

		JLabel lblStudentSurname = new JLabel("Student Surname:");
		lblStudentSurname.setBounds(21, 62, 183, 14);
		panStudInfo.add(lblStudentSurname);
		lblStudentSurname.setFont(new Font("Tahoma", Font.BOLD, 16));

		txtStudentSurname = new JTextField();
		txtStudentSurname.setBounds(187, 51, 248, 29);
		panStudInfo.add(txtStudentSurname);
		txtStudentSurname.setColumns(10);

		JLabel lblStudentIdnumber_1 = new JLabel("Student IDNumber:");
		lblStudentIdnumber_1.setBounds(21, 104, 171, 14);
		panStudInfo.add(lblStudentIdnumber_1);
		lblStudentIdnumber_1.setFont(new Font("Tahoma", Font.BOLD, 16));

		txtStudentIdNumber = new JTextField();
		txtStudentIdNumber.setBounds(187, 91, 248, 29);
		panStudInfo.add(txtStudentIdNumber);
		txtStudentIdNumber.setColumns(10);

		JLabel lblAccessRights = new JLabel("Access Rights:");
		lblAccessRights.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAccessRights.setBounds(21, 131, 171, 28);
		panStudInfo.add(lblAccessRights);

		
		ddlRights.setModel(new DefaultComboBoxModel(new String[] { "A", "B" }));
		ddlRights.setSelectedIndex(0);
		ddlRights.setBounds(187, 137, 64, 20);
		panStudInfo.add(ddlRights);

		JLabel lblAddupdateStudent = new JLabel("STUDENT DETAILS ");
		lblAddupdateStudent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC,
				24));
		lblAddupdateStudent.setBounds(373, 11, 345, 59);
		contentPane.add(lblAddupdateStudent);

		final JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (message) {
				case "UPDATE":
					if (!txtStudentName.getText().equals("")&& !txtStudentSurname.getText().equals("")&& !txtStudentIdNumber.getText().equals("")&& !txtStreetName.getText().equals("")&& !txtSuburb.getText().equals("")&& !txtAreaCode.getText().equals("")) {
						String name = txtStudentName.getText();
						String surname = txtStudentSurname.getText();
						String idNumber = txtStudentIdNumber.getText();
						String streetName = txtStreetName.getText();
						String suburb = txtSuburb.getText();
						String areaCode = txtAreaCode.getText();
						String streetNumber = txtStreetNumber.getText();
						Long role = new Long(ddlRights.getSelectedIndex() + 1);
						try{
							Roles rights = rolesService.get(role); //getting role from db
							if (rights != null){
								//update student Address
								student.getStudentAddress().setAreaCode(areaCode);
								student.getStudentAddress().setStreetName(streetName);
								student.getStudentAddress().setStreetNumber(streetNumber);
								student.getStudentAddress().setSurbubName(suburb);
								
								//update student
								student.setStudentName(name);
								student.setStudentSurname(surname);
								student.setRole(rights);
								
								studentService.put(student);
								Student updatedStudent = studentService.get(student.getStudentID());
								if (!updatedStudent.equals( student))
									JOptionPane.showMessageDialog(null,"STUDENT HAS BEEN UPDATED!!", "SUCCESS",JOptionPane.INFORMATION_MESSAGE);
							}
						}catch(Exception ex){
							JOptionPane.showMessageDialog(null,ex.getMessage(), "INFO",JOptionPane.INFORMATION_MESSAGE);
						}
					}
					break;
				case "ADD":
					if (!txtStudentName.getText().equals("")&& !txtStudentSurname.getText().equals("")&& !txtStudentIdNumber.getText().equals("")&& !txtStreetName.getText().equals("")&& !txtSuburb.getText().equals("")&& !txtAreaCode.getText().equals("")) {
						String name = txtStudentName.getText();
						String surname = txtStudentName.getText();
						String idNumber = txtStudentIdNumber.getText();
						String streetName = txtStreetName.getText();
						String suburb = txtSuburb.getText();
						String areaCode = txtAreaCode.getText();
						String streetNumber = txtStreetNumber.getText();
						Long role = new Long(ddlRights.getSelectedIndex() + 1);

						try {
							Roles rights = rolesService.get(role); //getting role from db
							
							if (rights != null) {
								Address result = new Address(streetNumber, streetName,suburb, areaCode); //saving address into db
								Student student = studentService.post(new Student(name, surname,result, idNumber, rights)); //saving student into db
								if (student != null) 
									JOptionPane.showMessageDialog(null,"STUDENT HAS ADDED!!", "SUCCESS",JOptionPane.INFORMATION_MESSAGE);
							}
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,ex.getMessage(), "INFO",JOptionPane.INFORMATION_MESSAGE);
						}
					}
					else
						JOptionPane.showMessageDialog(null,
								"PLEASE ENSURE THAT ALL FIELDS ARE FILLED",
								"INFO", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSave.setBounds(566, 297, 184, 59);
		contentPane.add(btnSave);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentMenu menu = new StudentMenu(student);
				menu.setVisible(true);
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCancel.setBounds(760, 297, 184, 59);
		contentPane.add(btnCancel);

		Panel panStudAddress = new Panel();
		panStudAddress.setBounds(521, 83, 423, 174);
		contentPane.add(panStudAddress);
		panStudAddress.setLayout(null);

		txtStreetName = new JTextField();
		txtStreetName.setColumns(10);
		txtStreetName.setBounds(159, 9, 248, 29);
		panStudAddress.add(txtStreetName);

		txtSuburb = new JTextField();
		txtSuburb.setColumns(10);
		txtSuburb.setBounds(159, 49, 248, 29);
		panStudAddress.add(txtSuburb);

		txtAreaCode = new JTextField();
		txtAreaCode.setColumns(10);
		txtAreaCode.setBounds(159, 97, 64, 29);
		panStudAddress.add(txtAreaCode);

		JLabel lblStreetName = new JLabel("Street Name:");
		lblStreetName.setBounds(10, 18, 139, 20);
		panStudAddress.add(lblStreetName);
		lblStreetName.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblSurbubName = new JLabel("Surbub Name:");
		lblSurbubName.setBounds(10, 58, 139, 20);
		panStudAddress.add(lblSurbubName);
		lblSurbubName.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblAreaCode = new JLabel("Area Code:");
		lblAreaCode.setBounds(10, 106, 139, 20);
		panStudAddress.add(lblAreaCode);
		lblAreaCode.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblStreetNo = new JLabel("Street NO:");
		lblStreetNo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStreetNo.setBounds(10, 148, 139, 20);
		panStudAddress.add(lblStreetNo);

		txtStreetNumber = new JTextField();
		txtStreetNumber.setColumns(10);
		txtStreetNumber.setBounds(159, 139, 64, 29);
		panStudAddress.add(txtStreetNumber);
	}

}
