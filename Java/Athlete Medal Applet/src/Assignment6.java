// Assignment #: 6
//         Name: Michael Pardi
//    StudentID: 1201659320
//      Lecture: TTh 4:30-5:45
//  Description: The Assignment 6 class creates a Tabbed Pane with
//               two tabs, one for athlete creation and one for
//               their medal count, and adds it as its Applet content
//               and also sets its size.

import javax.swing.*;
import java.util.*;

public class Assignment6 extends JApplet
 {

   private int APPLET_WIDTH = 500, APPLET_HEIGHT = 400;

   private JTabbedPane tPane;
   private CreatePanel createPanel;
   private CountPanel countPanel;
   private Vector athleteList;

   //The method init initializes the Applet with a Pane with two tabs
   public void init()
    {
	 //list of athletes to be used in every panel
    athleteList = new Vector();

	 //register panel uses the list of athletes
     countPanel = new CountPanel(athleteList);

     createPanel = new CreatePanel(athleteList, countPanel);

     //create a tabbed pane with two tabs
     tPane = new JTabbedPane();
     tPane.addTab("Athlete Creation", createPanel);
     tPane.addTab("Medal Count", countPanel);

     getContentPane().add(tPane);
     setSize (APPLET_WIDTH, APPLET_HEIGHT); //set Applet size
    }
}

