package com.StudentEnrollmentClient.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import com.StudentEnrollmentClient.domain.Department;
import com.StudentEnrollmentClient.domain.Lecturer;
import com.StudentEnrollmentClient.services.Impl.DepartmentServiceImpl;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewDepartment extends JFrame {

	private JPanel contentPane;
	private Department department;
	private DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
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
		initialize();
	}
	
	public ViewDepartment(Department department){
		initialize();
		this.department = department;
	}
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1114, 648);
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
			}
		});
		btnAdd.setBounds(801, 557, 130, 42);
		panel.add(btnAdd);

		JButton btnCancel = new JButton("Menu");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu mainMenu = new Menu();
				mainMenu.setVisible(true);
				dispose();
			}
		});
		btnCancel.setBounds(958, 557, 130, 42);
		panel.add(btnCancel);
	}
	
	public void reloadTable(JTable table, DefaultTableModel model) {
		Object[] columnsName = new Object[2];
		Object[] rowData = new Object[2];
		columnsName[0] = "DEPARTMENT ID";
		columnsName[1] = "DEPARTMENT NAME";
		model.setColumnIdentifiers(columnsName);
		
		List<Department>departments = departmentService.findAll();
		for(Department department : departments){
			rowData[0] = department.getDepartmentID();
			rowData[1] = department.getDepartmentName();
			model.addRow(rowData);
		}
	}
}
