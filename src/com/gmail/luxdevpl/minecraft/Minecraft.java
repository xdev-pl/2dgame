package com.gmail.luxdevpl.minecraft;

import com.gmail.luxdevpl.minecraft.world.Location;
import com.gmail.luxdevpl.minecraft.world.MinecraftWorld;

import gfx.Assets;
import gfx.GraphicsLoader;
import gfx.Sheet;
import input.KeyManager;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.gmail.luxdevpl.minecraft.entity.Player;
import com.gmail.luxdevpl.minecraft.world.AbstractWorld;

public class Minecraft implements MinecraftGame, Runnable {
	
	private Thread thread;
	
	private BufferStrategy bufferStrategy;
	
	private Graphics graphics;
	
	private JFrame frame;
	
	private Canvas canvas;
	
	private boolean running = false;
	
	private KeyManager keyManager;
	
	private AbstractWorld world;
	
	@Override
	public synchronized void start() {
		frame = new JFrame("Minecraft 2D");
		frame.setSize(1280, 720);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		
		canvas.setPreferredSize(new Dimension(1280, 720));
		canvas.setMaximumSize(new Dimension(1280, 720));
		canvas.setMinimumSize(new Dimension(1280, 720));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();

		keyManager = new KeyManager();
		
		frame.addKeyListener(keyManager);
		
		Assets.load();
		
		this.thread = new Thread(this);
	
		running = true;
		
		thread.start();
	
		this.world = new MinecraftWorld("swiat", 3424.2);
		
		world.create();
		
		Player player = new Player(new Location(0, 0, this.world));
		world.getEntities().add(player);
	}
	
	@Override
	public void doFullTick() {
		keyManager.tick();
		
		world.getEntities().forEach(Player::tick);
	}
	
	private void render() {
		bufferStrategy = this.canvas.getBufferStrategy();
		
		if(bufferStrategy == null) {
			this.canvas.createBufferStrategy(3);
			return;
		}
		
		graphics = bufferStrategy.getDrawGraphics();
		
		graphics.clearRect(0, 0, 1280, 720);
		
		world.getEntities().forEach(player -> player.render(graphics));
		
		bufferStrategy.show();
		
		graphics.dispose();
	}
	
	@Override
	public void run() {
		while(running) {
			this.doFullTick();
			this.render();
		}
		
	}

	@Override
	public void stop() {
		this.save();
	
		try {
			running = false;
			this.thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Game has been stopped.");
		
	}

	@Override
	public void save() {
		// TODO Saving method.
		
	}

	@Override
	public void load() {
		// TODO Map loading method
		
	}
	
	public KeyManager getKeyManager() {
		return this.keyManager;
	}

}
