package Zeldaminiclone;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener {

	public static int WIDTH = 640, HEIGHT = 480;

	public static int SCALE = 3;

	public Player player;

	public World world;

	public List<Enemy> Enemys = new ArrayList<Enemy>();

	public Game() {
		this.addKeyListener(this);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		new Spritesheet();
		player = new Player(32, 32);
		world = new World();
		Enemys.add(new Enemy(32, 32));
	}

	public void tick() {

		player.tick();

		for (int i = 0; i < Enemys.size(); i++) {
			Enemys.get(i).tick();
		}
	}

	public void render() {

		BufferStrategy bs = this.getBufferStrategy();

		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		// g.setColor(new Color(0, 135, 13));
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);

		player.render(g);
		// g.setColor(Color.red);
		// g.fillRect(0, 0, 50, 50);
		for (int i = 0; i < Enemys.size(); i++) {
			Enemys.get(i).render(g);
		}

		world.render(g);

		bs.show();
	}

	public static void main(String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame();

		frame.add(game);
		frame.setTitle("Zelda");
		frame.setLocationRelativeTo(null);
		frame.pack();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		new Thread(game).start();
	}

	@Override
	public void run() {
		while (true) {
			tick();
			render();
			try {
				Thread.sleep(1000 / 60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			player.right = true;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {

			player.up = true;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_Z) {
			player.shoot = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			player.right = false;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {

			player.up = false;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down = false;
		}

	}

}
