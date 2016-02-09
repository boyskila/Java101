package monday.webcrawler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DocumentCrawler {
	private Document webContent;
	private List<String> links;
	private static Set<String> visited = new HashSet<String>();

	public DocumentCrawler() {
		links = new ArrayList<>();
	}

	// Read content and extract all links from <a> tag's using JSOUP
	public void extractLinks(String url) {
		try {
			Connection connection = Jsoup.connect(url);
			webContent = connection.get();
			Elements linksOnPage = webContent.select("a");
			for (Element link : linksOnPage) {
				String href = link.absUrl("href");
				// check for duplicates and whether is outside of scope
				if (!visited.contains(href)) {
					links.add(href);
				}
				visited.add(href);
			}
		} catch (Exception e) {
			return;
		}
	}

	public String getWebContent() {
		return webContent == null ? "" : webContent.text();
	}

	public List<String> getLinks() {
		return links;
	}
}
