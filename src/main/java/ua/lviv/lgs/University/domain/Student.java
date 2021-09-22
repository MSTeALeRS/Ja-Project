package ua.lviv.lgs.University.domain;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private String surname;


    @Enumerated(EnumType.STRING)
    private Faculty faculty;

    public Student() {
    }

    public Student(String name, String surname, Faculty faculty) {
        this.name = name;
        this.surname = surname;
        this.faculty = faculty;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && faculty == student.faculty;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, faculty);
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", faculty=" + faculty +
                '}';
    }
}
