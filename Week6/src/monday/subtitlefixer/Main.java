package monday.subtitlefixer;

import java.io.File;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		File f = new File("lost.s04e11.hdtv.xvid-2hd.srt");
		new SubtitleFixer(f);
	}
}