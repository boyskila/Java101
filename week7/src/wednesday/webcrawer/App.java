package wednesday.webcrawer;

public class App {
	private final static String WEB = "http://ebusiness.free.bg/";
	// private final static String WEB = "http://abv.bg";
	private static final String NEEDLE = "Револвираща";

	// private static final String NEEDLE = "Бойко";

	public static void main(String[] args) {
		WebSiteCrawler spider = new WebSiteCrawler(WEB, NEEDLE);
		spider.search();
	}
}
