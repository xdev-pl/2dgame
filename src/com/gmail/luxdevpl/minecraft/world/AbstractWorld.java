package com.gmail.luxdevpl.minecraft.world;

import java.util.ArrayList;
import java.util.List;

import com.gmail.luxdevpl.minecraft.entity.Player;

public abstract class AbstractWorld {
	
	private String name;
	
	private double seed;
	
	private List<Block> blocks;
	
	private List<Player> entiies;
	
	public AbstractWorld(String name, double seed) {
		this.name = name;
		
		this.seed = seed;
		
		this.blocks = new ArrayList<>();
	
		this.entiies = new ArrayList<>();
	}
	
	protected String getName() {
		return name;
	}
	
	protected double getSeed() {
		return seed;
	}
	
	protected List<Block> getBlocks(){
		return blocks;
	}
	
	public List<Player> getEntities(){
		return entiies;
	}
	
	protected final void placeBlock(Block block) {
		this.blocks.add(block);
		
		System.out.println("Block: " + block.getType() + " with id: " + block.getId() + " has been added to the game on world: " + block.getWorld().getName());
		System.out.println(" and location x: " + block.getLocation().getX() + " y: " + block.getLocation().getY());
		
		//TODO: Make block visible
	}
	
	protected final void breakBlock(Block block) {
		this.blocks.remove(block);
		
		System.out.println("Block" + block.getType() + " with id: " + block.getId() + " has been removed from the game from world: " + block.getWorld().getName());
	}
	
	private final void load() {
		//if(!exists){
		//this.create();
		//} else {
		//loading code
	}
	
	public abstract void create();
	
}
