package ua.lviv.lgs.University.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.University.domain.Facultys;
import ua.lviv.lgs.University.domain.User;

import java.util.Optional;

public interface FacultysRepository extends JpaRepository <Facultys,Integer> {


}
