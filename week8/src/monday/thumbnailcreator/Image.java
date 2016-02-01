package monday.thumbnailcreator;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {
	private String path;
	private String pathToCopy;
	private BufferedImage image;
	private int height;
	private int width;

	public Image(String path, int width, int height) {
		super();
		this.path = path;
		File file = new File(path);
		setPathToCopy(file.getParent() + "/thumbnails");
		try {
			this.image = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.width = width;
		this.height = height;
	}

	public BufferedImage readImage() throws IOException {
		return image;

	}

	public String getPath() {
		return path;
	}

	public BufferedImage getImage() {
		return image;
	}

	public String getPathToCopy() {
		return pathToCopy;
	}

	public void setPathToCopy(String pathToCopy) {
		this.pathToCopy = pathToCopy;
		File f = new File(pathToCopy);
		if (!f.exists()) {
			f.mkdir();
		}
	}

	@Override
	public String toString() {
		return "Image [path=" + path + ", pathToCopy=" + getPathToCopy()
				+ ", image=" + image + "]";
	}
}
