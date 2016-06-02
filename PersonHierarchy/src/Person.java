
public class Person {

	private String name;
	private int age;
	private boolean isMan;

	public Person(String name, int age, boolean isMan) {
		this.name = name;
		this.age = age;
		this.isMan = isMan;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public boolean isMan() {
		return isMan;
	}
	@Override
	public String toString(){
		return "Name: " + name + "\nAge: " + age + "\nisMan: " + isMan;
	}
}
