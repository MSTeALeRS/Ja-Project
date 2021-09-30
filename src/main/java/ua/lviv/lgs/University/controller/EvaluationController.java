package ua.lviv.lgs.University.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ua.lviv.lgs.University.domain.Evaluation;
import ua.lviv.lgs.University.domain.Faculty;
import ua.lviv.lgs.University.domain.Student;
import ua.lviv.lgs.University.service.EvaluationService;
import ua.lviv.lgs.University.service.StudentService;
import ua.lviv.lgs.University.service.StudentsDTOHelper;

import java.io.IOException;


@Controller
public class EvaluationController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private EvaluationService evaluationService;

    @RequestMapping(value ="/studentEvaluation/{id}/addEvaluation", method = RequestMethod.GET)
    public ModelAndView addEvaluation(@PathVariable Integer id) {
        ModelAndView map = new ModelAndView("addEvaluation");
        map.addObject("currentStudent",  studentService.findById(id));

        return map;
    }

    @RequestMapping(value = "{id}/add-Evaluation", method = RequestMethod.POST)
    public ModelAndView addEvaluation(
            @PathVariable Integer id,
            @RequestParam Integer english,
            @RequestParam Integer anatomy,
            @RequestParam Integer chemestry,
            @RequestParam Integer biology,
            @RequestParam Integer phisic
    ) {
        Evaluation evaluation = new Evaluation(english,anatomy,chemestry,biology,phisic);
         Student student = studentService.findById(id);
        student.setEvaluation(evaluation);
         studentService.save(student);
        return new ModelAndView("redirect:/home");
    }
}
