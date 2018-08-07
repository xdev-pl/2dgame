package com.gmail.luxdevpl.minecraft;

public interface MinecraftGame {
	
	void start();
	
	void stop();
	
	void save();

	void load();
	
	void doFullTick();

}
