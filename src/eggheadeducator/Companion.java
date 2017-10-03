package eggheadeducator;

/**
 * Project: 1
 * @author Jose Q
 * Student ID: 1208865927
 * Team: 7
 * Recitation: 6
 * Description: Companion class that displays avatar with different moods
 */
import java.awt.*;
import javax.swing.*;


public class Companion extends JPanel implements Runnable
{
	public Companion(){}

	int blinkCount = 0;
	Thread animator;

    public void addNotify()
    {
        super.addNotify();
        animator = new Thread(this);
        animator.start();
    }

	public void run()
	{
        while (true)
        {
			blinkCount++;
			if (blink && blinkCount > 10)
			{
				blink = false;
				blinkCount = 0;
			}
			else if (blinkCount > 25)
			{
				blink = true;
				blinkCount = 0;
			}
			repaint();

			try{
				Thread.sleep(100);
			} catch (InterruptedException ex) {
			}

			}

		}

    int state = 0;
    boolean blink = false;

    public void paintComponent(Graphics g)
    {
		super.paintComponent(g);

        switch(state)
        {
            case 0:     //show <author name>
                Font myFont = new Font ("Courier New", 1, 20);
                g.setFont (myFont);
				g.drawString ("Jose Quintana", 200, 100);
                break;

            case 1:     //draw happy avatar
				//face shape
				g.setColor(new Color(234, 192, 134));
				g.fillOval(100,50, 200, 300);

				if (blink) {
					g.setColor(new Color(234, 192, 134));
				}else {
					g.setColor(Color.black);
				}
				//eyes
				g.fillOval(140, 120, 30, 50);
				g.fillOval(230, 120, 30, 50);


				if (!blink) {
					//eyes detail
					g.setColor(Color.white);
					g.fillOval(145, 125, 12, 12);
					g.fillOval(235, 125, 12, 12);
					g.fillOval(154, 145, 7, 7);
					g.fillOval(244, 145, 7, 7);
				}
				//eyebrows
				g.setColor(Color.black);
				g.drawArc(125, 120, 60, 50, 45, 90);
				g.drawArc(215, 120, 60, 50, 45, 90);
				g.drawLine(135, 170, 175, 170);
				g.drawLine(225, 170, 265, 170);

				//nose
				g.setColor(Color.black);
				g.drawLine(200, 150, 195, 230);
				g.drawLine(195, 230, 200, 230);

				//eyebrows
				g.drawArc(125, 100, 60, 60, 45, 90);
				g.drawArc(215, 100, 60, 40, 45, 90);

				//mouth
				g.fillArc(160, 200, 80, 120, 0, -180);
				g.setColor(Color.white);
				g.fillRect(165, 261, 70, 10);

                break;

            case 2:     //draw thinking avatar
				//face shape
				g.setColor(new Color(234, 192, 134));
				g.fillOval(100,50, 200, 300);

				if (blink) {
					g.setColor(new Color(234, 192, 134));
				}else {
					g.setColor(Color.black);
				}
				//eyes
				g.fillOval(140, 120, 30, 50);
				g.fillOval(230, 120, 30, 50);


				if (!blink) {
					//eyes detail
					g.setColor(Color.white);
					g.fillOval(145, 125, 12, 12);
					g.fillOval(235, 125, 12, 12);
					g.fillOval(154, 145, 7, 7);
					g.fillOval(244, 145, 7, 7);
				}
				//eyebrows
				g.setColor(Color.black);
				g.drawArc(125, 120, 60, 50, 45, 90);
				g.drawArc(215, 120, 60, 50, 45, 90);
				g.drawLine(135, 170, 175, 170);
				g.drawLine(225, 170, 265, 170);

				//nose
				g.setColor(Color.black);
				g.drawLine(200, 150, 195, 230);
				g.drawLine(195, 230, 200, 230);

				//eyebrows
				g.drawArc(125, 90, 60, 90, 45, 90);
				g.drawLine(225, 120 , 265, 120);

				//mouth
				g.drawArc(150, 265, 150, 60, 70, 70);

                break;

            case 3:     //draw worry avatar
				//face shape
				g.setColor(new Color(234, 192, 134));
				g.fillOval(100,50, 200, 300);

				if (blink) {
					g.setColor(new Color(234, 192, 134));
				}else {
					g.setColor(Color.black);
				}
				//eyes
				g.fillOval(140, 120, 30, 50);
				g.fillOval(230, 120, 30, 50);


				if (!blink) {
					//eyes detail
					g.setColor(Color.white);
					g.fillOval(145, 125, 12, 12);
					g.fillOval(235, 125, 12, 12);
					g.fillOval(154, 145, 7, 7);
					g.fillOval(244, 145, 7, 7);
				}
				//eyebrows
				g.setColor(Color.black);
				g.drawArc(125, 120, 60, 50, 45, 90);
				g.drawArc(215, 120, 60, 50, 45, 90);
				g.drawLine(135, 170, 175, 170);
				g.drawLine(225, 170, 265, 170);

				//nose
				g.setColor(Color.black);
				g.drawLine(200, 150, 195, 230);
				g.drawLine(195, 230, 200, 230);

				//eyebrows
				g.drawLine(135, 120 ,175, 100);
				g.drawLine(225, 100 ,265, 120);

				//mouth
				g.fillOval(180, 280, 45, 45);
                break;

            case 4:     //draw sorry avatar
				//face shape
				g.setColor(new Color(234, 192, 134));
				g.fillOval(100,50, 200, 300);

				if (blink) {
					g.setColor(new Color(234, 192, 134));
				}else {
					g.setColor(Color.black);
				}
				//eyes
				g.fillOval(140, 120, 30, 50);
				g.fillOval(230, 120, 30, 50);


				if (!blink) {
					//eyes detail
					g.setColor(Color.white);
					g.fillOval(145, 125, 12, 12);
					g.fillOval(235, 125, 12, 12);
					g.fillOval(154, 145, 7, 7);
					g.fillOval(244, 145, 7, 7);
				}
				//eyebrows
				g.setColor(Color.black);
				g.drawArc(125, 120, 60, 50, 45, 90);
				g.drawArc(215, 120, 60, 50, 45, 90);
				g.drawLine(135, 170, 175, 170);
				g.drawLine(225, 170, 265, 170);

				//nose
				g.setColor(Color.black);
				g.drawLine(200, 150, 195, 230);
				g.drawLine(195, 230, 200, 230);

				//eyebrows
				g.drawLine(135, 120 ,175, 100);
				g.drawLine(225, 100 ,265, 120);

				//mouth
				g.drawArc(150, 265, 100, 60, 35, 110);

                break;
        }

    }

    public void changeState(int state)
    {
		this.state = state;
    }
}