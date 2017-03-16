package com.StudentEnrollmentClient.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JScrollPane;

import java.awt.Component;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.StudentEnrollmentClient.domain.ProgressStatus;
import com.StudentEnrollmentClient.domain.Student;
import com.StudentEnrollmentClient.domain.StudentCourse;
import com.StudentEnrollmentClient.domain.Subject;
import com.StudentEnrollmentClient.services.SubjectService;
import com.StudentEnrollmentClient.services.Impl.ProgressStatusServiceImpl;
import com.StudentEnrollmentClient.services.Impl.StudentCourseServiceImpl;
import com.StudentEnrollmentClient.services.Impl.SubjectServiceImpl;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ViewEnrollment extends JFrame {

	private JPanel contentPane;

	private Enrol enroll;

	private ProgressStatusServiceImpl progressStatusService = new ProgressStatusServiceImpl();
	private Student student;
	private StudentCourseServiceImpl studentCourseService = new StudentCourseServiceImpl();
	private SubjectServiceImpl subjectService = new SubjectServiceImpl();
	private JLabel lblFullname = new JLabel("FullName :");
	private JLabel lblStudentNumber = new JLabel("Student Number: ");
	private JLabel lblIdNumber = new JLabel("IdNumber");
	private JLabel lblDate = new JLabel("Date");
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	private JLabel lblCourse = new JLabel("lblCourse");
	JLabel lblCurrentYear = new JLabel("Current Year :");
	private Date date = new Date();
	private JLabel lblTotal = new JLabel("TOTAL:");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEnrollment frame = new ViewEnrollment();
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

	public ViewEnrollment() {
		intialize();
	}

	public ViewEnrollment(Student student) {

		this.student = student;
		intialize();
		lblFullname.setText(student.getStudentName() + " "
				+ student.getStudentSurname());
		lblStudentNumber.setText(student.getStudentNumber());
		lblIdNumber.setText(student.getStudentIdNumber());
		lblDate.setText(dateFormat.format(date).toString());
		try {
			ProgressStatus status = progressStatusService.getActive(
					student.getStudentID(), 1);
			lblCourse.setText(status.getCourse().getCourseName());
			lblCurrentYear.setText(status.getCurrentYear());

		} catch (Exception ex) {

		}
	}

	public void intialize() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 543);
		getContentPane().setLayout(null);
		final JTable table = new JTable() {
			public boolean isCellEditable(int row, int column) {
				if (column == 0 || column == 3)
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
		pane.setBounds(10, 162, 750, 254);
		panel.add(pane);
		setContentPane(panel);

		JButton btnCancel = new JButton("Cancel Course");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 try {
				ProgressStatus status = progressStatusService.getActive(student.getStudentID(), 1);
				String role = student.getRole().getRole();
				if (status != null) {
					status.setActive(0); // Canceling course
					progressStatusService.update(status);
					ProgressStatus updateStatus = progressStatusService.getActive(student.getStudentID(), 1);
					if(updateStatus == null){
						JOptionPane.showMessageDialog(null,"Course has been cancelled","INFO", JOptionPane.INFORMATION_MESSAGE);
						
						switch (role){
						case "A":
							EnrollementMenu view = new EnrollementMenu(student);
							view.setVisible(true);
							dispose();
							break;
						case "B":
							StudEnrollmentMenu studEnrolMenu = new StudEnrollmentMenu(student);
							studEnrolMenu.setVisible(true);
							dispose();
							break;
						}	
					}
				} 
			 }catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(),
							"INFO", JOptionPane.INFORMATION_MESSAGE);
				}
			}
				
		});
		btnCancel.setBounds(473, 452, 130, 42);
		panel.add(btnCancel);

		JButton btnMenua = new JButton("Menu");
		btnMenua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String role = student.getRole().getRole();
				switch (role){
				case "A":
					EnrollementMenu view = new EnrollementMenu(student);
					view.setVisible(true);
					dispose();
					break;
				case "B":
					StudEnrollmentMenu viewStudEnroll = new StudEnrollmentMenu(student);
					viewStudEnroll.setVisible(true);
					dispose();
					break;
				}				
			}
		});
		btnMenua.setBounds(630, 452, 130, 42);
		panel.add(btnMenua);

		JLabel lblEnrollementDetails = new JLabel("ENROLLEMENT DETAILS");
		lblEnrollementDetails.setFont(new Font("Tahoma", Font.BOLD
				| Font.ITALIC, 26));
		lblEnrollementDetails.setBounds(219, 11, 331, 32);
		panel.add(lblEnrollementDetails);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 71, 642, 80);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblFullname_1 = new JLabel("FullName :");
		lblFullname_1.setBounds(10, 11, 61, 14);
		panel_1.add(lblFullname_1);

		lblFullname.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFullname.setBounds(120, 11, 140, 14);
		panel_1.add(lblFullname);

		JLabel lblStudentNumber_1 = new JLabel("Student Number: ");
		lblStudentNumber_1.setBounds(10, 36, 99, 14);
		panel_1.add(lblStudentNumber_1);

		lblStudentNumber.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStudentNumber.setBounds(120, 36, 157, 14);
		panel_1.add(lblStudentNumber);

		JLabel lblIdNumber_1 = new JLabel("ID Number:");
		lblIdNumber_1.setBounds(10, 61, 99, 14);
		panel_1.add(lblIdNumber_1);

		lblIdNumber.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIdNumber.setBounds(120, 61, 157, 14);
		panel_1.add(lblIdNumber);

		JLabel lblCourse2 = new JLabel("Course :");
		lblCourse2.setBounds(303, 11, 61, 14);
		panel_1.add(lblCourse2);

		lblCourse.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCourse.setBounds(393, 11, 239, 13);
		panel_1.add(lblCourse);

		lblCurrentYear.setBounds(403, 35, 114, 14);
		panel_1.add(lblCurrentYear);

		lblCurrentYear.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCurrentYear.setBounds(393, 35, 140, 14);
		panel_1.add(lblCurrentYear);

		JLabel lblCurrentYear_1 = new JLabel("Current Year :");
		lblCurrentYear_1.setBounds(303, 36, 157, 14);
		panel_1.add(lblCurrentYear_1);

		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDate.setBounds(630, 47, 130, 14);
		panel.add(lblDate);

		JLabel lblNewLabel = new JLabel("TOTAL: R");
		lblNewLabel.setBounds(607, 427, 69, 14);
		panel.add(lblNewLabel);

		lblTotal.setBounds(665, 427, 83, 14);
		panel.add(lblTotal);

	}
	
	public void reloadTable(JTable table, DefaultTableModel model) {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		double total = 0;
		Object[] columnsName = new Object[4];
		Object[] rowData = new Object[4];
		List<Long> numbers = new ArrayList<>();
		columnsName[0] = "SUBJECT CODE";
		columnsName[1] = "SUBJECT NAME";
		columnsName[2] = "SUBJECT LEVEL";
		columnsName[3] = "SUBJECT PRICE";
		model.setColumnIdentifiers(columnsName);

		ProgressStatus status = progressStatusService.getActive(student.getStudentID(), 1);
		List<StudentCourse> studentCourses = studentCourseService.registeredSubjects(student.getStudentID(), status.getCourse().getId());
		List<String> codes = new ArrayList<>();
		
	
		if (studentCourses != null) {
			for (StudentCourse studentCourse : studentCourses) {
					if (studentCourse.getDateRegistered().substring(0, 4).equals(year + "")) {
						if (status.getCourse().getCourseName().equals(studentCourse.getCourse().getCourseName())) {
							codes.add(studentCourse.getSubject().getSubjectCode());
						}
					}
			}
			Set<String> sets = new HashSet<String>(codes);
			
			for(String set : sets){
				Subject sub = subjectService.getSubjectCode(set);
				rowData[0] = sub.getSubjectCode().trim();
				rowData[1] = sub.getSubjectName().trim();
				rowData[2] = sub.getYearCode();
				rowData[3] = sub.getPrice();
				model.addRow(rowData);
				total = total + sub.getPrice();
			}
			lblTotal.setText(total + "");
		}

	}
	
}
		

	

