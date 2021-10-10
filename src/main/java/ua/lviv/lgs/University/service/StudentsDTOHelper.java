package ua.lviv.lgs.University.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import ua.lviv.lgs.University.domain.Evaluation;
import ua.lviv.lgs.University.domain.Faculty;
import ua.lviv.lgs.University.domain.Student;

import java.io.IOException;
import java.util.Base64;

public class StudentsDTOHelper {


    public static Student createEntity(MultipartFile file, String name, String surname) throws IOException {
        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setEncodedImage(Base64.getEncoder().encodeToString(file.getBytes()));
        student.setEvaluation(new Evaluation());
        return student;
    }
}
