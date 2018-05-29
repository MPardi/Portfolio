package project04;

import java.awt.*;

public class NeutralCompanion extends CompanionDecorator {
	
	public void draw(Graphics face, Color color, boolean blink, boolean excited, int xPos, int yPos) {
		super.draw(face, color, blink, excited, xPos, yPos);
		
		//mouth
		face.fillRect(145, 215, 100, 10);
		
	}
}
