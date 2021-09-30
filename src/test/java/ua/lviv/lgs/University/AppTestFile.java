package ua.lviv.lgs.University;


import java.util.Arrays;
import java.util.List;

import org.junit.Test;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.lviv.lgs.University.dao.StudentRepository;
import ua.lviv.lgs.University.dao.UserRepository;
import ua.lviv.lgs.University.domain.*;
import ua.lviv.lgs.University.service.StudentService;
import ua.lviv.lgs.University.service.UserService;


import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AppTestFile {


    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;


    @Test
    public void testSaveUser() {
        List<User> users = userRepository.findAll();
        assertThat(users, hasSize(0));

        User user = new User();
        user.setEmail("1@gmail.com");
        user.setFirstName("1");
        user.setLastName("12");
        user.setPassword("13");
        user.setPasswordConfirm("14");
        user.setRole(UserRole.ROLE_USER);


        userService.save(user);


        users = userRepository.findAll();
        assertThat(users, hasSize(1));

        User userFromDb = users.get(0);
        assertTrue(userFromDb.getEmail().equals(user.getEmail()));
        assertTrue(userFromDb.getFirstName().equals(user.getFirstName()));
        assertTrue(userFromDb.getLastName().equals(user.getLastName()));
        assertTrue(userFromDb.getRole().equals(user.getRole()));

    }

    @Test
    public void testFindByEmail() {
        List<User> users = userRepository.findAll();
        assertThat(users, hasSize(0));

        User user = new User();
        user.setEmail("myCustomEmail@gmail.com");
        user.setFirstName("2");
        user.setLastName("2");
        user.setPassword("2");
        user.setPasswordConfirm("2");
        user.setRole(UserRole.ROLE_USER);

        userRepository.save(user);

        users = userRepository.findAll();
        assertThat(users, hasSize(1));

        User findByEmail = userService.findByEmail(user.getEmail());

        assertTrue(findByEmail.getEmail().equals(user.getEmail()));
        assertTrue(findByEmail.getFirstName().equals(user.getFirstName()));
        assertTrue(findByEmail.getLastName().equals(user.getLastName()));
        assertTrue(findByEmail.getRole().equals(user.getRole()));
    }

    @Test
    public void testSaveStudent() {
        List<Student> students = studentRepository.findAll();
        assertThat(students, hasSize(0));

        Student student = new Student();
        student.setName("1");
        student.setSurname("1");
        student.setEncodedImage("1");
        student.setFaculty(Faculty.STOMAT);

        studentService.save(student);

        students = studentRepository.findAll();
        assertThat(students, hasSize(1));

        Student studentFromDb = students.get(0);
        assertTrue(studentFromDb.getName().equals(student.getName()));
        assertTrue(studentFromDb.getSurname().equals(student.getSurname()));
        assertTrue(studentFromDb.getEncodedImage().equals(student.getEncodedImage()));
        assertTrue(studentFromDb.getFaculty().equals(student.getFaculty()));
    }

    @Test
    public void testFindById() {
        List<Student> students = studentRepository.findAll();
        assertThat(students, hasSize(0));

        Student student = new Student();
        student.setName("1");
        student.setSurname("1");
        student.setEncodedImage("1");
        student.setFaculty(Faculty.STOMAT);

        studentRepository.save(student);

        students = studentRepository.findAll();
        assertThat(students, hasSize(1));

        Student studentFromDb = studentService.findById(students.get(0).getId());


        assertTrue(studentFromDb.getName().equals(student.getName()));
        assertTrue(studentFromDb.getSurname().equals(student.getSurname()));
        assertTrue(studentFromDb.getEncodedImage().equals(student.getEncodedImage()));
        assertTrue(studentFromDb.getFaculty().equals(student.getFaculty()));
    }

    @Test
    public void testGetAllStudents() {
        List<Student> students = studentRepository.findAll();
        assertThat(students, hasSize(0));

        Student student = new Student();
        student.setName("1");
        student.setSurname("1");
        student.setEncodedImage("1");
        student.setFaculty(Faculty.STOMAT);

        studentRepository.save(student);

        Student student2 = new Student();
        student2.setName("12");
        student2.setSurname("12");
        student2.setEncodedImage("12");
        student2.setFaculty(Faculty.MEDICAL);

        studentRepository.saveAll(Arrays.asList(student, student2));

        students = studentRepository.findAll();
        assertThat(students, hasSize(2));

        List<Student> studentssFromDb = studentService.getAllStudents();

        assertTrue(studentssFromDb.get(0).getName().equals(student.getName()));
        assertTrue(studentssFromDb.get(0).getSurname().equals(student.getSurname()));
        assertTrue(studentssFromDb.get(0).getEncodedImage().equals(student.getEncodedImage()));
        assertTrue(studentssFromDb.get(0).getFaculty().equals(student.getFaculty()));

        assertTrue(studentssFromDb.get(1).getName().equals(student2.getName()));
        assertTrue(studentssFromDb.get(1).getSurname().equals(student2.getSurname()));
        assertTrue(studentssFromDb.get(1).getEncodedImage().equals(student2.getEncodedImage()));
        assertTrue(studentssFromDb.get(1).getFaculty().equals(student2.getFaculty()));
    }
    @Test
    public void testAddEvaluatin() {
        List<Student> students = studentRepository.findAll();
        assertThat(students, hasSize(0));

        Student student = new Student();
        student.setName("1");
        student.setSurname("1");
        student.setEncodedImage("1");
        student.setFaculty(Faculty.STOMAT);
        student.setEvaluation(new Evaluation(10, 12, 23,14,34));

        studentRepository.save(student);

        students = studentRepository.findAll();
        assertThat(students, hasSize(1));

        List<Student> studentsFromDb = studentService.getAllStudents();

        assertTrue(studentsFromDb.get(0).getEvaluation().getEnglish().equals(student.getEvaluation().getEnglish()));
        assertTrue(studentsFromDb.get(0).getEvaluation().getAnatomy().equals(student.getEvaluation().getAnatomy()));
        assertTrue(studentsFromDb.get(0).getEvaluation().getChemestry().equals(student.getEvaluation().getChemestry()));
        assertTrue(studentsFromDb.get(0).getEvaluation().getBiology().equals(student.getEvaluation().getBiology()));
        assertTrue(studentsFromDb.get(0).getEvaluation().getPhisic().equals(student.getEvaluation().getPhisic()));
        assertTrue(studentsFromDb.get(0).getEvaluation().getSumBall().equals(student.getEvaluation().getSumBall()));

    }
}
