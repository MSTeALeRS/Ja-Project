package ua.lviv.lgs.University;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import ua.lviv.lgs.University.dao.FacultysRepository;
import ua.lviv.lgs.University.dao.StudentRepository;
import ua.lviv.lgs.University.domain.Evaluation;
import ua.lviv.lgs.University.domain.Faculty;
import ua.lviv.lgs.University.domain.Facultys;
import ua.lviv.lgs.University.domain.Student;
import ua.lviv.lgs.University.service.EvaluationService;
import ua.lviv.lgs.University.service.FacultysService;
import ua.lviv.lgs.University.service.StudentService;

@SpringBootApplication
@Component
@ComponentScan("ua.lviv.lgs.University")
public class PeriodicalApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PeriodicalApplication.class);
		FacultysService service = context.getBean(FacultysService.class);

//		Facultys f = new Facultys("Gnom");
//
//		service.save(f);

//		System.out.println(facultysService.getAllFacultys());










	}

}
