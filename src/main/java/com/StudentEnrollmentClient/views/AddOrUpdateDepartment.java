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

import com.StudentEnrollmentClient.domain.Department;
import com.StudentEnrollmentClient.domain.Student;
import com.StudentEnrollmentClient.rest.Impl.DepartmentRestImpl;
import com.StudentEnrollmentClient.rest.Impl.StudentRestImpl;
import com.StudentEnrollmentClient.utils.AppUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddOrUpdateDepartment extends JFrame {

	private JPanel contentPane;
	private JTextField txtDeptName;
	Department department;
	private Student student;
	private String message;
	private DepartmentRestImpl departmentService = new DepartmentRestImpl();
	private AppUtil util = new AppUtil();

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
	
	public AddOrUpdateDepartment(){
		//initialize();
	}
	
	public AddOrUpdateDepartment(Student  student){
		initialize();
		this.student = student;
		this.message = message;	
//		switch(message)
//		{
//		case "UPDATE":
//			txtDeptName.setText(department.getDepartmentName());
//			break;
//		default:
//			break;
//		}
	}

	/**
	 * Create the frame.
	 */
	public void initialize() {
		setResizable(false);
		setTitle("Add Or Update Department");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 266);
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
		btnSaveDept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					if (!txtDeptName.getText().equals(""))
					{
						String name = txtDeptName.getText().toUpperCase();
						Department department = departmentService.post(new Department(name));
						
						if (department != null)
							JOptionPane.showMessageDialog(null,util.getRecordsAdded(), "SUCCESS", JOptionPane.INFORMATION_MESSAGE); // add
						else 
							JOptionPane.showMessageDialog(null,util.getRecordsNotAdded()+"\ndepartment name already exist", "ERROR", JOptionPane.ERROR_MESSAGE); //error
					}
					else
						JOptionPane.showMessageDialog(null,util.getRecordsFilled(),"INFO", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnSaveDept.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSaveDept.setBounds(68, 149, 164, 40);
		contentPane.add(btnSaveDept);
		
		JButton btnCancelDept = new JButton("Cancel");
		btnCancelDept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DepartmentMenu deptMenu = new DepartmentMenu(student);
				deptMenu.setVisible(true);
				dispose();
			}
		});
		btnCancelDept.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelDept.setBounds(279, 149, 164, 40);
		contentPane.add(btnCancelDept);
	}

}
