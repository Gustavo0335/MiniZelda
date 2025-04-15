package Zeldaminiclone;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {

	public static BufferedImage spritesheet;

	public static BufferedImage[] player_front;

	public static BufferedImage[] Enemy_front;

	public static BufferedImage tileWall;
	
	public static BufferedImage Bow;

	public Spritesheet() {
		try {
			spritesheet = ImageIO.read(getClass().getResource("/spritesheet.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		player_front = new BufferedImage[2]; // Spritesheet.getSprite(0, 11, 16, 16)
		player_front[0] = Spritesheet.getSprite(0, 11, 16, 16);
		player_front[1] = Spritesheet.getSprite(16, 11, 16, 16);
		Enemy_front = new BufferedImage[2];
		Enemy_front[0] = Spritesheet.getSprite(175, 214, 16, 16);
		Enemy_front[1] = Spritesheet.getSprite(193, 214, 16, 16);
		tileWall = Spritesheet.getSprite(282, 242, 16, 16);
		Bow = Spritesheet.getSprite(10, 186, 10, 10);
	}

	public static BufferedImage getSprite(int x, int y, int width, int height) {
		return spritesheet.getSubimage(x, y, width, height);
	}
}
