package monday.parallelwebcrawler;

import org.jsoup.nodes.Document;

public class Main {
	private static final String DOMAIN = "http://www.9gag.com";

	public static void main(String[] args) throws InterruptedException {
		HtmlDocumentStorage<Document> htmlStorage = new HtmlDocumentStorage<>();
		URLStorage<String> urlStorage = new URLStorage<>();
		urlStorage.addURL(DOMAIN);
		// urlStorage.addURL("http://www.9gag.com");
		ContentDownloader cd = new ContentDownloader(urlStorage, htmlStorage);
		Thread contentDownloader = new Thread(cd);
		contentDownloader.start();
		// ContentDownloader cd = new ContentDownloader(urlStorage,
		// htmlStorage);
		Thread contentDownloader2 = new Thread(cd);
		//contentDownloader2.start();
		Thread contentDownloader3 = new Thread(cd);
		//contentDownloader3.start();
		Thread urlExtractor = new Thread(new URLExtractor(htmlStorage,
				urlStorage, DOMAIN));
		Thread urlExtractor2 = new Thread(new URLExtractor(htmlStorage,
				urlStorage, DOMAIN));
		urlExtractor.start();
		//urlExtractor2.start();
		// contentDownloader.join();
		// urlExtractor.join();
		// try {
		// contentDownloader.join();
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println(htmlStorage.getStorage());
	}
}
