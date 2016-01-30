package wednesday.codetester.api;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

public class ClassMetaData extends Reflections {
	// extract class metadata
	public ClassMetaData(String url) {
		super(new ConfigurationBuilder().setUrls(
				ClasspathHelper.forPackage(url)).setScanners(
				new MethodAnnotationsScanner()));
	}
}
