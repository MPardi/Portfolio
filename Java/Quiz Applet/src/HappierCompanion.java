package project04;

import java.awt.*;

public class HappierCompanion extends CompanionDecorator {
	
	public void draw(Graphics face, Color color, boolean blink, boolean excited, int xPos, int yPos) {
		super.draw(face, color, blink, excited, xPos, yPos);
		
		//mouth
		face.fillArc(145, 145, 100, 100, 180, 180);
	}
}
