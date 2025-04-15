package Zeldaminiclone;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Bullet extends Rectangle {

	public int dir = 1;

	public int speed = 8;

	public int timer = 0;
	

	public Bullet(int x, int y, int dir) {
		super(x + 16, y + 16, 10, 10);
		this.dir = dir;
	}

	public void tick() {

		x += speed * dir;
		timer++;
		if (timer == 60) {
			Player.bullets.remove(this);
			return;
		}
	}

	public void render(Graphics g) {

		//g.setColor(Color.red);
		//g.fillOval(x, y, width, height);
		g.drawImage(Spritesheet.Bow, x,y,10,10,null);
		
	}
}
