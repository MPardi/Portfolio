package Project03;

import java.awt.*;

public class InitialCompanion implements Companion {

	public void draw(Graphics face, Color color, boolean blink, boolean excited, int xPos, int yPos) {
		if (excited) {
			face.setColor(color);
			face.fillOval(xPos, yPos, 150, 150);
			// left eye
			face.setColor(Color.black);
			face.fillOval(xPos + 40, yPos + 55, 10, 10);
			// right eye
			face.fillOval(xPos + 100, yPos + 55, 10, 10);
		} else {
			face.setColor(color);
			face.fillOval(120, 120, 150, 150);
			face.setColor(Color.black);
			if (blink) {
				// left eye
				face.drawLine(160, 165, 170, 165);
				// right eye
				face.drawLine(220, 165, 230, 165);
			} else {
				// left eye
				face.fillOval(160, 160, 10, 10);
				// right eye
				face.fillOval(220, 160, 10, 10);
			}
		}
	}

}
