public class Student {
	private String name;
	private String subject;
	private double grade;
	private int yearInCollege;
	private int age;
	private boolean isDegree;
	private double money;

	public Student() {
		grade = 4.0;
		yearInCollege = 1;
		isDegree = false;
		money = 0;
	}

	public Student(String name, String subject, int age) {
		this();
		this.name = name;
		this.subject = subject;
		this.age = age;
	}

	public void upYear() {
		if (yearInCollege < 4) {
			yearInCollege++;
			System.err.println(this.name + " has " + (4 - yearInCollege) + " more years in school");
		} else {
			isDegree = true;
			System.err.println(this.name + " finish school!");
		}
	}

	public double receiveScholarship(double min, double amount) {
		if (grade >= min && this.age < 30) {
			money += amount;
		}
		return this.money;
	}

	public String getName() {
		return name;
	}

	public String getSubject() {
		return subject;
	}

	public double getGrade() {
		return grade;
	}

	public int getYearInCollege() {
		return yearInCollege;
	}

	public int getAge() {
		return age;
	}

	public boolean isDegree() {
		return isDegree;
	}

	public double getMoney() {
		return money;
	}
	
	public void setGrade(int grade){
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Name: " + name + "\nSubject: " + subject + "\nGrade: " + grade + "\nYearInCollege: "
				+ yearInCollege + "\nAge: " + age + "\nisDegree: " + isDegree + "\nMoney: " + money + "\n";
	}
	
}
