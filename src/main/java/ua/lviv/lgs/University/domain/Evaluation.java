package ua.lviv.lgs.University.domain;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "evaluations")
public class Evaluation {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(mappedBy = "evaluation", cascade = CascadeType.ALL)
    private Student student;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Column
    private Integer english = 0;
    @Column
    private Integer anatomy = 0;
    @Column
    private Integer chemestry = 0;
    @Column
    private Integer biology = 0;
    @Column
    private Integer phisic = 0;
    @Column
    private Integer sumBall = 0;

    public Evaluation() {
    }

    public Evaluation(Integer english, Integer anatomy, Integer chemestry, Integer biology, Integer phisic) {
        this.english = english;
        this.anatomy = anatomy;
        this.chemestry = chemestry;
        this.biology = biology;
        this.phisic = phisic;
        this.sumBall=english+anatomy+chemestry+biology+phisic;

    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }

    public Integer getAnatomy() {
        return anatomy;
    }

    public void setAnatomy(Integer anatomy) {
        this.anatomy = anatomy;
    }

    public Integer getChemestry() {
        return chemestry;
    }

    public void setChemestry(Integer chemestry) {
        this.chemestry = chemestry;
    }

    public Integer getBiology() {
        return biology;
    }

    public void setBiology(Integer biology) {
        this.biology = biology;
    }

    public Integer getPhisic() {
        return phisic;
    }

    public void setPhisic(Integer phisic) {
        this.phisic = phisic;
    }

    public Integer getSumBall() {
        return sumBall;
    }

    public void setSumBall(Integer sumBall) {
        this.sumBall = sumBall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evaluation that = (Evaluation) o;
        return Objects.equals(english, that.english) && Objects.equals(anatomy, that.anatomy) && Objects.equals(chemestry, that.chemestry) && Objects.equals(biology, that.biology) && Objects.equals(phisic, that.phisic) && Objects.equals(sumBall, that.sumBall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(english, anatomy, chemestry, biology, phisic, sumBall);
    }

    @Override
    public String toString() {
        return "\nEvaluations{" +
                "id=" + id +
                ", student=" + student +
                ", english=" + english +
                ", anatomy=" + anatomy +
                ", chemestry=" + chemestry +
                ", biology=" + biology +
                ", phisic=" + phisic +
                ", sumBall=" + sumBall +
                '}';
    }
}
