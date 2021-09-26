package ua.lviv.lgs.University;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ua.lviv.lgs.University.dao.StudentRepository;
import ua.lviv.lgs.University.domain.Evaluation;
import ua.lviv.lgs.University.domain.Faculty;
import ua.lviv.lgs.University.domain.Student;
import ua.lviv.lgs.University.service.EvaluationService;
import ua.lviv.lgs.University.service.StudentService;

@SpringBootApplication
public class PeriodicalApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PeriodicalApplication.class);
		StudentService service = context.getBean(StudentService.class);








	}

}
