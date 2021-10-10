package ua.lviv.lgs.University.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ua.lviv.lgs.University.domain.Faculty;
import ua.lviv.lgs.University.domain.Facultys;
import ua.lviv.lgs.University.service.FacultysService;
import ua.lviv.lgs.University.service.StudentsDTOHelper;

import java.io.IOException;

@Controller

public class AddFacultysController {

    @Autowired
    private FacultysService facultysService;


    @RequestMapping(value ="/addFacultys", method = RequestMethod.GET)
    public ModelAndView addFacult() {

        return new ModelAndView("addfacultys");
    }

    @RequestMapping(value = "/addFacult", method = RequestMethod.POST)
    public ModelAndView addFacult(
//            @RequestParam MultipartFile image,
            @RequestParam String name
    ) throws IOException {
        facultysService.save(new Facultys(name));
        return new ModelAndView("redirect:/home");
    }


}
