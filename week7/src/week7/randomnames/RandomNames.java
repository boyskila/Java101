//Use more descriptive names and write comments

package week7.randomnames;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNames {
	private class Pair {
		Person nameA;
		Person nameB;

		public Pair() {

		}

		public Pair(Person nameA, Person nameB) {
			super();
			this.nameA = nameA;
			this.nameB = nameB;
		}

		public List<Pair> organizePairs(List<Person> list) {
			Random rand = new Random();
			List<Pair> pairs = new ArrayList<>();
			if (list.size() % 2 != 0) {
				int num = rand.nextInt(list.size());
				pairs.add(new RandomNames().new Pair(list.remove(num), null));
			}
			while (!list.isEmpty()) {
				int size = list.size();
				int num = rand.nextInt(size);
				Person nameA = list.remove(num);
				num = rand.nextInt(list.size());
				Person nameB = list.remove(num);
				pairs.add(new RandomNames().new Pair(nameA, nameB));
			}
			return pairs;
		}

		@Override
		public String toString() {
			return nameA + " <===> " + nameB;
		}

	}

	public static List<String> readFile(Path path) throws IOException {
		return Files.readAllLines(path);
	}

	public static List<Person> getNames(List<String> names) {
		List<Person> name = new ArrayList<>();
		for (String names2 : names) {
			String[] nam = names2.split(", ");
			for (int i = 0; i < nam.length; i++) {
				String[] n = nam[i].split(" ");
				name.add(new Person(n[0], n[1]));
			}

		}
		return name;
	}

	public static void main(String[] args) throws IOException {
		List<Person> list = getNames(readFile(Paths.get("names")));
		List<Pair> pairs = new RandomNames().new Pair().organizePairs(list);
		for (Pair pair : pairs) {
			System.out.println(pair);
		}
	}
}
