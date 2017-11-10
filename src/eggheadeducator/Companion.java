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
import java.util.Observer;


public class Companion extends JPanel implements Runnable, Observer
{
	public Companion()
	{
	}

	int blinkCount = 0;
	int deltaY = -1;
	int deltaYW = -1;
	int deltaMouth = -4;
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
			try{
				Thread.sleep(200);
			} catch (InterruptedException ex) {
			}

			//Eyebrow animation(thinking)
			int browRange = 2;
			eyeBrowY += deltaY;
			if (eyeBrowY <= -browRange)
			{
				eyeBrowY = -browRange;
				deltaY *= -1;
			}
			else if (eyeBrowY >= browRange)
			{
				eyeBrowY = browRange;
				deltaY *= -1;
			}

			//Eyebrow animation(worried)
			int browRangeW = 2;
			worryBrowY += deltaYW;
			if (worryBrowY <= -browRangeW)
			{
				worryBrowY = -browRangeW;
				deltaYW *= -1;
			}
			else if (worryBrowY >= browRangeW)
			{
				worryBrowY = browRangeW;
				deltaYW *= -1;
			}

			//Mouth animation(sad)
			int mouthRange = 40;
			mouthSad += deltaMouth;
			if (mouthSad <= -mouthRange)
			{
				mouthSad = -mouthRange;
				deltaMouth *= -1;
			}
			else if (mouthSad >= mouthRange)
			{
				mouthSad = mouthRange;
				deltaMouth *= -1;
			}

