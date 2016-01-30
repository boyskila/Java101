package monday.thumbnailgenerator;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;
import org.imgscalr.Scalr.Mode;

public class ThumbnailGenerator {
	private int height;
	private int width;
	private Map<BufferedImage, File> map;

	public ThumbnailGenerator(Map<BufferedImage, File> queue, int height, int width) {
		super();
		this.height = height;
		this.width = width;
		this.map = queue;
	}

	public void createThumbnails() throws IOException, InterruptedException {
		int count = 0;
		for (Map.Entry<BufferedImage, File> entry : map.entrySet()) {
			System.out.println(entry.getValue());
			BufferedImage image = entry.getKey();
			File path = entry.getValue();
			File thumbnail = new File(path + "/img" + count++);
			System.out.println(thumbnail.getAbsolutePath());
			BufferedImage thumbImg = Scalr.resize(image, Method.QUALITY, Mode.AUTOMATIC, height, width,
					Scalr.OP_ANTIALIAS);
			ImageIO.write(thumbImg, "png", thumbnail);
		}
	}
}
