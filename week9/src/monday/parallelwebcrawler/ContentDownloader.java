package monday.parallelwebcrawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ContentDownloader implements Runnable {
	private HtmlDocumentStorage<Document> htmlStorage;
	private URLStorage<String> urlStorage;

	public ContentDownloader(URLStorage<String> urlStorage,
			HtmlDocumentStorage<Document> htmlStorage) {
		this.urlStorage = urlStorage;
		this.htmlStorage = htmlStorage;
	}

	@Override
	public void run() {
		while (true) {
			try {
				String url = urlStorage.getURL();
				Document doc = Jsoup.connect(url).ignoreHttpErrors(true).get();
				if (doc.text().contains("junk")) {
					System.out.println(doc);
					System.err.println(url);
					System.exit(0);
				}
				// System.out.println(doc);
				htmlStorage.addDocument(doc);
				// System.out.println(htmlStorage.getStorage());
			} catch (IOException e) {
				continue;
			}
		}
	}
}
