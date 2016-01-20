package week7.wednesday.downloadfile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

public class DownloadFile {
	private static final String ADDRESS = "http://www.oddities123.com/wp-content/uploads/2010/08/wtf-pics-21.jpg";

	private static void downloadImage(String url) throws MalformedURLException {
		URL imageLocation = new URL(url);
		BufferedImage image = null;
		try {
			image = ImageIO.read(imageLocation);
			ImageIO.write(image, "jpg", new File("image.jpg"));
			System.out.println("Image downloaded successfully!");
		} catch (Exception e) {
			System.err.println("Image not exsist");
		}
	}

	public static void main(String[] args) throws IOException {
		downloadImage(ADDRESS);
	}
}
