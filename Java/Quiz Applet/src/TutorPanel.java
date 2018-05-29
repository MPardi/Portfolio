package project04;
/*
 * Description:  Displays the lesson notes for the user to read. This will explain to the user how to
 * about approaching the questions that are given in the lesson, and are visible at all times during
 * the lesson.
 * Assignment: Recitation Project 3
 * Completion time: 2
 * 
 * Author: David Passapera
 * v1.0
 
 */
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.net.MalformedURLException;

public class TutorPanel extends JPanel {

    private int lesson;
    private String fileName;
    private URL path;
    private JEditorPane editorPane;
    private JScrollPane editorScrollPane;
    private JPanel namePanel = new JPanel(new GridBagLayout());
    private JLabel nameLabel = new JLabel("Lesson Notes Area");

    // constructor
    public TutorPanel() {
        // initialize state value to 0 when first ran for initial panel
        lesson = 0;
        
        namePanel.add(nameLabel);
        namePanel.setPreferredSize(new Dimension(385, 381));

        // instantiate Editor Pane
        editorPane = new JEditorPane();

        // set correct content for the editor pane according to its lesson number
        updateLesson();

        // add editor pane to a scroll pane
        editorScrollPane = new JScrollPane(editorPane);
        editorScrollPane.setPreferredSize(new Dimension(385, 381));
        //add(editorScrollPane);
        
        add(namePanel);
    }

    // changeState method to be called whenever the slider is moved in the
    // Universe.java class
    public void changeState(int s) {
        if (s != lesson) {
            if (lesson == 0) {
                removeAll();
                revalidate();
                repaint();
                
                add(editorScrollPane);
            }
            lesson = s;

            editorPane.setText("");

            updateLesson();
        }
    }

    // updateTutor method to be used every time state changes
    public void updateLesson() {

        // check if state is within proper bounds
        if (lesson >= 1 && lesson <= 2) {
            // update HTML file target to correct lesson html file
            fileName = "lesson" + lesson + ".html";

            // update file path and display correct HTML file in JEditorPane
            // use try-catch statements for all possible exceptions
            try {
                path = (new File(new File("src/main/resources"), fileName)).toURI().toURL();
                editorPane.setPage(path);
                editorPane.setEditable(false);
            } catch (MalformedURLException e) {
                System.err.println("Error: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            } catch (NullPointerException e) {
                System.err.println("Error: Null pointer Exception");
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            } catch (SecurityException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

        // check if this is the first time running the program (state will be
        // set to 0)
        if (lesson == 0) {
            editorPane.setText("Lesson Notes Area");
            editorPane.setEditable(false);
        }
    }
}