/**
 * Project: 1
 * @author Michael Crivello
 * Student ID: 1205570856
 * Team: 7
 * Recitation: 6
 * Description: Companion class that displays avatar with different moods
 */

package eggheadeducator;

import java.awt.*;
import javax.swing.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.JInternalFrame;

import javax.swing.JSlider;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.event.ChangeListener;
//import net.miginfocom.swing.MigLayout;
import java.awt.Window.Type;

public class Universe extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Universe frame = new Universe();
					frame.setSize(1103,984);
					frame.setVisible(true);
					frame.revalidate();
					frame.repaint();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Universe() {
		setTitle("Egghead Educator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1103, 984);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	
	
		contentPane.setLayout(null);
		
		JPanel a = new Companion();
		a.setBounds(10, 11, 522, 360);
		contentPane.add(a);
		a.setVisible(true);
		
		JPanel b = new Assessor();
		b.setBounds(20, 382, 522, 340);
		contentPane.add(b);
		b.setVisible(true);
		
		JPanel c = new JPanel();
		Tutor tutor = new Tutor(c);
		c.setBounds(566, 10, 500, 350);
		c.setBackground(new Color(100, 20, 55));
		contentPane.add(c);
		c.setVisible(true);
		
		
		JSlider slider = new JSlider();
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setBounds(375,700,300,200);
		slider.setSize(400, 100);
		
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//int state = slider.getValue();    			//not required hence commented
				repaint();
				((Companion) a).changeState(slider.getValue());
				((Assessor) b).changeState(slider.getValue());
				tutor.changeState(slider.getValue());
				
			}
			
		});
		
		slider.setSnapToTicks(true);
		slider.setMinorTickSpacing(1);
		slider.setMaximum(4);
		slider.setMinimum(0);
		slider.setValue(0);
		
		slider.setMajorTickSpacing(1);
		contentPane.add(slider);
		slider.setVisible(true);
		
		JLabel label = new JLabel("<html>Michael Crivello, <br>Jose Quintara, <br> Andrew Wijaya, <br>Darshan Prakash</html>");
		label.setBounds(566, 508, 270, 156);
		label.setFont(new Font("Courier New", 1, 20));
		contentPane.add(label);
		}
	}
	

	



