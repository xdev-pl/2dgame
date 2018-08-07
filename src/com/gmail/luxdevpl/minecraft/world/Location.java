package com.gmail.luxdevpl.minecraft.world;

public class Location implements Cloneable {
	
	private double x, y;
	
	private final AbstractWorld world;
	
	public Location(double x, double y, AbstractWorld world) {
		this.x = x;
		this.y = y;
		
		this.world = world;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}

	public AbstractWorld getWorld() {
		return world;
	}

}
