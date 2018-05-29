package project04;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import javax.swing.*;

@SuppressWarnings("serial")

/*
 * File: Tutor.java
 * Author: Michael Pardi
 * Course: CSE 360
 * Group: 1
 */
public class CompanionPanel extends JPanel implements Runnable, Observer {
	
	//Checks for program start and displays initial panel
	int paintState;
	public JPanel layoutPanel = new JPanel();
	public GridBagConstraints gbc = new GridBagConstraints();
	public JLabel nameLabel = new JLabel("Companion Area");
	
	private Observable assessor;

	//Colors used for faces
	public Color colors[] = { Color.YELLOW, Color.GREEN, Color.LIGHT_GRAY, Color.ORANGE, Color.RED };
	//Random seed for SuperHappyFace color changes
	public Random rand = new Random();

	//SuperHappyFace color RGB values
	public float r = rand.nextFloat();
	public float g = rand.nextFloat();
	public float b = rand.nextFloat();
	
	//Creates color out of varaibles
	public Color randomColor = new Color(r, g, b);
	
	//Happiness meter initialized
	public JProgressBar happinessBar = new JProgressBar();

	//Animation thread
	private Thread stepper;
	
	//Control variable for animation thread
	private int runState = 0;
	
	//Used for SuperHappyFace wall bounce
	private Dimension panelSize;

	private int xPos;
	private int yPos;

	//Control variable for blinking animation
	public int blinkDelay = 0;

	//Happiness meter range
	public int happiness;

	//Keeps track of user answer counts
	public int incorrectCount = 0;
	public int correctCount = 0;

	//Boolean state for blink animation
	public boolean blink = false;

	public CompanionPanel() {
		setLayout(new GridBagLayout());
		setPreferredSize(new Dimension(400, 400));
		add(nameLabel);
		
		viewHappinessBar();

		yPos = 120;
	}
	
	public void setAssessor(Assessor assessor) {
		this.assessor = assessor;
		assessor.addObserver(this);
		assessor.setHappiness(4);
		happiness = assessor.getHappiness();
		viewHappinessBar();
	}

	public void start() {
		if (stepper == null) {
			stepper = new Thread(this);
			stepper.start();
		}
	}

	public void stop() {
		if (stepper != null) {
			stepper.stop();
			stepper = null;
		}
	}

	public void changeState(int state) {
		if (paintState == 0) {
			remove(nameLabel);
			
			gbc.weighty = 1;
			gbc.anchor = GridBagConstraints.SOUTHWEST;
			add(happinessBar, gbc);
			viewHappinessBar();
			start();
		}

		paintState = state;
		stop();
		resetPos();
		repaint();
		start();
	}

	public void resetPos() {
		xPos = 120;
		yPos = 120;
	}

//	public void setCorrectCount(int count) {
//		if (correctCount < count) {
//			if (happiness < 5) {
//				happiness++;
//			}
//		}
//
//		correctCount = count;
//		System.out.println(correctCount);
//	}
//
//	public void setIncorrectCount(int count) {
//		if (incorrectCount < count) {
//			if (happiness > 0) {
//				happiness--;
//			}
//		}
//
//		incorrectCount = count;
//		System.out.println(incorrectCount);
//	}

	public void checkHappiness() {
		happinessBar.setValue(happiness);
	}

	public int getHappiness() {
		return happiness;
	}

	public void run() {
		while (true) {
			if (happiness < 5) {
				if (blinkDelay == 50) {
					blink = true;

					repaint();
					try {
						Thread.sleep(350);
					} catch (InterruptedException ex) {

					}
					blinkDelay = 0;
				} else {
					blink = false;

					repaint();
				}
				try {
					Thread.sleep(50);
				} catch (InterruptedException ex) {

				}
				checkHappiness();
				blinkDelay++;
			} else {
				for (xPos = 120; xPos <= 240; xPos += 15) {
					if (runState == 0) {
						yPos += 15;
					} else {
						yPos -= 15;
					}
					repaint();
					try {
						Thread.sleep(100);
					} catch (InterruptedException ex) {
					}
				}
				for (xPos = 240; xPos >= 0; xPos -= 15) {
					if (runState == 0) {
						yPos -= 15;
					} else {
						yPos += 15;
					}
					repaint();
					try {
						Thread.sleep(100);
					} catch (InterruptedException ex) {
					}
				}
				for (xPos = 0; xPos <= 120; xPos += 15) {
					if (runState == 0) {
						yPos += 15;
					} else {
						yPos -= 15;
					}
					repaint();
					try {
						Thread.sleep(100);
					} catch (InterruptedException ex) {
					}
				}
				if (runState == 0) {
					runState = 1;
				} else {
					runState = 0;
				}
			}

				r = rand.nextFloat();
				g = rand.nextFloat();
				b = rand.nextFloat();

				randomColor = new Color(r, g, b);
		}
	}
	
	public void viewHappinessBar() {
		happinessBar.setStringPainted(true);
		happinessBar.setString("Happiness Level");

		happinessBar.setValue(happiness);
		happinessBar.setMinimum(0);
		happinessBar.setMaximum(5);

		happinessBar.setPreferredSize(new Dimension(300, 30));
	}

	public void paintComponent(Graphics face) {
		super.paintComponent(face);
		if (paintState == 0) {

		} else {
			Companion companionFace = new InitialCompanion();
			
			if (happiness < 5) {
								
				switch (happiness) {
				case 4:
					HappierCompanion happier = new HappierCompanion();
					happier.add(companionFace);
					if (blink) {
						happier.draw(face, colors[0], true, false, 0, 0);
					} else {
						happier.draw(face, colors[0], false, false, 0, 0);
					}
					break;
				case 3:
					HappyCompanion happy = new HappyCompanion();
					happy.add(companionFace);
					if (blink) {
						happy.draw(face, colors[1], true, false, 0, 0);
					} else {
						happy.draw(face, colors[1], false, false, 0, 0);
					}
					break;
				case 2:
					NeutralCompanion neutral = new NeutralCompanion();
					neutral.add(companionFace);
					if (blink) {
						neutral.draw(face, colors[2], true, false, 0, 0);
					} else {
						neutral.draw(face, colors[2], false, false, 0, 0);
					}
					break;
				case 1:
					WorriedCompanion worried = new WorriedCompanion();
					worried.add(companionFace);
					if (blink) {
						worried.draw(face, colors[3], true, false, 0, 0);
					} else {
						worried.draw(face, colors[3], false, false, 0, 0);
					}
					break;
				default:
					SadCompanion sad = new SadCompanion();
					sad.add(companionFace);
					if (blink) {
						sad.draw(face, colors[4], true, false, 0, 0);
					} else {
						sad.draw(face, colors[4], false, false, 0, 0);
					}
					break;
				}
			} else {
				SuperHappyCompanion superHappy = new SuperHappyCompanion();
				superHappy.add(companionFace);
				
				superHappy.draw(face, randomColor, false, true, xPos, yPos);
				repaint();
			}
		}
	}

	public void update(Observable o, Object arg) {
		happiness = ((Assessor) o).getHappiness();
		
		System.out.println("Current Happiness: " + happiness);
	}
}