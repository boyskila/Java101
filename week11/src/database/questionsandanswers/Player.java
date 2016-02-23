package database.questionsandanswers;

public class Player {
	private String name;
	private int age;
	private int currentPoints;
	private int bestResult;

	public Player(String name, int age, int bestResult) {
		super();
		this.setName(name);
		this.setAge(age);
		this.bestResult = bestResult;
		setCurrentPoints(0);
	}

	public void addPoints(int points) {
		this.setCurrentPoints(this.getCurrentPoints() + points);
	}

	public int getBestResult() {
		return bestResult;
	}

	public void setBestResult(int bestResult) {
		this.bestResult = bestResult;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getCurrentPoints() {
		return currentPoints;
	}

	public void setCurrentPoints(int currentPoints) {
		this.currentPoints = currentPoints;
	}
}
