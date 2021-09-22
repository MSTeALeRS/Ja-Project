package ua.lviv.lgs.University.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import ua.lviv.lgs.University.domain.Student;
import ua.lviv.lgs.University.service.StudentService;

@Controller
public class StudentController {

    @Autowired
    StudentService facultyService;

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public ModelAndView createStudent(@Valid @ModelAttribute("student") Student student,
                                         BindingResult bindingResult) {
        facultyService.save(student);
        return new ModelAndView("redirect:/home");
    }

}