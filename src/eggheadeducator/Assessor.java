package eggheadeducator;
//Project Part: 1
//Name: Andre Wijaya
//StudentID: 1211513326
//Team: 7
//Recitation: 6
//Description: Assessor class that will provide different types of how to
//			answer the question

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.text.Document;

public class Assessor extends JPanel
{
private int state = 0;
private String result;
private JPanel questionPanel;
private JPanel answerPanel;
private JComboBox menu;
private JCheckBox check1;
private JCheckBox check2;
private JCheckBox check3;
private JCheckBox check4;
private JButton doneButton;
private JButton button1;
private JButton button2;
private JButton button3;
private JButton button4;
private JTextField text;


public Assessor()
{
questionPanel = new JPanel();
questionPanel.setPreferredSize(new Dimension(350, 100));

answerPanel = new JPanel();
answerPanel.setPreferredSize(new Dimension(500, 220));

JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, questionPanel, answerPanel);
add(sp);
}


public void states()
{
if(state == 1)
{
	questionPanel.add(new JLabel("Question1"));
	menu();
}
else if(state == 2)
{
	questionPanel.add(new JLabel("Question2"));
	checkboxes();
}
else if(state == 3)
{
	questionPanel.add(new JLabel("Question3"));
	buttons();
}
else if(state == 4)
{
	questionPanel.add(new JLabel("Question4"));
	textfield();
}
else
{
	questionPanel.add(new JLabel("Author Name: Andre Wijaya"));
}
}

public void menu()
{
String[] menus = {"Answer 1", "Answer 2", "Answer 3" , "Answer 4"};
menu = new JComboBox(menus);

answerPanel.add(menu);
menu.addActionListener(new ComboBoxListener());
}

private class ComboBoxListener implements ActionListener
{
public void actionPerformed(ActionEvent event)
{
	String type = (String) menu.getSelectedItem();
	
	if(type.equals("Answer 1"))
	{
		JOptionPane.showMessageDialog(null, "Answer 1");
	}
	else if(type.equals("Answer 2"))
	{
		JOptionPane.showMessageDialog(null, "Answer 2");
	}
	else if(type.equals("Answer 3"))
	{
		JOptionPane.showMessageDialog(null, "Answer 3");
	}
	else if(type.equals("Answer 4"))
	{
		JOptionPane.showMessageDialog(null, "Answer 4");
	}
}
}

public void checkboxes()
{
check1 = new JCheckBox("Answer 1");
check2 = new JCheckBox("Answer 2");
check3 = new JCheckBox("Answer 3");
check4 = new JCheckBox("Answer 4");
doneButton = new JButton("DONE!");

answerPanel.setLayout(new GridLayout(5, 1));

answerPanel.add(check1);
answerPanel.add(check2);
answerPanel.add(check3);
answerPanel.add(check4);
answerPanel.add(doneButton);

check1.addItemListener(new CheckBoxListener());
check2.addItemListener(new CheckBoxListener());
check3.addItemListener(new CheckBoxListener());
check4.addItemListener(new CheckBoxListener());
doneButton.addActionListener(new DoneButtonListener());
}

private class CheckBoxListener implements ItemListener
{
public void itemStateChanged(ItemEvent event)
{
	result = "You choose: ";
	
	if(check1.isSelected())
	{
		result += "Answer 1 ";
	}
	if(check2.isSelected())
	{
		result += "Answer 2 ";
	}
	if(check3.isSelected())
	{
		result += "Answer 3 ";
	}
	if(check4.isSelected())
	{
		result += "Answers 4 ";
	}
}
}

private class DoneButtonListener implements ActionListener
{
public void actionPerformed(ActionEvent event)
{
	 JOptionPane.showMessageDialog(null, result);
}
}

public void buttons()
{
button1 = new JButton("Answer 1");
button2 = new JButton("Answer 2");
button3 = new JButton("Answer 3");
button4 = new JButton("Answer 4");

answerPanel.setLayout(new GridLayout(4, 1));

button1.setActionCommand("answer1");
button2.setActionCommand("answer2");
button3.setActionCommand("answer3");
button4.setActionCommand("answer4");

answerPanel.add(button1);
answerPanel.add(button2);
answerPanel.add(button3);
answerPanel.add(button4);

button1.addActionListener(new ButtonListener());
button2.addActionListener(new ButtonListener());
button3.addActionListener(new ButtonListener());
button4.addActionListener(new ButtonListener());
}

private class ButtonListener implements ActionListener
{
public void actionPerformed(ActionEvent event)
{
	 if("answer1".equals(event.getActionCommand()))
	 {
		 JOptionPane.showMessageDialog(null, "Answer 1");
	 }
	 else if("answer2".equals(event.getActionCommand()))
	 {
		 JOptionPane.showMessageDialog(null, "Answer 2");
	 }
	 else if("answer3".equals(event.getActionCommand()))
	 {
		 JOptionPane.showMessageDialog(null, "Answer 3");
	 }
	 else if("answer4".equals(event.getActionCommand()))
	 {
		 JOptionPane.showMessageDialog(null, "Answer 4");
	 }
}
}

public void textfield()
{
text = new JTextField();

text.setPreferredSize(new Dimension(340, 340));
answerPanel.add(text);

text.addActionListener(new TextFieldListener());
}

private class TextFieldListener implements ActionListener
{

public void actionPerformed(ActionEvent event) 
{
	if(text.getDocument() != null)
	{
		JOptionPane.showMessageDialog(null, "You just put an answer :)");
	}
}
}

public void changeState(int state) 
{
questionPanel.removeAll();
answerPanel.removeAll();
this.state = state;
states();
}
}


