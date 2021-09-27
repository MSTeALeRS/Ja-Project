package ua.lviv.lgs.University.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.University.domain.Faculty;
import ua.lviv.lgs.University.domain.Student;
import ua.lviv.lgs.University.domain.User;
import ua.lviv.lgs.University.domain.UserRole;
import ua.lviv.lgs.University.service.StudentService;
import ua.lviv.lgs.University.service.StudentsDTOHelper;
import ua.lviv.lgs.University.service.UserService;

import java.io.IOException;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;




    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registration(
            @RequestParam String email,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String password

    ) throws IOException {
        User userForm = new User(email,firstName, lastName, UserRole.ROLE_USER, password);
        userService.save(userForm);
        return new ModelAndView("redirect:/home");
    }

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value ="/home", method = RequestMethod.GET)
    public ModelAndView welcome() {
        ModelAndView map = new ModelAndView("home");
        map.addObject("students", studentService.getAllStudents());

        return map;
    }



}