package repositories;

import domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findStudentByDepartment(String department);
    List<Student> findStudentByCourse(String course);
}
