package com.gmail.luxdevpl.minecraft.world;

import java.util.List;

import metadata.MetadataValue;
import metadata.Metadatable;

public class Block implements Metadatable {
	
	private final Material material;
	
	private final AbstractWorld world;
	
	private final int id;
	
	private final Location location;
	
	private final boolean isSolid;
	
	public Block(Material material, AbstractWorld world, int id, Location location, boolean isSolid) {
		this.material = material;
		
		this.world = world;
		
		this.id = id;
		
		this.location = location;
		
		this.isSolid = isSolid;
	}
	
	public Material getType() {
		return material;
	}
	
	public AbstractWorld getWorld() {
		return world;
	}
	
	public Location getLocation() {
		return location;
	}

	@Deprecated
	public int getId() {
		return id;
	}

	@Override
	public List<MetadataValue> getMetadata() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasMetadata() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setMetadata() {
		// TODO Auto-generated method stub
		
	}

}
