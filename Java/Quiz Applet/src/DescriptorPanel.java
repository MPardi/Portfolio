package project04;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

@SuppressWarnings("serial")

// Tain Henning
public class DescriptorPanel extends JPanel {
	private JPanel namePanel = new JPanel(new GridBagLayout());
	private JLabel nameLabel = new JLabel("Descriptor Area");

	int state = 0;
	static int appendCount = 0;
	static int correctAmount = 0;

	GridBagConstraints gbc = new GridBagConstraints();

	// static JTextPane mainText = new JTextPane();
	// static StyledDocument doc = (StyledDocument) mainText.getDocument();

	private static JLabel responseText = new JLabel();
	private static JLabel timeLabel = new JLabel();
	private static JLabel lessonLabel = new JLabel();
	private static JLabel keepTrack = new JLabel();

	private static ControlCenter controlCenter;

	public DescriptorPanel() {

		this.setVisible(true);

		// try {
		//
		// SimpleAttributeSet center = new SimpleAttributeSet();
		// StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		// doc.setParagraphAttributes(0, doc.getLength() - 1, center, false);
		// } catch (Exception ex) {
		//
		// ex.printStackTrace();
		// }

		firstLoad();
		// prepareGUI();
	}

	public void setControlCenter(ControlCenter controlCenter) {
		this.controlCenter = controlCenter;
	}

	public void firstLoad() {
		namePanel.add(nameLabel);
		namePanel.setPreferredSize(new Dimension(385, 381));
		add(namePanel);
	}

	public void changeState(int state) {
		if (state == 1) {
			removeAll();
			revalidate();
			repaint();

			prepareGUI();
		}
	}

	public static void updateLabels() {
		keepTrack.setText("Correct: " + controlCenter.getCorrectCount() + "    Incorrect: "
				+ controlCenter.getIncorrectCount() + "    Attepts: " + controlCenter.getAttempts());
		if (controlCenter.getQuestionTime() != 0) {
			timeLabel.setText("Last Question Time: " + controlCenter.getQuestionTime() + " Seconds");
		}
		lessonLabel.setText("Lesson: " + controlCenter.getCurrentLesson());
	}

	public void prepareGUI() {
		// mainText.setBackground(Color.black);
		// mainText.setForeground(Color.white);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 10, 0, 10);
		gbc.weighty = 0.25;
		responseText.setOpaque(false);
		this.setLayout(new GridBagLayout());
		this.setPreferredSize(new Dimension(400, 400));
		responseText.setLayout(new BorderLayout());
		responseText.setPreferredSize(new Dimension(100, 10));
		// lessonLabel.setPreferredSize(new Dimension(100, 10));
		lessonLabel.setHorizontalAlignment(JLabel.CENTER);
		responseText.setHorizontalAlignment(JLabel.CENTER);
		keepTrack.setHorizontalAlignment(JLabel.CENTER);
		timeLabel.setHorizontalAlignment(JLabel.CENTER);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridy = 0;

		this.add(keepTrack, gbc);
		keepTrack.setText("Correct: " + controlCenter.getCorrectCount() + "    Incorrect: "
				+ controlCenter.getIncorrectCount() + "    Attepts: " + controlCenter.getAttempts());
		gbc.gridy = 1;

		this.add(timeLabel, gbc);
		timeLabel.setText("Last Question Time: " + controlCenter.getQuestionTime() + " Seconds");

		gbc.gridy = 2;

		this.add(lessonLabel, gbc);
		lessonLabel.setText("Lesson: " + controlCenter.getCurrentLesson());

		gbc.gridy = 3;
		this.add(responseText, gbc);
		responseText.setText("Answer Response: ");
	}

	public static void appendText(boolean bol) // to implement just type
												// Descriptor.appendText(boolean
												// value);
	{
		if (appendCount == 24) {
			responseText.setText("");
			appendCount = 0;
		}

		if (bol == true) {
			System.out.println("Correct\n");
			// doc.insertString(doc.getLength(), "Correct!\n", null);
			responseText.setText("Answer Response: Correct!");
			// mainText.append("Correct!\n");
			correctAmount++;

			updateLabels();

			if (correctAmount > 6) {
				// doc.insertString(doc.getLength(), "Lesson completed!\n",
				// null);
				responseText.setText("Lesson Completed!");
				// mainText.append("Lesson completed!\n");
			}
		} else
			responseText.setText("Answer Response: Incorrect!");

		updateLabels();
		appendCount++;
	}
}