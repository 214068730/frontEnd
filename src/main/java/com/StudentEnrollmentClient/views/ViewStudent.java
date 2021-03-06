package com.StudentEnrollmentClient.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import com.StudentEnrollmentClient.domain.Student;
import com.StudentEnrollmentClient.services.Impl.AddressServiceImpl;
import com.StudentEnrollmentClient.services.Impl.StudentServiceImpl;
import com.StudentEnrollmentClient.utils.AppUtil;

import java.awt.Font;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewStudent extends JFrame {

	private JPanel contentPane;
	private Student student;
	private StudentServiceImpl studentService = new StudentServiceImpl();
	private AddressServiceImpl addressService = new AddressServiceImpl();
	private AppUtil util = new AppUtil();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStudent frame = new ViewStudent();
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
	public ViewStudent() {
		//intialize();
	}

	public ViewStudent(Student student) {
		this.student = student;
		intialize();
	}

	public void intialize() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1332, 698);
		getContentPane().setLayout(null);
		final JTable table = new JTable() {
			public boolean isCellEditable(int row, int column) {
				if (column == 0 || column == 4 || column == 8)
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

		JLabel lblSubjectSelection = new JLabel("STUDENTS");
		lblSubjectSelection.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC,
				26));
		lblSubjectSelection.setBounds(609, 26, 147, 32);
		panel.add(lblSubjectSelection);

		JButton btnAdd = new JButton("Update");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				if (row != -1) {
					if (table.isEditing()) {
						table.getCellEditor().stopCellEditing();
						table.setRowSelectionInterval(row, row);
						String id;
						Object[] result = new Object[9];
						for (int i = 0; i < table.getColumnCount(); i++) {
							result[i] = table.getValueAt(row, i);
						}
						id = result[3].toString();
						boolean isNumber = isNumeric(id);//checking if id is a number
						if (isNumber == false)
							JOptionPane.showMessageDialog(null,"ID NUMBER MUST BE DIGITS ONLY", "ERROR",JOptionPane.ERROR_MESSAGE);
						else if (id.length() != 13)
							JOptionPane.showMessageDialog(null,"ID NUMBER MUST BE 13 DIGITS LONG","ERROR", JOptionPane.ERROR_MESSAGE);
						else if(isNumber == true && id.length() == 13){
							try {
								Student student = studentService.findById(Long.parseLong(result[0].toString()));
								if (student != null) {
									if(!result[1].toString().equals("") && !result[2].toString().equals("") && !result[3].toString().equals("") && !result[5].toString().equals("") && !result[6].toString().equals("") && !result[7].toString().equals("")){
										if(!student.getStudentName().equals(result[1].toString()) || !student.getStudentSurname().equals(result[2].toString()) || !student.getStudentIdNumber().equals(result[3].toString()) || !student.getStudentAddress().getStreetName().equals(result[5].toString())|| !student.getStudentAddress().getSurbubName().equals(result[6].toString())|| !student.getStudentAddress().getAreaCode().equals(result[7].toString())){
											boolean update = update(result,id);
											if(update == true)
												JOptionPane.showMessageDialog(null,util.getRecordsUpdated(),"SUCCESS", JOptionPane.INFORMATION_MESSAGE); //update
											else
												JOptionPane.showMessageDialog(null,util.getRecordsNotUpdated()+"\nid number already exist","ERROR", JOptionPane.ERROR_MESSAGE); //not updated
										}
									}
									else
										JOptionPane.showMessageDialog(null,util.getNoBlankFields(),"ERROR", JOptionPane.ERROR_MESSAGE);
								}
							} catch (Exception ex) {
								JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				}
				else
					JOptionPane.showMessageDialog(null,util.getNoRowSelected(),"INFO", JOptionPane.INFORMATION_MESSAGE);
				model.setRowCount(0);
				reloadTable(table, model);
				table.changeSelection(row, col, false, false);

			}
		});
		btnAdd.setBounds(1019, 607, 130, 42);
		panel.add(btnAdd);

		JButton btnCancel = new JButton("Menu");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentMenu mainMenu = new StudentMenu(student);
				mainMenu.setVisible(true);
				dispose();
			}
		});
		btnCancel.setBounds(1176, 607, 130, 42);
		panel.add(btnCancel);
	}

	public void reloadTable(JTable table, DefaultTableModel model) {
		Object[] columnsName = new Object[9];
		Object[] rowData = new Object[9];
		columnsName[0] = "ID";
		columnsName[1] = "NAME";
		columnsName[2] = "SURNAME";
		columnsName[3] = "IDENTIFICATION NUMBER";
		columnsName[4] = "STUDENT NUMBER";
		columnsName[5] = "STREET NAME";
		columnsName[6] = "SUBURB";
		columnsName[7] = "AREA CODE";
		columnsName[8] = "DATE ADDED";
		model.setColumnIdentifiers(columnsName);

		List<Student> students = studentService.findAll();
		for (Student student : students) {
			rowData[0] = student.getStudentID().toString().trim();
			rowData[1] = student.getStudentName();
			rowData[2] = student.getStudentSurname();
			rowData[3] = student.getStudentIdNumber();
			rowData[4] = student.getStudentNumber();
			rowData[5] = student.getStudentAddress().getStreetName();
			rowData[6] = student.getStudentAddress().getSurbubName();
			rowData[7] = student.getStudentAddress().getAreaCode();
			rowData[8] = student.getDateCreated();
			model.addRow(rowData);
		}

	}
	
	public boolean update(Object[] result,String id){
		boolean flag = false;
		Student update = studentService.findById(Long.parseLong(result[0].toString())); 
		update.getStudentAddress().setAreaCode(result[7].toString().toUpperCase());
		update.getStudentAddress().setStreetName(result[5].toString().toUpperCase());
		update.getStudentAddress().setSurbubName(result[6].toString().toUpperCase());
		update.setStudentIdNumber(id.toString().toUpperCase());
		update.setStudentName(result[1].toString().toUpperCase());
		update.setStudentSurname(result[2].toString().toUpperCase());
		
		Student originalStudent = studentService.findById(Long.parseLong(result[0].toString())); //get the original object
		addressService.update(update.getStudentAddress());
		studentService.update(update);
		Student updateStudent = studentService.findById(Long.parseLong(result[0].toString())); //get the updated object
		
		
		if (!originalStudent.getStudentIdNumber().trim().equals(updateStudent.getStudentIdNumber().trim())|| !originalStudent.getStudentName().trim().equals(updateStudent.getStudentName().trim())|| !originalStudent.getStudentSurname().trim().equals(updateStudent.getStudentSurname().trim())|| !originalStudent.getStudentAddress().getStreetName().trim().equals(updateStudent.getStudentAddress().getStreetName().trim())|| !originalStudent.getStudentAddress().getSurbubName().trim().equals(updateStudent.getStudentAddress().getSurbubName().trim())|| !originalStudent.getStudentAddress().getAreaCode().trim().equals(updateStudent.getStudentAddress().getAreaCode().trim()))
			flag = true;
		
		return flag;
	}

	private boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

}
