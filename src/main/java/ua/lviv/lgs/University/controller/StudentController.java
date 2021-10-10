package ua.lviv.lgs.University.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import ua.lviv.lgs.University.domain.Faculty;
import ua.lviv.lgs.University.domain.Facultys;
import ua.lviv.lgs.University.domain.Student;
import ua.lviv.lgs.University.service.FacultysService;
import ua.lviv.lgs.University.service.StudentService;
import ua.lviv.lgs.University.service.StudentsDTOHelper;

import java.io.IOException;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private FacultysService facultysService;
    @RequestMapping(value ="/facultys/{id}/create-student", method = RequestMethod.GET)
    public ModelAndView createStudent(@PathVariable Integer id) {

        ModelAndView map = new ModelAndView("createStudent");
        map.addObject("facultyRole",  facultysService.findById(id));

        return map;
    }

    @RequestMapping(value = "{id}/addStudent", method = RequestMethod.POST)
    public ModelAndView createStudent(
            @PathVariable Integer id,
            @RequestParam MultipartFile image,
            @RequestParam String name,
            @RequestParam String surname

            ) throws IOException {
        studentService.save(StudentsDTOHelper.createEntity(image, name, surname), id);


        return new ModelAndView("redirect:/home");
    }

}