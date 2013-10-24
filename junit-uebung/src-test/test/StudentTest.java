package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import daten.Student;

public class StudentTest {

	@Test
	public void testSetBirthDate() {
		Student s = new Student("Testi", "Tester", new Date(1995, 3, 1));
		Date bd = new Date(1999, 4, 2);
		s.setBirthDate(bd);
		assertEquals(s.getBirthDate(), bd);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testSetToSmallBirthDate() {
		Student s = new Student("Testi", "Tester", new Date(1995, 3, 1));
		Date bd = null;
		s.setBirthDate(bd);
		assertEquals(s.getBirthDate(), bd);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetNullBirthDate() {
		Student s = new Student("Testi", "Tester", new Date(1995, 3, 1));
		s.setBirthDate(null);
	}

	@Test
	public void testCompareToFalse() {
		Student s = new Student("Testi", "Tester", new Date(1995, 3, 1));
		Student s1 = new Student("Peter", "Franz", new Date(1994, 3, 1));
		assertTrue(s.compareTo(s1)!=0&&s1.compareTo(s)!=0);
	}
	
	@Test
	public void testCompareToTrue() {
		Student s = new Student("Testi", "Tester", new Date(1995, 3, 1));
		Student s1 = new Student("Testi", "Tester", new Date(1995, 3, 1));
		assertTrue(s.compareTo(s1)==0&&s1.compareTo(s)==0);
	}

}
