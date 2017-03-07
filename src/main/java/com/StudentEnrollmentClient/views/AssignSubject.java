package com.StudentEnrollmentClient.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;

import com.StudentEnrollmentClient.domain.Course;
import com.StudentEnrollmentClient.domain.Student;
import com.StudentEnrollmentClient.domain.Subject;
import com.StudentEnrollmentClient.domain.SubjectCourse;
import com.StudentEnrollmentClient.rest.Impl.CourseRestImpl;
import com.StudentEnrollmentClient.rest.Impl.SubjectCourseRestImpl;
import com.StudentEnrollmentClient.rest.Impl.SubjectRestImpl;
import com.StudentEnrollmentClient.services.Impl.SubjectCourseServiceImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class AssignSubject extends JFrame {
	private Student student;
	private CourseRestImpl courseService = new CourseRestImpl();
	private SubjectCourseServiceImpl subjectCourseService = new SubjectCourseServiceImpl();
	private SubjectRestImpl subjectService = new SubjectRestImpl();
	private JComboBox ddlCourses = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AssignSubject frame = new AssignSubject();
					frame.setVisible(true);
					generateTable();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AssignSubject() {
		intialize();
	}

	public AssignSubject(Student student) {

		this.student = student;
		List<Course> courses = courseService.getAll();
		for (Course course : courses) {
			ddlCourses.addItem(course.getCourseName());
		}
		intialize();

	}

	private void intialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 842, 556);
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
		pane.setBounds(10, 116, 806, 313);
		panel.add(pane);
		setContentPane(panel);

		JLabel lblSubjectSelection = new JLabel("Subject Selection");
		lblSubjectSelection.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC,
				26));
		lblSubjectSelection.setBounds(297, 11, 233, 32);
		panel.add(lblSubjectSelection);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row = table.getSelectedRow();
				try{
				if (row != -1) {
					String courseName = ddlCourses.getSelectedItem().toString();
					String subjectCode = table.getValueAt(row, 0).toString();
					Subject subject = subjectService.getSubjectCode(subjectCode); 
					Course course = courseService.getByName(courseName);
					SubjectCourse subjectCourse = subjectCourseService.save(new SubjectCourse(course,subject));
					if(subjectCourse != null)
						JOptionPane.showMessageDialog(null,"SUBJECT HAD BEEN ADDED", "INFO",JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null,"SUBJECT ALREADY EXIST IN THE COURSE", "INFO",JOptionPane.ERROR_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(null,"NO SUBJECT SELECTED", "INFO",JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null,ex.getMessage(), "ERROR",JOptionPane.ERROR_MESSAGE);
				}
					

			}
		});
		btnAdd.setBounds(546, 466, 130, 41);
		panel.add(btnAdd);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SubjectMenu subjectMenu = new SubjectMenu();
				subjectMenu.setVisible(true);
				dispose();
			}
		});
		btnCancel.setBounds(686, 466, 130, 41);
		panel.add(btnCancel);

		ddlCourses.setBounds(10, 73, 233, 25);
		panel.add(ddlCourses);
	}

	public static void generateTable() {

	}

	public void reloadTable(JTable table, DefaultTableModel model) {
		Object[] columnsName = new Object[3];
		Object[] rowData = new Object[3];
		columnsName[0] = "SUBJECT CODE";
		columnsName[1] = "SUBJECT NAME";
		columnsName[2] = "SUBJECT PRICE";
		model.setColumnIdentifiers(columnsName);

		List<Subject> subjects = subjectService.getAll();
		for (Subject sub : subjects) {
			rowData[0] = sub.getSubjectCode();
			rowData[1] = sub.getSubjectName();
			rowData[2] = sub.getPrice();

			model.addRow(rowData);
		}
	}

}
