package domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Student {
    @Id
    private long studentNumber;

    private String name;

    @OneToMany(cascade = CascadeType.PERSIST)
    List<Grade> grades = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Department department;

    public Student(long l, String frankBrown) {
        studentNumber = l;
        name = frankBrown;
    }
    public void addGrade(Grade grade){
        grades.add(grade);
    }
}
