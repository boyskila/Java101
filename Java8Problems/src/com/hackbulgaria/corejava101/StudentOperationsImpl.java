package com.hackbulgaria.corejava101;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.hackbulgaria.corejava101.data.Gender;
import com.hackbulgaria.corejava101.data.Student;

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
		return students.stream().filter(u -> u.getGrade() > 2).collect(Collectors.toList());
	}

	@Override
	public List<Student> getAllFailing() {
		return students.stream().filter(u -> u.getGrade() < 3).collect(Collectors.toList());
	}

	@Override
	public Map<Boolean, List<Student>> splitStudentsByMarks(float splitMark) {
		return students.stream().collect(Collectors.partitioningBy(s -> s.getGrade() >= splitMark));
	}

	@Override
	public List<Student> orderByMarkDescending() {
		return students.stream().sorted((s1, s2) -> -1).collect(Collectors.toList());
	}

	@Override
	public List<Student> orderByMarkAscending() {
		return students.stream().sorted((s1, s2) -> 1).collect(Collectors.toList());
	}

	@Override
	public List<Student> getStudentsWithLowestMarks() {
		return students.stream().filter(s -> s.getGrade() == 2).collect(Collectors.toList());
	}

	@Override
	public List<Student> getStudentsWithHighestMarks() {
		return students.stream().filter(s -> s.getGrade() == 6).collect(Collectors.toList());
	}

	@Override
	public Map<Integer, List<Double>> getMarksDistributionByAge() {
		return students.stream().collect(
				Collectors.groupingBy(Student::getAge, Collectors.mapping(Student::getGrade, Collectors.toList())));
	}

	@Override
	public Map<Gender, Double> getAverageMarkByGender() {
		return students.stream()
				.collect(Collectors.groupingBy(Student::getGender, Collectors.averagingDouble(Student::getGrade)));
	}

	@Override
	public Map<Double, Integer> getMarksDistribution() {
		return students.stream().collect(Collectors.toMap(Student::getGrade, s -> 1, Integer::sum));
	}

	@Override
	public String getEmailToHeader() {
		final String email = "@gmail.com";
		return students.stream().map(o -> o.getName() + "_" + ((Calendar.getInstance().get(Calendar.YEAR)-1) - o.getAge()))
				.collect(Collectors.joining(email + ", ","","@gmail.com"));
	}

	@Override
	public Map<Gender, Map<Integer, List<Student>>> splitStudentMarksByGenderAndThenByAge() {

		return students.stream().collect(
				Collectors.groupingBy(Student::getGender, Collectors.groupingBy(Student::getAge, Collectors.toList())));
	}

}
