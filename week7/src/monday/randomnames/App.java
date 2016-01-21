package monday.randomnames;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class App {

	public static void main(String[] args) throws IOException {
		RandomNamesGenerator generator = new RandomNamesGenerator();
		List<String> names = FileUtils.readFile(Paths.get("names"));
		List<Person> persons = generator.getNames(names);
		generator.new Pair().organizePairs(persons);
		generator.printPairs();
	}
}
