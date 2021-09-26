package ua.lviv.lgs.University.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.University.dao.EvaluationRepository;
import ua.lviv.lgs.University.domain.Evaluation;

import java.util.List;

@Service
public class EvaluationService {

    @Autowired
     private EvaluationRepository evaluationRepository;

    public Evaluation save(Evaluation ev){
        return evaluationRepository.save(ev);
    }

    public List<Evaluation> getAllEvaluation(){

        return evaluationRepository.findAll();
    }
    public Evaluation findById(Integer id) {
        return evaluationRepository.findById(id).get();
    }
}
