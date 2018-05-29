package project04;

import java.awt.*;

public class HappyCompanion extends CompanionDecorator {
	
	public void draw(Graphics face, Color color, boolean blink, boolean excited, int xPos, int yPos) {
		super.draw(face, color, blink, excited, xPos, yPos);
		
		//mouth
		face.fillArc(145, 195, 100, 50, 180, 180);
		
	}
}
