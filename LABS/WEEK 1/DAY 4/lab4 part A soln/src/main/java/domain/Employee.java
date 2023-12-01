package domain;

import jakarta.persistence.*;

@Entity
public class Employee {

	public Long getEmployeeNumber() {
		return employeeNumber;
	}

	public String getName() {
		return name;
	}

	public Department getDepartment() {
		return department;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeNumber;
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="department_id")
	private Department department;



	protected Employee() {
	}

	public Employee( String name) {
		super();

		this.name = name;

	}



	@Override
	public String toString() {
		return String.format("Empoyee[employeeNumber=%d, name='%s', department='%s']", employeeNumber, name, department);
	}

}


