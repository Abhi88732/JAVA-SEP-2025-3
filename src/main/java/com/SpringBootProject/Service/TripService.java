package com.SpringBootProject.Service;

import com.SpringBootProject.DTO.TripDTO;
import com.SpringBootProject.DTO.TripDTOWithOutId;
import com.SpringBootProject.Entity.Status;
import com.SpringBootProject.Entity.TripEntity;
import com.SpringBootProject.Mapper.MapperConfig;
import com.SpringBootProject.Repository.TripRespository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TripService {
    public final TripRespository tripRespository;
    public final MapperConfig mapperConfig;
    public TripDTO save(@Valid TripDTOWithOutId tripDTOWithOutId) {
         TripEntity tripEntity =mapperConfig.getModelMapper().map(tripDTOWithOutId,TripEntity.class);
         return mapperConfig.getModelMapper().map(tripRespository.save(tripEntity),TripDTO.class);
    }

    public Page<TripEntity> GetAllData(@Valid Pageable pageable) {
        return tripRespository.findAll(pageable);
    }

    public TripDTO GetTripByID(Integer id) {
        TripEntity tripEntity = tripRespository.findById(id).orElseThrow(()->new IllegalArgumentException("This "+id+" Does't exits"));
        return mapperConfig.getModelMapper().map(tripEntity,TripDTO.class);
    }

    public TripDTO TripUpdateAll(Integer id, TripDTOWithOutId tripDTOWithOutId) {
        TripEntity tripEntity=tripRespository.findById(id).orElseThrow(()->new IllegalArgumentException("This "+id+" Does't exits"));
        mapperConfig.getModelMapper().map(tripDTOWithOutId,tripEntity);
        tripEntity= tripRespository.save(tripEntity);
        return mapperConfig.getModelMapper().map(tripEntity,TripDTO.class);
    }

    public void TripDelete(Integer id) {
            if(!tripRespository.existsById(id)){
                throw new IllegalArgumentException("This "+id+" Does't exits");
            }
            tripRespository.deleteById(id);
        }

    public List<TripEntity> findByDestination(String destination) {
        return tripRespository.findByDestination(destination);
    }


    public Specification<TripEntity> hasStatus(Status status) {
        return (root, query, cb) -> cb.equal(root.get("status"), status);
    }

    public List<TripEntity> filterByStatus(Status status) {
        Specification<TripEntity> spec = null;
        if (status != null) {
            spec = hasStatus(status);
        }
        return tripRespository.findAll(spec);
    }
    public List<TripEntity> getTripsBetweenDates(LocalDate startDate, LocalDate endDate) {
        return tripRespository.findByStartDateBetween(startDate, endDate);
    }
    public Map<String, Object> getTripSummary() {
        Object[] result = tripRespository.getTripSummary().get(0);
        Map<String, Object> summary = new HashMap<>();
        summary.put("totalTrips", result[0]);
        summary.put("minPrice", result[1]);
        summary.put("maxPrice", result[2]);
        summary.put("averagePrice", result[3]);
        return summary;

    }
}
