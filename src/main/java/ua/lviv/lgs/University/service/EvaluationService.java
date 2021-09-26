package ua.lviv.lgs.University.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.University.dao.EvaluationRepository;
import ua.lviv.lgs.University.domain.Evaluation;

import java.util.List;

@Service
public class EvaluationService {
    private Logger logger = LoggerFactory.getLogger(EvaluationService.class);

    @Autowired
     private EvaluationRepository evaluationRepository;

    public Evaluation save(Evaluation ev){
        logger.info("add new Evaluation {} : " + ev);
        return evaluationRepository.save(ev);
    }

    public List<Evaluation> getAllEvaluation(){
        logger.info("find all Evaluation {} : " );
        return evaluationRepository.findAll();
    }
    public Evaluation findById(Integer id) {
        logger.info("find Evaluation by {} : " + id);
        return evaluationRepository.findById(id).get();
    }
}
