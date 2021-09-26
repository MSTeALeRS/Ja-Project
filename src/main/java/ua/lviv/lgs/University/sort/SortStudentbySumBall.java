package ua.lviv.lgs.University.sort;

import ua.lviv.lgs.University.domain.Student;

import java.util.Comparator;

public class SortStudentbySumBall implements Comparator<Student> {


    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getEvaluation().getSumBall().compareTo(o2.getEvaluation().getSumBall())>0){
            return -1;
        } else if (o1.getEvaluation().getSumBall().compareTo(o2.getEvaluation().getSumBall()) < 0) {
            return 1;
        }

        return 0;
    }
    }

