package app;

import domain.Department;
import domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repository.DepartmentRepository;
import repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableJpaRepositories("repository")
@EntityScan("domain") 
public class Application implements CommandLineRunner {


	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Employee employee1 = new Employee("John Doe");
		Employee employee2 = new Employee("Jane Doe");
		List<Employee> employees = new ArrayList<>();
		employees.add(employee1);
		employees.add(employee2);

		Department department = new Department("IT", employees);

		// Link employees back to the department if the relationship is bidirectional
		employees.forEach(emp -> emp.setDepartment(department));

		// Save the department along with the employees due to cascading
		departmentRepository.save(department);

		// Retrieve and verify the association
		Department retrievedDepartment = departmentRepository.findById(department.getId()).orElse(null);
		if (retrievedDepartment != null) {
			System.out.println("Retrieved department name: " + retrievedDepartment.getName());
			System.out.println("Number of employees: " + retrievedDepartment.getEmployees().size());
		} else {
			System.out.println("Department not found.");


		}

	}
}
