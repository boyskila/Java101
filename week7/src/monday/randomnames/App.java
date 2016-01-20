package monday.randomnames;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import monday.randomnames.RandomNames.Pair;

public class App {

	public static void main(String[] args) throws IOException {
		RandomNames randomNames = new RandomNames();
		List<Person> persons = randomNames.getNames(FileUtils.readFile(Paths
				.get("names")));
		List<Pair> pairs = randomNames.new Pair().organizePairs(persons);
		for (Pair pair : pairs) {
			System.out.println(pair);
		}
	}
}
