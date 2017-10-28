import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Font;

public class EmployerText {
	public static void main(String[] args) throws Exception {
		final BufferedImage image = ImageIO.read(new File("C:\\Users\\alam\\Desktop\\blue2.png"));
		
		Graphics g = image.getGraphics();
		g.setFont(g.getFont().deriveFont(40f));
		g.drawString("[Company Name Here]", 0, 200);
		g.dispose();

		ImageIO.write(image, "png", new File("test.png"));
	}
}