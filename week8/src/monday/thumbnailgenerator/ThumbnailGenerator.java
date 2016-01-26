package monday.thumbnailgenerator;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;
import org.imgscalr.Scalr.Mode;

public class ThumbnailGenerator {
	private File file;
	private int height;
	private int width;
	private BlockingQueue<BufferedImage> queue;
	private volatile boolean QUIT = true;

	public ThumbnailGenerator(BlockingQueue<BufferedImage> queue, File file, int height, int width) {
		super();
		this.file = file;
		this.height = height;
		this.width = width;
		this.queue = queue;
	}

	public void createThummnails() throws IOException, InterruptedException {
		File thumbnailsDir = new File(file.getAbsolutePath() + "/thumbnails");
		thumbnailsDir.mkdirs();
		int count = 0;
		while (QUIT) {
			BufferedImage image = queue.removeFirst();
			File thumbnail = new File(thumbnailsDir + "/img" + count++);
			System.out.println(thumbnail.getAbsolutePath());
			BufferedImage thumbImg = Scalr.resize(image, Method.QUALITY, Mode.AUTOMATIC, height, width,
					Scalr.OP_ANTIALIAS);
			ImageIO.write(thumbImg, "png", thumbnail);
		}
	}

	public void setQuit(boolean flag) {
		this.QUIT = flag;
	}
}
