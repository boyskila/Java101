package wednesday.filesearcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileSearcherTask implements Runnable {
	private final String pattern;
	private FileQueue db;
	private List<MatchDb> matchDb;

	public FileSearcherTask(FileQueue db, String pattern, List<MatchDb> matchDb) {
		this.pattern = pattern;
		this.db = db;
		this.matchDb = matchDb;
	}

	@Override
	public void run() {
		try {
			findPattern();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void findPattern() throws IOException {
		while (!db.isEmpty()) {
			Path path = db.getFile().toPath();
			String contentType = Files.probeContentType(path);
			// System.out.println(path + " " + contentType);
			try {
				// if (contentType.matches("text/plain")) {
				try (BufferedReader reader = Files.newBufferedReader(path)) {
					String line = null;
					int row = 1;
					while ((line = reader.readLine()) != null) {
						if (line.contains(pattern)) {
							matchDb.add(new MatchDb(pattern, path.toString(),
									row++));
						}
					}
				} catch (IOException x) {
				}
			} catch (Exception e) {

			}

			// }
		}
	}
}
