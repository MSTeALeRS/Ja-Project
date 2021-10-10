package ua.lviv.lgs.University.domain;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="facultys")
public class Facultys {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String facultyName;


    public Facultys(String facultyName) {
        this.facultyName = facultyName;

    }

    public Facultys() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facultys facultys = (Facultys) o;
        return Objects.equals(id, facultys.id) && Objects.equals(facultyName, facultys.facultyName) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, facultyName);
    }

    @Override
    public String toString() {
        return "Facultys{" +
                "id=" + id +
                ", facultyName='" + facultyName + '\'' +

                '}';
    }
}
