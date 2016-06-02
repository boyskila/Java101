
public class PersonDemo {

	public static void main(String[] args) {
		// init array with size of 10
		Person[] persons = new Person[10];

		// another way to fill the array
		Person[] personsArray = { 
				new Person("Gosho", 20, true),
				new Person("Pesho", 22, true),
				new Student("Penka", 20, true, 6),
				new Student("Deni", 25, true, 2),
				new Employee("Dinko", 27, true, 1000),
				new Employee("Iliancho", 21, true, 2000)
		};

		// create persons of different types

		Person person1 = new Person("Gosho", 20, true);
		Person person2 = new Person("Pesho", 22, true);
		Person person3 = new Student("Penka", 20, true, 6);
		Person person4 = new Student("Deni", 25, true, 2);
		Person person5 = new Employee("Dinko", 27, true, 1000);
		Person person6 = new Employee("Iliancho", 21, true, 2000);

		persons[0] = person1;
		persons[1] = person2;
		persons[2] = person3;
		persons[3] = person4;
		persons[4] = person5;
		persons[5] = person6;

		for (Person person : persons) {
			System.out.println(person + "\n");
		}

		int overtime = 4;
		System.out.println();
		for (Person person : persons) {
			if (person instanceof Employee) {
				// type casting...Java is type safety
				System.out.println("For " + overtime + " hours of overtime " + person.getName() + " will take "
						+ ((Employee) person).calculateOvertime(overtime));
			}
		}
		System.out.println();

		for (Person person : personsArray) {
			System.out.println(person + "\n");
		}
		// end of main method
	}
}
