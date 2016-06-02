
public class Computer {

	private int year;
	private double price;
	private boolean isNotebook;
	private double hardDiskMemory;
	private double freeMemory;
	private String operationSystem;

	public Computer() {
		isNotebook = false;
		operationSystem = "Win XP";
	}

	public Computer(int year, double price, double hardDiskMemory, double freeMemory) {
		this();
		this.year = year;
		this.price = price;
		this.hardDiskMemory = hardDiskMemory;
		this.freeMemory = freeMemory;
	}

	public Computer(int year, double price, boolean isNotebook, int hardDiskMemory, int freeMemory,
			String operationSystem) {

		this.year = year;
		this.price = price;
		this.isNotebook = isNotebook;
		this.hardDiskMemory = hardDiskMemory;
		this.freeMemory = freeMemory;
		this.operationSystem = operationSystem;
	}

	public int comparePrice(Computer anotherComputer) {
		if (this.price > anotherComputer.price) {
			return -1;
		} else if (this.price < anotherComputer.price) {
			return 1;
		}
		return 0;
	}

	public void changeOperationSystem(String newOperationSystem) {
		operationSystem = newOperationSystem;
	}

	public void useMemory(double memory) {
		if (memory > freeMemory) {
			System.out.println("Not enough free memory!");
		} else {
			freeMemory -= memory;
		}
	}

	public int getYear() {
		return year;
	}

	public double getPrice() {
		return price;
	}

	public boolean isNotebook() {
		return isNotebook;
	}

	public double getHardDiskMemory() {
		return hardDiskMemory;
	}

	public double getFreeMemory() {
		return freeMemory;
	}

	public String getOperationSystem() {
		return operationSystem;
	}

}
