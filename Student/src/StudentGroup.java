public class StudentGroup {
	private String groupSubject;
	private Student[] students;
	private static int freePlaces;

	public StudentGroup() {
		students = new Student[5];
		freePlaces = 5;
	}

	public StudentGroup(String subject) {
		this();
		groupSubject = subject;
	}

	public void addStudent(Student candidate) {
		int position = students.length - freePlaces;
		// prevent index outOfBoundException
		if (freePlaces > 0) {
			students[position] = candidate;
			freePlaces--;
		}
	}

	public void emptyGroup() {
		students = new Student[5];
		freePlaces = 5;
	}

	public String theBestStudent() {
		double higherGrade = 0;
		String bestStudentName = null;

		for (Student student : students) {
			if (student.getGrade() > higherGrade) {
				higherGrade = student.getGrade();
				bestStudentName = student.getName();
			}
		}
		return bestStudentName;
	}

	public String getGroupSubject() {
		return groupSubject;
	}

	public Student[] getStudents() {
		return students;
	}

	public static int getFreePlaces() {
		return freePlaces;
	}

	@Override
	public String toString() {
		StringBuilder allStudents = new StringBuilder();
		for (Student student : students) {
			allStudents.append(student);
			allStudents.append(System.lineSeparator());
		}
		return allStudents.toString();
	}
}
