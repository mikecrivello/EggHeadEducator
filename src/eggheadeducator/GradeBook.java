/**
 * Project: 1
 * @author Michael Crivello
 * Student ID: 1205570856
 * Team: 7
 * Recitation: 6
 * Description: Holds and shows graded work and grades for student
 */

package eggheadeducator;

import java.sql.*;
import javax.swing.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GradeBook extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GradeBook frame = new GradeBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	Connection connection = null;
	
	
	/**
	 * Create the frame.
	 */
	public GradeBook() {
		connection = SqliteConnection.dataConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoadTable = new JButton("Load Student Data");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query = "select * from gradeBook";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rst = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rst));
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		btnLoadTable.setBounds(10, 27, 233, 45);
		contentPane.add(btnLoadTable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 106, 825, 422);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnReturn = new JButton("Return ");
		btnReturn.setBounds(253, 27, 250, 45);
		contentPane.add(btnReturn);
	}
}
