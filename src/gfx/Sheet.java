package gfx;

import java.awt.image.BufferedImage;

public class Sheet {
	
	private BufferedImage image;
	
	public Sheet(BufferedImage image) {
		this.image = image;
	}
	
	public BufferedImage cropImage(int x, int y, int width, int height) {
		return this.image.getSubimage(x, y, width, height);
	}

}
