package lab6b;

import domain.Course;
import domain.Department;
import domain.Grade;
import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.CourseRepository;
import repositories.DepartmentRepository;
import repositories.GradeRepository;
import repositories.StudentRepository;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain")
public class Lab6bApplication implements CommandLineRunner{
	@Autowired
	GradeRepository gradeRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(Lab6bApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course course1 = new Course("FPP");
		Course course2 = new Course("MPP");
		courseRepository.save(course1);
		courseRepository.save(course2);
		Department department = new Department("ComPro");
		departmentRepository.save(department);

		Student s1 = new Student(1L, "Hillary Arinda");
		Student s2 = new Student(2L, "James Balimunsi");
		Student s3 = new Student(3L, "Suzan Sue");

		s1.setDepartment(department);
		s2.setDepartment(department);
		s3.setDepartment(department);

		Grade g1 = new Grade("A", course1);
		gradeRepository.save(g1);
		s1.addGrade(g1);
		Grade g2 = new Grade("A-", course2);
		gradeRepository.save(g2);
		s1.addGrade(g2);
		Grade g3 = new Grade("B", course1);
		gradeRepository.save(g3);
		s2.addGrade(g3);
		Grade g4 = new Grade("C", course1);
		gradeRepository.save(g4);
		s3.addGrade(g4);
		Grade g5 = new Grade("A+", course2);
		gradeRepository.save(g5);
		s3.addGrade(g5);

		studentRepository.save(s1);
		studentRepository.save(s2);
		studentRepository.save(s3);

        List<Student> students = studentRepository.findStudentByDepartment(department);
        System.out.println("------All students from the Com Pro department  -------------------");
        students.stream().forEach(c->System.out.println(c));

        List<Student> students2 = studentRepository.findStudentByCourse("MPP");
        System.out.println("------All students who took MPP  -------------------");
        students2.stream().forEach(c->System.out.println(c));
	}


}

