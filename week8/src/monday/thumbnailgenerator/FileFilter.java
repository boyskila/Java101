package monday.thumbnailgenerator;

import java.io.File;
import java.io.FilenameFilter;

public class FileFilter implements FilenameFilter {

	private enum Extensions {
		GIF, PNG, JPG, BMP
	}

	@Override
	public boolean accept(File dir, String name) {
		for (Extensions extension : Extensions.values()) {
			if (name.toUpperCase().endsWith(extension.toString())) {
				return true;
			}
		}
		return false;
	}
}
