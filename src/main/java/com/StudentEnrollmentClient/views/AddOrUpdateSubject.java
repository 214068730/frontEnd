package com.StudentEnrollmentClient.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JMenu;
import javax.swing.JComboBox;

import com.StudentEnrollmentClient.domain.Lecturer;
import com.StudentEnrollmentClient.domain.Student;
import com.StudentEnrollmentClient.domain.Subject;
import com.StudentEnrollmentClient.services.LecturerService;
import com.StudentEnrollmentClient.services.Impl.LecturerServiceImpl;
import com.StudentEnrollmentClient.services.Impl.SubjectServiceImpl;

import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddOrUpdateSubject extends JFrame {

	private JPanel contentPane;
	private JTextField txtSubjectCode;
	private JTextField txtSubjectName;
	private JTextField txtPrice;
	private Student student;
	private String message;
	private JComboBox ddlLecturer = new JComboBox();
	private JComboBox ddlSubjectLevel = new JComboBox();
	private LecturerServiceImpl lecturerService = new LecturerServiceImpl();
	private SubjectServiceImpl  subjectService = new SubjectServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddOrUpdateSubject frame = new AddOrUpdateSubject();
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
	public AddOrUpdateSubject() {
		//intialize();
	}
	
	public AddOrUpdateSubject(Student student){
		
		this.student = student;
		List<Lecturer>lectures = lecturerService.findAll();
		for(Lecturer lec : lectures){
			ddlLecturer.addItem(lec.getName()+" "+lec.getSurname());
		}
		intialize();
	}
	
	private void intialize(){
		setResizable(false);
		setTitle("Add Or Update Subject");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Subject Details");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(301, 11, 177, 61);
		contentPane.add(lblNewLabel);
		
		JLabel lblSubjectCode = new JLabel("Subject Code:");
		lblSubjectCode.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSubjectCode.setBounds(48, 110, 162, 20);
		contentPane.add(lblSubjectCode);
		
		JLabel lblSubjectName = new JLabel("Subject Name:");
		lblSubjectName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSubjectName.setBounds(48, 141, 162, 26);
		contentPane.add(lblSubjectName);
		
		JLabel lblAcademicYear = new JLabel("Subject Level:");
		lblAcademicYear.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAcademicYear.setBounds(48, 178, 162, 26);
		contentPane.add(lblAcademicYear);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPrice.setBounds(48, 215, 162, 26);
		contentPane.add(lblPrice);
		
		txtSubjectCode = new JTextField();
		txtSubjectCode.setBounds(203, 105, 177, 25);
		contentPane.add(txtSubjectCode);
		txtSubjectCode.setColumns(10);
		
		txtSubjectName = new JTextField();
		txtSubjectName.setColumns(10);
		txtSubjectName.setBounds(203, 141, 177, 25);
		contentPane.add(txtSubjectName);
		
		txtPrice = new JTextField();
		txtPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
		          if (!((c >= '0') && (c <= '9') ||
		        	 (c == KeyEvent.VK_PERIOD) ||
		             (c == KeyEvent.VK_BACK_SPACE) ||
		             (c == KeyEvent.VK_DELETE))) {
		            getToolkit().beep();
		            e.consume();
		          }
			}
		});
		txtPrice.setColumns(10);
		txtPrice.setBounds(203, 215, 177, 25);
		contentPane.add(txtPrice);
		
		JButton btnSaveSubject = new JButton("Save");
		btnSaveSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fullName = ddlLecturer.getSelectedItem().toString();
				String nameAndSurname[]  = fullName.split(" ");
				String name;
				String surname;
				String subjectName;
				String subjectCode;
				int subjectLevel;
				double price;
				
				//Separating name and surname
				name = nameAndSurname[0];
				surname = nameAndSurname[1];
				if(!txtSubjectName.getText().equals("")&&!txtSubjectCode.getText().equals("")&&!txtPrice.getText().equals("")){
			    subjectName = txtSubjectName.getText();
			    subjectCode = txtSubjectCode.getText();
			    subjectLevel = Integer.parseInt(ddlSubjectLevel.getSelectedItem().toString());
			    price = Double.parseDouble(txtPrice.getText());
			    
			    Lecturer lecturer = lecturerService.findByNameAndSurname(name, surname);
			    if(lecturer != null){
			    	Subject subject = subjectService.save(new Subject(subjectName,subjectCode,price,subjectLevel,lecturer));
			    	if(subject != null){
			    		JOptionPane.showMessageDialog(null,"RECORD INSERTED", "SUCCESS",JOptionPane.INFORMATION_MESSAGE); //add
			    	}
			    	else
			    		JOptionPane.showMessageDialog(null,"RECORD NOT ADDED", "ERROR",JOptionPane.ERROR_MESSAGE); //not added
			    }
			}
			 else
				 JOptionPane.showMessageDialog(null,"FILL IN ALL FIELDS", "ERROR",JOptionPane.ERROR_MESSAGE); //
			}
		});
		btnSaveSubject.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSaveSubject.setBounds(456, 281, 153, 45);
		contentPane.add(btnSaveSubject);
		
		JLabel lblNewLabel_1 = new JLabel("Lecturer:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(443, 111, 123, 20);
		contentPane.add(lblNewLabel_1);
		
		
		ddlLecturer.setBounds(560, 109, 177, 26);
		contentPane.add(ddlLecturer);
		
		JButton btnCancelSubject = new JButton("Cancel");
		btnCancelSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubjectMenu menu = new SubjectMenu(student);
				menu.setVisible(true);
				dispose();
			}
		});
		btnCancelSubject.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCancelSubject.setBounds(630, 281, 153, 45);
		contentPane.add(btnCancelSubject);
		
		
		ddlSubjectLevel.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		ddlSubjectLevel.setSelectedIndex(0);
		ddlSubjectLevel.setBounds(203, 178, 54, 26);
		contentPane.add(ddlSubjectLevel);
	}
}
