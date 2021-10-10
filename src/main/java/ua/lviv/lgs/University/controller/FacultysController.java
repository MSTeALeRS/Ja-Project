package ua.lviv.lgs.University.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ua.lviv.lgs.University.domain.Facultys;
import ua.lviv.lgs.University.domain.Student;
import ua.lviv.lgs.University.service.FacultysService;
import ua.lviv.lgs.University.sort.SortStudentbySumBall;

import java.util.List;


@Controller

public class FacultysController {

    @Autowired
    private FacultysService facultysService;

    @RequestMapping(value ="/facultys", method = RequestMethod.GET)
    public ModelAndView getfacultys() {
        ModelAndView map = new ModelAndView("facultys");

        map.addObject("facultyRoles",  facultysService.getAllFacultys());

        return map;

    }


}
