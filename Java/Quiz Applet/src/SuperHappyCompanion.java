package project04;

import java.awt.Color;
import java.awt.Graphics;

public class SuperHappyCompanion extends CompanionDecorator {
	
	public void draw(Graphics face, Color color, boolean blink, boolean excited, int xPos, int yPos) {
		
		super.draw(face, color, blink, excited, xPos, yPos);
		
		//mouth
		face.fillArc(xPos + 25, yPos + 25, 100, 100, 180, 180);
	}
}
