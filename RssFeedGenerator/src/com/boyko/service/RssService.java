package com.boyko.service;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class RssService {
	public String getRss(HttpServletResponse response, String rsslink) throws IOException {
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(rsslink);
			SyndFeedInput input = new SyndFeedInput();
			SyndFeed feed = input.build(new XmlReader(url.openConnection()));
			@SuppressWarnings("unchecked")
			List<SyndEntry> entries = feed.getEntries();
			for (SyndEntry syndEntry : entries) {
				sb.append("<h3>" + syndEntry.getTitle() + "</h3></br>");
				sb.append("<br/>");
				String desc = syndEntry.getDescription().getValue();
				if (desc.endsWith("/>") && desc.length() > 100) {
					desc = desc.substring(0, desc.length()-11);
				}
				sb.append("<div>"+desc + "<a href=" + syndEntry.getLink() + ">" + "more</a></div><hr><br/>");
			}
		} catch (IllegalArgumentException | FeedException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
