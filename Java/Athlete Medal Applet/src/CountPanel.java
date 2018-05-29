// Assignment #: 6
//         Name: Michael Pardi
//    StudentID: 1201659320
//      Lecture: TTh 4:30-5:45
//  Description: Controls the layout and components of the Count Athlete tab.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class CountPanel extends JPanel
 {
     private Vector<Athlete> athleteList;
     private Container p1;
     private Container p2;
     private Container p3;
     private Container p4;
     private JScrollPane scroll;
     private JLabel instructionsLabel;
     private JTextArea list;
     private JRadioButton gold;
     private JRadioButton silver;;
     private JRadioButton bronze;
     private ButtonGroup medals;
     private JButton button1;
     
   //Constructor initialize each component and arrange them using
   //certain layouts
   public CountPanel(Vector<Athlete> athleteList)
     {
         this.athleteList = athleteList;
         
         p1 = new Container();
         p2 = new Container();
         p3 = new Container();
         p4 = new Container();
         
         instructionsLabel = new JLabel("Choose an athlete and a medal type to increase its count:");
         
         list = new JTextArea();

         list.setEditable(false);
         
         scroll = new JScrollPane(list);
         scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
         
         
         gold = new JRadioButton("Gold");
         silver = new JRadioButton("Silver");
         bronze = new JRadioButton("Bronze");
         medals = new ButtonGroup();
         medals.add(gold);
         medals.add(silver);
         medals.add(bronze);
         
         button1 = new JButton("Increase Medal Count");

        //organize components for spending panel
         setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
         p1.setLayout(new GridLayout(1, 1));
         p2.setLayout(new BorderLayout());
         p3.setLayout(new GridLayout(1, 3));
         p4.setLayout(new GridLayout(1, 1));
         
         add(p1);
         p1.add(instructionsLabel);
         add(p2);
         p2.add(scroll);
         add(p3);
         p3.add(gold);
         p3.add(silver);
         p3.add(bronze);
         add(p4);
         p4.add(button1);
     }

 //This method  refreshes the JComboBox with
 //updated vector information
 public void updateAthleteList()
  {
      //call updateUI() for the JList object
  }
     

 //CountListener class listens to see the radio buttons
 //was chosen
 private class CountListener implements ActionListener
     {
         public void actionPerformed(ActionEvent event)
         {
           //TO BE COMPLETED
         }
     }
     


 //ButtonListener class listens to see the button "Increase Medal Count" is pushed.
 //A user can choose which athlete to increase medal counts and that will update the
 //medal count of such athlete.
 private class ButtonListener implements ActionListener
  {
       public void actionPerformed(ActionEvent event)
        {
            //TO BE COMPLETED
        }
  } //end of ButtonListener class

} //end of CountPanel class