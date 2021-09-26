package ua.lviv.lgs.University.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.lviv.lgs.University.service.StudentService;

@Controller
public class singlStudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value ="/studentEvaluation/{id}", method = RequestMethod.GET)
    public ModelAndView findStudentbyID(@PathVariable Integer id) {

        ModelAndView map = new ModelAndView("studentEvaluation");
        map.addObject("currentStudent",  studentService.findById(id));

        return map;
    }
}
