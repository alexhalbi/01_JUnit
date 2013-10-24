package daten;
import java.util.Date;

public class Student extends Person implements Comparable<Student> {

	public Student(String firstName, String lastName, Date birthDate) {
		this(firstName, lastName, birthDate, false);
	}

	public Student(String firstName, String lastName, Date birthDate, boolean selfEntitled) {
		super(firstName, lastName);
		setSelfEntitled(selfEntitled);
		setBirthDate(birthDate);
	}

	private boolean selfEntitled;
	public boolean isSelfEntitled() {
		return selfEntitled;
	}

	private Date birthDate;

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		if (birthDate == null) {
			throw new IllegalArgumentException("birthDate must not be null!");
		}
		if (birthDate.before(new Date(1900,1,1))) {
			throw new IllegalArgumentException(
					"birthDate before 1900 is not possible");
		}
		this.birthDate = birthDate;
	}

	public void setSelfEntitled(boolean selfEntitled) {
		this.selfEntitled = selfEntitled;
	}

	@Override
	public int compareTo(Student o) {
		int result = 0;

		// TODO implement meaningful unit tests
		if ((result = getLastName().compareTo(o.getLastName())) == 0) {
			if ((result = getFirstName().compareTo(o.getFirstName())) == 0) {
				result = getBirthDate().compareTo(o.getBirthDate());
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return String.format("%s {firstName=%s, lastName=%s, birthDate=%i, selfEntitled=%s}", getClass()
				.getSimpleName(), getFirstName(), getLastName(), getBirthDate(), isSelfEntitled() + "");
	}
}
