/**
 * Project: 1
 * @author Darshan Prakash
 * Student ID: 1213487299
 * Team: 7
 * Recitation: 6
 * Description: Tutor class that displays HTML file
 */

package eggheadeducator;
import javax.swing.text.*;
import javax.swing.*;
import java.io.*;
import java.awt.*;


public class Tutor extends JPanel{

	int state = 0;

	JEditorPane jep;
	String initPath = new String("file:///Users/darshan/eclipse-workspace/EggHeadTutor/resources/");
	// change location path according to local system
	
	public void changeState(int state){

		this.state=state;
		changePage(this.state);
		
		
	}
	
	private void changePage(int state2) {
		// TODO Auto-generated method stub
		
		switch(state2)
		{
			case 0:     //show <author name>
			this.jep.setBackground(Color.WHITE);
			this.jep.setText("Author Name: Darshan Prakash");
	        break;
			
			case 1: 
			try {
				this.jep.setBounds(566, 20, 500, 500);
				//this.jep.setPage("http://www.google.com");
				this.jep.setPage(initPath.toString() + "P1.html");			//display HTML page
				}
			catch (IOException e) 
			{
				this.jep.setContentType("text/html");
				this.jep.setText("<html>Could not load P1.html </html>");
		    }
		    break; 

			case 2: 

			try {
				this.jep.setPage(initPath.toString() + "P2.html");			//display HTML page
				//this.jep.setPage("https://www.asu.edu");
				}
			catch (IOException e) 
			{
				this.jep.setContentType("text/html");
				this.jep.setText("<html>Could not load P2.html </html>");		
			} 
			break;

			case 3: 

			try {
				this.jep.setPage(initPath.toString() + "P3.html");			//display HTML page
				}
			catch (IOException e) 
			{
				this.jep.setContentType("text/html");
				this.jep.setText("<html>Could not load P3.html </html>");		
			} 
			break;

			case 4: 

			try {
				this.jep.setPage(initPath.toString() + "P4.html");			//display HTML page
				}
			catch (IOException e) 
			{
				this.jep.setContentType("text/html");
				this.jep.setText("<html>Could not load P4.html </html>");
			}	 
			break;

	 	}
		
	}

	public Tutor(JPanel c)
	{
		this.state = 0;
		this.jep = new JEditorPane();
		this.jep.setBounds(566, 20, 500, 350);
		this.jep.setSize(500, 350);											//set size of panel
		this.jep.setVisible(true);
		changeState(0);
		JScrollPane scrollPane = new JScrollPane(jep);
		c.setVisible( true );
		add(scrollPane);
        this.setBounds( 0, 0, 200, 200);
		scrollPane.setVisible(true);
		//add(scrollPane);
		//scrollPane.bounds()
		//this.jep.add(scrollPane);
		//scrollPane.setVerticalScrollBar();
		this.jep.setEditable(true);
		c.add(this.jep);
		//this.jep.resize(700, 500);
	
		//removeAll();
	
	    //changePage(0);
	    
	}
}