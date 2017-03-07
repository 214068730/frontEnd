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
import com.StudentEnrollmentClient.rest.Impl.DepartmentRestImpl;
import com.StudentEnrollmentClient.rest.Impl.StudentRestImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddOrUpdateDepartment extends JFrame {

	private JPanel contentPane;
	private JTextField txtDeptName;
	Department department;
	private String message;
	private DepartmentRestImpl departmentService = new DepartmentRestImpl();

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
		initialize();
	}
	
	public AddOrUpdateDepartment(Department department, String message){
		initialize();
		this.department = department;
		this.message = message;	
		switch(message)
		{
		case "UPDATE":
			txtDeptName.setText(department.getDepartmentName());
			break;
		default:
			break;
		}
	}

	/**
	 * Create the frame.
	 */
	public void initialize() {
		setResizable(false);
		setTitle("Add Or Update Department");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 300);
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
				switch(message)
				{
				//case "UPDATE":
					//break;
				case "ADD":
					if (!txtDeptName.getText().equals(""))
					{
						String name = txtDeptName.getText();
						Department department = departmentService.post(new Department(name));
						
						if (department != null)
						{
							JOptionPane.showMessageDialog(null, "DEPARTMENT ADDED!!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
						}
						
						/*Department updatedLecturer = lecturerService.get(lecturer.getId());
						if (!updatedDepartment.equals( department))
							JOptionPane.showMessageDialog(null,"DEPARTMENT HAS BEEN UPDATED!!", "SUCCESS",JOptionPane.INFORMATION_MESSAGE);
						 * else if (txtDeptName.getText().matches(name)) //check if it exist
						{
							JOptionPane.showMessageDialog(null, "DEPARTMENT ALREADY EXIST!!", "ENTER A NEW ONE", JOptionPane.INFORMATION_MESSAGE);
						}*/
					}
					else
					{
						JOptionPane.showMessageDialog(null,
								"PLEASE ENSURE THAT ALL FIELDS ARE FILLED",
								"INFO", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnSaveDept.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSaveDept.setBounds(59, 149, 120, 40);
		contentPane.add(btnSaveDept);
		
		JButton btnUpdateDept = new JButton("Update");
		btnUpdateDept.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdateDept.setBounds(215, 149, 120, 40);
		contentPane.add(btnUpdateDept);
		
		JButton btnCancelDept = new JButton("Cancel");
		btnCancelDept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnCancelDept.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelDept.setBounds(370, 149, 120, 40);
		contentPane.add(btnCancelDept);
	}

}
