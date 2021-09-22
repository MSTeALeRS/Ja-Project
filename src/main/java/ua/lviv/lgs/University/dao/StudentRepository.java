package ua.lviv.lgs.University.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lviv.lgs.University.domain.Student;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {



}
