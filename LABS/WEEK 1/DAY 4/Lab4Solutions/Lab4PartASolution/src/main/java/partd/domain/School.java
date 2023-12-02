package partd.domain;

import jakarta.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class School {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "student")
	@MapKey(name = "studentId")
	Map<Long, Student> studentMap = new HashMap<Long, Student>();

	public School() {
	}

	public School(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Long, Student> getStudentlist() {
		return studentMap;
	}

	public Student addStudent(Student student) {
		return studentMap.put(student.getStudentId(), student);
	}
	
	public Student removeStudent(Student student) {
		return studentMap.remove(student);
	}

	@Override
	public String toString() {
		return "School{" +
				"id=" + id +
				", name='" + name + '\'' +
				", studentMap=" + studentMap +
				'}';
	}
}
