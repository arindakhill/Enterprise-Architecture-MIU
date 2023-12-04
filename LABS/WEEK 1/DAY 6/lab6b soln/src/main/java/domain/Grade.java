package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Grade {
    @Id
    @GeneratedValue
    private long id;
    private String grade;
    @ManyToOne
    private Course course;

    public Grade() {
    }

    public Grade(String grade, Course course) {
        this.grade = grade;
        this.course = course;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "grade='" + grade + '\'' +
                ", course=" + course +
                '}';
    }
}