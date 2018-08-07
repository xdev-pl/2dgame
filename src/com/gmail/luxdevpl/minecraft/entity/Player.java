package com.gmail.luxdevpl.minecraft.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.gmail.luxdevpl.minecraft.Main;
import com.gmail.luxdevpl.minecraft.world.Block;
import com.gmail.luxdevpl.minecraft.world.Location;
import com.gmail.luxdevpl.minecraft.world.Material;

import gfx.Assets;
import gfx.Sheet;

public class Player extends AbstractEntity {
	
	private Location location;
	
	private List<Block> poops = new ArrayList<>();
	
	private long lastPoop;
	
	public Player(Location location) {
		this.location = location;
	}
	
	public void tick() {
		if(Main.getMinecraft().getKeyManager().down) {
			this.location.setY(location.getY() +0.05);
		}
		
		if(Main.getMinecraft().getKeyManager().up) {
			this.location.setY(location.getY() -0.05);
		}
		
		if(Main.getMinecraft().getKeyManager().left) {
			this.location.setX(location.getX() -0.05);
		}
		
		if(Main.getMinecraft().getKeyManager().right) {
			this.location.setX(location.getX() +0.05);
		}
		
	}
	
	public void render(Graphics graphics) {
		if(Main.getMinecraft().getKeyManager().poop) {
			if(System.currentTimeMillis() - this.lastPoop > 1000) {
				this.lastPoop = System.currentTimeMillis();
				
				Block block = new Block(Material.DIRT, this.location.getWorld(), 1, new Location(this.location.getX(), this.location.getY(), this.location.getWorld()), true);
				
				this.poops.add(block);
			}
	
		}
		for(Block block : poops) {
			System.out.println("Rendering: " + block.getLocation().getX() + " > " + poops.size());
			graphics.drawImage(Assets.poop, (int) block.getLocation().getX(), (int) block.getLocation().getY(), null);
			
		}
		
		graphics.drawImage(Assets.player, (int) this.location.getX(), (int) this.location.getY(), null);
	}
}
