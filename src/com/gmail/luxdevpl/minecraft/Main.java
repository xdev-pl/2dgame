package com.gmail.luxdevpl.minecraft;

public class Main {
	
	private static Minecraft minecraftGame;

	public static void main(String[] args) {
		System.out.println("The game should start!!");
		
		MinecraftGame minecraft = new Minecraft();
		
		minecraftGame = (Minecraft) minecraft;
		
		minecraft.start();
	}
	
	public static Minecraft getMinecraft() {
		return minecraftGame;
	}

}
