package com.StudentEnrollmentClient.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import com.StudentEnrollmentClient.domain.Course;
import com.StudentEnrollmentClient.domain.Student;
import com.StudentEnrollmentClient.services.Impl.CourseServiceImpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewCourse extends JFrame {

	private JPanel contentPane;
	private Student student;
	private CourseServiceImpl courseService = new CourseServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCourse frame = new ViewCourse();
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
	public ViewCourse() {
		intialize();
	}

	public ViewCourse(Student student) {
		intialize();
		this.student = student;
		
	}

	public void intialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1332, 698);
		getContentPane().setLayout(null);
		final JTable table = new JTable() {
			public boolean isCellEditable(int row, int column) {
				if (column == 0 || column == 5)
					return false;
				else
					return true;
			};
		};
		final DefaultTableModel model = new DefaultTableModel();
		reloadTable(table, model);

		table.setModel(model);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(10, 73, 1296, 433);
		panel.add(pane);
		setContentPane(panel);

		JLabel lblSubjectSelection = new JLabel("Courses");
		lblSubjectSelection.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC,
				26));
		lblSubjectSelection.setBounds(609, 26, 110, 32);
		panel.add(lblSubjectSelection);

		JButton btnAdd = new JButton("Update");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setBounds(1019, 607, 130, 42);
		panel.add(btnAdd);

		JButton btnCancel = new JButton("Menu");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancel.setBounds(1176, 607, 130, 42);
		panel.add(btnCancel);
	}

	public void reloadTable(JTable table, DefaultTableModel model) {
		Object[] columnsName = new Object[4];
		Object[] rowData = new Object[4];
		columnsName[0] = "COURSE ID";
		columnsName[1] = "COURSE CODE";
		columnsName[2] = "COURSE SUBJECT";
		columnsName[3] = "DEPARTMENT";
		model.setColumnIdentifiers(columnsName);
		
		List<Course>courses = courseService.findAll();
		for(Course course : courses){
			rowData[0] = course.getId();
			rowData[1] = course.getCourseCode();
			rowData[2] = course.getCourseName();
			rowData[3] = course.getDepartment().getDepartmentName();
			model.addRow(rowData);
		}
	}

}
