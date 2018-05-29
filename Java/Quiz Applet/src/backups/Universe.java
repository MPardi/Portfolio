package Project03;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
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
public class Universe extends JFrame implements ChangeListener {

    //Sets up all components
    private JFrame mainFrame = new JFrame("CSE360 Project One");
    private JPanel namePanel = new JPanel();
    
    private Border raisedbevel = BorderFactory.createRaisedBevelBorder();
    private Border loweredbevel = BorderFactory.createLoweredBevelBorder();

    //Instantiate class objects
    private final CompanionPanel a = new CompanionPanel();
    private final TutorPanel b = new TutorPanel();
    private final AssessorPanel c = new AssessorPanel(this);
    private final DescriptorPanel d = new DescriptorPanel();
    private JSlider slider1 = new JSlider(1, 2, 1);

    //Initial state
    private int state = 0;

    //Constructor
    public Universe() {
        prepareGUI();
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Universe main = new Universe();
    }

    public void prepareGUI() {
        //Sets close operation and mainFrame layout
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new GridBagLayout());

        //Constraints for GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();

        //Creates borders
        a.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
        b.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
        c.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
        d.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));

        //GBC settings
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

        slider1.setSnapToTicks(true);
        slider1.setPaintTicks(true);
        slider1.setMajorTickSpacing(1);

        slider1.addChangeListener(this);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 4;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weighty = 1000;

        mainFrame.add(slider1, gbc);

        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
    }

    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();

        //If slider isn't being used
        if (!source.getValueIsAdjusting()) {
            if (state == 0) {
                namePanel.removeAll();

                if ((int)source.getValue() != 1) {
                    state = 1;
                    c.setState((int)source.getValue());
                    b.changeState((int)source.getValue());
                    a.changeState((int)source.getValue());
                    d.changeState(state);
                }
            }
            else {
                c.setState((int)source.getValue());
                b.changeState((int)source.getValue());
                a.changeState((int)source.getValue());
                d.changeState((int)source.getValue());
            }
        }
    }

    public void setQuestionsCounts() {
        a.setCorrectCount(c.getCorrectAnswerCount());
        a.setIncorrectCount(c.getWrongAnswerCount());
    }
}