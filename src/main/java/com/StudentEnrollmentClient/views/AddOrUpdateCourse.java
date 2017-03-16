package com.StudentEnrollmentClient.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import com.StudentEnrollmentClient.domain.Course;
import com.StudentEnrollmentClient.domain.Department;
import com.StudentEnrollmentClient.domain.Student;
import com.StudentEnrollmentClient.services.Impl.CourseServiceImpl;
import com.StudentEnrollmentClient.services.Impl.DepartmentServiceImpl;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class AddOrUpdateCourse extends JFrame {

	private JPanel contentPane;
	private Student student;
	private JTextField txtCourseName;
	private JTextField txtCourseCode;
	private JComboBox ddlDepartment = new JComboBox();
	private CourseServiceImpl courseService = new CourseServiceImpl();
	private DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddOrUpdateCourse frame = new AddOrUpdateCourse();
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
	public AddOrUpdateCourse() {
		//intialize();
	}

	public AddOrUpdateCourse(Student student) {
		this.student = student;
		List<Department> departments = departmentService.findAll();
		for(Department department : departments){
			ddlDepartment.addItem(department.getDepartmentName());
		}
		intialize();
	}

	public void intialize() {
		setResizable(false);
		setTitle("Add Or Update Course(s)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAddupdateCourse = new JLabel("ADD COURSE DETAILS");
		lblAddupdateCourse.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddupdateCourse.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC,
				22));
		lblAddupdateCourse.setBounds(220, 11, 266, 44);
		contentPane.add(lblAddupdateCourse);
		
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCourseName.setBounds(10, 99, 162, 20);
		contentPane.add(lblCourseName);
		
		txtCourseName = new JTextField();
		txtCourseName.setColumns(10);
		txtCourseName.setBounds(139, 94, 177, 25);
		contentPane.add(txtCourseName);
		
		JLabel lblCourseCode = new JLabel("Course Code");
		lblCourseCode.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCourseCode.setBounds(10, 130, 162, 20);
		contentPane.add(lblCourseCode);
		
		txtCourseCode = new JTextField();
		txtCourseCode.setColumns(10);
		txtCourseCode.setBounds(139, 130, 177, 25);
		contentPane.add(txtCourseCode);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDepartment.setBounds(383, 99, 119, 20);
		contentPane.add(lblDepartment);
		
		
		ddlDepartment.setBounds(497, 96, 155, 23);
		contentPane.add(ddlDepartment);
		
		JButton button = new JButton("Save");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtCourseName.getText().equals("")&& !txtCourseCode.getText().equals("")){
					String courseName = txtCourseName.getText().toUpperCase();
					String courseCode = txtCourseCode.getText().toUpperCase();
					String departmentName = ddlDepartment.getSelectedItem().toString();
					
					//Getting department by its unique name
				try{
						Department department = departmentService.getByName(departmentName);
						if(department != null){
							//saving course
							Course course =  courseService.save(new Course(courseName,courseCode,department));
							if(course != null)
								JOptionPane.showMessageDialog(null,"RECORD ADDED", "INFO",JOptionPane.INFORMATION_MESSAGE);
							else
								JOptionPane.showMessageDialog(null,"COURSE ALREADY EXIST", "ERROR",JOptionPane.ERROR_MESSAGE);
						}
						
					}catch(Exception ex){
						JOptionPane.showMessageDialog(null,ex.getMessage(), "INFO",JOptionPane.ERROR_MESSAGE);
					}					
				}
				else
					JOptionPane.showMessageDialog(null,"PLEASE FILL IN ALL FIELDS", "INFO",JOptionPane.INFORMATION_MESSAGE);
					
				
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBounds(337, 241, 153, 45);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Cancel");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CourseMenu view = new CourseMenu(student);
				view.setVisible(true);
				dispose();
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_1.setBounds(511, 241, 153, 45);
		contentPane.add(button_1);
	}
}
