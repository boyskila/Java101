package wednesday.webcrawer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyDocumentCrawler {
	private List<String> links;
	private static Set<String> visited = new HashSet<String>();

	public MyDocumentCrawler() {
		links = new ArrayList<>();
	}

	public void getAllLinks(String url2, String content)
			throws MalformedURLException {

		try {

			String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(content);
			while (matcher.find()) {
				String href = matcher.group(1);
				URL url = new URL(url2);
				String host = url.getHost();
				String protocol = url.getProtocol();
				href = normalizeHref(href);
				String fulladress = protocol + "://" + host + "/" + href;
				if (!visited.contains(fulladress)
						&& fulladress.contains(url.toString())) {
					links.add(fulladress);
				}
				visited.add(fulladress);
			}
		} catch (Exception e) {
			return;
		}
	}

	private String normalizeHref(String href) {
		if (href.contains("./")) {
			return href.substring(href.lastIndexOf("/") + 1);
		}
		return href;
	}

	public String getContent(String url) throws IOException {
		URL oracle = new URL(url);
		StringBuilder builder = new StringBuilder();
		try (BufferedReader in = new BufferedReader(new InputStreamReader(
				oracle.openStream()))) {
			String inputLine;
			while ((inputLine = in.readLine()) != null)
				builder.append(inputLine);

		}
		return builder.toString();
	}

	// send links
	public List<String> getLinks() {
		return links;
	}
}
