package domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Department {
    public Department(String name, List<Employee> employees) {

        this.name = name;
        this.employees = employees;
    }

    public Department() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public List<Employee> getEmployees() {
        return employees;
    }

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Employee> employees;// = new ArrayList<>();







    @Override
    public String toString() {
        String result = "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees IDs=";
        if(employees != null) {
            result += employees.stream()
                    .map(employee -> employee.getEmployeeNumber().toString())
                    .collect(Collectors.joining(", ", "[", "]"));
        } else {
            result += "null";
        }
        result += '}';
        return result;
    }

}
