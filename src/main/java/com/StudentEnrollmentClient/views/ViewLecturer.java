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

import com.StudentEnrollmentClient.domain.Lecturer;
import com.StudentEnrollmentClient.services.Impl.LecturerServiceImpl;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewLecturer extends JFrame {

	private JPanel contentPane;
	private Lecturer lecturer;
	private LecturerServiceImpl lecturerService = new LecturerServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLecturer frame = new ViewLecturer();
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
	public ViewLecturer()
	{
		initialize();
	}
	
	public ViewLecturer(Lecturer lecturer)
	{
		initialize();
		this.lecturer = lecturer;
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

		JLabel lblSubjectSelection = new JLabel("Lecturers");
		lblSubjectSelection.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC,
				26));
		lblSubjectSelection.setBounds(488, 25, 140, 32);
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
		Object[] columnsName = new Object[3];
		Object[] rowData = new Object[3];
		columnsName[0] = "LECTURER ID";
		columnsName[1] = "LECTURER NAME";
		columnsName[2] = "LECTURER SURNAME";
		model.setColumnIdentifiers(columnsName);
		
		List<Lecturer>lecturers = lecturerService.findAll();
		for(Lecturer lecturer : lecturers){
			rowData[0] = lecturer.getId();
			rowData[1] = lecturer.getName();
			rowData[2] = lecturer.getSurname();
			model.addRow(rowData);
		}
	}

}
