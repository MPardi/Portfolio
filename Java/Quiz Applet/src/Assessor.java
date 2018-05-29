package project04;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Assessor extends Observable {
	
	private int happinessLevel;
	private boolean isCorrect;
	
	public void answerCorrect() {
		if (happinessLevel < 5) {
			happinessLevel++;
		}
		
		isCorrect = true;
		
		setChanged();
		notifyObservers();
	}
	
	public void answerIncorrect() {
		if (happinessLevel > 0) {
			happinessLevel--;
		}
		
		isCorrect = false;
		
		setChanged();
		notifyObservers();
	}
	
	public void setHappiness(int happinessLevel) {
		if (happinessLevel <= 5 || happinessLevel >= 0) {
			this.happinessLevel = happinessLevel;
		}
		
		notifyObservers();
	}
	
	public int getHappiness() {
		return happinessLevel;
	}
}
