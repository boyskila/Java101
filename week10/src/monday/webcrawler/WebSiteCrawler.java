package monday.webcrawler;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class WebSiteCrawler {
	private String needle;
	private String url;
	private Queue<String> toVisit;
	/*
	 * DocumentCrawler using JSOUP to retrieve href's from <a> tag's
	 */
	private DocumentCrawler documentCrawler;

	/*
	 * MyDocumentCrawler not using external lib's
	 */
	// private MyDocumentCrawler myDocumentCrawler;

	public WebSiteCrawler(String url, String needle) {
		super();
		toVisit = new LinkedList<>();
		// add starting URL
		toVisit.add(url);
		documentCrawler = new DocumentCrawler();
		// myDocumentCrawler = new MyDocumentCrawler();
		this.url = url;
		this.needle = needle;
	}

	public void search() throws IOException {
		while (!isNeedle()) {
			documentCrawler = new DocumentCrawler();
			url = toVisit.poll();
			documentCrawler.extractLinks(url);
			toVisit.addAll(documentCrawler.getLinks());
		}
		System.out.println(needle + " found in " + url);
	}

	// public void mySearch() throws IOException {
	// String content = "";
	// while (!isNeedle(content)) {
	// myDocumentCrawler = new MyDocumentCrawler();
	// url = toVisit.poll();
	// content = myDocumentCrawler.getContent(url);
	// myDocumentCrawler.getAllLinks(url, content);
	// toVisit.addAll(myDocumentCrawler.getLinks());
	// }
	// System.out.println(needle + " found in " + url);
	// }
	//
	// private boolean isNeedle(String content) {
	// return content != null && content.contains(needle);
	// }

	private boolean isNeedle() {
		return documentCrawler.getWebContent() != null
				&& documentCrawler.getWebContent().contains(needle);
	}
}