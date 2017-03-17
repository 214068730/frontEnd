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
import com.StudentEnrollmentClient.utils.AppUtil;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddOrUpdateStudent extends JFrame {

	private JPanel contentPane;
	private String message;
	private Student student;
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
	private AppUtil util = new AppUtil();
	private JLabel lblAccessRights = new JLabel("Access Rights:");

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
		// intialize();
	}

	public AddOrUpdateStudent(Student student, String message) {
		intialize();
		this.student = student;
		this.message = message;
		switch (message) {
		case "UPDATE":
			load(student);
			accessRights();
			break;
		default:
			break;
		}
	}

	public void accessRights() {
		// Access Rights
		String role = student.getRole().getRole();
		switch (role) {
		case "B":
			lblAccessRights.setVisible(false);
			ddlRights.setVisible(false);
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
		txtStudentIdNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		txtStudentIdNumber.setBounds(187, 91, 248, 29);
		panStudInfo.add(txtStudentIdNumber);
		txtStudentIdNumber.setColumns(10);

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
						if (txtStudentIdNumber.getText().length() == 13) {
							if (!student.getStudentIdNumber().trim().equals(txtStudentIdNumber.getText().trim())|| !student.getStudentName().trim().equals(txtStudentName.getText().trim())|| !student.getStudentSurname().trim().equals(txtStudentSurname.getText().trim())|| !student.getStudentAddress().getStreetName().trim().equals(txtStreetName.getText().trim())|| !student.getStudentAddress().getSurbubName().trim().equals(txtSuburb.getText().trim())|| !student.getStudentAddress().getAreaCode().trim().equals(txtAreaCode.getText().trim())|| !student.getStudentAddress().getStreetNumber().trim().equals( txtStreetNumber.getText().trim())){
								if (update() == true)
									JOptionPane.showMessageDialog(null, util.getRecordsUpdated(),"UPDATED",JOptionPane.INFORMATION_MESSAGE);// update
								else
									JOptionPane.showMessageDialog(null,util.getRecordsNotUpdated()+"\nID number already exist","ERROR",JOptionPane.ERROR_MESSAGE);// update
						}
					}
					else
						JOptionPane.showMessageDialog(null,"ID FIELD MUST BE 13 DIGITS LONG", "INFO",JOptionPane.INFORMATION_MESSAGE);
					} 
					else
						JOptionPane.showMessageDialog(null,util.getRecordsFilled(),"INFO", JOptionPane.INFORMATION_MESSAGE);
					break;
				case "ADD":
					if (!txtStudentName.getText().equals("")&& !txtStudentSurname.getText().equals("")&& !txtStudentIdNumber.getText().equals("")&& !txtStreetName.getText().equals("")&& !txtSuburb.getText().equals("")&& !txtAreaCode.getText().equals("")) {
						if (txtStudentIdNumber.getText().length() == 13){
							if(add() == true)
								JOptionPane.showMessageDialog(null,util.getRecordsAdded(),"SUCCESS",JOptionPane.INFORMATION_MESSAGE);// add
							else
								JOptionPane.showMessageDialog(null,util.getRecordsNotAdded()+"\nID  number already exist","ERROR",JOptionPane.ERROR_MESSAGE);// not add
						}
						else
							JOptionPane.showMessageDialog(null,"ID FIELD MUST BE 13 DIGITS LONG", "INFO",JOptionPane.INFORMATION_MESSAGE);
					}
					else
						JOptionPane.showMessageDialog(null,util.getRecordsFilled(),"INFO", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSave.setBounds(566, 297, 184, 59);
		contentPane.add(btnSave);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String role = student.getRole().getRole();

				switch (role) {
				case "A":
					StudentMenu menu = new StudentMenu(student);
					menu.setVisible(true);
					dispose();
					break;
				case "B":
					StudentSubMenu studSubMenu = new StudentSubMenu(student);
					studSubMenu.setVisible(true);
					dispose();
					break;
				}
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
		txtStreetNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		txtStreetNumber.setColumns(10);
		txtStreetNumber.setBounds(159, 139, 64, 29);
		panStudAddress.add(txtStreetNumber);
	}// end

	public boolean update() {
		boolean flag = false;
		String name = txtStudentName.getText().toUpperCase();
		String surname = txtStudentSurname.getText().toUpperCase();
		String idNumber = txtStudentIdNumber.getText().toUpperCase();
		String streetName = txtStreetName.getText().toUpperCase();
		String suburb = txtSuburb.getText().toUpperCase();
		String areaCode = txtAreaCode.getText().toUpperCase();
		String streetNumber = txtStreetNumber.getText().toUpperCase();
		Long role = new Long(ddlRights.getSelectedIndex() + 1);
//		try {
			Roles rights = rolesService.get(role); // getting role from db
			if (rights != null) {
				
				// update student Address
				student.getStudentAddress().setAreaCode(areaCode.trim());
				student.getStudentAddress().setStreetName(streetName.trim());
				student.getStudentAddress().setStreetNumber(streetNumber.trim());
				student.getStudentAddress().setSurbubName(suburb.trim());
				// update student
				student.setStudentName(name.trim());
				student.setStudentSurname(surname.trim());
				student.setRole(rights);
				student.setStudentIdNumber(idNumber.trim());
				
				Student result = studentService.get(student.getStudentID());
				studentService.put(student);
				Student updatedResult = studentService.get(student.getStudentID());
				
				
				if (!result.getStudentIdNumber().trim().equals(updatedResult.getStudentIdNumber().trim())|| !result.getStudentName().trim().equals(updatedResult.getStudentName().trim())|| !result.getStudentSurname().trim().equals(updatedResult.getStudentSurname().trim())|| !result.getStudentAddress().getStreetName().trim().equals(updatedResult.getStudentAddress().getStreetName().trim())|| !result.getStudentAddress().getSurbubName().trim().equals(updatedResult.getStudentAddress().getSurbubName().trim())|| !result.getStudentAddress().getAreaCode().trim().equals(updatedResult.getStudentAddress().getAreaCode().trim())|| !result.getStudentAddress().getStreetNumber().trim().equals(updatedResult.getStudentAddress().getStreetNumber().trim()))
					flag = true;
				else
					flag = false;
				load(updatedResult);
			} 
//		} catch (Exception ex) {
//			JOptionPane.showMessageDialog(null, ex.getMessage(), "INFO",JOptionPane.INFORMATION_MESSAGE);
//		}
		return flag;
	}

	public boolean add() {
		boolean flag = false;
		String name = txtStudentName.getText().toUpperCase();
		String surname = txtStudentSurname.getText().toUpperCase();
		String idNumber = txtStudentIdNumber.getText().toUpperCase();
		String streetName = txtStreetName.getText().toUpperCase();
		String suburb = txtSuburb.getText().toUpperCase();
		String areaCode = txtAreaCode.getText().toUpperCase();
		String streetNumber = txtStreetNumber.getText().toUpperCase();
		Long role = new Long(ddlRights.getSelectedIndex() + 1);

//		try {
			Roles rights = rolesService.get(role); // getting role from db

			if (rights != null) {
				Address result = new Address(streetNumber, streetName, suburb,areaCode); // saving address into db
				Student student = studentService.post(new Student(name,surname, result, idNumber, rights)); // saving student												// into db
				if (student != null)
					flag = true;
			}
//		} catch (Exception ex) {
//			JOptionPane.showMessageDialog(null, ex.getMessage(), "INFO",JOptionPane.INFORMATION_MESSAGE);
//		}
		return flag;
	}

	public void load(Student student) {
		txtStudentName.setText(student.getStudentName().trim());
		txtStudentSurname.setText(student.getStudentSurname().trim());
		txtStudentIdNumber.setText(student.getStudentIdNumber().trim());
		txtStreetName.setText(student.getStudentAddress().getStreetName().trim());
		txtSuburb.setText(student.getStudentAddress().getSurbubName().trim());
		txtAreaCode.setText(student.getStudentAddress().getAreaCode().trim());
		String index = student.getRole().getId().toString().trim();
		ddlRights.setSelectedIndex(Integer.parseInt(index) - 1);
		txtStreetNumber.setText(student.getStudentAddress().getStreetNumber().trim());
	}
}
