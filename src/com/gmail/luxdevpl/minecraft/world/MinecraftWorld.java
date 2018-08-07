package com.gmail.luxdevpl.minecraft.world;

import java.util.ArrayList;
import java.util.List;

import com.gmail.luxdevpl.minecraft.entity.Player;

public class MinecraftWorld extends AbstractWorld {
	
	private List<Player> entities;

	public MinecraftWorld(String name, double seed) {
		super(name, seed);
		
		this.entities = new ArrayList<>();
	}

	@Override
	public void create() {
		//TODO: Map generation.
		
		System.out.println("Map: " + super.getName() + " with seed: " + super.getSeed() + " has been created. ");
		
		Block block = new Block(Material.DIRT, this, 1, new Location(0, 0, this), true);
		
		super.placeBlock(block);
		
	}
	
	public void addEntity(Player player) {
		this.entities.add(player);
	}
	
	public List<Player> getEntites(){
		return entities;
	}

}
