package java8problems;

import java.util.List;
import java.util.Map;

import java8problems.data.Gender;
import java8problems.data.Student;

public class StudentOperationsImpl implements StudentOperations {

	List<Student> students;

	public StudentOperationsImpl(List<Student> students) {
		this.students = students;
	}

	@Override
	public double getAverageMark() {
		return students.stream().mapToDouble(s -> s.getGrade()).average().getAsDouble();
	}

	@Override
	public List<Student> getAllPassing() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAllFailing() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Boolean, List<Student>> splitStudentsByMarks(float splitMark) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> orderByMarkDescending() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> orderByMarkAscending() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudentsWithLowestMarks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudentsWithHighestMarks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, List<Double>> getMarksDistributionByAge() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Gender, Double> getAverageMarkByGender() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Double, Integer> getMarksDistribution() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEmailToHeader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Gender, Map<Integer, List<Student>>> splitStudentMarksByGenderAndThenByAge() {
		// TODO Auto-generated method stub
		return null;
	}

}
