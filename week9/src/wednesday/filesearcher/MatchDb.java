package wednesday.filesearcher;

public class MatchDb {
	private final String pattern;
	private final String fileName;
	private final int line;

	public MatchDb(String pattern, String fileName, int line) {
		this.pattern = pattern;
		this.fileName = fileName;
		this.line = line;
	}

	@Override
	public String toString() {
		return "pattern=" + pattern + ", found in " + fileName
				+ " at line=" + line;
	}
}
