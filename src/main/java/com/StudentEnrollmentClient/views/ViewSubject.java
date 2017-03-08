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
import com.StudentEnrollmentClient.domain.Subject;
import com.StudentEnrollmentClient.services.Impl.AddressServiceImpl;
import com.StudentEnrollmentClient.services.Impl.StudentServiceImpl;
import com.StudentEnrollmentClient.services.Impl.SubjectServiceImpl;

import java.awt.Font;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewSubject extends JFrame {

	private JPanel contentPane;
	private Student student;
	private SubjectServiceImpl subjectService = new SubjectServiceImpl();
	private AddressServiceImpl addressService = new AddressServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSubject frame = new ViewSubject();
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
	public ViewSubject() {
		intialize();
	}

	public ViewSubject(Student student) {
		this.student = student;
		intialize();
	}

	public void intialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1332, 698);
		getContentPane().setLayout(null);
		final JTable table = new JTable() {
			public boolean isCellEditable(int row, int column) {
				if (column == 0 || column == 4)
					return false;
				else
					return true;
			};

			public Class getColumnClass(int col) {
				if (col == 2) // second column accepts only Integer // values
					return Integer.class;
				else if (col == 3)
					return Integer.class;
				else
					return String.class; // other columns accept String values
			};
		};
		final DefaultTableModel model = new DefaultTableModel();
		reloadTable(table, model);

		table.setModel(model);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(10, 73, 1296, 477);
		panel.add(pane);
		setContentPane(panel);

		JLabel lblSubjectSelection = new JLabel("SUBJECTS");
		lblSubjectSelection.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC,
				26));
		lblSubjectSelection.setBounds(570, 24, 155, 32);
		panel.add(lblSubjectSelection);

		JButton btnAdd = new JButton("Update");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row != -1) {
					if (table.isEditing()) {
						table.getCellEditor().stopCellEditing();
						table.setRowSelectionInterval(row, row);

						Object[] result = new Object[6];//6 is the number of columns
						for (int i = 0; i < table.getColumnCount() - 1; i++) {
							result[i] = table.getValueAt(row, i);
						}
						try {
							Subject subject = subjectService
									.getSubjectCode(result[0].toString());
							if (subject != null) {
								
								subject.setSubjectCode(result[0].toString());
								subject.setSubjectName(result[1].toString());
								subject.setPrice(Integer.parseInt(result[2]
										.toString().trim().replace(".", "")));
								subject.setYearCode(Integer.parseInt(result[3]
										.toString()));
								Subject updatedSubject = subjectService
										.update(subject);

								if (updatedSubject != null)
									JOptionPane.showMessageDialog(null,
											"RECORD UPDATED", "INFO",
											JOptionPane.INFORMATION_MESSAGE);
								else
									JOptionPane.showMessageDialog(null,
											"RECORD UPDATED NOT UPDATED",
											"ERROR", JOptionPane.ERROR_MESSAGE);
							}
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									ex.getMessage(), "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				} else
					JOptionPane.showMessageDialog(null, "NO ROW WAS SELECTED",
							"INFO", JOptionPane.INFORMATION_MESSAGE);

				model.setRowCount(0);
				reloadTable(table, model);
			}
		});

		btnAdd.setBounds(1036, 591, 130, 42);
		panel.add(btnAdd);

		JButton btnCancel = new JButton("Menu");
		btnCancel.setBounds(1176, 591, 130, 42);
		panel.add(btnCancel);
	}

	public void reloadTable(JTable table, DefaultTableModel model) {
		Object[] columnsName = new Object[5];
		Object[] rowData = new Object[5];
		columnsName[0] = "SUBJECT CODE";
		columnsName[1] = "SUBJECT NAME";
		columnsName[2] = "PRICE";
		columnsName[3] = "LEVEL";
		columnsName[4] = "DATE ADDED";
		model.setColumnIdentifiers(columnsName);

		List<Subject> subjects = subjectService.findAll();
		for (Subject sub : subjects) {
			rowData[0] = sub.getSubjectCode();
			rowData[1] = sub.getSubjectName();
			rowData[2] = sub.getPrice();
			rowData[3] = sub.getYearCode();
			rowData[4] = sub.getDateAdded();
			model.addRow(rowData);
		}
	}

}
