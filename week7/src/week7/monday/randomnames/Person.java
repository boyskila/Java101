package week7.monday.randomnames;

public class Person {
	private String firstName;
	private String lastName;

	public Person(String first, String last) {
		super();
		this.firstName = first;
		this.lastName = last;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}
