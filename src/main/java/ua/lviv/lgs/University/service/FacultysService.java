package ua.lviv.lgs.University.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.University.dao.FacultysRepository;
import ua.lviv.lgs.University.dao.StudentRepository;
import ua.lviv.lgs.University.domain.Faculty;
import ua.lviv.lgs.University.domain.Facultys;
import ua.lviv.lgs.University.domain.Student;

import java.util.List;

@Service
public class FacultysService {

    private Logger logger = LoggerFactory.getLogger(FacultysService.class);

    @Autowired
    private FacultysRepository facultysRepository;

    public void save(Facultys facultys){
        logger.info("add new Facultys {} : " + facultys);
        facultysRepository.save(facultys);

    }

    public List<Facultys> getAllFacultys(){
        logger.info("get all Facultys {} : " );

        return facultysRepository.findAll();
    }

    public Facultys findById(Integer id) {
        logger.info("find Student by {} : " + id);
        return facultysRepository.findById(id).get();
    }
}
