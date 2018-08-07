package gfx;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.gmail.luxdevpl.minecraft.Main;

public class GraphicsLoader {
	
	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(GraphicsLoader.class.getResource(path));
		} catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
