package daten;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Course {

	public Course(String name) {
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("name must not be null!");
		}
		if ("".equals(name.trim())) {
			throw new IllegalArgumentException(
					"name must not empty or whitespaces only!");
		}
		this.name = name;
	}

	private String name;

	private final Set<Student> students = new TreeSet<Student>(new Comparator<Student>() {

		@Override
		public int compare(Student o1, Student o2) {
			int comp = 0;
			if((comp = o1.getLastName().compareTo(o2.getLastName()))==0) {
				if((comp = o1.getFirstName().compareTo(o2.getFirstName()))==0) {
					return o1.getBirthDate().compareTo(o2.getBirthDate());
				}
			}
			return comp;
		}
	});

	public void addStudent(Student student) {
		if (student == null) {
			throw new IllegalArgumentException(
					"student to add must not be null!");
		}
		if (students.contains(student)) {
			return;
		}
		students.add(student);
	}

	public boolean removeStudent(Student student) {
		if (student == null) {
			throw new IllegalArgumentException(
					"student to remove must not be null!");
		}
		return students.remove(student);
	}
}
