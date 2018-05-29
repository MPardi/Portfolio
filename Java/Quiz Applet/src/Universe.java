package project04;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * File: Universe.java
 * Author: Tain Henning
 * Course: CSE 360
 * Group: 1
 */
public class Universe extends JFrame implements ChangeListener, ActionListener {

	// Sets up all components
	private JFrame mainFrame = new JFrame("CSE360 Project One");
	private JPanel namePanel = new JPanel();

	// calc button ---------
	private JButton calc = new JButton("Calculator");
	Calculator calculator = new Calculator();
	boolean open = false;
	// --------------------

	private Border raisedbevel = BorderFactory.createRaisedBevelBorder();
	private Border loweredbevel = BorderFactory.createLoweredBevelBorder();

	// Instantiate class objects
	private final CompanionPanel a = new CompanionPanel();
	private final TutorPanel b = new TutorPanel();
	private final AssessorPanel c = new AssessorPanel(this);
	private final DescriptorPanel d = new DescriptorPanel();
	private JSlider slider1 = new JSlider(1, 2, 1);
	
	private JButton startButton = new JButton("Start");
	private JButton prevLesson = new JButton("Previous Lesson");
	private JButton nextLesson = new JButton("Next Lesson");
	private JButton help = new JButton("Help");

	public final Assessor assessor = new Assessor();
	public final ControlCenter controlCenter = new ControlCenter();
	
	private GridBagConstraints gbc = new GridBagConstraints();

	// Initial state
	private int state = 0;

	// Constructor
	public Universe() {
		c.setAssessor(assessor);
		a.setAssessor(assessor);

		assessor.setHappiness(4);

		c.setControlCenter(controlCenter);
		d.setControlCenter(controlCenter);

		prepareGUI();
	}

	public static void main(String[] args) {
		// TODO code application logic here
		Universe main = new Universe();
	}

	public void prepareGUI() {
		// Sets close operation and mainFrame layout
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(new GridBagLayout());

		// Constraints for GridBagLayout

		// Creates borders
		a.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
		b.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
		c.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
		d.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));

		// GBC settings
		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridwidth = 2;
		gbc.gridheight = 2;

		gbc.weightx = 0.5;
		gbc.weighty = 0.25;
		gbc.gridx = 0;
		gbc.gridy = 0;

		mainFrame.add(a, gbc);

		gbc.gridx = 2;
		mainFrame.add(b, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;

		mainFrame.add(c, gbc);

		gbc.gridx = 2;
		gbc.gridy = 2;

		mainFrame.add(d, gbc);
//
//		slider1.setSnapToTicks(true);
//		slider1.setPaintTicks(true);
//		slider1.setMajorTickSpacing(1);
//
//		slider1.addChangeListener(this);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 4;
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weighty = 1000;

		mainFrame.add(startButton, gbc);
		startButton.addActionListener(this);
		
		calc.addActionListener(this);

		mainFrame.pack();
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
	}

	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();

		// If slider isn't being used
		if (!source.getValueIsAdjusting()) {
			if (state == 0) {
				namePanel.removeAll();

				if ((int) source.getValue() != 1) {
					state = 1;
					c.changeState((int) source.getValue());
					b.changeState((int) source.getValue());
					a.changeState((int) source.getValue());
					d.changeState(state);
				}
			} else {
				c.changeState((int) source.getValue());
				b.changeState((int) source.getValue());
				a.changeState((int) source.getValue());
				d.changeState((int) source.getValue());
			}
		}
	}

	public void playSound(String soundFile) {
		try {
			URL url = this.getClass().getClassLoader().getResource(soundFile);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			Clip clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
		} catch (UnsupportedAudioFileException g) {
			g.printStackTrace();
		} catch (IOException g) {
			g.printStackTrace();
		} catch (LineUnavailableException g) {
			g.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == calc) {
			open = !open;
			calculator.setVisible(open);
			playSound("resources/boing_x.wav");

		}
		
		if (e.getSource() == startButton) {
			namePanel.removeAll();
			mainFrame.remove(startButton);
			
			gbc.gridwidth = 1;
			gbc.gridx = 0;
			
			mainFrame.add(prevLesson, gbc);
			
			gbc.gridx = 1;
			
			mainFrame.add(calc, gbc);
			
			gbc.gridx = 2;
			
			mainFrame.add(help, gbc);
			
			gbc.gridx = 3;
			
			mainFrame.add(nextLesson, gbc);
			
			mainFrame.revalidate();
			mainFrame.repaint();
			mainFrame.pack();
			mainFrame.setVisible(true);
			mainFrame.setResizable(false);
			
			c.changeState(1);
			b.changeState(1);
			a.changeState(1);
			d.changeState(1);
		}

	}
}