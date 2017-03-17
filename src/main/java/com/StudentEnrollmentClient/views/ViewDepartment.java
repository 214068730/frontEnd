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

import com.StudentEnrollmentClient.domain.Department;
import com.StudentEnrollmentClient.domain.Lecturer;
import com.StudentEnrollmentClient.domain.Student;
import com.StudentEnrollmentClient.domain.Subject;
import com.StudentEnrollmentClient.services.Impl.DepartmentServiceImpl;
import com.StudentEnrollmentClient.utils.AppUtil;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewDepartment extends JFrame {

	private JPanel contentPane;
	private Student student;
	private DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
	private AppUtil util = new AppUtil();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDepartment frame = new ViewDepartment();
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
	public ViewDepartment() {
		//initialize();
	}

	public ViewDepartment(Student student) {
		initialize();
		this.student = student;
	}

	public void initialize() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1114, 648);
		getContentPane().setLayout(null);
		final JTable table = new JTable() {
			public boolean isCellEditable(int row, int column) {
				if (column == 0 || column == 2)
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
		pane.setBounds(10, 73, 1078, 433);
		panel.add(pane);
		setContentPane(panel);

		JLabel lblSubjectSelection = new JLabel("Departments");
		lblSubjectSelection.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC,
				26));
		lblSubjectSelection.setBounds(488, 25, 217, 32);
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

						Object[] result = new Object[3];// 3 is the number of columns
						for (int i = 0; i < table.getColumnCount(); i++) {
							result[i] = table.getValueAt(row, i);
						}
						try {
							Long id = Long.parseLong(result[0].toString());
							Department originalDepartment = departmentService.findById(id);// original object
							if(!result[1].toString().equals("")){
								if(!originalDepartment.getDepartmentName().equals(result[1].toString())){
									boolean update = update(result);
									if(update == true)
										JOptionPane.showMessageDialog(null,util.getRecordsUpdated(), "SUCCESS",JOptionPane.INFORMATION_MESSAGE); //update
									else
										JOptionPane.showMessageDialog(null,util.getRecordsNotUpdated()+"\ndepartment name already exist", "ERROR",JOptionPane.ERROR_MESSAGE);
								}
							}
							else
								JOptionPane.showMessageDialog(null,util.getNoBlankFields(), "ERROR",JOptionPane.ERROR_MESSAGE);
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,ex.getMessage(), "ERROR",JOptionPane.ERROR_MESSAGE);
						}
					}
				} else
					JOptionPane.showMessageDialog(null,util.getNoRowSelected(),"INFO", JOptionPane.INFORMATION_MESSAGE);
				model.setRowCount(0);
				reloadTable(table, model);
				table.changeSelection(row, col, false, false);
			}
		});

		btnAdd.setBounds(801, 557, 130, 42);
		panel.add(btnAdd);

		JButton btnCancel = new JButton("Menu");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepartmentMenu deptMenu = new DepartmentMenu(student);
				deptMenu.setVisible(true);
				dispose();
			}
		});
		btnCancel.setBounds(958, 557, 130, 42);
		panel.add(btnCancel);
	}

	public void reloadTable(JTable table, DefaultTableModel model) {
		Object[] columnsName = new Object[3];
		Object[] rowData = new Object[3];
		columnsName[0] = "DEPARTMENT ID";
		columnsName[1] = "DEPARTMENT NAME";
		columnsName[2] = "DATE ADDED";
		model.setColumnIdentifiers(columnsName);

		List<Department> departments = departmentService.findAll();
		for (Department department : departments) {
			rowData[0] = department.getDepartmentID();
			rowData[1] = department.getDepartmentName();
			rowData[2] = department.getDateAdded();
			model.addRow(rowData);
		}
	}
	
	public boolean update(Object[] result){
		boolean flag = false;
		Long id = Long.parseLong(result[0].toString());
		Department department = departmentService.findById(id);// original object
		if (department != null) {
			department.setDepartmentName(result[1].toString().toUpperCase());
			Department originalDepartment = departmentService.findById(department.getDepartmentID());// updated object
			departmentService.update(department); 
			Department updatedDepartment = departmentService.findById(department.getDepartmentID());// updated object
			if(updatedDepartment != null){
				if(!originalDepartment.getDepartmentName().equals(updatedDepartment.getDepartmentName()))
					flag = true;
				}
		}
		return flag;
	}
}