			//Blinking animation (all)
			blinkCount++;
			if (blink && blinkCount > 15)
			{
				blink = false;
				blinkCount = 0;
			}
			else if (blinkCount > 18)
			{
				blink = true;
				blinkCount = 0;
			}
			repaint();

		}

	}

	int state = 0;
    boolean blink = false;
    int eyeBrowY = 0;
    int worryBrowY = 0;
    int mouthSad = 0;

    public void paintComponent(Graphics g)
    {
		int faceX = 100;
		int faceY = 50;

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
				g.fillOval(faceX,faceY, 200, 300);

				if (blink) {
					g.setColor(new Color(234, 192, 134));
				}else {
					g.setColor(Color.black);
				}
				//eyes
				g.fillOval(faceX+40, faceY+70, 30, 50);
				g.fillOval(faceX+130, faceY+70, 30, 50);


				if (!blink) {
					//eyes detail
					g.setColor(Color.white);
					g.fillOval(faceX+45, faceY+75, 12, 12);
					g.fillOval(faceX+135, faceY+75, 12, 12);
					g.fillOval(faceX+54, faceY+95, 7, 7);
					g.fillOval(faceX+144, faceY+95, 7, 7);
				}
				//eyeCrease
				g.setColor(Color.black);
				g.drawArc(faceX+25, faceY+70, 60, 50, 45, 90);
				g.drawArc(faceX+115, faceY+70, 60, 50, 45, 90);
				g.drawLine(faceX+35, faceY+120, faceX+75, faceY+120);
				g.drawLine(faceX+125, faceY+120, faceX+165, faceY+120);

				//nose
				g.setColor(Color.black);
				g.drawLine(faceX+100, faceY+100, faceX+95, faceY+180);
				g.drawLine(faceX+95, faceY+180, faceX+100, faceY+180);

				//eyebrows
				g.drawArc(faceX+25, faceY+50, 60, 60, 45, 90);
				g.drawArc(faceX+115, faceY+50, 60, 40, 45, 90);

				//mouth
				g.fillArc(faceX+60, faceY+150, 80, 120, 0, -180);
				g.setColor(Color.white);
				g.fillRect(faceX+65, faceY+211, 70, 10);

                break;

            case 2:     //draw thinking avatar
				//face shape
				g.setColor(new Color(234, 192, 134));
				g.fillOval(faceX,faceY, 200, 300);

				if (blink) {
					g.setColor(new Color(234, 192, 134));
				}else {
					g.setColor(Color.black);
				}
				//eyes
				g.fillOval(faceX+40, faceY+70, 30, 50);
				g.fillOval(faceX+130, faceY+70, 30, 50);


				if (!blink) {
					//eyes detail
					g.setColor(Color.white);
					g.fillOval(faceX+45, faceY+75, 12, 12);
					g.fillOval(faceX+135, faceY+75, 12, 12);
					g.fillOval(faceX+54, faceY+95, 7, 7);
					g.fillOval(faceX+144, faceY+95, 7, 7);
				}
				//eyeCrease
				g.setColor(Color.black);
				g.drawArc(faceX+25, faceY+70, 60, 50, 45, 90);
				g.drawArc(faceX+115, faceY+70, 60, 50, 45, 90);
				g.drawLine(faceX+35, faceY+120, faceX+75, faceY+120);
				g.drawLine(faceX+125, faceY+120, faceX+165, faceY+120);

				//nose
				g.setColor(Color.black);
				g.drawLine(faceX+100, faceY+100, faceX+95, faceY+180);
				g.drawLine(faceX+95, faceY+180, faceX+100, faceY+180);

				//eyebrows
				g.drawArc(faceX+25, faceY+40+eyeBrowY, 60, 90, 45, 90);	//animation here for y axis
				g.drawLine(faceX+125, faceY+70 , faceX+165, faceY+70);

				//mouth
				g.drawArc(faceX+50, faceY+215, 150, 60, 70, 70);

                break;

            case 3:     //draw worry avatar
				//face shape
				g.setColor(new Color(234, 192, 134));
				g.fillOval(faceX,faceY, 200, 300);

				if (blink) {
					g.setColor(new Color(234, 192, 134));
				}else {
					g.setColor(Color.black);
				}
				//eyes
				g.fillOval(faceX+40, faceY+70, 30, 50);
				g.fillOval(faceX+130, faceY+70, 30, 50);


				if (!blink) {
					//eyes detail
					g.setColor(Color.white);
					g.fillOval(faceX+45, faceY+75, 12, 12);
					g.fillOval(faceX+135, faceY+75, 12, 12);
					g.fillOval(faceX+54, faceY+95, 7, 7);
					g.fillOval(faceX+144, faceY+95, 7, 7);
				}
				//eyeCrease
				g.setColor(Color.black);
				g.drawArc(faceX+25, faceY+70, 60, 50, 45, 90);
				g.drawArc(faceX+115, faceY+70, 60, 50, 45, 90);
				g.drawLine(faceX+35, faceY+120, faceX+75, faceY+120);
				g.drawLine(faceX+125, faceY+120, faceX+165, faceY+120);

				//nose
				g.setColor(Color.black);
				g.drawLine(faceX+100, faceY+100, faceX+95, faceY+180);
				g.drawLine(faceX+95, faceY+180, faceX+100, faceY+180);

				//eyebrows
				g.drawLine(faceX+35, faceY+70 ,faceX+75, faceY+50+worryBrowY);  	//Animation here in y axis
				g.drawLine(faceX+125, faceY+50+worryBrowY ,faceX+165, faceY+70);	//Animation here in y axis

				//mouth
				g.fillOval(faceX+80, faceY+230, 45, 45);
                break;

            case 4:     //draw sorry avatar
				//face shape
				g.setColor(new Color(234, 192, 134));
				g.fillOval(faceX,faceY, 200, 300);

				if (blink) {
					g.setColor(new Color(234, 192, 134));
				}else {
					g.setColor(Color.black);
				}
				//eyes
				g.fillOval(faceX+40, faceY+70, 30, 50);
				g.fillOval(faceX+130, faceY+70, 30, 50);


				if (!blink) {
					//eyes detail
					g.setColor(Color.white);
					g.fillOval(faceX+45, faceY+75, 12, 12);
					g.fillOval(faceX+135, faceY+75, 12, 12);
					g.fillOval(faceX+54, faceY+95, 7, 7);
					g.fillOval(faceX+144, faceY+95, 7, 7);
				}
				//eyeCrease
				g.setColor(Color.black);
				g.drawArc(faceX+25, faceY+70, 60, 50, 45, 90);
				g.drawArc(faceX+115, faceY+70, 60, 50, 45, 90);
				g.drawLine(faceX+35, faceY+120, faceX+75, faceY+120);
				g.drawLine(faceX+125, faceY+120, faceX+165, faceY+120);

				//nose
				g.setColor(Color.black);
				g.drawLine(faceX+100, faceY+100, faceX+95, faceY+180);
				g.drawLine(faceX+95, faceY+180, faceX+100, faceY+180);

				//eyebrows
				g.drawLine(faceX+35, faceY+70 ,faceX+75, faceY+50);
				g.drawLine(faceX+125, faceY+50 ,faceX+165, faceY+70);

				//mouth
				g.drawArc(faceX+50, faceY+215, 100, 60-mouthSad, 35, 110);	//Animation here for mouthSad

                break;
        }

    }

    public void changeState(int state)
    {
		this.state = state;
    }
    
    @Override
	public void update(Observable o, Object arg) 
	{
		// TODO Auto-generated method stub
		boolean correct = ((AssessorObservable)o).getCorrectness();
		
		if(correct)
		{
			state = 1;
			repaint();
		}
		else
		{
			state = 4;
			repaint();
		}
	}
}
