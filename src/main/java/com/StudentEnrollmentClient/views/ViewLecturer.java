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
import com.StudentEnrollmentClient.services.Impl.LecturerServiceImpl;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewLecturer extends JFrame {

	private JPanel contentPane;
	private Lecturer lecturer;
	private Student student;
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
		//initialize();
	}
	
	public ViewLecturer(Student student)
	{
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
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				if (row != -1) {
					if (table.isEditing()) {
						table.getCellEditor().stopCellEditing();
						table.setRowSelectionInterval(row, row);

						Object[] result = new Object[4];// 4 is the number of columns
						for (int i = 0; i < table.getColumnCount(); i++) {
							result[i] = table.getValueAt(row, i);
						}
						try {
							Lecturer lecturer = lecturerService.findById(Long.parseLong(result[0].toString()));
							if (lecturer != null) {
								if(!lecturer.getName().equals(result[1].toString()) || !lecturer.getSurname().equals(result[2].toString()))
								{
									boolean update = update(result);
									if(update == true)
										JOptionPane.showMessageDialog(null,"updated", "SUCCESS",JOptionPane.INFORMATION_MESSAGE);
									else
										JOptionPane.showMessageDialog(null,"not updated", "ERROR",JOptionPane.ERROR_MESSAGE);
								}
							}
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,ex.getMessage(), "ERROR",JOptionPane.ERROR_MESSAGE);
						}
					}
				} else
					JOptionPane.showMessageDialog(null, "NO ROW WAS SELECTED","INFO", JOptionPane.INFORMATION_MESSAGE);

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
				LecturerMenu lecturerMenu = new LecturerMenu(student);
				lecturerMenu.setVisible(true);
				dispose();
			}
		});
		btnCancel.setBounds(958, 557, 130, 42);
		panel.add(btnCancel);
	}
	
	public void reloadTable(JTable table, DefaultTableModel model) {
		Object[] columnsName = new Object[4];
		Object[] rowData = new Object[4];
		columnsName[0] = "LECTURER ID";
		columnsName[1] = "LECTURER NAME";
		columnsName[2] = "LECTURER SURNAME";
		columnsName[3] = "DATE ADDED";
		model.setColumnIdentifiers(columnsName);
		
		List<Lecturer>lecturers = lecturerService.findAll();
		for(Lecturer lecturer : lecturers){
			rowData[0] = lecturer.getId();
			rowData[1] = lecturer.getName();
			rowData[2] = lecturer.getSurname();
			rowData[3] = lecturer.getDateAdded();
			model.addRow(rowData);
		}
	}
	
	public boolean update(Object[] result){
		boolean flag = false;
		Lecturer lecturer = lecturerService.findById(Long.parseLong(result[0].toString()));
		lecturer.setName(result[1].toString());
		lecturer.setSurname(result[2].toString());
		
		Lecturer originalLecturer = lecturerService.findById(Long.parseLong(result[0].toString())); // get original object
		lecturerService.update(lecturer); 
		Lecturer updatedLecturer = lecturerService.findById(Long.parseLong(result[0].toString())); //get updated object
		if(!originalLecturer.getName().equals(updatedLecturer.getName()) || !originalLecturer.getSurname().equals(updatedLecturer.getSurname()))
			flag = true;
		
		return flag;
	}

}
