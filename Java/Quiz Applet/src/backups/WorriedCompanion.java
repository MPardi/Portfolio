package Project03;

import java.awt.*;

public class WorriedCompanion extends CompanionDecorator {
	
	public void draw(Graphics face, Color color, boolean blink, boolean excited, int xPos, int yPos) {
		super.draw(face, color, blink, excited, xPos, yPos);
		
		//mouth
		face.drawArc(145, 200, 100, 60, 180, -180);
		
	}
}
