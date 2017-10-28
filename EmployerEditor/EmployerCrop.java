import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EmployerCrop {
	public static void main(String[] args) {
		makeImage(1, 267, 1, 0, 0, 400, 400);
		makeImage(1, 267, 268, 400, 0, 400, 400);
		makeImage(1, 267, 535, 0, 400, 400, 400);
		makeImage(1, 267, 802, 400, 400, 400, 400);
	}
	
	public static void makeImage(int start, int end, int nstart, int x, int y, int w, int h) {
		try {
			while (start <= end) {
				BufferedImage src = ImageIO.read(new File("C:\\Users\\alam\\Desktop\\uncropped\\" + start + ".jpg"));
				BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
				dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
				ImageIO.write(dst, "png", new File("C:\\Users\\alam\\Desktop\\cropped\\" + nstart + "_cropped.jpg"));
				System.out.println("Cropped C:\\Users\\alam\\Desktop\\uncropped\\" + nstart + ".jpg to C:\\Users\\alam\\Desktop\\cropped\\" + nstart + "_cropped.jpg");
				start++;
				nstart++;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}