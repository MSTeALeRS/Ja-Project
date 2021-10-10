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
    private String firstName;

    @Column
    private String surname;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "facultys_id", referencedColumnName = "id")
    private Facultys facultys;

    @Lob
    private String encodedImage;

    public Student() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Facultys getFacultys() {
        return facultys;
    }

    public void setFacultys(Facultys facultys) {
        this.facultys = facultys;
    }

    public Student(String firstName, String surname, Facultys facultys) {
        this.firstName = firstName;
        this.surname = surname;
        this.facultys = facultys;

    }

    public Student(Integer id, String firstName, String surname, Facultys faculty) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.facultys = facultys;

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
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public Facultys getFaculty() {
        return facultys;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.firstName = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFaculty(Faculty faculty) {
        this.facultys = facultys;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(firstName, student.firstName) && Objects.equals(surname, student.surname) && facultys == student.facultys;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, surname, facultys);
    }


    @Override
    public String toString() {
        return "\nStudent{" +
                "id=" + id +
                ", evaluation=" + evaluation +
                ", name='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", faculty=" + facultys +
                ", encodedImage='" + encodedImage + '\'' +
                '}';
    }


    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
