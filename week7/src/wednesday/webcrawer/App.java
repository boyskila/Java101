package wednesday.webcrawer;

import java.io.IOException;

public class App {
	// private final static String WEB = "http://ebusiness.free.bg/";
	private final static String WEB = "http://abv.bg";
	// private static final String NEEDLE = "Револвираща";

	private static final String NEEDLE = "Григор";

	public static void main(String[] args) throws IOException {
		WebSiteCrawler spider = new WebSiteCrawler(WEB, NEEDLE);
		spider.search();
	}
}
