package com.StudentEnrollmentClient.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

import com.StudentEnrollmentClient.domain.Course;
import com.StudentEnrollmentClient.domain.ProgressStatus;
import com.StudentEnrollmentClient.domain.Student;
import com.StudentEnrollmentClient.domain.StudentCourse;
import com.StudentEnrollmentClient.domain.Subject;
import com.StudentEnrollmentClient.domain.SubjectCourse;
import com.StudentEnrollmentClient.services.Impl.CourseServiceImpl;
import com.StudentEnrollmentClient.services.Impl.ProgressStatusServiceImpl;
import com.StudentEnrollmentClient.services.Impl.StudentCourseServiceImpl;
import com.StudentEnrollmentClient.services.Impl.SubjectCourseServiceImpl;
import com.StudentEnrollmentClient.services.Impl.SubjectServiceImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Enrol extends JFrame {

	private JPanel contentPane;
	private Student student;
	private JComboBox ddlCourses = new JComboBox();
	private JLabel lblFullName = new JLabel("New label");
	private JLabel lblStudentNumber = new JLabel("New label");
	private JLabel lblIDNumber = new JLabel("New label");
	private JLabel lblDate = new JLabel("Date");
	private CourseServiceImpl courseService = new CourseServiceImpl();
	private SubjectCourseServiceImpl subjectCourseService = new SubjectCourseServiceImpl();
	private ProgressStatusServiceImpl progressStatusService = new ProgressStatusServiceImpl();
	private SubjectServiceImpl subjectService = new SubjectServiceImpl();
	private StudentCourseServiceImpl studentCourseService = new StudentCourseServiceImpl();
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	private Date date = new Date();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Enrol frame = new Enrol();
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
	public Enrol() {
		intialize();
	}

	public Enrol(Student student) {
		this.student = student;
		List<Course> courses = courseService.findAll();
		for (Course course : courses) {
			ddlCourses.addItem(course.getCourseName());
		}
		lblFullName.setText(student.getStudentName() + " "
				+ student.getStudentSurname());
		lblIDNumber.setText(student.getStudentIdNumber());
		lblStudentNumber.setText(student.getStudentNumber());
		lblDate.setText(dateFormat.format(date).toString());
		intialize();
	}

	public void intialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 641);
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
		
		loadSubjects(table, model);//loading data in table
		table.setModel(model);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(268, 222, 391, 264);
		panel.add(pane);
		setContentPane(panel);

		JLabel lblSubjectSelection = new JLabel("ENROLLMENT");
		lblSubjectSelection.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubjectSelection.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC,
				26));
		lblSubjectSelection.setBounds(172, 26, 330, 32);
		panel.add(lblSubjectSelection);

		JButton btnAdd = new JButton("Menu");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu view = new Menu(student);
				view.setVisible(true);
				dispose();

			}
		});
		btnAdd.setBounds(541, 537, 130, 42);
		panel.add(btnAdd);

		JButton btnCancel = new JButton("Enroll");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Course resultCourse = courseService.getByName(ddlCourses.getSelectedItem().toString());
				boolean isRegistered = false;
				ProgressStatus status = progressStatusService.findByStudentStudentIDAndActive(student.getStudentID(), 1, resultCourse.getId());
				if (status == null) {
					JOptionPane.showMessageDialog(null, "already registred","INFO", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,status.getCurrentYear(), "INFO",JOptionPane.INFORMATION_MESSAGE);
					List<Subject> subjects = subjectService.getAllBySubjectLevel(resultCourse.getId(),student.getStudentID());
					for (Subject subject : subjects) {
						isRegistered = false;
						StudentCourse studentCourse = studentCourseService.save(new StudentCourse(resultCourse, student,subject));
						isRegistered = true;
					}
					if(isRegistered == false)
						JOptionPane.showMessageDialog(null, "NOT REGISTERED","INFO", JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "YOU HAVE SUCCESSFULLY REGISTERED!!!","INFO", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnCancel.setBounds(401, 537, 130, 42);
		panel.add(btnCancel);
		ddlCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadSubjects(table, model);
			}
		});

		ddlCourses.setBounds(22, 218, 222, 25);
		panel.add(ddlCourses);

		JPanel panelDetails = new JPanel();
		panelDetails.setBounds(22, 92, 276, 81);
		panel.add(panelDetails);
		panelDetails.setLayout(null);

		JLabel lblNewLabel = new JLabel("Fullname: ");
		lblNewLabel.setBounds(10, 12, 60, 14);
		panelDetails.add(lblNewLabel);

		lblFullName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFullName.setBounds(117, 11, 149, 14);
		panelDetails.add(lblFullName);

		JLabel lblStudentNumber_1 = new JLabel("Student Number: ");
		lblStudentNumber_1.setBounds(10, 37, 120, 14);
		panelDetails.add(lblStudentNumber_1);

		lblStudentNumber.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStudentNumber.setBounds(117, 36, 149, 14);
		panelDetails.add(lblStudentNumber);

		JLabel IdNumber = new JLabel("ID Number:");
		IdNumber.setBounds(10, 62, 101, 14);
		panelDetails.add(IdNumber);

		lblIDNumber.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIDNumber.setBounds(117, 61, 149, 14);
		panelDetails.add(lblIDNumber);

		lblDate.setBounds(577, 41, 65, 14);
		panel.add(lblDate);
	}

	public void reloadTable(JTable table, DefaultTableModel model, Course course) {
		Object[] columnsName = new Object[3];
		Object[] rowData = new Object[3];
		columnsName[0] = "SUBJECT CODE";
		columnsName[1] = "SUBJECT NAME";
		columnsName[2] = "PRICE";
		model.setColumnIdentifiers(columnsName);

		List<SubjectCourse> subjects = subjectCourseService
				.findByCourseCode(course.getId());
		for (SubjectCourse subjectCourse : subjects) {
			rowData[0] = subjectCourse.getSubject().getSubjectCode();
			rowData[1] = subjectCourse.getSubject().getSubjectName();
			rowData[2] = subjectCourse.getSubject().getPrice();
			model.addRow(rowData);
		}
	}

	private void loadSubjects(JTable table, DefaultTableModel model) {
		model.setRowCount(0);
		String courseName = ddlCourses.getSelectedItem().toString();
		Course course = courseService.getByName(courseName);
		reloadTable(table, model, course);
	}
}
