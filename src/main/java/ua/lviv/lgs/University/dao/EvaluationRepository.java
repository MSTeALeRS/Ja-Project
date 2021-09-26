package ua.lviv.lgs.University.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.University.domain.Evaluation;

public interface EvaluationRepository extends JpaRepository<Evaluation,Integer> {
}
