// Assignment #: 6
//         Name: Michael Pardi
//    StudentID: 1201659320
//      Lecture: TTh 4:30-5:45
//  Description: Creates the components and adds them to the Create Atlhete tab.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

import java.util.*;

public class CreatePanel extends JPanel
 {
   private Vector<Athlete> athleteList;
   private Container p1;
   private Container subP1_1;
   private Container subP1_2;
   private Container subP1_3;
   private Container p4;
   private JButton button1;
   private JLabel responseLabel;
   private JLabel fNameLabel;
   private JLabel lNameLabel;
   private JLabel sportsLabel;
   private JTextField fNameField;
   private JTextField lNameField;
   private JTextField sportsField;
   private JTextArea inputArea;
   private JScrollPane scroll;
   private JPanel forScroll;
   private CountPanel cPanel;
   private ButtonListener lis;

   //Constructor initializes components and organize them using certain layouts
   public CreatePanel(Vector athleteList, CountPanel cPanel)
    {
      this.athleteList = athleteList;
      this.cPanel = cPanel;
      
      p1 = new Container();
      subP1_1 = new Container();
      subP1_2 = new Container();
      subP1_3 = new Container();
      p4 = new Container();
      
      responseLabel = new JLabel();
      responseLabel.setForeground(Color.RED);
      responseLabel.setPreferredSize(new Dimension(150, 16));
      
      fNameLabel = new JLabel("First Name" );
      lNameLabel = new JLabel("Last Name");
      sportsLabel = new JLabel("Sport");
      
      fNameField = new JTextField();
      fNameField.setMaximumSize(fNameField.getPreferredSize());
      lNameField = new JTextField();
      lNameField.setMaximumSize(lNameField.getPreferredSize());
      sportsField = new JTextField();
      sportsField.setMaximumSize(sportsField.getPreferredSize());
      
      button1 = new JButton("Create An Athlete");
      
      inputArea = new JTextArea("No Athlete");
      inputArea.setEditable(false);
      inputArea.setColumns(17);
      
      scroll = new JScrollPane(inputArea);
//      scroll.setMinimumSize(inputArea.getPreferredSize());
      scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      
      lis = new ButtonListener();
      //organize components here
      setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
      p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
      subP1_1.setLayout(new BorderLayout());
      subP1_2.setLayout(new GridLayout(3,2));
      subP1_3.setLayout(new BorderLayout());
      p4.setLayout(new BorderLayout());
      
      add(p1);
      p1.add(subP1_1);
      subP1_1.add(responseLabel, BorderLayout.WEST);
      p1.add(subP1_2);
      subP1_2.add(fNameLabel);
      subP1_2.add(fNameField);
      subP1_2.add(lNameLabel);
      subP1_2.add(lNameField);
      subP1_2.add(sportsLabel);
      subP1_2.add(sportsField);
      p1.add(subP1_3);
      subP1_3.add(button1, BorderLayout.NORTH);
      add(p4);
      p4.add(scroll);
      
      button1.addActionListener(lis);
    
  }


  //ButtonListener is a listener class that listens to
  //see if the button "Create an Athlete" is pushed.
  //When the event occurs, it adds an athlete using the information
  //entered by a user.
  //It also performs error checking.
  private class ButtonListener implements ActionListener
   {
	  
	private int buttonCount = 0;  
    public void actionPerformed(ActionEvent event)
     {
    	String fName = fNameField.getText();
    	String lName = lNameField.getText();
    	String sport = sportsField.getText();
    	
    	if(fName.equals("") || lName.equals("") || sport.equals("")) {
    		responseLabel.setText("Please enter all fields.");
    	}
    	else {
    		if(buttonCount == 0) {
        		inputArea.setText("");
        	}
    		responseLabel.setText("Athlete added.");
    		Athlete a = new Athlete();
    		
    		a.setFirstName(fName);
    		a.setLastName(lName);
    		a.setSport(sport);
    		
    		athleteList.add(a);
    		
    		inputArea.append(a.toString());
    		
    		fNameField.setText("");
    		lNameField.setText("");
    		sportsField.setText("");
    		
    		buttonCount++;
    	}
    	
    	

     } //end of actionPerformed method
  } //end of ButtonListener class

} //end of CreatePanel class