package monday.randomnames;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNames {
	public class Pair {
		Person nameA;
		Person nameB;

		public Pair() {

		}

		public Pair(Person nameA, Person nameB) {
			super();
			this.nameA = nameA;
			this.nameB = nameB;
		}

		public List<Pair> organizePairs(List<Person> persons) {
			int randomNumber = 0;
			Random rand = new Random();
			List<Pair> pairs = new ArrayList<>();
			if (persons.size() % 2 != 0) {
				randomNumber = rand.nextInt(persons.size());
				pairs.add(new RandomNames().new Pair(persons
						.remove(randomNumber), null));
			}
			while (!persons.isEmpty()) {
				int size = persons.size();
				randomNumber = rand.nextInt(size);
				Person personA = persons.remove(randomNumber);
				randomNumber = rand.nextInt(persons.size());
				Person personB = persons.remove(randomNumber);
				pairs.add(new RandomNames().new Pair(personA, personB));
			}
			return pairs;
		}

		@Override
		public String toString() {
			return nameA + " <===> " + nameB;
		}

	}

	public List<Person> getNames(List<String> names) {
		List<Person> persons = new ArrayList<>();
		for (String name : names) {
			String[] nam = name.split(", ");
			for (int i = 0; i < nam.length; i++) {
				String[] fullName = nam[i].split(" ");
				persons.add(new Person(fullName[0], fullName[1]));
			}

		}
		return persons;
	}
}
