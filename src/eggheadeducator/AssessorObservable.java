package eggheadeducator;

import java.util.Observable;

public class AssessorObservable extends Observable
{
	private boolean correct;
	private int wrongAttempt = 0;
	
	public void correctness(boolean correct)
	{
		this.correct = correct;
		setChanged();
		notifyObservers();
		
		if(correct)
		{
			wrongAttempt = 0;
		}
		else
		{
			wrongAttempt++;
		}
	}
	
	public boolean getCorrectness()
	{
		return correct;
	}
	
	public int getWrongAttempt()
	{
		return wrongAttempt;
	}
	
	public void resetAttempt()
	{
		wrongAttempt = 0;
	}
}
