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
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.*;
import javax.swing.text.Document;

public class Assessor extends JPanel
{
private int state = 0;
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
	JPanel panel = new JPanel();
	answerPanel.setLayout(new BoxLayout(answerPanel, BoxLayout.Y_AXIS));
	
	JButton hint = new JButton("HINT");
	JButton research = new JButton("RESEARCH");
	hint.setPreferredSize(new Dimension(100, 20));
	research.setPreferredSize(new Dimension(100, 20));
	panel.add(hint);
	panel.add(research);
	
	String[] menus = {"Answer 1", "Correct Answer", "Answer 3" , "Answer 4"};
	menu = new JComboBox(menus);
	menu.setPreferredSize(new Dimension(250, 200));
	
	answerPanel.add(menu);
	answerPanel.add(Box.createRigidArea(new Dimension(0,100)));
	answerPanel.add(panel);

	menu.addActionListener(new ComboBoxListener());
	
	hint.addActionListener(new HintButtonListener());
	research.addActionListener(new ResearchButtonListener());
}

private class ComboBoxListener implements ActionListener
{
	public void actionPerformed(ActionEvent event)
	{
		String type = (String) menu.getSelectedItem();
		if(type.equals("Correct Answer"))
		{
			Message correctMessage = new CorrectAnswer(new BasicMessage(type, true));
			correctMessage.doSomething();
		}
		else
		{
			Message wrongMessage = new WrongAnswer(new BasicMessage(type, false));
			wrongMessage.doSomething();
		}
	}
}


public void checkboxes()
{
	JPanel panel = new JPanel();
	JPanel panel1 = new JPanel();
	
	answerPanel.setLayout(new BoxLayout(answerPanel, BoxLayout.Y_AXIS));
	
	JButton hint = new JButton("HINT");
	JButton research = new JButton("RESEARCH");
	hint.setPreferredSize(new Dimension(100, 20));
	research.setPreferredSize(new Dimension(100, 20));
	panel.add(hint);
	panel.add(research);
	
	check1 = new JCheckBox("Answer 1");
	check2 = new JCheckBox("Correct Answer");
	check3 = new JCheckBox("Correct Answer");
	check4 = new JCheckBox("Answer 4");
	doneButton = new JButton("DONE!");

	panel1.setLayout(new GridLayout(5, 1));
	panel1.setPreferredSize(new Dimension(400, 200));

	panel1.add(check1);
	panel1.add(check2);
	panel1.add(check3);
	panel1.add(check4);
	panel1.add(doneButton);

	answerPanel.add(panel1);
	answerPanel.add(panel);
	
	doneButton.addActionListener(new DoneButtonListener());
	
	hint.addActionListener(new HintButtonListener());
	research.addActionListener(new ResearchButtonListener());
}

private class DoneButtonListener implements ActionListener
{
	public void actionPerformed(ActionEvent event)
	{
		String result = "";
		
		if(check2.isSelected() && check3.isSelected() && !check1.isSelected() && !check4.isSelected())
		{
			result = check2.getText() + " and " + check3.getText();
			Message correctMessage = new CorrectAnswer(new BasicMessage(result, true));
			correctMessage.doSomething();
		}
		else
		{
			if(check1.isSelected())
			{
				result += check1.getText();
			}
			if(check2.isSelected())
			{
				result += check2.getText();
			}
			if(check3.isSelected())
			{
				result += check3.getText();
			}
			if(check4.isSelected())
			{
				result += " " + check4.getText();
			}
			
			Message wrongMessage = new WrongAnswer(new BasicMessage(result, false));
			wrongMessage.doSomething();
		}
	}
}

public void buttons()
{
	JPanel panel = new JPanel();
	JPanel panel1 = new JPanel();
	
	answerPanel.setLayout(new BoxLayout(answerPanel, BoxLayout.Y_AXIS));
	
	JButton hint = new JButton("HINT");
	JButton research = new JButton("RESEARCH");
	hint.setPreferredSize(new Dimension(100, 20));
	research.setPreferredSize(new Dimension(100, 20));
	panel.add(hint);
	panel.add(research);
	
	button1 = new JButton("Answer 1");
	button2 = new JButton("Correct Answer");
	button3 = new JButton("Answer 3");
	button4 = new JButton("Answer 4");

	panel1.setLayout(new GridLayout(2, 2));
	panel1.setPreferredSize(new Dimension(400, 150));

	button1.setActionCommand("answer1");
	button2.setActionCommand("correctAnswer");
	button3.setActionCommand("answer3");
	button4.setActionCommand("answer4");

	panel1.add(button1);
	panel1.add(button2);
	panel1.add(button3);
	panel1.add(button4);

	answerPanel.add(panel1);
	answerPanel.add(Box.createRigidArea(new Dimension(0,30)));
	answerPanel.add(panel);

	button1.addActionListener(new ButtonListener());
	button2.addActionListener(new ButtonListener());
	button3.addActionListener(new ButtonListener());
	button4.addActionListener(new ButtonListener());
	
	hint.addActionListener(new HintButtonListener());
	research.addActionListener(new ResearchButtonListener());
}

