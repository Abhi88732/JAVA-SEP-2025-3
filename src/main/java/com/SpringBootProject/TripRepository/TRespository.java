package com.SpringBootProject.TripRepository;

import com.SpringBootProject.Entity.TripEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TRespository extends JpaRepository<TripEntity,Integer>, Specification<TripEntity> {
}
