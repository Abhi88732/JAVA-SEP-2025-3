package com.SpringBootProject.Repository;
import com.SpringBootProject.Entity.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
@Repository
public interface TripRespository extends JpaRepository<TripEntity,Integer>, JpaSpecificationExecutor<TripEntity> {
}