private class ButtonListener implements ActionListener
{
public void actionPerformed(ActionEvent event)
{
	String result = "";
	
	 if("correctAnswer".equals(event.getActionCommand()))
	 {
		Message correctMessage = new CorrectAnswer(new BasicMessage(button2.getText(), true));
		correctMessage.doSomething();
	 }
	 else
	 {
		 if("answer1".equals(event.getActionCommand()))
		 {
			 result = button1.getText();
		 }
		 else if("answer3".equals(event.getActionCommand()))
		 {
			 result = button3.getText();
		 }
		 else if("answer4".equals(event.getActionCommand()))
		 {
			 result = button4.getText();
		 }
		 
		Message wrongMessage = new WrongAnswer(new BasicMessage(result, false));
		wrongMessage.doSomething();
	 }
}
}

public void textfield()
{
	JPanel panel = new JPanel();
	answerPanel.setLayout(new BoxLayout(answerPanel, BoxLayout.Y_AXIS));
	
	JButton hint = new JButton("HINT");
	JButton research = new JButton("RESEARCH");
	hint.setPreferredSize(new Dimension(100, 20));
	research.setPreferredSize(new Dimension(100, 20));
	panel.add(hint);
	panel.add(research);
	
	text = new JTextField();
	text.setPreferredSize(new Dimension(400, 100));
	
	answerPanel.add(text);
	answerPanel.add(Box.createRigidArea(new Dimension(0,10)));
	answerPanel.add(panel);

	text.addActionListener(new TextFieldListener());
	hint.addActionListener(new HintButtonListener());
	research.addActionListener(new ResearchButtonListener());
}

private class TextFieldListener implements ActionListener
{

public void actionPerformed(ActionEvent event) 
{
	if(text.getDocument() != null)
	{
		if(text.getText().equals("Correct Answer"))
		{
			Message correctMessage = new CorrectAnswer(new BasicMessage(text.getText(), true));
			correctMessage.doSomething();
		}
		else
		{
			Message wrongMessage = new WrongAnswer(new BasicMessage(text.getText(), false));
			wrongMessage.doSomething();
		}
	}
}
}

private class HintButtonListener implements ActionListener
{
	public void actionPerformed(ActionEvent event)
	{
		JOptionPane.showMessageDialog(null, "Showing Hints!");
	}
}

private class ResearchButtonListener implements ActionListener 
{
	public void actionPerformed(ActionEvent event)
	{
		Desktop d = Desktop.getDesktop();
		try {
			d.browse(new URI("http://google.com"));
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Failed to load Webpage!");
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

public interface Message
{
	public void doSomething();
}

public class BasicMessage implements Message
{
	String answer = "";
	boolean correctness = true;

	public BasicMessage(String answer, boolean correctness)
	{
		this.answer = answer;
		this.correctness = correctness;
	}

	public void doSomething()
	{
		if(correctness == true)
		{
			JOptionPane.showMessageDialog(null, (answer + " is the correct answer! Nice!"));
		}
		else
		{
			JOptionPane.showMessageDialog(null, (answer + " is not the correct answer! TOO BAD!"));
		}
	}
}

public class MessageDecorator implements Message
{
	protected Message message;
	
	public MessageDecorator(Message message)
	{
		this.message = message;
	}
	
	public void doSomething()
	{
		this.message.doSomething();
	}
}

public class CorrectAnswer extends MessageDecorator
{
	public CorrectAnswer(Message message)
	{
		super(message);
	}
	
	public void doSomething()
	{
		super.doSomething();
		if(state == 1)
		{
			menu.setBackground(Color.green);
		}
		else if(state == 2)
		{
			check2.setBackground(Color.green);
			check3.setBackground(Color.green);
			check1.setBackground(Color.red);
			check4.setBackground(Color.red);
		}
		else if(state == 3)
		{
			button2.setBackground(Color.green);
			button1.setBackground(Color.red);
			button3.setBackground(Color.red);
			button4.setBackground(Color.red);
		}
		else if(state == 4)
		{
			text.setBackground(Color.green);
		}
	}
}

public class WrongAnswer extends MessageDecorator
{
	public WrongAnswer(Message message)
	{
		super(message);
	}
	
	public void doSomething()
	{
		super.doSomething();
		if(state == 1)
		{
			menu.setBackground(Color.red);
		}
		else if(state == 2)
		{
			if(check1.isSelected())
				check1.setBackground(Color.red);
			
			if(check2.isSelected())
				check2.setBackground(Color.red);
			
			if(check3.isSelected())
				check3.setBackground(Color.red);
			
			if(check4.isSelected())
				check4.setBackground(Color.red);
		}
		else if(state == 3)
		{
			button1.setBackground(Color.red);
			button2.setBackground(Color.red);
			button3.setBackground(Color.red);
			button4.setBackground(Color.red);
		}
		else if(state == 4)
		{
			text.setBackground(Color.red);
		}
	}
}
}
