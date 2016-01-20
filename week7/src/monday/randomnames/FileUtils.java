package monday.randomnames;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileUtils {
	public static List<String> readFile(Path path) throws IOException {
		return Files.readAllLines(path);
	}
}
