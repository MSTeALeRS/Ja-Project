package ua.lviv.lgs.University.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.University.dao.StudentRepository;
import ua.lviv.lgs.University.domain.Evaluation;
import ua.lviv.lgs.University.domain.Student;

@Service
public class StudentService {
    private Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    FacultysService facultysService;
    @Autowired
    private StudentRepository studentRepository;

    public Student save(Student student, Integer id){
        logger.info("add new Student {} : " + student);
        student.setFacultys(facultysService.findById(id));
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
        logger.info("get all Students {} : " );

        return studentRepository.findAll();
    }

    public Student findById(Integer id) {
        logger.info("find Student by {} : " + id);
        return studentRepository.findById(id).get();
    }



}