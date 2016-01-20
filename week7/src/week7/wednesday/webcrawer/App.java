package week7.wednesday.webcrawer;

public class App {
	private final static String WEB = "http://ebusiness.free.bg/";
	// private final static String WEB = "http://abv.bg";
	private static final String NEEDLE = "Револвираща";

	// private static final String NEEDLE = "Бойко";

	public static void main(String[] args) {
		Webcrawler spider = new Webcrawler(WEB, NEEDLE);
		spider.search();
	}
}
