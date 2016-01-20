package wednesday.webcrawer;

import java.util.LinkedList;
import java.util.Queue;

public class WebSiteCrawler {
	private String needle;
	private String url;
	private Queue<String> toVisit;
	private DocumentCrawler documentCrawler;

	public WebSiteCrawler(String url, String needle) {
		super();
		toVisit = new LinkedList<>();
		// add input URL
		toVisit.add(url);
		documentCrawler = new DocumentCrawler();
		this.url = url;
		this.needle = needle;
	}

	public void search() {
		while (!isNeedle()) {
			documentCrawler = new DocumentCrawler();
			url = toVisit.poll();
			documentCrawler.extractLinks(url);
			toVisit.addAll(documentCrawler.getLinks());
		}
		System.out.println(needle + " found in " + url);
	}

	private boolean isNeedle() {
		return documentCrawler.getWebContent() != null
				&& documentCrawler.getWebContent().contains(needle);
	}
}
