package repositories;

import domain.Department;
import domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("select distinct s from Student s join fetch s.department join fetch s.grades where s.department = ?1")
    List<Student> findStudentByDepartment(Department department);
//    List<Student> findStudentByCourse(String course);

    @Query("select distinct s from Student s join fetch s.grades sg join fetch s.department where sg.course.name= :name")
    List<Student> findStudentByCourse(@Param("name") String courseName);

}
