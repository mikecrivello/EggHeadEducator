package eggheadeducator;

import java.util.Observable;

public class AssessorObservable extends Observable
{
	private boolean correct;
	
	public void correctness(boolean correct)
	{
		this.correct = correct;
		setChanged();
		notifyObservers();
	}
	
	public boolean getCorrectness()
	{
		return correct;
	}
}
