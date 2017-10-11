/**
 * Project: 1
 * @author Michael Crivello
 * Student ID: 1205570856
 * Team: 7
 * Recitation: 6
 * Description: Connects sqlite databases to various classes for use
 */
package eggheadeducator;

import java.sql.*;
import javax.swing.*;

public class SqliteConnection {
	
	Connection conn = null;
	
	
	public static Connection dbConnector() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\mwgcr\\eclipse-workspace\\EggHeadEducator-master\\StudentGrades.sqlite");
			//JOptionPane.showMessageDialog(null, "Connection successful");
			return conn;
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
	public static Connection dataConnector() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\mwgcr\\eclipse-workspace\\EggHeadEducator-master\\GradeInfo.sqlite");
			//JOptionPane.showMessageDialog(null, "Connection successful");
			return conn;
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	

}
