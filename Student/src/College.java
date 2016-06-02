
public class College {

	public static void main(String[] args) {
		Student st1 = new Student("Ilianka", "C#", 25);
		Student st2 = new Student("Deni", "Java", 22);
		Student st3 = new Student("Ilian", "Js", 25);
		Student st4 = new Student("Niki", "C++", 25);
		Student st5 = new Student("Toshko", "C", 25);
		st1.receiveScholarship(4, 100);
		st2.receiveScholarship(4, 50);
		st3.upYear();
		st3.upYear();
		st3.upYear();
		st3.upYear();
		st3.setGrade(5);
		System.out.println(st3);
		
		StudentGroup group1 = new StudentGroup("Python");
		group1.addStudent(st1);
		group1.addStudent(st2);
		group1.addStudent(st3);
		group1.addStudent(st4);
		group1.addStudent(st5);
		//test group capacity
		group1.addStudent(st1);
		
		System.out.println(group1.theBestStudent());

	}

}
