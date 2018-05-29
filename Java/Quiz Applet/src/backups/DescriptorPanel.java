package Project03;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

@SuppressWarnings("serial")

//Tain Henning
public class DescriptorPanel extends JPanel {
	private JPanel namePanel = new JPanel(new GridBagLayout());
	private JLabel nameLabel = new JLabel("Descriptor Area");

	int state = 0;
	static int appendCount = 0;
	static int correctAmount = 0;

	GridBagConstraints gbc = new GridBagConstraints();

	static JTextPane mainText = new JTextPane();
	static StyledDocument doc = (StyledDocument) mainText.getDocument();

	public DescriptorPanel() {

		this.setVisible(true);

		try {

			SimpleAttributeSet center = new SimpleAttributeSet();
			StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
			doc.setParagraphAttributes(0, doc.getLength() - 1, center, false);
		} catch (Exception ex) {

			ex.printStackTrace();
		}

		firstLoad();
		// prepareGUI();
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

	public void prepareGUI() {
		// mainText.setBackground(Color.black);
		// mainText.setForeground(Color.white);
		mainText.setOpaque(false);
		mainText.setEditable(false);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(400, 400));
		mainText.setLayout(new BorderLayout());
		this.add(mainText);
	}

	public static void appendText(boolean bol) throws BadLocationException // to implement just type
																			// Descriptor.appendText(boolean value);
	{
		if (appendCount == 24) {
			mainText.setText("");
			appendCount = 0;
		}

		if (bol == true) {
			System.out.println("Correct\n");
			doc.insertString(doc.getLength(), "Correct!\n", null);
			// mainText.append("Correct!\n");
			correctAmount++;
			if (correctAmount > 6) {
				doc.insertString(doc.getLength(), "Lesson completed!\n", null);
				// mainText.append("Lesson completed!\n");
			}
		} else
			doc.insertString(doc.getLength(), "Incorrect!\n", null);
		// mainText.append("Incorrect\n");
		appendCount++;

	}
}