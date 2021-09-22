package ua.lviv.lgs.University.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lviv.lgs.University.domain.Bucket;

public interface BucketRepository extends JpaRepository<Bucket, Integer>{
}
