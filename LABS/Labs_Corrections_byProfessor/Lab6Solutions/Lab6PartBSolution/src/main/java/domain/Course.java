package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
