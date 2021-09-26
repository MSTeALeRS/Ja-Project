package ua.lviv.lgs.University.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.University.dao.StudentRepository;
import ua.lviv.lgs.University.domain.Evaluation;
import ua.lviv.lgs.University.domain.Student;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student save(Student student){
    return studentRepository.save(student);
    }

    public List<Student> getAllStudents(){


        return studentRepository.findAll();
    }

    public Student findById(Integer id) {
        return studentRepository.findById(id).get();
    }



}