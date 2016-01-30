package monday.thumbnailgenerator;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

public class RecursiveWalk extends Thread {
	private volatile Map<BufferedImage, File> map;
	private File path;

	public RecursiveWalk(Map<BufferedImage, File> map, File path)
			throws InterruptedException {
		this.map = map;
		this.path = path;
	}

	public void recursiveWalk(File path) throws InterruptedException,
			IOException {
		File thumbnailDir = new File(path + "/thumbnails");
		thumbnailDir.mkdir();
		File[] content = path.listFiles();
		for (File file : content) {
			if (file.isDirectory() && !file.getName().equals("thumbnails")) {
				recursiveWalk(file);
			}
			if (file.getName().endsWith("JPG")) {
				System.out.println(thumbnailDir.getAbsolutePath());
				map.put(ImageIO.read(file), thumbnailDir);
			}
		}
		System.out.println(map);
	}

	@Override
	public void run() {
		try {
			synchronized (map) {
				while (map.size() == 5) {
					map.wait();
				}
				recursiveWalk(path);
			}
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
