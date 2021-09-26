package ua.lviv.lgs.University.domain;

import javax.persistence.*;
import java.util.Comparator;
import java.util.Objects;


@Entity
@Table(name = "students")
public class Student implements Comparable<Student> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="evaluation_id", referencedColumnName = "id")
    private Evaluation evaluation ;

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }

    @Column
    private String name;

    @Column
    private String surname;


    @Enumerated(EnumType.STRING)
    private Faculty faculty;

    @Lob
    private String encodedImage;

    public Student() {

    }

    public Student(String name, String surname, Faculty faculty) {
        this.name = name;
        this.surname = surname;
        this.faculty = faculty;

    }

    public Student(Integer id, String name, String surname, Faculty faculty) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.faculty = faculty;

    }

    public String getEncodedImage() {
        return encodedImage;
    }

    public void setEncodedImage(String encodedImage) {
        this.encodedImage = encodedImage;
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
        return "\nStudent{" +
                "id=" + id +
                ", evaluation=" + evaluation +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", faculty=" + faculty +
                ", encodedImage='" + encodedImage + '\'' +
                '}';
    }


    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
