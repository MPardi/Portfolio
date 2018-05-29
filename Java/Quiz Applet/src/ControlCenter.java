package project04;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ControlCenter {

	private static ControlCenter _instance;

	protected ControlCenter() {
	}

	public static ControlCenter getInstance() {
		if (_instance == null) {
			_instance = new ControlCenter();
		}

		return _instance;
	}

	private int[] correctCount = new int[10];
	private int[] incorrectCount = new int[10];
	private float[] timeSpentPerQuestion = new float[10];
	private ArrayList<float[]> timeSpentPerLessons = new ArrayList<float[]>();
	
	private boolean lastLesson = false;

	private int currentLesson;

	private int currentQuestion;

	private long timerStart;
	private long timerEnd;
	private float questionTime;

	private int attempts = 1;

	private DecimalFormat format = new DecimalFormat("#.00");

	public void newQuestion() {
		timerSet();

		if (currentQuestion == 10) {
			newLesson();
		} else {
			currentQuestion++;
			attempts = 1;
		}
	}

	public void newLesson() {
		if (currentLesson != 8) {
			currentLesson++;
			lastLesson = false;
		}
		else {
			lastLesson = true;
		}
		
		currentQuestion = 1;
		timeSpentPerLessons.add(timeSpentPerQuestion);
		for (int i = 0; i < timeSpentPerQuestion.length; i++) {
			timeSpentPerQuestion[i] = (float) 0.0;
		}
		timerSet();
	}

	public void setCurrentLesson(int currentLesson) {
		this.currentLesson = currentLesson;
		currentQuestion = 1;
	}

	public int getCurrentLesson() {
		return currentLesson;
	}

	public void setCurrentQuestion(int currentQuestion) {
		this.currentQuestion = currentQuestion;
	}

	public int getCurrentQuestion() {
		return currentQuestion;
	}
	
	public int getCorrectCount() {
		return correctCount[currentLesson];
	}
	
	public int getIncorrectCount() {
		return incorrectCount[currentLesson];
	}
	
	public int getAttempts() {
		return attempts;
	}
	
	public float getQuestionTime() {
		return timeSpentPerQuestion[currentQuestion - 1];
	}

	public void answerCorrect() {
		timerStop();
		correctCount[currentLesson]++;

		newQuestion();
	}

	public void answerIncorrect() {
		incorrectCount[currentLesson]++;
		if (attempts == 3) {
			timerStop();

			newQuestion();
		} else {
			attempts++;
		}
	}

	public void timerSet() {
		timerStart = System.currentTimeMillis();
	}

	public void timerStop() {
		timerEnd = System.currentTimeMillis() - timerStart;
		
		questionTime = (float) (timerEnd / 1000.00);

		String dfStore = format.format(questionTime);
		
		float elapsedTime = Float.valueOf(dfStore);
		
		questionTime = Float.valueOf(dfStore);

		timeSpentPerQuestion[currentQuestion] = questionTime;

		System.out.println("Question Time: " + timeSpentPerQuestion[currentQuestion]);
	}
}
