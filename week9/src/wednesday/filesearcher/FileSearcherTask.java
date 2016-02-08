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
			try {
				Path path = db.getFile().toPath();
				String contentType = Files.probeContentType(path);
				try {
					System.out.println(contentType);
					if (contentType.matches("text/plain")
							|| contentType.matches("application/msword")) {

						try (BufferedReader reader = Files
								.newBufferedReader(path)) {
							String line = null;
							int row = 1;
							while ((line = reader.readLine()) != null) {
								if (line.contains(pattern)) {
									matchDb.add(new MatchDb(pattern, path
											.toString(), row++));
								}
							}
						} catch (IOException x) {
							// System.out.println("Cannot open file.");
						}

						List<String> lines = Files.readAllLines(path);
						int len = lines.size();
						for (int i = 0; i < len; i++) {
							if (lines.get(i).contains(pattern)) {
								matchDb.add(new MatchDb(pattern, path
										.toString(), i));
							}

						}
					}
				} catch (Exception e) {

				}

			} catch (Exception e) {
			}
		}
	}
}
