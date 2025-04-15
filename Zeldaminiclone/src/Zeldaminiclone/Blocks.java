package Zeldaminiclone;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Blocks extends Rectangle {

	public Blocks(int x, int y) {

		super(x, y, 32, 32);
	}

	public void render(Graphics g) {
		//g.setColor(Color.GRAY);
		//g.fillRect(x, y, width, height);
		g.drawImage(Spritesheet.tileWall, x, y, 32, 32, null);
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);
	    

	}
}
