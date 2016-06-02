
public class Student extends Person {
	
	private int score;

	public Student(String name, int age, boolean isMan, int score) {
		super(name, age, isMan);
		this.score = score;
	}

	@Override
	public String toString(){
		return super.toString() + "\nScore: " + score;
	}
}
