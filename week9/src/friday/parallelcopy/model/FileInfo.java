package friday.parallelcopy.model;

import java.io.File;

public class FileInfo {
	private File path;
	private File target;
	private float size;

	public FileInfo(File path, File target, float size) {
		this.setPath(path);
		this.setTarget(target);
		this.setSize(size);
	}

	public File getPath() {
		return path;
	}

	public void setPath(File path) {
		this.path = path;
	}

	public File getTarget() {
		return target;
	}

	public void setTarget(File target) {
		this.target = target;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "FileInfo" + getPath() + " target "+ target;
	}
}
