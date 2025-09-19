package com.SpringBootProject.Repository;
import com.SpringBootProject.Entity.Status;
import com.SpringBootProject.Entity.TripEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TripRespository extends JpaRepository<TripEntity,Integer>, JpaSpecificationExecutor<TripEntity> {
    List<TripEntity> findByDestination(String destination);

    List<TripEntity> findByStartDateBetween(LocalDate start, LocalDate end);
    // Custom summary query
    @Query("SELECT COUNT(t), MIN(t.price), MAX(t.price), AVG(t.price) FROM TripEntity t")
    List<Object[]> getTripSummary();
}
