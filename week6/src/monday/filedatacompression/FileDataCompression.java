package monday.filedatacompression;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class FileDataCompression {
	public static final File COMPRESSED_DATA = new File("compressedFile.properties");
	private static Properties properties = new Properties();

	public static void compress(Path path) throws IOException {
		int wordId = -1;
		Map<String, Integer> mappedWords = new HashMap<>();
		List<String> content = Files.readAllLines(path);
		for (String line : content) {
			line = line.replaceAll("\\s+", "~");
			String[] words = line.split("~");
			for (String word : words) {
				word = word.replaceAll("\\p{Punct}", "");
				if (!mappedWords.containsKey(word)) {
					mappedWords.put(word, ++wordId);
					properties.put(wordId + "", word);
				}
				line = line.replaceFirst(word, mappedWords.get(word) + "");
			}
			String oldValue = (String) properties.get("-1");
			String appendedData = oldValue != null ? oldValue + "\n" + line : line;
			properties.setProperty("-1", appendedData);
		}
		properties.store(new FileWriter(COMPRESSED_DATA), "compression");
		FileManager.openFileWithNotePad(COMPRESSED_DATA);
	}

	public static File decompress(Path path) throws ClassNotFoundException, IOException {
		properties.load(new FileReader(path.toFile()));
		String[] compressedText = properties.get("-1").toString().split("\n");
		StringBuilder stringBuilder = new StringBuilder();
		for (String line : compressedText) {
			String[] words = line.split("~");
			for (String code : words) {
				code = code.replaceAll("\\p{Punct}", "");
				String word = properties.getProperty(code);
				line = line.replaceAll(code, word);
			}
			stringBuilder.append(line.replaceAll("\\~", " ") + "\n");
		}
		return FileManager.saveToFile(stringBuilder.toString());
	}
}
