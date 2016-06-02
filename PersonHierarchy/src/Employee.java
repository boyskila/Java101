
public class Employee extends Person {

	private double daySalary;

	public Employee(String name, int age, boolean isMan, double daySalary) {
		super(name, age, isMan);
		this.daySalary = daySalary;
	}
	//Simple Math
	public double calculateOvertime(double hours) {
		if (this.getAge() < 18) {
			return 0;
		}
		double moneyPerHour = daySalary / 8;
		return (moneyPerHour * 1.5) * hours;
	}

	@Override
	public String toString() {
		return super.toString() + "\nSalary: " + daySalary;
	}
}
