
public class ComputerDemo {

	public static void main(String[] args) {

		Computer computer1 = new Computer(2015, 1001, false, 1000, 50, "Linux");
		computer1.useMemory(100);
		Computer computer2 = new Computer(2016, 1000, true, 1000, 500, "Windows");
		System.out.println("Computer 2 is now with " + computer2.getOperationSystem() + " operating system");
		computer2.changeOperationSystem("Linux");
		System.out.println("Computer 2 now is with " + computer2.getOperationSystem() + " operating system");

		int comparePrice = computer1.comparePrice(computer2);
		
		if (comparePrice == -1) {
			System.out.println("Computer1 is more expensive than computer2");
		}else if (comparePrice == 1) {
			System.out.println("Computer1 is cheaper than computer2");
		}else{
			System.out.println("Equal price");
		}
	}
}
