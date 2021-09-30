package ua.lviv.lgs.University.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import ua.lviv.lgs.University.domain.Faculty;
import ua.lviv.lgs.University.domain.Student;
import ua.lviv.lgs.University.service.StudentService;
import ua.lviv.lgs.University.service.StudentsDTOHelper;

import java.io.IOException;

@Controller
public class StudentController {

    @Autowired
    private StudentService facultyService;

    @RequestMapping(value ="/create-student", method = RequestMethod.GET)
    public ModelAndView createStudent() {

        return new ModelAndView("createStudent");
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public ModelAndView createStudent(
            @RequestParam MultipartFile image,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam Faculty faculty
            ) throws IOException {
        facultyService.save(StudentsDTOHelper.createEntity(image, name, surname, faculty));
        return new ModelAndView("redirect:/home");
    }

}