package ua.lviv.lgs.University.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.lviv.lgs.University.domain.Student;
import ua.lviv.lgs.University.service.EvaluationService;
import ua.lviv.lgs.University.service.StudentService;
import ua.lviv.lgs.University.sort.SortStudentbySumBall;

import java.util.Comparator;
import java.util.List;

@Controller
public class EvaluationsController {


    @Autowired
    private EvaluationService evaluationService;

    @Autowired
    private StudentService studentService;


    @RequestMapping(value ="/evaluations", method = RequestMethod.GET)
    public ModelAndView evaluations() {
        ModelAndView map = new ModelAndView("evaluations");
        List<Student> students = studentService.getAllStudents();
        students.sort(new SortStudentbySumBall());
        map.addObject("students", students);
        return map;
    }


}
