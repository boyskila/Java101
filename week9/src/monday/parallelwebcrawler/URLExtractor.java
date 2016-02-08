package monday.parallelwebcrawler;

import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class URLExtractor implements Runnable {
	private HtmlDocumentStorage<Document> htmlStorage;
	private URLStorage<String> urlStorage;
	private String domain;

	public URLExtractor(HtmlDocumentStorage<Document> htmlStorage,
			URLStorage<String> urlStorage, String domain) {
		super();
		this.htmlStorage = htmlStorage;
		this.urlStorage = urlStorage;
		this.domain = domain;
	}

	@Override
	public void run() {
		while (true) {
			Document doc = htmlStorage.getDocument();
			System.out.println("Getting Doc");
			Elements elements = doc.select("a[href]");
			for (Element element : elements) {
				String url = element.attr("href");
				try {
					Jsoup.connect(element.attr("href"));
					if (url.contains("9gag")) {
						urlStorage.addURL(url);
						System.out.println(url);
					}
				} catch (Exception e) {
					continue;
				}
			}
		}
	}

	public boolean isInsideDomain(String atr) throws MalformedURLException {
		return !atr.contains("yahoo") && !atr.contains("linkedin")
				&& !atr.contains("github") && !atr.contains("google")
				&& !atr.contains("facebook") && !atr.contains("twitter")
				&& !atr.contains("yahoo");
//		return !atr.contains("index");
	}
}
