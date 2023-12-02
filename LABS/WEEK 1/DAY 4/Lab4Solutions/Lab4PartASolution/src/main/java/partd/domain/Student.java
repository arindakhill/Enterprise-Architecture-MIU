package partd.domain;

import jakarta.persistence.Entity;
import jakarta .persistence.Id;

@Entity
public class Student {

	@Id
	private long studentId;
	private String firstname;
	private String lastname;

	public Student(long studentId, String firstname, String lastname) {
		this.studentId = studentId;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Student() {
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentid) {
		this.studentId = studentid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "Student{" +
				"studentid=" + studentId +
				", firstname='" + firstname + '\'' +
				", lastname='" + lastname + '\'' +
				'}';
	}
}
